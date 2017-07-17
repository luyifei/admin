package com.admin.base.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.admin.base.entity.BaseQuery;
import com.admin.base.util.PageUtils;

public class Page<T> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 8160976258668795789L;
    /** 分页结果集 **/
    protected List<T> result;
    /** 单页显示记录数 **/
    protected int pageSize;
    /** 当前页号 **/
    protected int pageNumber;
    /** 总记录数 **/
    protected int totalCount = 0;
    /** 分页标签显示数量 **/
    protected int showNumber = 5;

    public Page(BaseQuery baseQuery, int totalCount) {
        this(baseQuery.getPageNumber(), baseQuery.getPageSize(), totalCount);
    }

    public Page(int pageNumber, int pageSize, int totalCount) {
        this(pageNumber, pageSize, totalCount, new ArrayList<T>(0));
    }

    public Page(int pageNumber, int pageSize, int totalCount, List<T> result) {
        if (pageSize <= 0)
            throw new IllegalArgumentException("[pageSize] must great than zero");
        this.pageSize = pageSize;
        this.pageNumber = PageUtils.computePageNumber(pageNumber, pageSize, totalCount);
        this.totalCount = totalCount;
        setResult(result);
    }

    public void setResult(List<T> elements) {
        if (elements == null)
            throw new IllegalArgumentException("'result' must be not null");
        this.result = elements;
    }

    public List<T> getResult() {
        return this.result;
    }

    /**
     * 是否第一页
     * 
     * @return
     */
    public boolean isFirstPage() {
        return getThisPageNumber() == 1;
    }

    /**
     * 是否最后一页
     * 
     * @return
     */
    public boolean isLastPage() {
        return getThisPageNumber() >= getLastPageNumber();
    }

    /**
     * 是否存在下页
     * 
     * @return
     */
    public boolean isHasNextPage() {
        return getLastPageNumber() > getThisPageNumber();
    }

    /**
     * 是否存在上页
     * 
     * @return
     */
    public boolean isHasPreviousPage() {
        return getThisPageNumber() > 1;
    }

    /**
     * 获取最后一页页号
     * 
     * @return
     */
    public int getLastPageNumber() {
        return PageUtils.computeLastPageNumber(this.totalCount, this.pageSize);
    }

    /**
     * 获取总记录数
     * 
     * @return
     */
    public int getTotalCount() {
        return this.totalCount;
    }

    /**
     * 获取当前页号
     * 
     * @return
     */
    public int getPageNumber() {
        return pageNumber;
    }

    public int getThisPageFirstElementNumber() {
        return (getThisPageNumber() - 1) * getPageSize() + 1;
    }

    public int getThisPageLastElementNumber() {
        int fullPage = getThisPageFirstElementNumber() + getPageSize() - 1;
        return getTotalCount() < fullPage ? getTotalCount() : fullPage;
    }

    /**
     * 获取下一页号
     * 
     * @return
     */
    public int getNextPageNumber() {
        return getThisPageNumber() + 1;
    }

    /**
     * 获取上一页号
     * 
     * @return
     */
    public int getPreviousPageNumber() {
        return getThisPageNumber() - 1;
    }

    /**
     * 获取分页显示数
     * 
     * @return
     */
    public int getPageSize() {
        return this.pageSize;
    }

    /**
     * 获取当前页号
     * 
     * @return
     */
    public int getThisPageNumber() {
        return this.pageNumber;
    }

    /**
     * 获取总页数
     * 
     * @return
     */
    public int getTotalNumber() {
        if (totalCount % pageSize == 0) {
            return totalCount / pageSize;
        } else {
            return totalCount / pageSize + 1;
        }
    }

    public List<Integer> getLinkPageNumbers() {
        return PageUtils.generateLinkPageNumbers(getThisPageNumber(), getLastPageNumber(), this.showNumber);
    }

    public int getFirstResult() {
        return PageUtils.getFirstResult(this.pageNumber, this.pageSize);
    }

    @SuppressWarnings("unchecked")
    public Iterator<T> iterator() {
        return (Iterator<T>) (this.result == null ? Collections.emptyList().iterator() : this.result.iterator());
    }
}
