package com.flex.java.oss.dto;

public class CustomerDTO extends UserDTO{
    private String address;

    public CustomerDTO(Long id, String name, String email, String address) {
        super(id, name, email);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
