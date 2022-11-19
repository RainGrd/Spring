package com.bdqn.Vo;

import java.util.List;

/**
 * @BelongsProject: JWeb
 * @BelongsPackage: com.bdqn.utils
 * @Author: RainGrd
 * @CreateTime: 2022-05-30  09:46
 * @Description: 分页工具类
 * @Version: 1.0
 */
public class PageInfo<E> {
    /**
     * @description: 页中的数据
     * @author: RainGrd
     * @date: 2022/5/30 10:01:21
     **/
    private List<E> data;
    /**
     * @description: 总条数
     * @author: RainGrd
     * @date: 2022/5/30 10:01:37
     **/
    private int totalCount;
    /**
     * @description: 总页数
     * @author: RainGrd
     * @date: 2022/5/30 10:29:39
     **/
    private int countPages;
    /**
     * @description: 每一行的页数
     * @author: RainGrd
     * @date: 2022/5/30 10:02:14
     **/
    private int pageSize;
    /**
     * @description: 当前页数
     * @author: RainGrd
     * @date: 2022/5/30 10:05:52
     **/
    private int current;
    /**
     * @description: 下一页
     * @author: RainGrd
     * @date: 2022/5/30 10:07:28
     **/
    private boolean nextPage;
    /**
     * @description: 上一页
     * @author: RainGrd
     * @date: 2022/5/30 10:09:39
     **/
    private boolean upPage;
    /**
     * @description: 开始页
     * @author: RainGrd
     * @date: 2022/5/30 10:11:13
     **/
    private int startPage;
    /**
     * @description: 结束页
     * @author: RainGrd
     * @date: 2022/5/30 10:11:42
     **/
    private int endPage;

    public PageInfo(List<E> data, int totalCount, int pageSize, int pageNumber) {
        this.data = data;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.current = pageNumber;
        this.countPages = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        this.startPage = 1;
        this.endPage = countPages;
        this.upPage = pageNumber != 1;
        this.nextPage = pageNumber != endPage;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public boolean isNextPage() {
        return nextPage;
    }

    public void setNextPage(boolean nextPage) {
        this.nextPage = nextPage;
    }

    public boolean isUpPage() {
        return upPage;
    }

    public void setUpPage(boolean upPage) {
        this.upPage = upPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "data=" + data +
                ", totalCount=" + totalCount +
                ", countPages=" + countPages +
                ", pageSize=" + pageSize +
                ", current=" + current +
                ", nextPage=" + nextPage +
                ", upPage=" + upPage +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                '}';
    }
}
