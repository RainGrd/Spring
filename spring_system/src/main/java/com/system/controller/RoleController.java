package com.system.controller;

import com.system.entity.Role;
import com.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.system.controller
 * @Author: RainGrd
 * @CreateTime: 2022-06-17  08:43
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findRoleList")
    public ModelAndView findRoleList(Role role){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role-list");
        return modelAndView;
    }
}
