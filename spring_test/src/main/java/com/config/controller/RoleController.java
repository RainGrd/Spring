package com.config.controller;

import com.config.entity.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.config.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.controller
 * @Author: RainGrd
 * @CreateTime: 2022-06-07  11:28
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseServlet{
    @Autowired
    private IRoleService roleService;
    ObjectMapper mapper = new ObjectMapper();
    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 创建Spring视图对象
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public String list(int page, int limit, Role role) throws IOException {

        return mapper.writeValueAsString(roleService.roleAll(page,limit,role));
    }

    @RequestMapping(value = "/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/pages/role-list.jsp";
    }
}
