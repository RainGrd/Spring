package com.bdqn.utils;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.utils
 * @Author: RainGrd
 * @CreateTime: 2022-05-28  08:18
 * @Description: TODO
 * @Version: 1.0
 */
public class WebApplicationContextUtils {
    public static ApplicationContext getWebApplicationContext(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
