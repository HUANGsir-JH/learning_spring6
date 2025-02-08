package validator_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

@Component
public class UserValidator {
    @Autowired
    private Validator validator;
    
    public boolean validate(User user) {
        BindException errors = new BindException(user, "user");// 创建一个BindException对象，用于保存校验错误信息
        validator.validate(user, errors);// 使用Validator对User对象进行校验
        if (errors.hasErrors()) {
            System.out.println("校验结果：" + errors);
            return false;
        }else {
            System.out.println("校验通过");
            return true;
        }
    }
}
