package com.koussay.jeux.dto;

import java.util.Date;

import com.koussay.jeux.entities.Entreprise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JeuDTO {
private Long idJeu;
private String titre;
private Double taille;
private String niveauDifficulte;
private Date dateCreation;
private Entreprise entreprise;
private String nomEnt;
}

