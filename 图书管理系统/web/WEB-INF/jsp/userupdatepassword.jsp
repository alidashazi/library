<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="common/userhead.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户页面 >> 用户密码修改页面</span>
    </div>
    <div class="providerAdd">
        <form method="post" action="${pageContext.request.contextPath }/user/updatepassword">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                ${msg}
            </div>
            <div>
                <label for="password">请输旧密码：</label>
                <input type="text" name="password" id="password" >
            </div>
            <div>
                <label for="rpassword">请输入新密码：</label>
                <input type="text" name="rpassword" id="rpassword">
            </div>
            <div class="providerAddBtn">
                <input type="submit" value="保存" >
                <input type="reset"  value="重置" >
            </div>
        </form>
    </div>
</div>
</section>