<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<input type="hidden" id="id" name="id" value="${id}" />

<tr class="table-row">
    <td class="table-name">
                    用户名:
    </td>
    <td class="table-value">
        <input type="text" id="userName" name="userName" value="${systemUser.userName}" placeholder="用户名"  class="col-xs-10 col-sm-5">
    </td>
</tr>
<tr class="table-row">
    <td class="table-name">
                    密码:
    </td>
    <td class="table-value">
        <input type="text" id="password" name="password" value="${systemUser.password}" placeholder="请输入字母和数字组合" class="col-xs-10 col-sm-5">
    </td>
</tr>
<tr class="table-row">
    <td class="table-name">
                    用户姓名:
    </td>
    <td class="table-value">
        <input type="text" id="name" name="name" value="${systemUser.name}" placeholder="用户姓名" class="col-xs-10 col-sm-5">
    </td>
</tr>
<tr class="table-row">
    <td class="table-name">
                    电子邮箱:
    </td>
    <td class="table-value">
        <input type="text" id="email" name="email" value="${systemUser.email}" placeholder="电子邮箱" class="col-xs-10 col-sm-5">
    </td>
</tr>
<tr class="table-row">
    <td class="table-name">
                    固定号码:
    </td>
    <td class="table-value">
        <input type="text" id="number" name="number" value="${systemUser.number}" placeholder="固定号码" class="col-xs-10 col-sm-5">
    </td>
</tr>
<tr class="table-row">
    <td class="table-name">
                    手机号码:
    </td>
    <td class="table-value">
        <input type="text" id="phone" name="phone" value="${systemUser.phone}" placeholder="手机号码" class="col-xs-10 col-sm-5">
    </td>
</tr>
