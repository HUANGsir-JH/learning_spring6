package spring6.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestUser {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        System.out.println(context.getBean("user", User.class));
    }
}
