package com.example.logistics_system.service;

import com.example.logistics_system.dao.IDriverDao;
import com.example.logistics_system.pojo.DriverDto;
import com.example.logistics_system.pojo.Drivers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:沈玲彬
 * @create: 2022-10-14 19:51
 * @Description:
 */
@Service(value = "driverService")
public class DriverServiceImp implements IDriverService{
    @Autowired
    IDriverDao dao;
    @Override
    public List<DriverDto> all() {
        return dao.all();
    }

    @Override
    public int add(DriverDto driverDto) {
        return dao.add(driverDto);
    }

    @Override
    public List<DriverDto> search(String userName) {
        return dao.search(userName);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public int update(DriverDto driverDto) {
        return dao.update(driverDto);
    }

    @Override
    public DriverDto personal(String userName) {
        return dao.personal(userName);
    }
}
