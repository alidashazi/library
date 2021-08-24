<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="common/head.jsp" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户已还书页面</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath}/admin/queryreturnbookname">
            <span>用户名：</span>
            <input name="queryBookName" class="input-text" type="text"  placeholder="请输入用户名">
            <input value="查 询" type="submit" id="searchbutton">
        </form>
    </div>
    <!--用户-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th>借阅编号</th>
            <th>借阅人</th>
            <th>书籍编号</th>
            <th>书籍名字</th>
            <th>借阅时间</th>
            <th>状态</th>
        </tr>
        <c:forEach var="borrow" items="${requestScope.get('returnbooklist')}">
            <tr>
                <td>${borrow.getBorrowId()}</td>
                <td>${borrow.getBorrowName()}</td>
                <td>${borrow.getBookId()}</td>
                <td>${borrow.getBookName()}</td>
                <td>${borrow.getBorrowtime()}</td>
                <td>${borrow.getStatus()}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</section>
