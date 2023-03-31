package com.example.user_register_ee.servlets;


import com.example.user_register_ee.util.AppUtil;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(value = "/avatar")
public class UserAvatarGet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //What image is being requested?
        String imageName = request.getParameter("img");

        File imageDirectory = new File(AppUtil.loadProperties().getProperty("avatar.file.directory"));
        File imageFile = new File(imageDirectory, imageName);

        BufferedImage image = ImageIO.read(new FileInputStream(imageFile));

        ImageIO.write(image, "jpeg",  resp.getOutputStream());
    }
}
