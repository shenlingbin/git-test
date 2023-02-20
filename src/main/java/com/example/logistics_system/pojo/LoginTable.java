package com.example.logistics_system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:沈玲彬
 * @create: 2022-10-13 20:57
 * @Description:
 */
@Data
public class LoginTable {
    private Integer id;
    private String userName;
    private String password;
    private Integer userRole;
}
