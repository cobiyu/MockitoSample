package com.cobi.testdouble.non_spring;

import com.cobi.testdouble.NotificationClient;
import com.cobi.testdouble.repository.OrderRepository;
import com.cobi.testdouble.service.OrderService;
import org.junit.jupiter.api.Test;

class BasicTests {
    private OrderService orderService;

    @Test
    void createOrderTest() {
        OrderRepository orderRepository = new OrderRepository();
        NotificationClient notificationClient = new NotificationClient();

        orderService = new OrderService(orderRepository, notificationClient);

        orderService.createOrder(true);
    }

}
