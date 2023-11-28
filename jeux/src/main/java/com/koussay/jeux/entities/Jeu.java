package com.koussay.jeux.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Jeu {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idJeu;
@NotNull
@Size (min = 2,max = 40)
private String titre;
@Min(value = 5)
@Max(value = 10000)
private Double taille;
private String niveauDifficulte;

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateCreation;
@ManyToOne
private Entreprise entreprise;

/*@OneToOne
private Image image;*/

@OneToMany (mappedBy = "jeu")
private List<Image> images;

public Jeu() {
super();
}
public Jeu(String titre, Double taille,String niveauDifficulte, Date dateCreation) {
super();
this.titre = titre;
this.taille = taille;
this.niveauDifficulte = niveauDifficulte;
this.dateCreation = dateCreation;
}
public Long getIdJeu() {
return idJeu;
}
public void setIdJeu(Long idJeu) {
this.idJeu = idJeu;
}
public String getTitre() {
return titre;
}
public void setTitre(String titre) {
this.titre = titre;
}
public Double getTaille() {
return taille;
}
public void setTaille(Double taille) {
this.taille = taille;
}

public String getNiveauDifficulte() {
return niveauDifficulte;
}
public void setNiveauDifficulte(String niveauDifficulte) {
this.niveauDifficulte = niveauDifficulte;
}

public Date getDateCreation() {
return dateCreation;
}
public void setDateCreation(Date dateCreation) {
this.dateCreation = dateCreation;
}

@Override
public String toString() {
return "Jeu [idJeu=" + idJeu + ", titre=" +
titre + ", taille=" + taille + ", niveauDifficulte=" + niveauDifficulte
+ ", dateCreation=" + dateCreation + "]";
}
public Entreprise getEntreprise() {
	return entreprise;
}
public void setEntreprise(Entreprise entreprise) {
	this.entreprise = entreprise;
}
public List<Image> getImages() {
	return images;
}
public void setImages(List<Image> images) {
	this.images = images;
}


}
