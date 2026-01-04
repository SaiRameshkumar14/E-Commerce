package com.flex.java.oss.dto;

public class AdminDTO extends UserDTO {
    private String role;

    public AdminDTO(Long id, String name, String email, String role) {
        super(id, name, email);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
