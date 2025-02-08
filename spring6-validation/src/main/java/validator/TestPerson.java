package validator;

import org.springframework.validation.DataBinder;

public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("John");
        person.setAge(200);
        // 1. 创建DataBinder对象,并指定需要绑定的对象
        DataBinder binder = new DataBinder(person);
        // 2. 设置验证器
        binder.setValidator(new PersonValidator());
        // 3. 执行验证
        binder.validate();
        // 4. 获取绑定结果
        binder.getBindingResult().getAllErrors().forEach(error ->
                System.out.println(error.getCode() + " : " + error.getDefaultMessage())
        );
    }
}
