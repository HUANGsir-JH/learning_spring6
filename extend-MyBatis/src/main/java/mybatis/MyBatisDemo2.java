package mybatis;

import mybatis.mapper.UserMapper;
import mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

// MyBatis Demo-Mapper代理开发
public class MyBatisDemo2 {
    public static void main(String[] args) throws IOException {
        // 1.加载配置文件，获取SqlSessionFactory对象（官网）
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.执行SQL, 获取Mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 4.输出结果
        userMapper.selectAll().forEach(System.out::println);
        User userById = userMapper.selectById(1);
        System.out.println(userById);
        // 5.关闭SqlSession
        sqlSession.close();
    }
}
