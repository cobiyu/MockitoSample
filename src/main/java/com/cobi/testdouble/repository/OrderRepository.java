package com.cobi.testdouble.repository;

import com.cobi.testdouble.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class OrderRepository {
    public List<Order> findOrderList(){
        System.out.println("real OrderRepository findOrderList");
        return Collections.emptyList();
    }

    public void createOrder(){
        System.out.println("createOrder success");
    }
}
