package com.example.user_register_ee.servlets;

import com.example.user_register_ee.manager.UserManager;
import com.example.user_register_ee.manager.impl.UserManagerImpl;
import com.example.user_register_ee.models.User;
import com.example.user_register_ee.models.enums.Gender;
import com.example.user_register_ee.util.FileUtil;
import com.example.user_register_ee.util.PasswordEncoder;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

import static com.example.user_register_ee.util.AppConstants.CURRENT_USER;

@WebServlet(value = "/upload-avatar", loadOnStartup = 1)
@MultipartConfig
public class UploadAvatar extends HttpServlet {

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

        String avatarName = FileUtil.saveAvatar(req);
        User currentUser = (User) req.getSession().getAttribute(CURRENT_USER);
        currentUser.setAvatar(avatarName);
        User saveedUser = userManager.save(currentUser);
        req.getSession().setAttribute("currentUser", saveedUser);
        resp.sendRedirect("/user-home");
    }

}
