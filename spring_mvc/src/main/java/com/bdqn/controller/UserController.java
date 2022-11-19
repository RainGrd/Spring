package com.bdqn.controller;

import cn.hutool.core.io.FileUtil;
import com.bdqn.Vo.UserVo;
import com.bdqn.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.controller
 * @Author: RainGrd
 * @CreateTime: 2022-05-28  09:45
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {



    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(String fileName, MultipartFile[] uploadFiles) throws IOException {
        System.out.println(fileName);
        for (MultipartFile uploadFile : uploadFiles) {
            String originalFilename = uploadFile.getOriginalFilename();
            uploadFile.transferTo(new File("D:\\"+originalFilename));
        }
    }


    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(String fileName, MultipartFile uploadFile) throws IOException {
        System.out.println(fileName);
        System.out.println(uploadFile);
        /*获取文件名称*/
        String originalFilename = uploadFile.getOriginalFilename();
        System.out.println(originalFilename);
        /*保存文件*/
        uploadFile.transferTo(new File("D:\\"+originalFilename));
    }

    /**
     * @author RainGrd
     * @description RequestHeader请求头，CookieValue会话技术
     * @date 14:06:21 2022/6/6
     **/
    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(@RequestHeader(value = "User-Agent") String user_agent,@CookieValue(value = "JSESSIONID") String jsessionId){
        System.out.println(user_agent);
        System.out.println(jsessionId);
    }


    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(@RequestHeader(value = "User-Agent") String user_agent,@CookieValue(value = "JSESSIONID") String jsessionId){
        System.out.println(user_agent);
        System.out.println(jsessionId);
    }

    @RequestMapping(value = "/quick17/{date}")
    @ResponseBody
    public void save17(@PathVariable(value = "date")LocalDate date){
        System.out.println(date);
    }

    @RequestMapping(value = "/quick16/{username}")
    @ResponseBody
    public void save16(@PathVariable(value = "username") String username){
        System.out.println(username);
    }


    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(@RequestParam(value = "name")String username){
        System.out.println(username);
    }

    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(@RequestBody List<User> userList){
        System.out.println(userList);
    }



    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(UserVo userVo){
        System.out.println(userVo);
    }



    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(String[] strs){
        System.out.println(Arrays.asList(strs));
    }


    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(User user){
        System.out.println(user);
    }


    @RequestMapping(value = "/quick10")
    @ResponseBody
    public void save10(String username,int age){
        System.out.println(username);
        System.out.println(age);
    }


    @RequestMapping(value = "/quick9")
    @ResponseBody
    public User save9(){
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(18);
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() throws JsonProcessingException {
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(18);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        System.out.println(json);
        return  json;
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody   /*告知Spring MVC框架 不进行视图跳转 直接进行数据响应*/
    public String save7(){
        return "hello RainGrd";
    }



    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("<h1>hello RainGrd</h1>");
    }


    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","程序员");
        return "success";
    }


    @RequestMapping(value = "/quick4")
    public String save4(Model model){
        /*参数添加*/
        model.addAttribute("username","北大青鸟");
        return "success";
    }
    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        /*设置模型数据*/
        modelAndView.addObject("username","公平");
        /*设置视图名称*/
        modelAndView.setViewName("success");
        System.out.println("Controller save3 run...");
        return modelAndView;
    }



    @RequestMapping(value = "/quick2")
    public ModelAndView save2(){
        /*
         * model模型：封装数据
         * view视图:展示数据
         * */
        ModelAndView modelAndView = new ModelAndView();
        /*设置视图名称*/
        modelAndView.setViewName("success");
        /*设置模型数据*/
        modelAndView.addObject("username","zhangsan");
        System.out.println("Controller save2 run...");
        return modelAndView;
    }

    //@RequestMapping处理器映射器
    @RequestMapping(value = "/quick",method = RequestMethod.GET)
    public String save(){
        System.out.println("Controller save run...");
        return "success";
    }
}
