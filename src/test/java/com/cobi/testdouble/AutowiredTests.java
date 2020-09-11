package com.cobi.testdouble;

import com.cobi.testdouble.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutowiredTests {
    @Autowired
    private OrderService orderService;

    @Test
    void createOrderTest() {
        orderService.createOrder();
    }

}
