package transaction.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transaction.dao.DaoImp;

@Data
@Service
public class BookService implements ServiceImp {
    @Autowired
    private final DaoImp dao;
    
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        // 查询库存
        Integer stock = dao.getStockByBookId(bookId);
        if(stock<=0){
            System.out.println("库存不足");
            return;
        }
        // 查询书的价格
        Integer price=dao.getPriceByBookId(bookId);
        // 查询用户的余额
        Integer balance=dao.getBalanceByUserId(userId);
        // 判断余额是否足够并且判断是否进行减余额操作&&判断库存是否足够并且判断是否进行减库存操作
//        if(balance>=price) {
            // 减余额
            dao.updateBalanceByUserId(userId, price);
            // 减库存
            dao.updateStockByBookId(bookId, 1);
            System.out.println(dao.getUserNameByUserId(userId)+"购买《"+dao.getBookNameByBookId(bookId)+"》成功");
//        }else{
//            System.out.println("余额不足");
//        }
    }
}
