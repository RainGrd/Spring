package com.system.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.system.entity.User;
import com.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.system.controller
 * @Author: RainGrd
 * @CreateTime: 2022-06-16  20:11
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/userList.do")
    public String userList() {
        return "user-list";
    }

    @RequestMapping("/findAllUsers")
    @ResponseBody
    public String findAllUsers(int page, int rows, User user) throws JsonProcessingException {
        System.out.println(page);
        System.out.println(rows);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writeValueAsString(userService.findUserAll(page, rows, user));
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) {
        System.out.println(username);
        System.out.println(password);
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            /*跳转主页*/
            return "main";
        }
        /*重新跳转登录页面*/
        return "login";
    }


}
