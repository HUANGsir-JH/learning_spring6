package spring6.autowried.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp_2 implements UserDao {
    @Override
    public void add() {
        System.out.println("dao-2 add........");
    }
}
