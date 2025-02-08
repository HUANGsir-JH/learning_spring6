class UserService {
    private UserRepository userRepository;
    
    public void print() {
        System.out.println("UserService: " + userRepository);
    }
}

class UserRepository {
    public void print() {
        System.out.println("UserRepository");
    }
}

public class TestSimpleIoC {
    public static void main(String[] args) {
        // 1. 创建容器
        SimpleBeanContainer container = new SimpleBeanContainer();
        // 2. 注册 Bean 定义
        container.registerBean("userRepository", UserRepository.class);
        container.registerBean("userService", UserService.class);
        
        // 3. 获取 Bean
        UserRepository userRepository = (UserRepository) container.getBean("userRepository");
        userRepository.print(); // 输出：UserRepository
        
        UserService userService = (UserService) container.getBean("userService");
        userService.print(); // 输出：UserService: 地址
    }
}