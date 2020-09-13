package com.cobi.testdouble.non_spring;

import com.cobi.testdouble.NotificationClient;
import com.cobi.testdouble.repository.OrderRepository;
import com.cobi.testdouble.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;


public class MockitoTests {
    private OrderService orderService;

    @Test
    public void createOrderTest() {
        // given
        OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
        NotificationClient notificationClient = Mockito.mock(NotificationClient.class);
        orderService = new OrderService(orderRepository, notificationClient);

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



