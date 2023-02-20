package com.example.logistics_system.dao;

import com.example.logistics_system.pojo.Customers;
import com.example.logistics_system.pojo.DriverDto;
import com.example.logistics_system.pojo.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrderDao {
    @Select("select * from orders")
    List<Orders> all();
    //模糊查询
    @Select("select * from orders where productName like concat('%',#{productName},'%')")
    List<Orders> search(@Param("productName")String productName);
    //根据订单所属用户查订单
    @Select("select * from orders where orderUser = #{userName}")
    List<Orders> personalOrder(String userName);
    //根据Id查询订单
    @Select("select * from orders where id = #{id}")
    Orders order(@Param("id") int id);
    //根据Id删除订单
    @Delete("delete from orders where id=#{id}")
    int delete(@Param("id") int id);
    //根据id修改订单
    @Update("update orders set productName=#{productName},productNumber=#{productNumber},productUnit =#{productUnit}," +
            "deliverman=#{deliverman} where id=#{id}")
    int update(Orders orders);
    //添加订单
    int add(Orders order);
}
