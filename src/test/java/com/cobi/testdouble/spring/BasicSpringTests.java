package com.cobi.testdouble.spring;

import com.cobi.testdouble.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BasicSpringTests {
    @Autowired
    private OrderService orderService;

    @Test
    void createOrderTest() {
        orderService.createOrder(true);
    }
}
