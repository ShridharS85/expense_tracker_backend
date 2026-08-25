package com.spring.expense_tracker_backend.service;


import com.spring.expense_tracker_backend.dto.UserResponse;
import com.spring.expense_tracker_backend.entity.User;
import com.spring.expense_tracker_backend.enums.Role;
import com.spring.expense_tracker_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public UserResponse promoteToAdmin(Long userId, User admin) {
        if (admin.getId().equals(userId)) {
            throw new RuntimeException("You cannot change your own role");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getRole() == Role.ADMIN) {
            throw new RuntimeException("User is already an ADMIN");
        }

        user.setRole(Role.ADMIN);
        userRepository.save(user);

        return toResponse(user);
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name(),
                user.getProvider().name(),
                user.getCreatedAt()
        );
    }
}
