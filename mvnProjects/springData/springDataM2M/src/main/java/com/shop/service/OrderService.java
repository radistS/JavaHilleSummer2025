package com.shop.service;

import com.shop.dto.OrderDto;
import com.shop.dto.OrderUpdateDto;
import com.shop.entity.Order;
import java.util.List;

public interface OrderService {

    Long addOrder(OrderDto product);

    Order getOrderById(Long id);

    Order updateOrder(OrderUpdateDto order);

    void deleteOrderById(Long id);

    List<Order> getAllOrders();

    List<Order> getOrdersByUsername(String username);

    void deleteProductFromOrderById(long orderId, long productId);

}
