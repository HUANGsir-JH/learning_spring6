package transaction.dao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class BookDao implements DaoImp {
    @Autowired
    private final JdbcTemplate jdbc;
    
    @Override
    public Integer getStockByBookId(Integer bookId) {
        String sql = "select stock from t_book where book_id=?";
        return jdbc.queryForObject(sql, Integer.class, bookId);
    }
    
    @Override
    public void updateStockByBookId(Integer bookId, Integer num) {
        String sql = "update t_book set stock=stock-? where book_id=?";
        jdbc.update(sql, num, bookId);
    }
    
    @Override
    public String getBookNameByBookId(Integer bookId) {
        String sql="select book_name from t_book where book_id=?";
        return jdbc.queryForObject(sql,String.class,bookId);
    }
    
    @Override
    public Integer getPriceByBookId(Integer bookId) {
        String sql = "select price from t_book where book_id=?";
        return jdbc.queryForObject(sql, Integer.class, bookId);
    }
    
    @Override
    public Integer getBalanceByUserId(Integer userId) {
        String sql = "select balance from t_user where user_id=?";
        return jdbc.queryForObject(sql, Integer.class,userId);
    }
    
    @Override
    public void updateBalanceByUserId(Integer userId, Integer price) {
        String sql = "update t_user set balance=balance-? where user_id=?";
        jdbc.update(sql, price, userId);
    }
    
    @Override
    public String getUserNameByUserId(Integer userId) {
        String sql="select username from t_user where user_id=?";
        return jdbc.queryForObject(sql,String.class,userId);
    }
    
}
