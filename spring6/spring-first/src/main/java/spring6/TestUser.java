package spring6;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    
    @Test
    public void testUser() {
        //加载配置文件，创建对象
        User user = (User) new ClassPathXmlApplicationContext("bean.xml").getBean("user");
        System.out.println(user);
        //调用方法
        user.add();
    }
    
    public void testLog(){
        Logger logger = LoggerFactory.getLogger(TestUser.class);
        logger.info(() -> "the test is running");
    }
    
    public static void main(String[] args) {
        TestUser testUser = new TestUser();
        testUser.testLog();
    }
}
