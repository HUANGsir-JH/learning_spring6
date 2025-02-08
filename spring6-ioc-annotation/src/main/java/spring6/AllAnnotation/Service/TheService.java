package spring6.AllAnnotation.Service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring6.AllAnnotation.Dao.TheDao;

@Data
@Service
public class TheService implements ServiceInterface {
    
    @Autowired
    private TheDao theDao;

    @Override
    public void save() {
        System.out.println("TheService save() method called");
        theDao.save();
    }
}
