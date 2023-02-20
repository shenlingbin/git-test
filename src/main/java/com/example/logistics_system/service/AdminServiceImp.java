package com.example.logistics_system.service;

import com.example.logistics_system.dao.IAdminDao;
import com.example.logistics_system.pojo.DriverDto;
import com.example.logistics_system.pojo.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author:沈玲彬
 * @create: 2022-10-11 21:00
 * @Description:
 */
@Service(value = "adminService")
public class AdminServiceImp implements IAdminService{
    @Autowired
    IAdminDao dao;
    @Override
    public List<UserDto> all() {
        return dao.all();
    }

    @Override
    public int add(UserDto userDto) {
        return dao.add(userDto);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public int update(UserDto userDto) {
        return dao.update(userDto);
    }

    @Override
    public List<UserDto> search(String userName) {
        return dao.search(userName);
    }
}
