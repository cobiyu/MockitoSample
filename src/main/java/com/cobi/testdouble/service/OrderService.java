package com.cobi.testdouble.service;

import com.cobi.testdouble.NotificationClient;
import com.cobi.testdouble.exception.OrderDuplicateException;
import com.cobi.testdouble.entity.Order;
import com.cobi.testdouble.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final NotificationClient notificationClient;

    public void createOrder(Boolean isNotify){
        List<Order> orderList = orderRepository.findOrderList();
        if(orderList.size() > 0){
            throw new OrderDuplicateException();
        }

        orderRepository.createOrder();

        if(isNotify){
            notificationClient.notifyToMobile();
        }
    }
}
