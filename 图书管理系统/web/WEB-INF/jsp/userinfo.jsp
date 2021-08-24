<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="common/userhead.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户页面 >> 用户个人信息页面</span>
    </div>
    <div class="providerAdd">
        <form method="post" action="${pageContext.request.contextPath }/user/touserinfo">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                用户名:${user.username}
            </div>
            <div>
                用户密码:${user.password}
            </div>
            <div>
                用户电话:${user.usernumber}
            </div>
            <div>
                可借阅天数:${user.day}
            </div>
            <div>
                违约天数:${user.overday}
            </div>
        </form>
    </div>
</div>
</section>