package com.example.user_register_ee.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("i**** "+req.getAttribute("loginError"));
        req.getRequestDispatcher("index.jsp").forward(req, resp);
//        resp.sendRedirect("/user-home");
    }
}
