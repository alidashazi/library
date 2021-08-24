import com.hao.pojo.Borrowbook;
import com.hao.service.AdminServiceImpl;
import com.hao.service.BorrowServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BorrowTest {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        BorrowServiceImpl borrowService= (BorrowServiceImpl) context.getBean("BorrowServiceImpl");
        borrowService.addBorrowbook(new Borrowbook("5","1810301218",1,"Java","2021-07-29 15:39","2021-08-29 15:39","未归还"));
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        BorrowServiceImpl borrowService= (BorrowServiceImpl) context.getBean("BorrowServiceImpl");
        System.out.println(borrowService.selectByBorrowName("1810301218"));
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        BorrowServiceImpl borrowService= (BorrowServiceImpl) context.getBean("BorrowServiceImpl");
        //borrowService.addBorrowbook(new Borrowbook("6","1810301218",2,"MySQL","2021-07-29 15:39","2021-08-29 15:39","未归还"));
        System.out.println(borrowService.selectByBorrowName("1810301218"));
    }

    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        BorrowServiceImpl borrowService= (BorrowServiceImpl) context.getBean("BorrowServiceImpl");
        borrowService.updateBorrowbook("1");
    }

    @Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        BorrowServiceImpl borrowService= (BorrowServiceImpl) context.getBean("BorrowServiceImpl");
        System.out.println(borrowService.selectByBorrowBookName("Java"));
    }

    @Test
    public void test6(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        BorrowServiceImpl borrowService= (BorrowServiceImpl) context.getBean("BorrowServiceImpl");
        System.out.println(borrowService.selectByReturnBookName("Java"));
    }

    @Test
    public void test7(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        BorrowServiceImpl borrowService= (BorrowServiceImpl) context.getBean("BorrowServiceImpl");
        System.out.println(borrowService.selectUserByReturnBookName("Java","1810301218"));
    }

    @Test
    public void test8(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        BorrowServiceImpl borrowService= (BorrowServiceImpl) context.getBean("BorrowServiceImpl");
        System.out.println(borrowService.selectUserByBorrowBookName("Java","1810301218"));
    }

}
