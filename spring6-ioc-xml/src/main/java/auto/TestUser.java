package auto;

import auto.UserController.UserController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean-auto.xml");
        context.getBean("userController", UserController.class).addUser();
    }
}
