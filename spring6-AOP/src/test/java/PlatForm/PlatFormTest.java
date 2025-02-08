package PlatForm;

import Platform.aspect.PermissionAspect;
import Platform.config.AppConfig;
import Platform.service.MerchantService;
import Platform.service.OrderInter;
import Platform.service.OrderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(classes = AppConfig.class)
public class PlatFormTest {
    @Autowired
    private OrderInter orderService;
    @Autowired
    private MerchantService merchantService;
    @BeforeEach
    public void setUp(){
        // 设置当前线程的角色为用户
        PermissionAspect.setCurrentRole("USER");
    }
    @AfterEach
    public void tearDown(){
        // 清除当前线程的角色
        PermissionAspect.removeCurrentRole();
    }
    
    @Test
    public void testCreateOrder(){
        List<String> items = Arrays.asList("红烧肉", "米饭");
        String orderId = orderService.createOrder("user_01", "shop_123", items);
        assertNotNull(orderId);// 断言订单ID不为空
    }
    
    @Test
    public void testCancelOrderWithoutPermission(){
        // 普通用户
        try{
            orderService.cancelOrder("order_123");
        } catch (Exception e) {
            System.out.println("权限异常");
        }
    }
    
    @Test
    public void testCancelOrderWithPermission(){
        // 管理员
        PermissionAspect.setCurrentRole("MERCHANT");
        orderService.cancelOrder("order_123");
    }
    
    @Test
    public void testPerformance() throws InterruptedException {
        long start = System.currentTimeMillis();
        orderService.queryUserOrders("user_01");
        System.out.println("首次查询耗时： "+(System.currentTimeMillis() - start)+"ms");
    }
}
