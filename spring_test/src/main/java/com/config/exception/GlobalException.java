package com.config.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.system.exception
 * @Author: RainGrd
 * @CreateTime: 2022-06-11  11:26
 * @Description: TODO
 * @Version: 1.0
 */
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        /*设置错误视图*/
        mv.setViewName("/WEB-INF/error/404.jsp");
        if(e instanceof ClassCastException){
            mv.addObject("msg","服务器出错了");
        }
        return mv;
    }
}
