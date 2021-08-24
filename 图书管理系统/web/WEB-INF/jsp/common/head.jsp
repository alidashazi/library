<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>图书馆管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>图书馆管理系统</h1>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${usersession}</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="${pageContext.request.contextPath }/admin/allUser">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath }/admin/allBook">书籍管理</a></li>
                <li><a href="${pageContext.request.contextPath }/admin/toborrowlist">用户借阅列表</a></li>
                <li><a href="${pageContext.request.contextPath }/admin/toupdatepassword">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath }/admin/toadminInfo">管理员个人信息</a></li>
            </ul>
        </nav>
    </div>
    <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
    <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>

