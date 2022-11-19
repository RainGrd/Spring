package com.bdqn.controller;

import com.bdqn.entity.Account;
import com.bdqn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.controller
 * @Author: RainGrd
 * @CreateTime: 2022-06-15  19:37
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/save")
    public String save(Account account) {
        accountService.save(account);
        return "redirect:/account/find";
    }

    @RequestMapping("/find")
    @ResponseBody
    public ModelAndView find() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("accountList",accountService.accountFindAll());
        mv.setViewName("main");
        return mv;
    }

}
