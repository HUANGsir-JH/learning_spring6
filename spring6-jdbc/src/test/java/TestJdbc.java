import JDBC.Dao.UserDao;
import JDBC.User;
import JDBC.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;

@SpringJUnitConfig(classes = AppConfig.class)
public class TestJdbc {
    @Autowired
    private UserDao userDao;
    
    @Test
    public void testInsert(){
        System.out.println("before insert");
        userDao.selectAllUser().forEach(System.out::println);
        User user = new User("xiaohong", "xiaohong@qq.com");
        userDao.insertUser(user);
        System.out.println("success");
        userDao.selectAllUser().forEach(System.out::println);
    }
    
    @Test
    public void testUpdate() {
        System.out.println("before update");
        System.out.println(userDao.selectUser(1));
        User user = new User("xiaoxiaohei", "xiaohei@qq.com");
        user.setId(1);
        userDao.updateUser(user);
        System.out.println("success");
        System.out.println(userDao.selectUser(1));
    }
    
    @Test
    public void testDelete() {
        System.out.println("before delete");
        userDao.selectAllUser().forEach(System.out::println);
        User user = new User();
        user.setId(4);
        userDao.deleteUser(user);
        System.out.println("success");
        userDao.selectAllUser().forEach(System.out::println);
    }
    
    @Test
    public void testCount(){
        System.out.println(userDao.selectUserCount());
    }
    
    @Test
    public void testBatchInsert(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("xiaoming", "xiaoming@qq.com"));
        users.add(new User("xiaozhang", "xiaozhang@qq.com"));
        users.add(new User("xiaoli", "xiaoli@qq.com"));
        userDao.batchInsertUser(users);
        System.out.println("success");
        userDao.selectAllUser().forEach(System.out::println);
    }
}
