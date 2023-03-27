package com.example.user_register_ee.servlets;

import com.example.user_register_ee.manager.UserManager;
import com.example.user_register_ee.manager.impl.UserManagerImpl;
import com.example.user_register_ee.models.User;
import com.example.user_register_ee.models.enums.Gender;
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

@WebServlet(value = "/login", loadOnStartup = 1)
public class UserLogin extends HttpServlet {

    private UserManager userManager;


    @Override
    public void init() throws ServletException {
        userManager = new UserManagerImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        if (userManager.existByEmail(email)) {
            User byEmail = userManager.getByEmail(email);
            if(PasswordEncoder.isMatch(password, byEmail.getPassword())){
                req.getSession().setAttribute(AppConstants.CURRENT_USER, byEmail);
                resp.sendRedirect("/user-home");
                return;
            }
        }
        req.setAttribute("loginError", "Invalid email or password");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
