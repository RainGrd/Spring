package com.bdqn.converter;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.Converter
 * @Author: RainGrd
 * @CreateTime: 2022-06-05  17:48
 * @Description: TODO
 * @Version: 1.0
 */
public class DateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(@NotNull String str) {
        /*将我们这个日期字符串转换成日期对象,并进行返回*/
        return LocalDate.parse(str,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
