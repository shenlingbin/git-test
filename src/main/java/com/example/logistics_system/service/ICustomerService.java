package com.example.logistics_system.service;

import com.example.logistics_system.pojo.CustomerDto;
import com.example.logistics_system.pojo.Customers;

import java.util.List;

public interface ICustomerService {
    List<Customers> all();
    int add(CustomerDto customerDto);
    int delete(int id);
    List<Customers> search(String userName);
    CustomerDto personal(String userName);
    int update(CustomerDto customerDto);
}
