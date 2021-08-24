<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>书籍管理页面 >> 书籍修改页面</span>
    </div>
    <div class="providerAdd">
        <form method="post" action="${pageContext.request.contextPath }/admin/updateBook">
            <input type="hidden" name="bookID" value="${book.getBookID()}"/>
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                <label for="bookName">书籍名字：</label>
                <input type="text" name="bookName" id="bookName" value="${book.getBookName()}">
            </div>
            <div>
                <label for="bookCounts">书籍数量：</label>
                <input type="text" name="bookCounts" id="bookCounts" value="${book.getBookCounts()}">
            </div>
            <div>
                <label for="detail">书籍详情：</label>
                <input type="text" name="detail" id="detail" value="${book.getDetail()}">
            </div>
            <div class="providerAddBtn">
                <input type="submit" value="保存" >
                <input type="reset"  value="重置" >
            </div>
        </form>
    </div>
</div>
</section>