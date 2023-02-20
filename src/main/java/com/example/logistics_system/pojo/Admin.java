package com.example.logistics_system.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author:沈玲彬
 * @create: 2022-10-13 19:39
 * @Description:
 */
@Data
public class Admin implements Serializable {
    private int id;
    private String userName;
    private String password;
    private int userRole;
    private int loginId;

}
