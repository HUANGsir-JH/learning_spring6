package validator_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestValidator {
    
    public static void main(String[] args) {
        User user = new User();
        user.setName("John");
        user.setAge(200);
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserValidator validator = context.getBean(UserValidator.class);
        validator.validate(user);
    }
}
