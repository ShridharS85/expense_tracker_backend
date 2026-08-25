package com.spring.expense_tracker_backend.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthResponse {
    // Getters and Setters
    private String token;
    private String email;
    private String name;
    private String role;

    public AuthResponse() {}

    public AuthResponse(String token, String email, String name, String role) {
        this.token = token;
        this.email = email;
        this.name = name;
        this.role = role;
    }

}