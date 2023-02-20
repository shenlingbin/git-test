package com.example.logistics_system.service;

import com.example.logistics_system.dao.ICustomerDao;
import com.example.logistics_system.pojo.CustomerDto;
import com.example.logistics_system.pojo.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:沈玲彬
 * @create: 2022-10-16 16:48
 * @Description:
 */
@Service(value = "customerService")
public class CustomerServiceImp implements ICustomerService{
    @Autowired
    ICustomerDao dao;

    @Override
    public List<Customers> all() {
        return dao.all();
    }

    @Override
    public int add(CustomerDto customerDto) {
        return dao.add(customerDto);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public List<Customers> search(String userName) {
        return dao.search(userName);
    }

    @Override
    public CustomerDto personal(String userName) {
        return dao.personal(userName);
    }
    @Override
    public int update(CustomerDto customerDto) {
        return dao.update(customerDto);
    }


}
