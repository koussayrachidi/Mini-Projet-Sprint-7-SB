package com.koussay.jeux.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.koussay.jeux.entities.Entreprise;
import com.koussay.jeux.entities.Jeu;
public interface JeuService {
Jeu saveJeu(Jeu j);
Jeu updateJeu(Jeu j);
void deleteJeu(Jeu j);
 void deleteJeuById(Long id);
 Jeu getJeu(Long id);
List<Jeu> getAllJeux();
List<Entreprise> getAllEntreprises();



Page<Jeu> getAllJeuxParPage(int page, int size);

List<Jeu> findByTitre(String nom);
List<Jeu> findByTitreContains(String nom);
List<Jeu> findByTitreTaille (String titre, Double taille);
List<Jeu> findByEntreprise (Entreprise entreprise);
List<Jeu> findByEntrepriseIdEnt(Long id);
List<Jeu> findByOrderByTitreAsc();
List<Jeu> trierJeuxTitresTaille();

}