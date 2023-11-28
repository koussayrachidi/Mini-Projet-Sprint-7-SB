package com.koussay.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.koussay.users.entities.Role;
import com.koussay.users.entities.User;
import com.koussay.users.service.UserService;
import jakarta.annotation.PostConstruct;
@SpringBootApplication
public class UsersMicroserviceApplication {

	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}


/*	@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"koussay","123",true,null));
	userService.saveUser(new User(null,"aziz","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("admin", "USER");
	userService.addRoleToUser("koussay", "USER");
	userService.addRoleToUser("aziz", "USER");
	} */

	@Bean
	BCryptPasswordEncoder getBCE() {
	return new BCryptPasswordEncoder();
	}}

