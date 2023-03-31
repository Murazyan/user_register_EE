package com.example.user_register_ee.servlets;

import com.example.user_register_ee.manager.UserManager;
import com.example.user_register_ee.manager.impl.UserManagerImpl;
import com.example.user_register_ee.models.User;
import com.example.user_register_ee.models.enums.Gender;
import com.example.user_register_ee.util.FileUtil;
import com.example.user_register_ee.util.PasswordEncoder;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(value = "/register", loadOnStartup = 1)
public class UserRegister extends HttpServlet {

    private UserManager userManager;
    private SimpleDateFormat inputFormat;

    @Override
    public void init() throws ServletException {
        userManager = new UserManagerImpl();
        inputFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String birthDate = req.getParameter("birth_date");
        String gender = req.getParameter("gender");

        System.out.println(String.format("%s %s %s %s %s %s ", name, surname, email, password, birthDate, gender));
        if (userManager.existByEmail(email)) {
            req.setAttribute("regErrorUserExists", "User already exist");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            User saveedUser = userManager.save(User.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .password(PasswordEncoder.encrypt(password))
                    .birthDate(inputFormat.parse(birthDate))
                    .gender(Gender.valueOf(gender))
                    .build());
            req.getSession().setAttribute("currentUser", saveedUser);
            resp.sendRedirect("/user-home");
        }


    }


}
