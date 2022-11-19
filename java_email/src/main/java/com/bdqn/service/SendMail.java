package com.bdqn.service;

import com.bdqn.entity.User;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.util.Properties;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.service
 * @Author: RainGrd
 * @CreateTime: 2022-06-11  17:12
 * @Description: TODO
 * @Version: 1.0
 */
public class SendMail extends Thread{

    //发件人信息
    private String From = "3408396469@qq.com";
    //发件人邮箱
    private String recipient = "3408396469@qq.com";
    //邮箱密码
    private String password = "faon hsuh fhsf cihd,chgs mmuh ixwn dbjc";
    //邮件发送的服务器
    private String host = "smtp.qq.com";

    //收件人信息
    private User user;

    public SendMail(User user){
        this.user = user;
    }

    @Override
    public void run() {
        try {
            Properties properties = new Properties();

            properties.setProperty("mail.host","smtp.qq.com");

            properties.setProperty("mail.transport.protocol","smtp");

            properties.setProperty("mail.smtp.auth","true");

            //QQ存在一个特性设置SSL加密
            MailSSLSocketFactory sf = null;
            try {
                sf = new MailSSLSocketFactory();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);

            //创建一个session对象
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(recipient,password);
                }
            });

            //开启debug模式
            session.setDebug(true);

            //获取连接对象
            Transport transport = null;
            try {
                transport = session.getTransport();
            } catch (NoSuchProviderException e) {
                e.printStackTrace();
            }

            //连接服务器
            if (transport != null) {
                transport.connect(host,From,password);
            }


            //创建一个邮件发送对象
            MimeMessage mimeMessage = new MimeMessage(session);
            //邮件发送人
            mimeMessage.setFrom(new InternetAddress(recipient));

            //邮件接收人
            mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(user.getEmail()));

            //邮件标题
            mimeMessage.setSubject("网站注册成功");

            //设置邮件内容
            mimeMessage.setContent("网站注册成功，密码为"+user.getPassword()+"，请妥善保管密码","text/html;charset=UTF-8");

            //发送邮件
            transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());

            transport.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
