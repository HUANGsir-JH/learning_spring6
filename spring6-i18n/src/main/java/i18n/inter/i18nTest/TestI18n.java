package i18n.inter.i18nTest;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Locale;

@Data
@Component
public class TestI18n {
    private static MessageSource messageSource;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("i18n.inter.config");
        messageSource = context.getBean(MessageSource.class);
        String message = messageSource.getMessage("message",
                new Object[] {"john",new Date().toString()}, Locale.US);
        System.out.println(message);
    }
}
