<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="page" required="true" type="com.admin.base.dao.Page" description="Page.java" %>
<%@ attribute name="pageSizeSelectList" type="java.lang.Number[]" required="false"  %>
<%@ attribute name="isShowPageSizeList" type="java.lang.Boolean" required="false"  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	// set default values
	Integer[] defaultPageSizes = new Integer[]{10,50,100};
	if(jspContext.getAttribute("pageSizeSelectList") == null) {
		jspContext.setAttribute("pageSizeSelectList",defaultPageSizes); 
	}
	
	if(jspContext.getAttribute("isShowPageSizeList") == null) {
		jspContext.setAttribute("isShowPageSizeList",true); 
	} 
%>

<table width="100%"  border="0" cellspacing="0" class="gridToolbar">
  <tr>
	<td>
		<div class="box">
			<div  class="leftControls" >
				<jsp:doBody/>
			</div>
	    <div class="page-header position-relative">
        <table style="width:100%;">
            <tr>
                <td style="vertical-align:top;"><div style="float: right;padding-top: 0px;margin-top: 0px;">
	                <ul class="pagination">
	                    <li><a>共<font color="red">${page.totalCount}</font>条</a></li>
	                    <li>
	                       <input type="number" value="" id="jumpPageNumber" style="height:32px;width:60px;text-align:center;float:left;" placeholder="页码">
	                    </li>
	                    <li style="cursor:pointer;"><a onclick="simpleTable.jumpPage(${page.totalNumber});" class="btn btn-success" style="height:32px;">跳转</a></li>
	                    <!-- 首页按钮 -->
	                    <c:choose>
	                        <c:when test="${page.firstPage}">
	                            <li><a>首页</a></li>
	                        </c:when>
	                        <c:otherwise>
	                            <li style="cursor:pointer;"><a onclick="simpleTable.togglePage(1);">首页</a></li>
	                         </c:otherwise>
	                    </c:choose>
	                    <!-- 上页按钮 -->
	                    <c:choose>
	                        <c:when test="${page.firstPage}">
	                            <li><a>上页</a></li>
	                        </c:when>
	                        <c:otherwise>
	                            <li style="cursor:pointer;"><a onclick="simpleTable.togglePage(${page.previousPageNumber});">上页</a></li>
	                         </c:otherwise>
	                    </c:choose>
	                    <!-- 页码按钮 -->
	                    <c:forEach var="item" items="${page.linkPageNumbers}">
			                <c:choose>
			                <c:when test="${item == page.thisPageNumber}">
			                     <li class="active"><a>${item}</a></li>
			                </c:when>
			                <c:otherwise>
			                     <li style="cursor:pointer;"><a onclick="simpleTable.togglePage(${item});">${item}</a></li>
			                </c:otherwise>
			                </c:choose>
		                </c:forEach>
	                    <!-- 下页按钮 -->
	                    <c:choose>
	                        <c:when test="${page.lastPage}">
	                            <li><a>下页</a></li>
	                        </c:when>
	                        <c:otherwise>
	                            <li style="cursor:pointer;"><a onclick="simpleTable.togglePage(${page.nextPageNumber});">下页</a></li>
	                         </c:otherwise>
	                    </c:choose>
	                    
	                    <!-- 尾页按钮 -->
	                    <c:choose>
	                        <c:when test="${page.lastPage}">
	                            <li><a>尾页</a></li>
	                        </c:when>
	                        <c:otherwise>
	                            <li style="cursor:pointer;"><a onclick="simpleTable.togglePage(${page.lastPageNumber});">尾页</a></li>
	                         </c:otherwise>
	                    </c:choose>
	                    <li><a>第 <font color="red">${page.thisPageNumber}</font>页</a></li>
	                    <li><a>共${page.totalNumber}页</a></li>
	                    <li>
	                       <c:if test="${isShowPageSizeList}">
			                <select title="显示条数" style="height:32px;width:60px;float:left;" onChange="simpleTable.togglePageSize(this.value)" >
			                    <c:forEach var="item" items="${pageSizeSelectList}">
			                        <option value="${item}" ${page.pageSize == item ? 'selected' : '' }>${item}</option>
			                    </c:forEach> 
			                </select>
			                </c:if>
	                    </li>
	                </ul>
                </div>
                </td>
            </tr>
        </table>
        </div>
		<div>
	</td>
  </tr>
</table>