package JDBC.Dao;

import JDBC.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
public class UserDao {
    @Autowired
    private final JdbcTemplate jdbc;
    
    // 插入用户
    public void insertUser(User user){
        String sql="insert into users(name,email) values(?,?)";
        jdbc.update(sql,user.getName(),user.getEmail());
    }
    
    // 更新用户
    public void updateUser(User user){
        String sql="update users set name=?,email=? where id=?";
        jdbc.update(sql,user.getName(),user.getEmail(),user.getId());
    }
    
    // 删除用户
    public void deleteUser(User user){
        String sql="delete from users where id=?";
        jdbc.update(sql,user.getId());
    }
    
    // 查询单个用户
    public User selectUser(Integer id){
        String sql="select * from users where id=?";
        return jdbc.queryForObject(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        },id);
    }
    
    // 查询所有用户
    public List<User> selectAllUser(){
        String sql="select * from users";
        return jdbc.query(sql,(rs,rowNum)->{
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        });
    }
    
    // 查询用户数量
    public Integer selectUserCount(){
        String sql="select count(*) from users";
        return jdbc.queryForObject(sql,Integer.class);
    }
    
    // 批量插入用户
    public void batchInsertUser(List<User> users){
        String sql="insert into users(name,email) values(?,?)";
        jdbc.batchUpdate(sql,users,users.size(),(ps,user)->{
            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
        });
    }
    
    // 批量更新用户
    public void batchUpdateUser(List<User> users){
        String sql="update users set name=?,email=? where id=?";
        jdbc.batchUpdate(sql,users,users.size(),(ps,user)->{
            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            ps.setInt(3,user.getId());
        });
    }
}
