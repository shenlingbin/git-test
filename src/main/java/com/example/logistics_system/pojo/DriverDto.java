package com.example.logistics_system.pojo;

import lombok.Data;

/**
 * @author:沈玲彬
 * @create: 2022-10-14 19:59
 * @Description:
 */
@Data
public class DriverDto extends UserDto{
    private Integer id;

    private String name;
    private Integer gender;
    private Integer age;
    private String phone;
    private String carType;
    private String path;
    private Integer loginId;
    private String userName;
    private String password;


    public DriverDto(Integer loginId, int id, String name, String userName,String password,  int gender, int age, String phone, String carType, String path) {
        this.loginId = loginId;

        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.age=age;
        this.phone = phone;
        this.carType=carType;
        this.path=path;
    }

    public DriverDto(String userName, Integer loginId, String password) {
        this.userName = userName;
        this.loginId = loginId;
        this.password = password;
    }

    public DriverDto() {
    }
}
