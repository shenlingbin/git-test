package com.example.logistics_system.dao;

import com.example.logistics_system.pojo.LoginTable;
import com.example.logistics_system.pojo.UserDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    //登录功能
    @Select("select * from logintable where userName=#{userName} and password=#{password} and userRole=#{userRole}")
    Map<String, Object> selectUser(@Param("userName")String username,@Param("password")String password,@Param("userRole")int userRole);
    //删除登录用户
    @Delete("delete from logintable where id=#{id}")
    int delete(@Param("id") int id);
    //添加登录用户
    int add(UserDto userDto);
    //修改登录用户
    @Update("update logintable set userName=#{userName},password=#{password} where id=#{loginId}")
    int update(UserDto userDto);


}
