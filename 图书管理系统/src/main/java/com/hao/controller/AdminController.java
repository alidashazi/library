package com.hao.controller;

import com.hao.pojo.Admin;
import com.hao.pojo.Books;
import com.hao.pojo.Borrowbook;
import com.hao.pojo.User;
import com.hao.service.AdminServiceImpl;
import com.hao.service.BookService;
import com.hao.service.BorrowServiceImpl;
import com.hao.service.UserService;
import com.hao.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;
    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminServiceImpl adminService;
    @Autowired
    @Qualifier("BorrowServiceImpl")
    private BorrowServiceImpl borrowService;

    //查询所有用户
    @RequestMapping("/allUser")
    public String selectAllUser(Model model){
        List<User> userlist=userService.queryAllUser();
        model.addAttribute("userlist",userlist);
        for (User user : userlist) {
            System.out.println("AdminController selectAllUser="+user);
        }
        return "usertable";
    }

    //通过用户名查询用户
    @RequestMapping("/query")
    public String selectByUserName(String username, Model model){
        User user = userService.queryUserById(username);
        List <User> userlist=new ArrayList();
        userlist.add(user);
        model.addAttribute("userlist",userlist);
        return "usertable";
    }

    //跳转到添加用户界面
    @RequestMapping("/toAddUser")
    public String toAddUserPaper(){
        return "useradd";
    }

    //添加用户操作
    @RequestMapping("/addUser")
    public String AddUser(String username,String password,String usernumber,Model model){
        User user=new User(username,password,usernumber,30,0);
        userService.addUser(user);
        System.out.println("AdminController AddUser添加成功");
        return "redirect:/admin/allUser";
    }

    //删除用户
    @RequestMapping("/delUser/{username}")
    public String delUser(@PathVariable String username){
        userService.deleteUserById(username);
        System.out.println("AdminController delUser删除成功");
        return "redirect:/admin/allUser";
    }

    //跳转到更新用户界面
    @RequestMapping("/toUpdateUser")
    public String toUpdateUser(String id,Model model){
        User user = userService.queryUserById(id);
        model.addAttribute("user",user);
        return "updateUser";
    }

    //更新用户操作
    @RequestMapping("/updateUser")
    public  String updateUser(User user){
        userService.updateUser(user);
        System.out.println("AdminController updateUser="+user);
        return "redirect:/admin/allUser";
    }

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
        return "redirect:/admin/allBook";
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
        return "redirect:/admin/allBook";
    }

    //删除操作
    @RequestMapping("/del/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id){
        bookService.deleteBookById(id);
        return "redirect:/admin/allBook";
    }

    //查询功能
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        List<Books> list = bookService.queryBook(queryBookName);
        model.addAttribute("list",list);
        return "allBook";
    }
    //跳转到密码修改界面
    @RequestMapping("/toupdatepassword")
    public String updatePassword(){
        return "adminupdatepassword";
    }

    @RequestMapping("/updatepassword")
    public String updatePassword(String password, String rpassword, HttpSession session,Model model){
        String name= (String) session.getAttribute(Constants.USER_SESSION);
        System.out.println("AdminController updatePassword name="+name);
        String corr_password=adminService.selectPassword(name);
        System.out.println("AdminController updatePassword password="+corr_password);
        if(!password.equals(corr_password)){
            model.addAttribute("msg","密码错误");
            return "/adminupdatepassword";
        }else{
            Admin admin = adminService.selectByAdminname(name);
            String number=admin.getAdminnumber();
            adminService.updatePassword(new Admin(name,rpassword,number));
            return "redirect:/admin/allBook";
        }
    }
    //跳转到admininfo界面
    @RequestMapping("toadminInfo")
    public String toadminInfo(HttpSession session,Model model){
        String adminname=(String)session.getAttribute(Constants.USER_SESSION);
        Admin admin=adminService.selectByAdminname(adminname);
        model.addAttribute("admin",admin);
        return "adminInfo";
    }

    //跳转到用户借阅列表
    @RequestMapping("/toborrowlist")
    public String toborrowlist(Model model){
        List<Borrowbook> borrowbooklist = borrowService.selectAllBorrowbook();
        model.addAttribute("borrowbooklist",borrowbooklist);
        return "borrowlist";
    }

    //归还操作
    @RequestMapping("/returnborrowbook/{borrowId}/{bookId}")
    public String returnborrowbook(Model model, @PathVariable String borrowId, @PathVariable String bookId){
        System.out.println("AdminController returnborrowbook");
        System.out.println("AdminController returnborrowbook borrowId"+borrowId);
        System.out.println("AdminController returnborrowbook bookId"+bookId);
        borrowService.updateBorrowbook(borrowId);
        List<Borrowbook> borrowbooklist = borrowService.selectAllBorrowbook();
        model.addAttribute("borrowbooklist",borrowbooklist);
        Books book = bookService.queryBookById(Integer.parseInt(bookId));
        bookService.updateBook(new Books(Integer.parseInt(bookId),book.getBookName(),book.getBookCounts()+1,book.getDetail()));
        return "redirect:/admin/toborrowlist";
    }

    //查询借阅的书籍信息
    @RequestMapping("/queryborrowbookname")
    public String queryborrowbookname(Model model,String queryusername){
        System.out.println("Admin Controller queryborrowbookname");
        List<Borrowbook> borrowbooklist = borrowService.selectByBorrowBookName(queryusername);
        model.addAttribute("borrowbooklist",borrowbooklist);
        System.out.println(borrowbooklist);
        return "borrowlist";
    }

    //跳转到归还的界面
    @RequestMapping("/toreturnbooklist")
    public String toqueryreturnbookname(HttpSession session,Model model){
        String borrowname=(String)session.getAttribute(Constants.USER_SESSION);
        List<Borrowbook> returnbooklist = borrowService.selectAllReturnbook();
        model.addAttribute("returnbooklist",returnbooklist);
        System.out.println(returnbooklist);
        return "adminreturnlist";
    }

    //查询归还书籍操作
    @RequestMapping("/queryreturnbookname")
    public String queryreturnbookname(Model model,String queryBookName){
        System.out.println("Admin Controller queryreturnbookname");
        List<Borrowbook> returnbooklist = borrowService.selectByReturnBookName(queryBookName);
        model.addAttribute("returnbooklist",returnbooklist);
        System.out.println(returnbooklist);
        return "adminreturnlist";
    }
}
