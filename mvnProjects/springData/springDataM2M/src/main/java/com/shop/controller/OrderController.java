package com.shop.controller;

import com.shop.dto.OrderDto;
import com.shop.dto.OrderResponse;
import com.shop.dto.OrderUpdateDto;
import com.shop.dto.PageResponse;
import com.shop.dto.ProductDto;
import com.shop.entity.Order;
import com.shop.entity.Product;
import com.shop.service.OrderService;
import com.shop.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService service;

    @PostMapping
    public Long createOtder(@RequestBody OrderDto order) {
        log.info("Run method create order");
        return service.addOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        log.info("Run method get order by id");
        return service.getOrderById(id);
    }

    @GetMapping("/user")
    public List<Order> getAllOrders(@RequestParam String username){
        log.info("Run method get all orders by user name");
        return service.getOrdersByUsername(username);
    }

    @PatchMapping
    public Order updateOrder(@RequestBody OrderUpdateDto order){
        log.info("Run method update order");
        return service.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id){
        log.info("Run method delete order by id");
        service.deleteOrderById(id);
    }

    @DeleteMapping("/{orderId}/product/{productId}")
    public void deleteProductFromOrderById(@PathVariable Long orderId, @PathVariable Long productId){
        service.deleteProductFromOrderById(orderId, productId);
    }

}
