package com.hao.pojo;

public class Borrowbook {
    private String borrowId;
    private String borrowName;
    private int bookId;
    private String bookName;
    private String borrowtime;
    private String returnday;
    private String status;

    public Borrowbook(String borrowId, String borrowName, int bookId, String bookName, String borrowtime, String returnday, String status) {
        this.borrowId = borrowId;
        this.borrowName = borrowName;
        this.bookId = bookId;
        this.bookName = bookName;
        this.borrowtime = borrowtime;
        this.returnday = returnday;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Borrowbook{" +
                "borrowId='" + borrowId + '\'' +
                ", borrowName='" + borrowName + '\'' +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", borrowtime='" + borrowtime + '\'' +
                ", returnday='" + returnday + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }
    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public void setBorrowtime(String borrowtime) {
        this.borrowtime = borrowtime;
    }
    public void setReturnday(String returnday) {
        this.returnday = returnday;
    }

    public String getStatus() {
        return status;
    }
    public String getBorrowId() {
        return borrowId;
    }
    public String getBorrowName() {
        return borrowName;
    }
    public int getBookId() {
        return bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public String getBorrowtime() {
        return borrowtime;
    }
    public String getReturnday() {
        return returnday;
    }

}
