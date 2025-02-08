package spring6.AllAnnotation.Dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class TheDao implements DaoInterface {

    @Override
    public void save() {
        System.out.println("TheDao save() method called");
    }
}
