package com.example.logistics_system.dao;


import com.example.logistics_system.pojo.Admin;
import com.example.logistics_system.pojo.DriverDto;
import com.example.logistics_system.pojo.Drivers;
import com.example.logistics_system.pojo.UserDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface IAdminDao {
    @Select("select * from admin")
    List<UserDto> all();
    //删除操作
    @Delete("delete from admin where id=#{id}")
    int delete(@Param("id") int id);
    int add(UserDto userDto);
    @Select("select * from admin where id =#{id}")
    Admin getById(@Param("id") int id);
    //根据用户id修改内容
    @Update("update admin set userName=#{userName},password=#{password} where id=#{id}")
    int update(UserDto userDto);
    //模糊查询
    List<UserDto> search(@Param("userName") String userName);


}
