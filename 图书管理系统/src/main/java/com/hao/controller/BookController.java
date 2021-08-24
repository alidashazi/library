package com.hao.controller;

import com.hao.pojo.Books;
import com.hao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller层调用service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部书籍
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list=bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    //跳转到增加书籍界面
    @RequestMapping("/toAddBook")
    public String toAddBookPaper(){
        return "addBook";
    }

    //添加书籍的操作
    @RequestMapping("/addBook")
    public String AddBook(String bookName,String bookCounts,String detail){
        int queryrows=bookService.queryAllRows();
        Books book=new Books(queryrows+1,bookName,Integer.parseInt(bookCounts),detail);
        bookService.addBook(book);
        System.out.println(book);
        return "redirect:/book/allBook";
    }

    //跳转到修改书籍界面
    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(int id,Model model){
        Books book=bookService.queryBookById(id);
        model.addAttribute("book",book);
        return "updateBook";
    }

    //执行修改操作
    @RequestMapping("/updateBook")
    public String updateBook(Books book){
        System.out.println("updateBook=>"+book);
        bookService.updateBook(book);
        return "redirect:/book/allBook";
    }

    //删除操作
    @RequestMapping("/del/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //查询功能
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        List<Books> list = bookService.queryBook(queryBookName);
        model.addAttribute("list",list);
        return "allBook";
    }


}
