import com.hao.pojo.Books;
import com.hao.service.BookServiceImpl;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mytest {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        BookServiceImpl bookServiceImpl = (BookServiceImpl) context.getBean("BookServiceImpl");
        for (Books books : bookServiceImpl.queryAllBook()) {
            System.out.println(books);
        }
    }

    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        BookServiceImpl bookServiceImpl = (BookServiceImpl) context.getBean("BookServiceImpl");
        System.out.println(bookServiceImpl.queryBookById(1));
    }

    @Test
    public void test2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        BookServiceImpl bookServiceImpl = (BookServiceImpl) context.getBean("BookServiceImpl");
        bookServiceImpl.addBook(new Books(4,"python",10,"python从入门到放弃"));
    }

    @Test
    public void test3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        BookServiceImpl bookServiceImpl = (BookServiceImpl) context.getBean("BookServiceImpl");
        System.out.println(bookServiceImpl.deleteBookById(4));
    }

    @Test
    public void test4(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        BookServiceImpl bookServiceImpl = (BookServiceImpl) context.getBean("BookServiceImpl");
        bookServiceImpl.updateBook(new Books(1,"Java",6,"Java程序设计"));
    }

    @Test
    public void test5(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        BookServiceImpl bookServiceImpl = (BookServiceImpl) context.getBean("BookServiceImpl");
        System.out.println(bookServiceImpl.queryAllRows());
    }

    @Test
    public void test6(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        BookServiceImpl bookServiceImpl = (BookServiceImpl) context.getBean("BookServiceImpl");
        System.out.println(bookServiceImpl.queryBook("Java"));
    }

}
