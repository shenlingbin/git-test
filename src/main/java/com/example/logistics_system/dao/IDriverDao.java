package com.example.logistics_system.dao;

import com.example.logistics_system.pojo.DriverDto;
import com.example.logistics_system.pojo.Drivers;
import com.example.logistics_system.pojo.UserDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IDriverDao {
    @Select("select * from drivers")
    List<DriverDto> all();
    int add(DriverDto driverDto);
    List<DriverDto> search(String userName);
    @Delete("delete  from drivers where id=#{id}")
    int delete(@Param("id") int id);

    @Select("select * from drivers where id = #{id}")
    Drivers getById(@Param("id") int id);

    //根据用户id修改内容
    @Update("update drivers set name=#{name},userName=#{userName},password =#{password}," +
            "gender=#{gender},age=#{age},phone=#{phone},carType=#{carType},path=#{path}" +
            " where id=#{id}")
    int update(DriverDto driverDto);
    //根据用户用户名查询
    @Select("select * from drivers where userName = #{userName}")
    DriverDto personal(@Param("userName") String userName);

}
