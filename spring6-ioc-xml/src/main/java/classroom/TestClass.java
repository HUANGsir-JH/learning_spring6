package classroom;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("bean-classroom.xml");
        Classroom classroom = context.getBean("classroom", Classroom.class);
        System.out.println(classroom);
    }
}
