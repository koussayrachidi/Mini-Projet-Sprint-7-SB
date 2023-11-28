package com.koussay.jeux;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.koussay.jeux.entities.Jeu;
import com.koussay.jeux.entities.Entreprise;
import com.koussay.jeux.repos.JeuRepository;
import com.koussay.jeux.service.JeuService;

@SpringBootTest
class JeuxApplicationTests {

	@Autowired
	private JeuRepository jeuRepository;
	
	@Autowired
	private JeuService jeuService;
	
	@Test
	public void testCreateJeu() {
	Jeu prod = new Jeu("lol", 30.1,"easy", new Date());
	jeuRepository.save(prod);
	}
	
	 @Test
	 public void testFindJeu()
	 {
	 Jeu p = jeuRepository.findById(1L).get();
	 System.out.println(p);
	 }
	 
	 @Test
	 public void testUpdateJeu()
	 {
		 Jeu p = jeuRepository.findById(1L).get();
	 p.setTaille(1000.0);
	 jeuRepository.save(p);
	 }
	 
	 @Test
	 public void testDeleteJeu()
	 {
		 jeuRepository.deleteById(1L);;
	 }
	 
	 @Test
	 public void testListerTousJeux()
	 {
	 List<Jeu> prods = jeuRepository.findAll();
	 for (Jeu p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 @Test
	 public void testFindByNomJeuContains()
	 {
	 Page<Jeu> prods = jeuService.getAllJeuxParPage(0,2);
	 System.out.println(prods.getSize());
	 System.out.println(prods.getTotalElements());
	 System.out.println(prods.getTotalPages());
	 prods.getContent().forEach(p -> {System.out.println(p.toString());
	  });
	 /*ou bien
	 for (Produit p : prods)
	 {
	 System.out.println(p);
	 } */
	 }
	 
	 @Test
	 public void testFindJeuByNom()
	 {
	 List<Jeu> prods = jeuRepository.findByTitre("lol");
	 
	 for (Jeu p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 @Test
	 public void testFindJeuByNomContains()
	 {
	 List<Jeu> prods = jeuRepository.findByTitreContains("c");
	 
	 for (Jeu p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 @Test
	 public void testfindByTitreTaille()
	 {
	 List<Jeu> prods = jeuRepository.findByTitreTaille("lol", 30.0);
	 for (Jeu p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 @Test
	 public void testfindByEntreprise()
	 {
	 Entreprise ent = new Entreprise();
	 ent.setIdEnt(1L);
	 List<Jeu> prods = jeuRepository.findByEntreprise(ent);
	 for (Jeu p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 @Test
	 public void findByEntrepriseIdEnt()
	 {
	 List<Jeu> prods = jeuRepository.findByEntrepriseIdEnt(1L);
	 for (Jeu p : prods)
	 {
	 System.out.println(p);
	 }
	  }
	 
	 @Test
	 public void testfindByOrderByTitreAsc()
	 {
	 List<Jeu> prods =jeuRepository.findByOrderByTitreAsc();
	 for (Jeu p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 @Test
	 public void testTrierJeuxTitresTaille()
	 {
	 List<Jeu> prods = jeuRepository.trierJeuxTitresTaille();
	 for (Jeu p : prods)
	 {
	 System.out.println(p);
	 }
	 }


}
