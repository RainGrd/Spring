package com.bdqn.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.exception
 * @Author: RainGrd
 * @CreateTime: 2022-06-10  20:06
 * @Description: TODO
 * @Version: 1.0
 */
@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception e) {
        ModelAndView mv = new ModelAndView();
        /*设置通用错误业务*/
        mv.setViewName("error");
        /*判断异常错误类型*/
        if (e instanceof MyException) {
            mv.addObject("msg", "系统繁忙，请稍后处理......");
        }
        return mv;
    }
}
