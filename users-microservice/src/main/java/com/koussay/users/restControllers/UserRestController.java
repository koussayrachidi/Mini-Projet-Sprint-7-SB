package com.koussay.users.restControllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.koussay.users.entities.User;
import com.koussay.users.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {
	 @Autowired
	    private UserService userService;

	    @Autowired
	    private JavaMailSender javaMailSender;

	    @PostMapping("/register")
	    public User registerUser(@RequestBody User user) {

	          return userService.saveUser(user);
	    }


	    @PostMapping("/verify")
	    public ResponseEntity<?> verifyUser(@RequestBody Map<String, String> requestBody) {
	        String verificationCode = requestBody.get("verificationCode");
	        String username = requestBody.get("username");
	        try {
	            userService.verifyUser(username, verificationCode);
	            return ResponseEntity.ok("User verified successfully");
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }

@RequestMapping(path = "all", method = RequestMethod.GET)
public List<User> getAllUsers() {
return userService.findAllUsers();
}
}