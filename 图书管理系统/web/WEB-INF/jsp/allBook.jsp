<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="common/head.jsp" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>书籍管理页面</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath}/admin/queryBook">
            <span>书籍：</span>
            <input name="queryBookName" class="input-text" type="text"  placeholder="请输入书籍名">
            <input value="查 询" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath}/admin/toAddBook">添加书籍</a>
        </form>

    </div>
    <!--用户-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th>书籍编号</th>
            <th>书籍名字</th>
            <th>书籍数量</th>
            <th>书籍详情</th>
            <th>操作</th>
        </tr>
        <c:forEach var="book" items="${requestScope.get('list')}">
            <tr>
                <td>${book.getBookID()}</td>
                <td>${book.getBookName()}</td>
                <td>${book.getBookCounts()}</td>
                <td>${book.getDetail()}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/toUpdateBook?id=${book.getBookID()}">更改</a> |
                    <a href="${pageContext.request.contextPath}/admin/del/${book.getBookID()}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</section>
