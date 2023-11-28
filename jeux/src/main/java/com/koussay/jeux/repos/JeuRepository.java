package com.koussay.jeux.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.koussay.jeux.entities.Entreprise;
import com.koussay.jeux.entities.Jeu;



@RepositoryRestResource(path = "rest")
public interface JeuRepository extends JpaRepository<Jeu, Long> {

	List<Jeu> findByTitre(String nom);
	List<Jeu> findByTitreContains(String nom);
    
	
	/*@Query("select p from Jeu p where p.titre like %?1 and p.taille > ?2")
	List<Jeu> findByTitreTaille (String titre, Double taille);*/
	
	@Query("select p from Jeu p where p.titre like  %:titre and p.taille> :taille")
	List<Jeu> findByTitreTaille (@Param("titre") String titre,@Param("taille") Double taille);


	@Query("select p from Jeu p where p.entreprise = ?1")
	List<Jeu> findByEntreprise (Entreprise Entreprise);

	List<Jeu> findByEntrepriseIdEnt(Long id);
	
	List<Jeu> findByOrderByTitreAsc();
	
	@Query("select p from Jeu p order by p.titre ASC, p.taille DESC")
	List<Jeu> trierJeuxTitresTaille ();


}
