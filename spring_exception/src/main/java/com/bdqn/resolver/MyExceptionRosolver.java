package com.bdqn.resolver;

import com.bdqn.exception.MyException;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.resolver
 * @Author: RainGrd
 * @CreateTime: 2022-06-10  19:40
 * @Description: TODO
 * @Version: 1.0
 */
public class MyExceptionRosolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, Object o, @NotNull Exception e) {
        ModelAndView mv = new ModelAndView();
        if (e instanceof MyException) {
            mv.addObject("info","自定义异常");
        }else if (e instanceof ClassCastException){
            mv.addObject("info","类转换异常");
        }
        /*返回视图*/
        mv.setViewName("error");
        return mv;
    }
}
