package spring6.autowried.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class UserDaoImp implements UserDao {
    @Override
    public void add() {
        System.out.println("dao add........");
    }
}
