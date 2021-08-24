package com.hao.service;

import com.hao.pojo.Books;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

//BookService:底下需要去实现,调用dao层
public interface BookService {
    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    int deleteBookById(int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book
    Books queryBookById(int id);

    //查询全部Book,返回list集合
    List<Books> queryAllBook();

    //查询数据库行数
    int queryAllRows();

    //查询书籍
    List<Books> queryBook(String bookName);

}