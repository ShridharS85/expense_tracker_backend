package com.spring.expense_tracker_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class UserResponse {
    // Getters and Setters
    private Long id;
    private String name;
    private String email;
    private String role;
    private String provider;
    private LocalDateTime createdAt;

    public UserResponse() {}

    public UserResponse(Long id, String name, String email, String role,
                        String provider, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.createdAt = createdAt;
    }

}
