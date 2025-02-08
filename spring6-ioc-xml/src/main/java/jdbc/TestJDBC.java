package jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJDBC {
    
    @Test
    public void test() {
        try (DruidDataSource dataSource = new DruidDataSource()) {
            dataSource.setUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void test2() {
        try {
            ClassPathXmlApplicationContext context = new
                    ClassPathXmlApplicationContext("bean-jdbc.xml");
            DruidDataSource dataSource = context.getBean("druidDataSource", DruidDataSource.class);
            System.out.println(dataSource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
