package mybatis;

import mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// MyBatis Demo快速入门
public class MyBatisDemo {
    public static void main(String[] args) throws IOException {
        // 1.加载配置文件，获取SqlSessionFactory对象（官网）
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
        // 2.获取SqlSession对象
         SqlSession sqlSession = sqlSessionFactory.openSession();
         
         // 3. 执行SQL
        List<User> users = sqlSession.selectList("userMapper.selectAll");
        
        // 4.输出结果
        for (User user : users) {
            System.out.println(user);
        }
        
        // 5.关闭SqlSession
        sqlSession.close();
    }
}
