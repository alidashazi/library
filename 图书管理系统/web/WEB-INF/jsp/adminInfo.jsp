<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>管理员页面 >> 管理员和人信息页面</span>
    </div>
    <div class="providerAdd">
        <form method="post" action="${pageContext.request.contextPath }/admin/updateBook">
            <input type="hidden" name="bookID" value="${book.getBookID()}"/>
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                管理员用户名:${admin.adminname}
            </div>
            <div>
                管理员密码:${admin.adminpassword}
            </div>
            <div>
                管理员电话:${admin.adminnumber}
            </div>
        </form>
    </div>
</div>
</section>