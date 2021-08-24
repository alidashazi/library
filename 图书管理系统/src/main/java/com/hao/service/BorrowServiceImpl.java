package com.hao.service;

import com.hao.dao.BorrowMapper;
import com.hao.pojo.Borrowbook;

import java.util.List;

public class BorrowServiceImpl implements BorrowService{
    private BorrowMapper borrowMapper;
    public void setBorrowMapper(BorrowMapper borrowMapper) {
        this.borrowMapper = borrowMapper;
    }

    @Override
    public List<Borrowbook> selectAllBorrowbook() {
        return borrowMapper.selectAllBorrowbook();
    }

    @Override
    public List<Borrowbook> selectAllReturnbook() {
        return borrowMapper.selectAllReturnbook();
    }

    @Override
    public List<Borrowbook> selectByBorrowName(String borrowName) {
        return borrowMapper.selectByBorrowName(borrowName);
    }

    @Override
    public List<Borrowbook> selectReturnByBorrowName(String borrowName) {
        return borrowMapper.selectReturnByBorrowName(borrowName);
    }

    @Override
    public int addBorrowbook(Borrowbook borrowbook) {
        return borrowMapper.addBorrowbook(borrowbook);
    }

    @Override
    public int queryAllRows() {
        return borrowMapper.queryAllRows();
    }

    @Override
    public int updateBorrowbook(String borrowId) {
        return borrowMapper.updateBorrowbook(borrowId);
    }

    @Override
    public List<Borrowbook> selectByReturnBookName(String borrowName) {
        return borrowMapper.selectByReturnBookName(borrowName);
    }

    @Override
    public List<Borrowbook> selectByBorrowBookName(String borrowName) {
        return borrowMapper.selectByBorrowBookName(borrowName);
    }

    @Override
    public List<Borrowbook> selectUserByReturnBookName(String bookName,String borrowName) {
        return borrowMapper.selectUserByReturnBookName(bookName,borrowName);
    }

    @Override
    public List<Borrowbook> selectUserByBorrowBookName(String bookName, String borrowName) {
        return borrowMapper.selectUserByBorrowBookName(bookName,borrowName);
    }

}
