package com.hao.dao;

import com.hao.pojo.Borrowbook;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BorrowMapper {
    //查询所有的借书人员
    List<Borrowbook> selectAllBorrowbook();
    //查看还书的人
    List<Borrowbook> selectAllReturnbook();
    //查询个人的借书情况
    List<Borrowbook> selectByBorrowName(String borrowName);
    //查看个人还书情况
    List<Borrowbook> selectReturnByBorrowName(String borrowName);
    //插入借书数据
    int addBorrowbook(Borrowbook borrowbook);
    //查询所有行数
    int queryAllRows();
    //还书的时候设置书的状态已归还
    int updateBorrowbook(String borrowId);
    //管理员根据归还图书名找对应的借书记录
    List<Borrowbook> selectByReturnBookName(String borrowName);
    //管理员根据未归还图书名找对应的借书记录
    List<Borrowbook> selectByBorrowBookName(String borrowName);
    //用户根据归还图书名找对应的借书记录
    List<Borrowbook> selectUserByReturnBookName(@Param("bookName")String bookName,@Param("borrowName")String borrowName);
    //用户根据未归还图书名找对应的借书记录
    List<Borrowbook> selectUserByBorrowBookName(@Param("bookName")String bookName,@Param("borrowName")String borrowName);
}
