package com.example.logistics_system.service;

import com.example.logistics_system.pojo.Orders;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface IOrderService {
    List<Orders> all();
    List<Orders> search(String productName);
    List<Orders> personalOrder(String userName);
    int delete(int id);
    int update(Orders orders);
    int add(Orders order);
}
