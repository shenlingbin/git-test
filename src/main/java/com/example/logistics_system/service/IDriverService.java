package com.example.logistics_system.service;

import com.example.logistics_system.pojo.DriverDto;
import com.example.logistics_system.pojo.Drivers;

import java.util.List;

public interface IDriverService {
    List<DriverDto> all();
    int add(DriverDto driverDto);
    List<DriverDto> search(String userName);
    int delete(int id);
    int update(DriverDto driverDto);
    DriverDto personal(String userName);

}
