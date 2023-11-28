package com.koussay.users.service;

import java.util.List;

import com.koussay.users.entities.Role;
import com.koussay.users.entities.User;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername(String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
    List<User> findAllUsers();
    void verifyUser(String username, String verificationCode);
    void sendVerificationEmail(User user);
}
