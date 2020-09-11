package com.cobi.testdouble.service;

import com.cobi.testdouble.entity.Order;
import com.cobi.testdouble.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void createOrder(){
        List<Order> orderList = orderRepository.findOrderList();
    }
}
