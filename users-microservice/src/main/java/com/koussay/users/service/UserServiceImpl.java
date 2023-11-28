package com.koussay.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.koussay.users.entities.Role;
import com.koussay.users.entities.User;
import com.koussay.users.repos.RoleRepository;
import com.koussay.users.repos.UserRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.Random;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRep;

    @Autowired
    private RoleRepository roleRep;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setVerified(false);
        user.setVerificationCode(generateVerificationCode());
        Role adminRole = roleRep.findById(1L).orElseThrow(() -> new RuntimeException("Role not found"));
        Role userRole = roleRep.findById(2L).orElseThrow(() -> new RuntimeException("Role not found"));

        List<Role> roleList = Collections.singletonList(userRole);
        user.setRoles(roleList);
        user.setRoles(roleList);
        userRep.save(user);

        sendVerificationEmail(user); // Send verification email after saving the user
        return user;
    }

    @Override
    public User addRoleToUser(String username, String rolename) {
        User usr = userRep.findByUsername(username);
        Role r = roleRep.findByRole(rolename);
        usr.getRoles().add(r);
        return usr;
    }

    @Override
    public Role addRole(Role role) {
        return roleRep.save(role);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRep.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return userRep.findAll();
    }

    @Override
    public void verifyUser(String usename, String verificationCode) {
        User user = userRep.findByUsername(usename);
        
            if (user.getVerificationCode().equals(verificationCode)) {
                user.setVerified(true);
                userRep.save(user);
            } else {
                throw new IllegalArgumentException("Invalid verification code");
            }
        };
    

    @Override
    public void sendVerificationEmail(User user) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getUsername());
        mailMessage.setSubject("Email Verification");
        mailMessage.setText("Your verification code is: " + user.getVerificationCode());
        javaMailSender.send(mailMessage);
    }

    private String generateVerificationCode() {
    	 Random random = new Random();
         int code = 100_000 + random.nextInt(900_000); // Generate a random 6-digit number
         return String.valueOf(code);
    }
}
