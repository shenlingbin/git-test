package com.example.logistics_system.pojo;

import lombok.Data;

/**
 * @author:沈玲彬
 * @create: 2022-10-16 17:36
 * @Description:
 */
@Data
public class CustomerDto extends UserDto{
    private String name;
    private Integer gender;
    private Integer ordersNumber;
    private String phone;
    private String address;
    private Integer id;
    private String userName;
    private String password;
    private Integer userRole;
    private Integer loginId;


    public CustomerDto(Integer loginId, int id, String name, String userName, String password, int gender, int ordersNumber, String phone, String address) {
        this.loginId = loginId;
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password =password;
        this.gender = gender;
        this.ordersNumber = ordersNumber;
        this.phone = phone;
        this.address = address;
    }

    public CustomerDto(String userName, String password, Integer loginId) {
        this.userName = userName;
        this.password = password;
        this.loginId = loginId;
    }

    public CustomerDto() {

    }
}
