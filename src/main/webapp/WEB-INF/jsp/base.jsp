<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<script type="text/javascript" src="<%=path%>/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/jquery.tips.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/jquery.cookie.js"></script>
</head>
<body>
</body>
</html>

