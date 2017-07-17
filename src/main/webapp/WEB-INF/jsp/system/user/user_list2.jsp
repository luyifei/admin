<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
    <head>
    <base href="<%=basePath%>">
    <!-- jsp文件头和头部 -->
    <%@ include file="../admin/top.jsp"%> 
    </head> 
<body>
        
<div class="container-fluid" id="main-container">


<div id="page-content" class="clearfix">
                        
  <div class="row-fluid">
    <div class="row-fluid">
            <!-- 检索  -->
            <form action="systemUser/listUsers.do" method="post" name="queryForm" id="queryForm">
            <table>
                <tr>
                    <td>
                    </td>
                </tr>
            </table>
            <!-- 检索  -->
            <table id="table_report" class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th class="center">
                        <label><input type="checkbox" id="zcheckbox" /><span class="lbl"></span></label>
                        </th>
                        <th>序号</th>
                        <th>编号</th>
                        <th>用户名</th>
                        <th>姓名</th>
                        <th>职位</th>
                        <th><i class="icon-envelope"></i>邮箱</th>
                        <th><i class="icon-time hidden-phone"></i>最近登录</th>
                        <th>上次登录IP</th>
                        <th>上次登录IP</th>
                        <th class="center">操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                    <c:when test="${not empty page.result}">
                        <!-- 开始循环 -->   
                        <c:forEach items="${page.result}" var="item" varStatus="vs">
                            <tr>
                                <td class='center' style="width: 30px;">
                                  <label><input type='checkbox' name='ids' value="${item.id }" alt="${user.userName}"/><span class="lbl"></span></label>
                                </td>
                                <td class='center' style="width: 30px;">${item.userName}</td>
                                <td class='center' style="width: 30px;">${item.userName}</td>
                                <td>${item.userName}</td>
                                <td>${item.userName}</td>
                                <td>${item.userName}</td>
                                <td>${item.userName}</td>
                                <td>${item.userName}</td>
                                <td>${item.userName}</td>
                                <td>${item.userName}</td>
                                <td style="width: 60px;">
                                    <a class='btn btn-mini btn-danger' title="不能删除"><i class='icon-trash'></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </c:when>
                        <c:otherwise>
	                        <tr class="main_info">
	                            <td colspan="10" class="center">没有相关数据</td>
	                        </tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
            <simpletable:pageToolbar page="${page}">
            </simpletable:pageToolbar>
        </form>
    </div>
  
</div>
    
</div>
</div>
        
        <!-- 返回顶部  -->
        <a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse">
            <i class="icon-double-angle-up icon-only"></i>
        </a>
        
        <!-- 引入 -->
        <script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
        <script src="static/js/bootstrap.min.js"></script>
        <script src="static/js/ace-elements.min.js"></script>
        <script src="static/js/ace.min.js"></script>
        
        <script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
        <script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
        <script type="text/javascript" src="static/js/bootbox.min.js"></script><!-- 确认窗口 -->
        <!-- 引入 -->
        
        
        <script type="text/javascript" src="static/js/jquery.tips.js"></script><!--提示框-->
        <script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
        <script type="text/javascript">
        $(document).ready(function() {
            // 分页需要依赖的初始化动作
            window.simpleTable = new SimpleTable('queryForm',${page.thisPageNumber},${page.pageSize},'${pageRequest.sortColumns}');
        });
        $(top.hangge());
        
        //检索
        function search(){
            top.jzts();
            $("#userForm").submit();
        }
        
        </script>
        
        <script type="text/javascript">
        
        $(function() {
            
            
        });
        </script>
    </body>
</html>

