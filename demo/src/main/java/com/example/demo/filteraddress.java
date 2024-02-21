package com.example.demo;

import jakarta.servlet.Filter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/requestingadmissionform.jsp")
public  class filteraddress implements Filter {
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpSession session = httpRequest.getSession(false);
            boolean isLoggedIn = (session != null && session.getAttribute("email") != null);
            if (!isLoggedIn && (httpRequest.getRequestURI().endsWith("requestingadmissionform.jsp"))) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/loginform.jsp");
                return;
            }
            chain.doFilter(request, response);
        }

}
