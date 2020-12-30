package com.dulianbin.demo.function.groupingBy;

import java.math.BigDecimal;

public class Product {

    private Integer id;

    private String skuNo;

    private BigDecimal price;

    private String skuName;

    public Product() {
    }

    public Product(Integer id, String skuNo, BigDecimal price, String skuName) {
        this.id = id;
        this.skuNo = skuNo;
        this.price = price;
        this.skuName = skuName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }
}
