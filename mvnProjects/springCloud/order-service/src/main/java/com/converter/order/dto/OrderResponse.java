package com.converter.order.dto;

public class OrderResponse {
    private Long orderId;
    private String product;
    private UserDto user;

    public OrderResponse() {}

    public OrderResponse(Long orderId, String product, UserDto user) {
        this.orderId = orderId;
        this.product = product;
        this.user = user;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}

