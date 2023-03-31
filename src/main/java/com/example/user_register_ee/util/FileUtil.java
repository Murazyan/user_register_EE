package com.example.user_register_ee.util;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.util.List;

public class FileUtil {

//    public static String storeAvatar(HttpServletRequest request) {
//        String name = "default.img";
//        String avatarsFolderDirectory = AppUtil.loadProperties().getProperty("avatar.file.directory");
//        if (ServletFileUpload.isMultipartContent(request)) {
//            try {
//                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
//
//                for (FileItem item : multiparts) {
//                    if (!item.isFormField()) {
//                        name = System.currentTimeMillis() + item.getName();
//                        item.write(new File(avatarsFolderDirectory + File.separator + name));
//                    }
//                }
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//
//        }
//        return name;
//
//    }


    @SneakyThrows
    public static String saveAvatar(HttpServletRequest request) {
        String name = "default.img";

        String avatarsFolderDirectory = AppUtil.loadProperties().getProperty("avatar.file.directory");
        FileOutputStream outputStream = null;
        try {
            Part filePart = request.getPart("file");
            name = System.currentTimeMillis() + filePart.getSubmittedFileName();
            InputStream fileContent = filePart.getInputStream();
            File avatarFile = new File(avatarsFolderDirectory + File.separator + name);
            avatarFile.createNewFile();
            outputStream = new FileOutputStream(avatarFile, true);
            IOUtils.copy(fileContent,outputStream);
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = fileContent.read(buffer)) != -1) {
//                outputStream.write(bytesRead);
//                outputStream.flush();
//            }
        } finally {
            outputStream.close();
        }

        return name;

    }
}
