<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户管理页面 >> 用户添加页面</span>
    </div>
    <div class="providerAdd">
        <form method="post" action="${pageContext.request.contextPath }/admin/addUser">
            <input type="hidden" name="method" value="add">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                <label for="username">用户名：</label>
                <input type="text" name="username" id="username" value="">
            </div>
            <div>
                <label for="password">密码：</label>
                <input type="text" name="password" id="password" value="">
            </div>
            <div>
                <label for="usernumber">用户手机号码：</label>
                <input type="text" name="usernumber" id="usernumber" value="">
            </div>
            <div class="providerAddBtn">
                <input type="submit" value="保存" >
                <input type="reset"  value="重置" >
            </div>
        </form>
    </div>
</div>
</section>