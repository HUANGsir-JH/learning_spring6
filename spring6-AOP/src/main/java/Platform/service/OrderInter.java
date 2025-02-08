package Platform.service;

import java.util.List;

public interface OrderInter {
    String createOrder(String userID, String restaurantID, List<String> items);
    // 生成订单
    void cancelOrder(String orderID);
    // 取消订单
    List<String> queryUserOrders(String userID);
    // 查看订单
}
