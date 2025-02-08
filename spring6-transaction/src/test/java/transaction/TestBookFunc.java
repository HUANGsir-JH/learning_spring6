package transaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import transaction.config.AppConfig;
import transaction.controller.BookController;

@SpringJUnitConfig(classes = AppConfig.class)
public class TestBookFunc {
    @Autowired
    private BookController bookController;
    
    @Test
    public void testBuyBook_exception() {
        bookController.buyBook(1, 1);
    }
    
    @Test
    /*
    在 Spring 的测试框架中，当 @Test 方法上标注了 @Transactional 注解时，默认情况下，
    Spring 会在测试方法执行完成后自动回滚事务 。这是为了确保测试不会对数据库状态产生持久化的影响。
    因此，即使你的 buyBook 方法成功执行了更新操作（如扣减余额和库存），
    这些更改也会在测试方法结束时被回滚，导致你观察不到数据库中的实际变化。
    */
    // @Transactional
    public void testBuyBook() {
        bookController.buyBook(2, 2);
    }
}
