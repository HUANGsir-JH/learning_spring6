package classroom;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class teacher {
    private String name;
    private String subject;
    public teacher(String name,String subject){
        this.name = name;
        this.subject = subject;
    }
    
    public teacher() {
    }
    
    @Override
    public String toString() {
        return "teacher{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
