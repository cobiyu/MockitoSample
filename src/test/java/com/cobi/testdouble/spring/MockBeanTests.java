package com.cobi.testdouble.spring;

import com.cobi.testdouble.NotificationClient;
import com.cobi.testdouble.repository.OrderRepository;
import com.cobi.testdouble.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;

@SpringBootTest
public class MockBeanTests {
    @MockBean
    private OrderRepository orderRepository;
    @MockBean
    private NotificationClient notificationClient;
    @Autowired
    private OrderService orderService;

    @Test
    public void createOrderTest_basic() {
        // given
        Mockito.when(orderRepository.findOrderList()).then(invocation -> {
            System.out.println("I'm mockBean orderRepository");
            return Collections.emptyList();
        });
        Mockito.doAnswer(invocation -> {
            System.out.println("I'm mockBean notificationclient");
            return null;
        }).when(notificationClient).notifyToMobile();


        // when
        orderService.createOrder(true);

        // then
        Mockito.verify(orderRepository, Mockito.times(1)).createOrder();
        Mockito.verify(notificationClient, Mockito.times(1)).notifyToMobile();
    }
}
