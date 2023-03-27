package com.example.user_register_ee.servlets;

import com.example.user_register_ee.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.user_register_ee.util.AppConstants.CURRENT_USER;

@WebServlet(value = "/user-home")
public class UserHome extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute(CURRENT_USER);
        if(currentUser==null){
            resp.sendRedirect("/home");
            return;
        }
        req.getRequestDispatcher("userHome.jsp").forward(req, resp);
    }
}
