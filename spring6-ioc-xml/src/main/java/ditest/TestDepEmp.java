package ditest;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDepEmp {
    
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-ditest.xml");
        Department department = context.getBean("department", Department.class);
        department.show();
//        Emp emp1 = context.getBean("emp1", Emp.class);
//        System.out.println(emp1);
//        Emp emp2 = context.getBean("emp2", Emp.class);
//        System.out.println(emp2);
        Emp emp3 = context.getBean("emp3", Emp.class);
        System.out.println(emp3);
    }
}
