<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户管理页面 >> 用户修改页面</span>
    </div>
    <div class="providerAdd">
        <form method="post" action="${pageContext.request.contextPath }/admin/updateUser">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                <label for="username">用户名：</label>
                <input type="text" name="username" id="username" value="${user.getUsername()}">
            </div>
            <div>
                <label for="password">密码：</label>
                <input type="text" name="password" id="password" value="${user.getPassword()}">
            </div>
            <div>
                <label for="usernumber">用户电话号码：</label>
                <input type="text" name="usernumber" id="usernumber" value="${user.getUsernumber()}">
            </div>
            <div>
                <label for="day">可借阅时间：</label>
                <input type="text" name="day" id="day" value="${user.getDay()}">
            </div>
            <div>
                <label for="overday">违约天数：</label>
                <input type="text" name="overday" id="overday" value="${user.getOverday()}">
            </div>
            <div class="providerAddBtn">
                <input type="submit" value="保存" >
                <input type="reset"  value="重置" >
            </div>
        </form>
    </div>
</div>
</section>