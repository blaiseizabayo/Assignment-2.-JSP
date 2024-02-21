package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdmissionRequestServlet extends HttpServlet { public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String course = request.getParameter("course");

        // Print the retrieved data (you may do further processing here)
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Course: " + course);

        // You can add your own logic here, such as storing the data in a database

        // Redirect to a thank you page or any other page after successful submission
        response.sendRedirect("thankyou.html");
    }
}
