package com.example.logistics_system.pojo;

import lombok.Data;

/**
 * @author:沈玲彬
 * @create: 2022-10-14 19:38
 * @Description:
 */
@Data
public class Drivers {
    private Integer id;
    private String name;
    private String userName;
    private String password;
    private Integer gender;
    private Integer age;
    private String phone;
    private String carType;
    private String path;
    private Integer userRole;
    private Integer loginId;
}
