package com.bdqn.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.utils
 * @Author: RainGrd
 * @CreateTime: 2022-06-20  12:03
 * @Description: TODO
 * @Version: 1.0
 */
public class Util {
    /**
     * 解析请求里面的数据
     *
     * @param valueType 各种类的class对象
     * @param request   请求对象
     * @return <T>
     * @author: RainGrd
     * @date: 2022/5/10 20:27:37
     */
    public static <T> T parsing(Class<T> valueType, HttpServletRequest request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(request.getReader().readLine(), valueType);
    }
}
