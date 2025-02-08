package classroom;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Classroom {
    private String cname;
    private teacher manager;
    public Classroom() {
    }
    public Classroom(String cname, teacher manager) {
        this.cname = cname;
        this.manager = manager;
    }
    
    @Override
    public String toString() {
        return "Classroom{" +
                "cname='" + cname + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
