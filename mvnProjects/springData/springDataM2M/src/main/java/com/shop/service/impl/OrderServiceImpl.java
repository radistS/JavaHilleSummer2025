package com.shop.service.impl;

import com.shop.dto.OrderDto;
import com.shop.dto.OrderUpdateDto;
import com.shop.entity.Order;
import com.shop.entity.Product;
import com.shop.exception.OrderNotFoundException;
import com.shop.exception.ProductNotFoundException;
import com.shop.repository.OrderRepository;
import com.shop.repository.ProductRepository;
import com.shop.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    public Long addOrder(OrderDto product) {
        List<Product> products = checkProductAvailability(product.getProducts());


        Order order = new Order()
            .setUserName(product.getUserName())
            .setProducts(products);
        return orderRepository.save(order).getId();
    }

    private List<Product> checkProductAvailability(List<Long> customerProductsList) {

        List<Product> products = productRepository.findAllById(customerProductsList);

        List<Long> availableProductList = products.stream().map(Product::getId).toList();

        customerProductsList.removeAll(availableProductList);

        if (!customerProductsList.isEmpty()) {
            throw new ProductNotFoundException(
                "Could not found products with id: " + customerProductsList);
        }

        return products;
    }

    @Override
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new OrderNotFoundException("ORDER_NOT_FOUND"));

        order.setCost(calucateCost(order.getProducts()));

        return order;
    }

    private Double calucateCost(List<Product> products) {
        return products.stream().map(Product::getPrice).reduce(0.0, Double::sum);
    }


    @Override
    public Order updateOrder(OrderUpdateDto updateOrder) {
        Order order = orderRepository.findById(updateOrder.getId())
            .orElseThrow(() -> new OrderNotFoundException("ORDER_NOT_FOUND"));

        List<Product> products = productRepository.findAllByIdIn(updateOrder.getProducts());

        order.getProducts().addAll(products);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);

    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByUsername(String username) {
        return orderRepository.findAllByUserName(username);
    }

    @Override
    public void deleteProductFromOrderById(long orderId, long productId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new OrderNotFoundException("ORDER_NOT_FOUND"));

        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ProductNotFoundException("PRODUCT_NOT_FOUND"));
        order.getProducts().remove(product);

        orderRepository.save(order);
    }
}
