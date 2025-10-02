package com.hilllel.cw_25.grasp;

public class Controller {

}

// Принцип контролера: Контролер відповідає за отримання входів від користувача або системи
// і делегує виконання відповідних операцій іншим класам.

class OrderController {
    private OrderService orderService;  // Сервіс для обробки замовлень

    public OrderController(OrderService service) {
        this.orderService = service;
    }

    // Метод контролера для обробки замовлення
    public void processOrder(int orderId) {
        // Контролер делегує обробку замовлення сервісу
        orderService.processOrder(orderId);
    }
}
//                      --> Service 1
// Controler -> Fasade  --> Service 2
//                      --> Service 3
class OrderService {
    // Логіка для обробки замовлення
    public void processOrder(int orderId) {
        System.out.println("Обробка замовлення з ID: " + orderId);
    }
}

// Пояснення:
// Контролер (OrderController) отримує вхідні дані (наприклад, ID замовлення) і делегує
// обробку замовлення іншому класу (OrderService), не виконуючи бізнес-логіку самостійно.
