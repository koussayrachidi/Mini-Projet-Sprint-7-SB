package com.koussay.jeux.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.koussay.jeux.entities.Entreprise;
import com.koussay.jeux.entities.Jeu;
import com.koussay.jeux.repos.EntrepriseRepository;
import com.koussay.jeux.repos.ImageRepository;
import com.koussay.jeux.repos.JeuRepository;

@Service
public class JeuServiceImpl implements JeuService {
@Autowired
JeuRepository jeuRepository;
@Autowired
EntrepriseRepository entrepriseRepository;
@Autowired
ImageRepository imageRepository;
@Override
public Jeu saveJeu(Jeu j) {
return jeuRepository.save(j);
}
/*@Override
public Jeu updateJeu(Jeu j) {
return jeuRepository.save(j);
}*/

@Override
public Jeu updateJeu(Jeu j) {
//Long oldJeuImageId = this.getJeu(j.getIdJeu()).getImage().getIdImage();
//Long newJeuImageId = j.getImage().getIdImage();
Jeu jeuUpdated = jeuRepository.save(j);
//if (oldJeuImageId != newJeuImageId) //si l'image a été modifiée
//imageRepository.deleteById(oldJeuImageId);
return jeuUpdated;
}

@Override
public void deleteJeu(Jeu j) {
jeuRepository.delete(j);
}
 @Override
public void deleteJeuById(Long id) {
jeuRepository.deleteById(id);
}
@Override
public Jeu getJeu(Long id) {
return jeuRepository.findById(id).get();
}
@Override
public List<Jeu> getAllJeux() {
return jeuRepository.findAll();
}
@Override
public Page<Jeu> getAllJeuxParPage(int page, int size) {
	return jeuRepository.findAll(PageRequest.of(page, size));

}
@Override
public List<Jeu> findByTitre(String nom) {
	
	return jeuRepository.findByTitre(nom);
}
@Override
public List<Jeu> findByTitreContains(String nom) {
	
	return jeuRepository.findByTitreContains(nom);
}
@Override
public List<Jeu> findByTitreTaille(String titre, Double taille) {
	return jeuRepository.findByTitreTaille(titre, taille);
}
@Override
public List<Jeu> findByEntreprise(Entreprise entreprise) {
	
	return jeuRepository.findByEntreprise(entreprise);
}
@Override
public List<Jeu> findByEntrepriseIdEnt(Long id) {
	return jeuRepository.findByEntrepriseIdEnt(id);
}
@Override
public List<Jeu> findByOrderByTitreAsc() {
	
	return jeuRepository.findByOrderByTitreAsc();
}
@Override
public List<Jeu> trierJeuxTitresTaille() {
	return jeuRepository.trierJeuxTitresTaille();
}
@Override
public List<Entreprise> getAllEntreprises() {
	return entrepriseRepository.findAll();
}
}