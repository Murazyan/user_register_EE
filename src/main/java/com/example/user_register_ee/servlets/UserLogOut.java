package com.example.user_register_ee.servlets;

import com.example.user_register_ee.manager.UserManager;
import com.example.user_register_ee.manager.impl.UserManagerImpl;
import com.example.user_register_ee.models.User;
import com.example.user_register_ee.util.AppConstants;
import com.example.user_register_ee.util.PasswordEncoder;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet(value = "/log-out", loadOnStartup = 1)
public class UserLogOut extends HttpServlet {




    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/home");
    }
}
