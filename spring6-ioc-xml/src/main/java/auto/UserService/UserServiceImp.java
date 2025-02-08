package auto.UserService;

import auto.UserDao.UserDaoImp;

public class UserServiceImp implements UserService {
    
    private UserDaoImp userDao;
    
    public UserDaoImp getUserDao() {
        return userDao;
    }
    
    public void setUserDao(UserDaoImp userDao) {
        this.userDao = userDao;
    }
    
    @Override
    public void addUserService() {
        System.out.println("userServiceImp执行...");
        userDao.addUserDao();
    }
}
