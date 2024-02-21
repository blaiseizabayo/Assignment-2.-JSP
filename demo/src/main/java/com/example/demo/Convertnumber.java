package com.example.demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/blaise")


public class Convertnumber extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer number = Integer.parseInt(request.getParameter("number"));
            String username = request.getParameter("username");
            String myBtn = request.getParameter("btn");
            String convertedNumber;
            String description;
            request.setAttribute("numberToConvert","Number "+ number);
            if(request.getParameter("number") ==""){
                request.setAttribute("requiredNumber","Warning: Number to be converted required!");
            }
            else {
                if(myBtn.equals("binary")){
                    StringBuilder binaryStringBuilder = new StringBuilder();
                    while (number > 0) {
                        int remainder = number % 2;
                        binaryStringBuilder.insert(0, remainder);
                        number = number / 2;
                    }
                    convertedNumber = binaryStringBuilder.toString();
                    description="Decimal number converted to binary";
                } else if(myBtn.equals("hexa")) {
                    StringBuilder hexStringBuilder = new StringBuilder();
                    while (number > 0) {
                        int remainder = number % 16;
                        char hexDigit = (char) (remainder < 10 ? remainder + '0' : remainder + 'A' - 10);
                        hexStringBuilder.insert(0, hexDigit);
                        number = number / 16;
                    }
                    convertedNumber = hexStringBuilder.toString();
                    description="Decimal number converted to Hexadecimal";

                } else if(myBtn.equals("octal")) {
                    StringBuilder octalStringBuilder = new StringBuilder();
                    while (number > 0) {
                        int remainder = number % 8;
                        octalStringBuilder.insert(0, remainder);
                        number = number / 8;
                    }
                    convertedNumber = octalStringBuilder.toString();
                    description="Decimal number converted to Octal";
                }
                else {
                    convertedNumber=number.toString();
                    description="Decimal number not converted";
                }
                request.setAttribute("convertedNumber","Result "+convertedNumber);
                request.setAttribute("description",description);
            }
            request.setAttribute("username",username);

        } catch (Exception ex){
            ex.printStackTrace();
            request.setAttribute("error","An expected error occurred!!");
        }
        RequestDispatcher dispatch = request.getRequestDispatcher("/Jsp.jsp");
        try {
            dispatch.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
