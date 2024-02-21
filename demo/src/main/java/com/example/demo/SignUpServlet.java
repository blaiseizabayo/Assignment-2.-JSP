package com.example.demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session =request.getSession();
        session.setAttribute("useremail",email);
        session.setAttribute("userpassword",password);

        RequestDispatcher dispatcher = request.getRequestDispatcher("loginform.jsp");
        dispatcher.forward(request,response);

        try {
            response.sendRedirect("thankyou.html");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
