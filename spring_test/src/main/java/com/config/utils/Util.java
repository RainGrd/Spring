package com.config.utils;

import com.config.Vo.PageBean;
import com.config.dao.RoleDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author: duan.rong.gui
 * @date: 2022/3/31 11:21:21
 * @description: 主方法
 * @version: 1.0
 * 类描述：
 */
@Component
public class Util {
    @Autowired
    private RoleDao roleDao;

    private static Util util;

    @PostConstruct
    public void init() {
        util = this;
    }

    /**
     * @param valueType 各种类的class对象
     * @param request   请求对象
     * @return <T>
     * @description: 返回解析JSON的对象
     * @author: RainGrd
     * @date: 2022/5/10 20:27:37
     */
    public static <T> T parsing(Class<T> valueType, HttpServletRequest request) throws IOException {
        System.out.println(request.getReader().readLine());
        return new ObjectMapper().readValue(request.getReader().readLine(), valueType);
    }

    /**
     * @param user 用户对象
     * @description: 将用户存放在cookie里面
     * @author: RainGrd
     * @date: 2022/5/11 14:14:57
     */
    /*public static void addCookie(User user, HttpServletResponse response) {
        Cookie cUserName = new Cookie("username", user.getUsername());
        Cookie cPassWord = new Cookie("password", user.getPassword());
        *//*添加到response对象里面*//*
        response.addCookie(cUserName);
        response.addCookie(cPassWord);
    }*/

    /**
     * @param name     cookie名
     * @param response 响应对象
     * @description: 清空cookie
     * @author: RainGrd
     * @date: 2022/5/16 18:55:00
     */
    public static void deleteCookie(String name, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    /**
     * @param sql 要执行的分页sql
     * @return null
     * @author RainGrd
     * 用于处理查询总数的SQL
     * @date 9:46:51 2022/6/9
     **/
    public static <T> PageBean<T> pageList(String sql, Class<T> clazz, Object[] args) {
        /*1.将原先分页查询SQL语句转成大写*/
        String sqlUp = sql.toUpperCase();
        /*重新编写查询符合条件的SQL语句*/
        StringBuilder sqlCount = new StringBuilder("SElECT COUNT(*) ");
        /*拼接SQL*/
        sqlCount.append(sqlUp.substring(sqlUp.indexOf("FROM")));
        /*去掉原先limit后面的SQL语句*/
        sqlCount.replace(sqlCount.indexOf("LIMIT"), sqlCount.length(), "");
        /*处理条件*/
        Object[] objects = Arrays.copyOf(args, args.length - 2);
        int pageSize = (int) args[args.length - 1];
        int pageNumber = (int) args[args.length - 2];
        pageNumber = pageNumber == 0 ? 0 : pageNumber - 1;
        args[args.length - 2] = pageNumber * pageSize;
        return new PageBean<T>(util.roleDao.queryAll(clazz, sql, args), util.roleDao.queryCount(sqlCount.toString(), objects));
    }
}
