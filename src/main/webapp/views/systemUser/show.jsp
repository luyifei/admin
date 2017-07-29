<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <base href="<%=basePath%>">
        <meta charset="utf-8" />
        <%@ include file="/views/system/admin/base.jsp"%> 
    </head>
<body class="main-content">
       <div class="main-container ace-save-state">
        <table class="table-info table-info-striped">
            <tr class="table-row">
                <td class="table-name" style="text-align: center;height: 40px;" colspan="2">
                     <h4>表单</h4>
                </td>
            </tr>
            <tr class="table-row">
			    <td class="table-name">
			                    用户名:
			    </td>
			    <td class="table-value">
			        ${systemUser.userName}
			    </td>
			</tr>
			<tr class="table-row">
			    <td class="table-name">
			                    密码:
			    </td>
			    <td class="table-value">
			        ${systemUser.password}
			    </td>
			</tr>
			<tr class="table-row">
			    <td class="table-name">
			                    用户姓名:
			    </td>
			    <td class="table-value">
			        ${systemUser.name}
			    </td>
			</tr>
			<tr class="table-row">
			    <td class="table-name">
			                    电子邮箱:
			    </td>
			    <td class="table-value">
			        ${systemUser.email}
			    </td>
			</tr>
			<tr class="table-row">
			    <td class="table-name">
			                    固定号码:
			    </td>
			    <td class="table-value">
			        ${systemUser.number}
			    </td>
			</tr>
			<tr class="table-row">
			    <td class="table-name">
			                    手机号码:
			    </td>
			    <td class="table-value">
			        ${systemUser.phone}
			    </td>
			</tr>
            <tr class="table-row">
                <td class="table-value" style="text-align: center;" colspan="2">
                    <a class="btn btn-sm btn-grey" onclick="cancel();">关闭</a>
                </td>
            </tr>
        </table>
<script type="text/javascript">
function cancel(){
    //先得到当前iframe层的索引
    var index = parent.layer.getFrameIndex(window.name);
    //再执行关闭   
    parent.layer.close(index); 
}
</script>
</body>
</html>