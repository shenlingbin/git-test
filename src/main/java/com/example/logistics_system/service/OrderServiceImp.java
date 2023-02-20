package com.example.logistics_system.service;

import com.example.logistics_system.dao.IOrderDao;
import com.example.logistics_system.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:沈玲彬
 * @create: 2022-10-16 20:21
 * @Description:
 */
@Service(value = "orderService")
public class OrderServiceImp implements IOrderService{
    @Autowired
    IOrderDao dao;
    @Override
    public List<Orders> all() {
        return dao.all();
    }

    @Override
    public List<Orders> search(String productName) {
        return dao.search(productName);
    }

    @Override
    public List<Orders> personalOrder(String userName) {
        return dao.personalOrder(userName);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public int update(Orders orders) {
        return dao.update(orders);
    }

    @Override
    public int add(Orders order) {
        return dao.add(order);
    }
}
