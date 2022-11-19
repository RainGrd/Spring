package com.bdqn.controller;
/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: ${PACKAGE_NAME}
 * @Author: RainGrd
 * @CreateTime: 2022-06-09  11:04
 * @Description: TODO
 * @Version: 1.0
 */

import cn.hutool.core.io.file.FileNameUtil;
import com.bdqn.utils.FileUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;
import java.util.UUID;

@WebServlet("/fileServlet")
public class FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        String uploadParamsRequest = FileUtil.uploadParamsRequest(request);
        /*回写数据*/
        writer.write(request.getContextPath()+uploadParamsRequest);
        writer.flush();
        writer.close();
/*        StringBuilder path = new StringBuilder("/img/");
        *//*新建文件*//*
        File file = new File(request.getServletContext().getRealPath("/img/"));
        if (!file.exists()) {
            *//*创建文件夹*//*
            file.mkdirs();
        }
        ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        try {
            *//*得到*//*
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                if (!fileItem.isFormField()) {
                    String name = fileItem.getName();
                    System.out.println(FileNameUtil.getSuffix(fileItem.getName()));
                    String fileName = UUID.randomUUID() + name.substring(name.lastIndexOf("."));
                    //提取生成文件名UUID+上传图片的后缀.jpg  .png
                    file = new File(file, fileName);
                    if (file.exists()) {
                        *//*避免同名的文件处理*//*
                        file.delete();
                    }
                    path.append(fileName);
                    fileItem.write(file);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        *//*回写数据*//*
        writer.write(request.getContextPath()+path);
        writer.flush();
        writer.close();*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
