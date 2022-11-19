package com.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.controller
 * @Author: RainGrd
 * @CreateTime: 2022-06-10  08:58
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
public class TargetController {
    @RequestMapping("/target")
    public ModelAndView show(){
        System.out.println("目标资源执行...");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","RainGrd");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
