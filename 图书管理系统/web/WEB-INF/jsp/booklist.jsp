<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="common/userhead.jsp" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>书籍列表页面</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath}/user/querybookname">
            <span>书名：</span>
            <input name="queryBookName" class="input-text" type="text"  placeholder="请输入书籍名">
            <input value="查 询" type="submit" id="searchbutton">
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
                    <a href="${pageContext.request.contextPath}/user/borrowbook/${book.getBookID()}">借阅</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</section>
