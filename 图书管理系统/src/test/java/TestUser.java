import com.hao.pojo.User;
import com.hao.service.UserService;
import com.hao.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void test01(){
       ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
       //UserServiceImpl userServiceImpl= (UserServiceImpl) context.getBean("UserServiceImpl");
        //使用注解方法
        UserServiceImpl userServiceImpl=context.getBean("userServiceImpl",UserServiceImpl.class);
        System.out.println(userServiceImpl.queryAllUser());
    }

    @Test
    public void test02(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        //UserServiceImpl userServiceImpl= (UserServiceImpl) context.getBean("UserServiceImpl");
        //使用注解方法
        UserServiceImpl userServiceImpl=context.getBean("userServiceImpl",UserServiceImpl.class);
        userServiceImpl.updateUser(new User("1810301218","197152","15672309528",20,5));
    }

    @Test
    public void test03(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        //UserServiceImpl userServiceImpl= (UserServiceImpl) context.getBean("UserServiceImpl");
        //使用注解方法
        UserServiceImpl userServiceImpl=context.getBean("userServiceImpl",UserServiceImpl.class);
        userServiceImpl.addUser(new User("1234567891","wyh123456","11011912211",10,2));
    }

    @Test
    public void test04(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        UserServiceImpl userServiceImpl=context.getBean("userServiceImpl",UserServiceImpl.class);
        userServiceImpl.deleteUserById("1234567891");
    }

    @Test
    public void test05(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        UserServiceImpl userServiceImpl=context.getBean("userServiceImpl",UserServiceImpl.class);
        System.out.println(userServiceImpl.queryUserById("1810301218"));
    }

    @Test
    public void test06(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        UserServiceImpl userServiceImpl=context.getBean("userServiceImpl",UserServiceImpl.class);
        System.out.println(userServiceImpl.queryAllRows());
    }

    @Test
    public void test07(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        UserServiceImpl userServiceImpl= (UserServiceImpl) context.getBean("UserServiceImpl");
        System.out.println(userServiceImpl.selectPassword("1810301218"));
    }



}
