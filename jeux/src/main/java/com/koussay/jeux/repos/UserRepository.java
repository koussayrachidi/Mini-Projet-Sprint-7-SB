package com.koussay.jeux.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.koussay.jeux.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}
