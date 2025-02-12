package mybatis.mapper;

// Mapper 代理开发
// 1. 定义与 SQL 映射文件同名的 Mapper 接口
// 2. 将 Mapper 接口和 SQL 映射文件放置在同一目录下
//   -> 在resources目录下创建mybatis/mapper目录，用于存放Mapper接口和SQL映射文件, 以便MyBatis自动扫描
//   -> 将UserMapper.java接口放置在mybatis/mapper目录下
//   -> 将UserMapper.xml放置在mybatis/mapper目录下
// 3. Mapper 接口的全限定名必须与 SQL 映射文件的 namespace 相同
//      <mapper namespace="mybatis.mapper.UserMapper">
//          <select id="selectAll" resultType="mybatis.pojo.User">
//              select * from tb_user;
//          </select>
//      </mapper>
// 4. Mapper 接口的方法名必须与 SQL 映射文件中的 SQL 语句的 id 相同，且返回值类型必须与 SQL 映射文件中的 resultType 相同

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    // 查询所有用户
    List<User> selectAll();
    // 根据id查询用户
    User selectById(Integer id);
    
    // 根据用户名查询用户（注解）
    // "Invalid or incomplete statement"报错无需理会，自己确保正确即可
    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(String username);
}
