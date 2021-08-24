package com.hao.controller;

import com.hao.pojo.Books;
import com.hao.pojo.Borrowbook;
import com.hao.pojo.User;
import com.hao.service.AdminServiceImpl;
import com.hao.service.BookService;
import com.hao.service.BorrowServiceImpl;
import com.hao.service.UserService;
import com.hao.util.Constants;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //controller层调用service层
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminServiceImpl adminService;
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;
    @Autowired
    @Qualifier("BorrowServiceImpl")
    private BorrowServiceImpl borrowService;

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, String type, Model model){
        System.out.println("UserController login username="+username);
        System.out.println("UserController login password="+password);
        System.out.println("UserController login type="+type);
        //设置session
        session.setAttribute(Constants.USER_SESSION,username);
        System.out.println("UserController login Constants.USER_SESSION="+session.getAttribute(Constants.USER_SESSION));
        String name= (String) session.getAttribute(Constants.USER_SESSION);
        if(type.equals("user")&&password.equals(userService.selectPassword(name))) {
            return "user";
        }else if(type.equals("admin")&&password.equals(adminService.selectPassword(name))) {
            System.out.println("进入管理员界面");
            return "admin";
        }else{
                System.out.println("密码错误");
                //model.addAttribute("msg","密码错误");
                return  "error";
            }
    }


    //跳转到用户信息界面
    @RequestMapping("/touserinfo")
    public String touserinfo(HttpSession session,Model model){
        String username=(String)session.getAttribute(Constants.USER_SESSION);
        User user = userService.queryUserById(username);
        model.addAttribute("user",user);
        System.out.println("UserController touserinfo username="+username);
        System.out.println("UserController touserinfo user="+user);
        return "userinfo";
    }

    //跳转到修改密码界面
    @RequestMapping("/toupdatepassword")
    public String toupdatepassword(){
        System.out.println("UserController toupdatepassword");
        return "userupdatepassword";
    }

    //执行修改密码操作
    @RequestMapping("/updatepassword")
    public String updatepassword(String password,String rpassword,HttpSession session,Model model){
        String username=(String)session.getAttribute(Constants.USER_SESSION);
        System.out.println("UserController updatepassword password="+password);
        User user = userService.queryUserById(username);
        if(!password.equals(user.getPassword())){
            model.addAttribute("msg","旧密码输入错误，清重新输入!");
            return "userupdatepassword";
        }else{
            String usernumber = user.getUsernumber();
            int day = user.getDay();
            int overday = user.getOverday();
            userService.updateUser(new User(username,rpassword,usernumber,day,overday));
            System.out.println("UserController updatepassword成功修改密码");
            return "redirect:/user/toupdatepassword";
        }
    }

    //跳转到书籍列表
    @RequestMapping("/tobooklist")
    public String tobooklist(Model model){
        System.out.println("UserController tobooklist");
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "booklist";
    }

    //书籍借阅操作，例如，借一次书就减少一本,然后会在借阅表多一条借阅记录
    @RequestMapping("/borrowbook/{bookID}")
    public String borrowbook(@PathVariable String bookID,HttpSession session){
        System.out.println("UserController borrowbook");
        System.out.println("UserController borrowbook bookID="+bookID);
        Books book = bookService.queryBookById(Integer.parseInt(bookID));
        bookService.updateBook(new Books(Integer.parseInt(bookID),book.getBookName(),book.getBookCounts()-1,book.getDetail()));
        int borrowcount=borrowService.queryAllRows();
        Long date=System.currentTimeMillis();
        String borrowname= (String) session.getAttribute(Constants.USER_SESSION);
        String borrowtime = new Date(date).toLocaleString();
        String returntime=new Date(date+1000*60*60*24*20).toLocaleString();
        Borrowbook borrow=new Borrowbook(Integer.toString(borrowcount+1),borrowname,book.getBookID(),book.getBookName(),borrowtime,returntime,"未归还");
        borrowService.addBorrowbook(borrow);
        return "redirect:/user/tobooklist";
    }

    //查询书籍操作
    @RequestMapping("/querybookname")
    public String querybookname(String queryBookName,Model model){
        System.out.println("UserController querybookname");
        List<Books> list = bookService.queryBook(queryBookName);
        model.addAttribute("list",list);
        System.out.println("UserController querybookname querylist="+list);
        return "booklist";
    }

    //跳转到借阅列表
    @RequestMapping("/toborrowbooklist")
    public String toborrowlist(HttpSession session,Model model){
        System.out.println("UserController toborrowlist");
        String username= (String) session.getAttribute(Constants.USER_SESSION);
        List<Borrowbook> borrowbooklist = borrowService.selectByBorrowName(username);
        model.addAttribute("borrowbooklist",borrowbooklist);
        return "userborrowlist";
    }

    //归还操作
    @RequestMapping("/returnborrowbook/{borrowId}/{bookId}")
    public String returnborrowbook(Model model, @PathVariable String borrowId, @PathVariable String bookId){
        System.out.println("UserController returnborrowbook");
        System.out.println("UserController returnborrowbook borrowId"+borrowId);
        System.out.println("UserController returnborrowbook bookId"+bookId);
        borrowService.updateBorrowbook(borrowId);
        List<Borrowbook> borrowbooklist = borrowService.selectAllBorrowbook();
        model.addAttribute("borrowbooklist",borrowbooklist);
        Books book = bookService.queryBookById(Integer.parseInt(bookId));
        bookService.updateBook(new Books(Integer.parseInt(bookId),book.getBookName(),book.getBookCounts()+1,book.getDetail()));
        return "redirect:/user/toborrowbooklist";
    }

    //查询借阅的书籍信息
    @RequestMapping("/queryborrowbookname")
    public String queryborrowbookname(HttpSession session,Model model,String queryBookName){
        System.out.println("UserController queryborrowbookname");
        String borrowname=(String)session.getAttribute(Constants.USER_SESSION);
        List<Borrowbook> borrowbooklist = borrowService.selectUserByBorrowBookName(queryBookName,borrowname);
        model.addAttribute("borrowbooklist",borrowbooklist);
        System.out.println(borrowbooklist);
        return "userborrowlist";
    }

    //跳转到归还的界面
    @RequestMapping("/toreturnbooklist")
    public String toqueryreturnbookname(HttpSession session,Model model){
        String borrowname=(String)session.getAttribute(Constants.USER_SESSION);
        List<Borrowbook> returnbooklist = borrowService.selectReturnByBorrowName(borrowname);
        model.addAttribute("returnbooklist",returnbooklist);
        System.out.println(returnbooklist);
        return "userreturnlist";
    }

    //查询归还书籍操作
    @RequestMapping("/queryreturnbookname")
    public String queryreturnbookname(HttpSession session,Model model,String queryBookName){
        System.out.println("UserController queryreturnbookname");
        String borrowname=(String)session.getAttribute(Constants.USER_SESSION);
        List<Borrowbook> returnbooklist = borrowService.selectUserByReturnBookName(queryBookName,borrowname);
        model.addAttribute("returnbooklist",returnbooklist);
        System.out.println(returnbooklist);
        return "userreturnlist";
    }
}
