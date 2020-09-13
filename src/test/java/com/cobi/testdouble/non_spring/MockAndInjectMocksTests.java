package com.cobi.testdouble.non_spring;

import com.cobi.testdouble.NotificationClient;
import com.cobi.testdouble.repository.OrderRepository;
import com.cobi.testdouble.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class MockAndInjectMocksTests {
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private NotificationClient notificationClient;
    @InjectMocks
    private OrderService orderService;

    @Test
    public void createOrderTest_basic() {
        // given
        Mockito.when(orderRepository.findOrderList()).then(invocation -> {
            System.out.println("I'm mock orderRepository");
            return Collections.emptyList();
        });
        Mockito.doAnswer(invocation -> {
            System.out.println("I'm mock notificationclient");
            return null;
        }).when(notificationClient).notifyToMobile();


        // when
        orderService.createOrder(true);

        // then
        Mockito.verify(orderRepository, Mockito.times(1)).createOrder();
        Mockito.verify(notificationClient, Mockito.times(1)).notifyToMobile();
    }
}
