package com.example.logistics_system.pojo;

import lombok.Data;

/**
 * @author:沈玲彬
 * @create: 2022-10-16 20:13
 * @Description:
 */
@Data
public class Orders {
    private Integer id;
    private String productName;
    private String productNumber;
    private String ProductUnit;
    private String orderUser;
    private String deliverman;

    public Orders(Integer id, String productName, String productNumber, String productUnit, String deliverman) {
        this.id = id;
        this.productName = productName;
        this.productNumber = productNumber;
        ProductUnit = productUnit;
        this.deliverman = deliverman;
    }

    public Orders() {
    }
}
