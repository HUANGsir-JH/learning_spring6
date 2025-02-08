package spring6.AllAnnotation.Controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import spring6.AllAnnotation.Service.TheService;

@Data
@Controller
public class TheController {
    
    @Autowired
    private TheService theService;
    
    public void save() {
        System.out.println("TheController save() method called");
        theService.save();
    }
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("spring6.AllAnnotation");
        context.getBean(TheController.class).save();
    }
}
