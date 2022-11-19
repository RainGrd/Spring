package com.bdqn.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

public class FileUtil {
    public static Map<String,Object> args = new HashMap<>();

    /**
     * 获取 DiskFileItemFactory 对象, 处理文件上传路径或者大小限制
     * @param file 文件
     * @return org.apache.commons.fileupload.disk.DiskFileItemFactory
     */
    public static DiskFileItemFactory getDiskFileItemFactory(File file) {
        // 处理文件上传, 一般通过获取流, request.getInputStream() 原生方式十分麻烦
        // 可以使用 Apache 文件上传组件, commons-fileupload, 它依赖于 commons-io 组件
        // 1. 创建 DiskFileItemFactory 对象, 处理文件上传路径或者大小限制
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置一个缓冲区大小, 当文件大于这个缓冲区大小的时候, 就会放到临时目录
        factory.setSizeThreshold(1024 * 1024); // 缓冲区大小 1 M
        factory.setRepository(file); // 设置临时目录, 接收一个 File
        return factory;
    }

    /**
     * 获取 ServletFileUpload 对象负责处理上传文件数据, 可以监听文件上传进度, 以及编码问题
     * @param factory 获取工厂
     * @return org.apache.commons.fileupload.servlet.ServletFileUpload
     */
    public static ServletFileUpload getServletFileUpload(DiskFileItemFactory factory) {
        // 2. 获取 ServletFileUpload 对象负责处理上传文件数据, 可以监听文件上传进度, 以及编码问题
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 监听文件上传进度
        upload.setProgressListener(new ProgressListener() {
            @Override
            public void update(long readBytes, long contentLength, int i) {
                System.out.println("总大小: " + contentLength + " 已上传进度: " + readBytes);
            }
        });
        // 处理乱码问题
        upload.setHeaderEncoding("UTF-8");
        // 设置单个文件最大值 设置总共能够上传文件大小 10M
        upload.setFileSizeMax(Long.MAX_VALUE);
        return upload;
    }

    /**
     * 保存文件
     * @param req request对象
     * @return java.lang.String
     */
    public static String uploadParamsRequest(HttpServletRequest req) {
        StringBuilder path = new StringBuilder();
        InputStream is;
        FileOutputStream fos;
        try {
            // 处理文件上传, 一般通过获取流, request.getInputStream() 原生方式十分麻烦
            // 可以使用 Apache 文件上传组件, commons-fileupload, 它依赖于 commons-io 组件
            // 1. 创建 DiskFileItemFactory 对象, 处理文件上传路径或者大小限制
            // 2. 获取 ServletFileUpload 对象负责处理上传文件数据, 可以监听文件上传进度, 以及编码问题
            ServletFileUpload upload = getServletFileUpload(getDiskFileItemFactory(new File(req.getServletContext().getRealPath(""))));
            List<FileItem> fileItems = upload.parseRequest(req);
            for (FileItem fileItem : fileItems) {
                // 判断上传文件是普通表单还是带文件的表单, true 代表普通表单, false 代表文件表单
                if (!fileItem.isFormField()){
                    //===================处理文件===================
                    // 获取文件名
                    String uploadFileName = fileItem.getName();
                    System.out.println("上传的文件名: " + uploadFileName);
                    // 判断文件名是否合法, 不合法直接跳过
                    if (uploadFileName == null || uploadFileName.trim().equals("")) {
                        continue;
                    }
                    // 获取上传文件后缀
                    String uploadExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1).toLowerCase();
                    System.out.println("文件信息 [文件名: " + uploadFileName + " ---文件类型: " + uploadExtName + "]");
                    //===================存放地址===================
                    // 文件真实存放的地址 readPath
                    // 给文件开辟一个文件夹
                    String src = "/file/";
                    if (uploadFileName.contains(".")){
                        if (suffixIsImg(uploadFileName)){
                            src="/img/";
                        }else if (uploadFileName.contains("mp4")){
                            src="/video/";
                        }
                    }
                    path.append(src);
                    File readPathFile = new File(req.getServletContext().getRealPath(src));
                    if (!readPathFile.exists()) {
                        // 如果没有该文件夹, 就创建
                        readPathFile.mkdir();
                    }
                    //===================文件传输===================
                    // 获取输入流
                    is = fileItem.getInputStream();
                    // 获取文件输出流
                    fos = new FileOutputStream(readPathFile+File.separator + uploadFileName);
                    // 建立缓存区
                    byte[] buffer = new byte[1024 * 1024];
                    int len;
                    // 读取流
                    while ((len = is.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    // 关闭流
                    fos.flush();
                    fos.close();
                    is.close();
                    // 清除临时文件
                    fileItem.delete();
                    path.append(uploadFileName);
                }else {
                    args.put(fileItem.getFieldName(),fileItem.getString("utf-8"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Long.MAX_VALUE);
        return path.toString();
    }

    public static boolean suffixIsImg(String uploadFileName){
        return (uploadFileName.contains("png") || uploadFileName.contains("jpg") || uploadFileName.contains("jpeg")|| uploadFileName.contains("gif"));
    }
}
