import com.hao.pojo.Admin;
import com.hao.service.AdminServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminTest {
    @Test
    public void test01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        AdminServiceImpl adminService= (AdminServiceImpl) context.getBean("AdminServiceImpl");
        System.out.println(adminService.selectPassword("admin"));
    }

    @Test
    public void test02(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        AdminServiceImpl adminService= (AdminServiceImpl) context.getBean("AdminServiceImpl");
        System.out.println(adminService.selectByAdminname("admin"));
    }

    @Test
    public void test03(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        AdminServiceImpl adminService= (AdminServiceImpl) context.getBean("AdminServiceImpl");
        adminService.updatePassword(new Admin("admin","1234","15672309528"));
    }
}
