package com.example.logistics_system.service;

import com.example.logistics_system.pojo.Admin;
import com.example.logistics_system.pojo.LoginTable;
import com.example.logistics_system.pojo.UserDto;

import java.util.List;
import java.util.Map;

public interface IUserService {
    //接收到登录任务
    Map<String, Object> login(String username, String password, int userRole);

    int addLogin(UserDto userDto);

    int deleteLogin(int id);

    int updateLogin(UserDto userDto);
}
