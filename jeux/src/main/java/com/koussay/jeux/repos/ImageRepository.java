package com.koussay.jeux.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.koussay.jeux.entities.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
}