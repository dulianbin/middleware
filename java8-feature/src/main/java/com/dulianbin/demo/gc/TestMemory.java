package com.dulianbin.demo.gc;

import lombok.Data;

@Data
public class TestMemory {
    private int id;
    private String name;
    private String address;
    private String mobile;

    public TestMemory(int id, String name, String address, String mobile) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }

    public TestMemory() {
    }
}
