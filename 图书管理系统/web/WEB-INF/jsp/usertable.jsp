<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="common/head.jsp" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户管理页面</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath}/admin/query">
            <span>用户名：</span>
            <input name="username" class="input-text" type="text"  placeholder="请输入用户名">
            <input value="查 询" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath}/admin/toAddUser">添加用户</a>
        </form>
    </div>
    <!--用户-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">用户名</th>
            <th width="20%">密码</th>
            <th width="10%">电话</th>
            <th width="10%">可借阅时间</th>
            <th width="10%">违约天数</th>
            <th width="10%">操作</th>
        </tr>
        <c:forEach var="user" items="${userlist }" varStatus="status">
            <tr>
                <td>
                    <span>${user.username }</span>
                </td>
                <td>
                    <span>${user.password }</span>
                </td>
                <td>
                    <span>${user.usernumber}</span>
                </td>
                <td>
                    <span>${user.day}</span>
                </td>
                <td>
                    <span>${user.overday}</span>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/toUpdateUser?id=${user.username}">更改</a> |
                    <a href="${pageContext.request.contextPath}/admin/delUser/${user.username}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</section>


