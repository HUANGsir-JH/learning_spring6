package transaction.dao;

public interface DaoImp {
    Integer getStockByBookId(Integer bookId);
    void updateStockByBookId(Integer bookId, Integer num);
    String getBookNameByBookId(Integer bookId);
    
    Integer getPriceByBookId(Integer bookId);
    
    Integer getBalanceByUserId(Integer userId);
    void updateBalanceByUserId(Integer userId, Integer price);
    String getUserNameByUserId(Integer userId);
}
