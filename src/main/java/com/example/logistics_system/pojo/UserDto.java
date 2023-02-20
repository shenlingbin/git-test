package com.example.logistics_system.pojo;

import lombok.Data;

/**
 * @author:沈玲彬
 * @create: 2022-10-13 21:22
 * @Description:
 */
@Data
public class UserDto extends LoginTable{
    private Integer loginId;

    public UserDto(int id, String userName, String password, int i, int loginId) {
        this.setId(id);
        this.setUserName(userName);
        this.setPassword(password);
        this.setUserRole(i);
        this.loginId = loginId;
    }

    public UserDto(int loginId, String userName, String password, int i) {
        this.setLoginId(loginId);
        this.setUserName(userName);
        this.setPassword(password);
        this.setUserRole(i);
    }


    public UserDto(Integer loginId) {
        this.loginId = loginId;
    }

    public UserDto() {
    }
}
