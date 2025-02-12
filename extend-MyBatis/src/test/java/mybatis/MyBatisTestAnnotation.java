package mybatis;

import mybatis.mapper.UserMapper;
import mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTestAnnotation {
    @Test
    public void testSelectByName() {
        String username = "zhangsan";
        
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource);
             SqlSession sqlSession =
                     new SqlSessionFactoryBuilder().build(inputStream).openSession(true)) {
            User user = sqlSession.getMapper(UserMapper.class).selectByUsername(username);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("查询失败");
        }
        
    }
}
