package com.example.logistics_system.service;

import com.example.logistics_system.dao.IUserDao;
import com.example.logistics_system.pojo.Admin;
import com.example.logistics_system.pojo.LoginTable;
import com.example.logistics_system.pojo.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author:沈玲彬
 * @create: 2022-10-10 20:33
 * @Description:
 */
@Service(value = "userService")
public class UserServiceImp implements IUserService{
    @Autowired
    IUserDao dao;
    @Override
    public Map<String, Object> login(String username, String password,int userRole) {
        //如果控制器发送过来数据是空的，那么返回控制器结果为空
        if (username == null && password==null && userRole == 0){
            return null;
        }else {
            return dao.selectUser(username,password,userRole);
        }
    }

    @Override
    public int addLogin(UserDto userDto) {
        return dao.add(userDto);
    }

    @Override
    public int deleteLogin(int id) {
        return dao.delete(id);
    }

    @Override
    public int updateLogin(UserDto userDto) {
        return dao.update(userDto);
    }

}
