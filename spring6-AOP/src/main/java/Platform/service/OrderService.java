package Platform.service;

import Platform.annotation.RequiresRole;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class OrderService implements OrderInter {
    
    @Override
    public String createOrder(String userID, String restaurantID, List<String> items) {
        return "ORDER_ "+userID +" "+restaurantID+" "+items.toString();
    }
    
    @Override
    @RequiresRole("MERCHANT")
    public void cancelOrder(String orderID) {
        System.out.println("Order: "+orderID+" is canceled.");
    }
    
    @Override
    public List<String> queryUserOrders(String userID) {
        // 模拟查询用户订单
        return List.of("ORDER_1", "ORDER_2", "ORDER_3");
    }
}
