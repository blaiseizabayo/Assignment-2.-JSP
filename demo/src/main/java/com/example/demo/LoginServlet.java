package com.example.demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session_data =request.getSession();
        Object emailname=session_data.getAttribute("useremail");
        Object passwordaddress=session_data.getAttribute("userpassword");

        // Check if username and password match
        if (username.equals(emailname) && password.equals(passwordaddress)) {
            HttpSession sessionfilter =request.getSession();

            sessionfilter.setAttribute("email",username);

            Emaildata emaildata=new Emaildata();
           emaildata.sendEmail(username);

            RequestDispatcher dispatcher = request.getRequestDispatcher("requestingadmissionform.jsp");
            dispatcher.forward(request,response);
        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("loginform.jsp");
            dispatcher.forward(request,response);

        }
    }
}
