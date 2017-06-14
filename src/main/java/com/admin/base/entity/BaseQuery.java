package com.admin.base.entity;

public class BaseQuery {
    protected int showCount; //每页显示记录数
    protected int totalPage;      //总页数
    protected int totalResult;    //总记录数
    protected int currentPage;    //当前页
    protected int currentResult;  //当前记录起始索引
    protected boolean entityOrField;  //true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性
    protected String pageStr;     //最终页面显示的底部翻页导航，详细见：getPageStr();
    
}
