package com.koussay.jeux.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.koussay.jeux.entities.Entreprise;
@RepositoryRestResource(path = "ent")
@CrossOrigin(origins = "http://localhost:4200/") 
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long>{

}