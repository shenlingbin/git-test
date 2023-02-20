package com.example.logistics_system.pojo;

import lombok.Data;

/**
 * @author:沈玲彬
 * @create: 2022-10-16 16:13
 * @Description:
 */
@Data
public class Customers {
    private Integer id;
    private String name;
    private String userName;
    private String password;
    private Integer gender;
    private Integer ordersNumber;
    private String phone;
    private String address;
    private Integer userRole;
    private Integer loginId;
}
