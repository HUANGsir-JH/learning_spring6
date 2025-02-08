package springIoCxml;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean("user", User.class);
        user.show();
        User user1 = context.getBean("non-arg-user", User.class);
        user1.show();
        User user2 = context.getBean("set-user", User.class);
        user2.show();
    }
}
