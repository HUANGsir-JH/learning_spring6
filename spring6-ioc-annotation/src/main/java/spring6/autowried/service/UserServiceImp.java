package spring6.autowried.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring6.autowried.dao.UserDao;

@Service
public class UserServiceImp implements UserService {
//    // 属性注入：注入dao
//    @Autowired
//    private UserDao userDao;

//    // set方法注入：注入dao
//    private UserDao userDao;
//    @Autowired
//    public void setUserDao(UserDaoImp userDao) {
//        this.userDao = userDao;
//    }
    
//    // 构造方法注入：注入dao
//    private UserDao userDao;
//    @Autowired
//    public UserServiceImp(UserDaoImp userDao) {
//        this.userDao = userDao;
//    }
    
//    // 形参注入：注入dao
//    private UserDao userDao;
//    @Autowired
//    public UserServiceImp(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }
    
    // Qualifier注解：指定注入的bean
    @Autowired
    @Qualifier("userDaoImp_2")
    private UserDao userDao;
    
    @Override
    public void add() {
        System.out.println("service add........");
        userDao.add();
    }
}
