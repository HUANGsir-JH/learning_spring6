package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    
    // 表示该验证器是否支持指定的类
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }
    
    // 验证目标对象，并将错误信息注册到Errors对象中
    @Override
    public void validate(Object target, Errors errors) {
        // name属性不能为空
        ValidationUtils.rejectIfEmpty(errors, "name",
                "name.empty", "Name is empty.");
        // age属性不能小于0
        Person person = (Person) target;
        if (person.getAge() < 0) {
            errors.rejectValue("age", "NegativeValue",
                    "Age can't be negative.");
        } else if (person.getAge() > 110) {
            errors.rejectValue("age", "too.darn.old",
                    "You're too old, dude.");
        }
    }
}
