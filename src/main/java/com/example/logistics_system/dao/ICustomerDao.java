package com.example.logistics_system.dao;

import com.example.logistics_system.pojo.CustomerDto;
import com.example.logistics_system.pojo.Customers;
import com.example.logistics_system.pojo.DriverDto;
import com.example.logistics_system.pojo.UserDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICustomerDao {
    @Select("select * from user")
    List<Customers> all();

    @Insert("insert into user(name,userName, password, gender,ordersNumber,phone,address,userRole, loginId)" +
            " VALUES (#{name},#{userName}, #{password},#{gender},#{ordersNumber},#{phone},#{address},#{userRole}, #{loginId})")
    int add(CustomerDto customerDto);

    @Delete("delete from user where id =#{id}")
    int delete(@Param("id") int id);

    @Select("select * from user where id =#{id}")
    Customers getLoginId(@Param("id") int id);
    //模糊查询
    @Select("select * from user where userName like concat('%',#{userName},'%')" +
            " or name like concat('%',#{userName},'%')")
    List<Customers> search(@Param("userName")String userName);
    //根据用户用户名查询
    @Select("select * from user where userName = #{userName}")
    CustomerDto personal(@Param("userName") String userName);

    //根据用户id修改内容
    @Update("update user set name=#{name},userName=#{userName},password =#{password}," +
            "gender=#{gender},ordersNumber=#{ordersNumber},phone=#{phone},address=#{address}" +
            " where id=#{id}")
    int update(CustomerDto customerDto);
}