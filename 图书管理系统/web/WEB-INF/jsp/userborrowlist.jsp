<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="common/userhead.jsp" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户借阅页面</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath}/user/queryborrowbookname">
            <span>书名：</span>
            <input name="queryBookName" class="input-text" type="text"  placeholder="请输入书籍名">
            <input value="查 询" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath}/user/toreturnbooklist">借阅历史</a>
        </form>
    </div>
    <!--用户-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th>借阅编号</th>
            <th>书籍编号</th>
            <th>书籍名字</th>
            <th>借阅时间</th>
            <th>归还时间</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <c:forEach var="borrow" items="${requestScope.get('borrowbooklist')}">
            <tr>
                <td>${borrow.getBorrowId()}</td>
                <td>${borrow.getBookId()}</td>
                <td>${borrow.getBookName()}</td>
                <td>${borrow.getBorrowtime()}</td>
                <td>${borrow.getReturnday()}</td>
                <td>${borrow.getStatus()}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/returnborrowbook/${borrow.getBorrowId()}/${borrow.getBookId()}">归还</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</section>
