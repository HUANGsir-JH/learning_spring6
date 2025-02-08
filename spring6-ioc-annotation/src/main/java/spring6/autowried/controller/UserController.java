package spring6.autowried.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import spring6.autowried.service.UserServiceImp;

@Data
@Controller
public class UserController {
    // 注入service
    @Autowired
    private UserServiceImp userService;
    public void addUser() {
        System.out.println("controller add........");
        userService.add();
    }
    
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("bean.xml")
                .getBean("userController", UserController.class).addUser();
    }
}
