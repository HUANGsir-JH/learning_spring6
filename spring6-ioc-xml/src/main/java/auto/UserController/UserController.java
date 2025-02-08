package auto.UserController;

import auto.UserService.UserServiceImp;

public class UserController {
    private UserServiceImp userService;
    
    public UserServiceImp getUserService() {
        return userService;
    }
    
    public void setUserService(UserServiceImp userService) {
        this.userService = userService;
    }
    
    public void addUser() {
        System.out.println("userController执行...");
        userService.addUserService();
    }
}
