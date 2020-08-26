package com.dulianbin.demo.function.stream;

class StringAndString {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StringAndString{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
