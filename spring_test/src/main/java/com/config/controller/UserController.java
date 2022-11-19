package com.config.controller;

import com.config.entity.User;
import com.config.service.IRoleService;
import com.config.service.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.system.controller
 * @Author: RainGrd
 * @CreateTime: 2022-06-09  08:32
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    /**
     * Jackson对象
     */
    ObjectMapper mapper = new ObjectMapper();



    @RequestMapping("/list")
    @ResponseBody
    public String userAll(int page, int limit, User user) throws JsonProcessingException {
        return mapper.writeValueAsString(userService.pageInfo(page,limit,user));
    }

    @RequestMapping("/saveUi")
    @ResponseBody
    public String saveUi() throws JsonProcessingException {
        return mapper.writeValueAsString(roleService.roleList());
    }

    @RequestMapping("/save")
    public String save(User user,Long[] roleIds){
        userService.save(user,roleIds);
        return "redirect:/pages/user-list.html";
    }
    @RequestMapping("/del/{userId}")
    @ResponseBody
    public String delete(@PathVariable("userId") Long userId) throws JsonProcessingException {
        userService.deleteUserById(userId);
        return mapper.writeValueAsString("success");
    }
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        System.out.println(username);
        System.out.println(password);
        User user=userService.login(username, password);
        if(user!=null){
            /*登录成功！将User对象储存session*/
            session.setAttribute("user",user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }

    /**
     * 用于返回错误页面
     * @return java.lang.String
     */
    @RequestMapping("*")
    public String exception(){
        return "404";
    }
}
