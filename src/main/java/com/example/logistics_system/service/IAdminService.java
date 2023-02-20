package com.example.logistics_system.service;

import com.example.logistics_system.pojo.DriverDto;
import com.example.logistics_system.pojo.UserDto;

import java.util.List;
import java.util.Map;

public interface IAdminService {
    List<UserDto> all();
    int add(UserDto userDto);
    int delete(int id);
    int update(UserDto userDto);
    List<UserDto> search(String userName);
}
