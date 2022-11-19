package com.config.Vo;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.Vo
 * @Author: RainGrd
 * @CreateTime: 2022-06-07  14:59
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> implements Serializable {
    /**
     * 第一页
     */
    private int page;
    /**
     * 查询每页的最大条数
     */
    private int limit;
    /**
     * 成功代码
     */
    private int code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 查询最大次数
     */
    private Long count;
    /**
     * 查询数据
     */
    private List<T> data;

    public PageBean(List<T> data,@NonNull Long count) {
        this.data=data;
        this.count=count;
    }
}
