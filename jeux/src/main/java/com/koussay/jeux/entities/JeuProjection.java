package com.koussay.jeux.entities;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomJeu", types = { Jeu.class })
public interface JeuProjection {
	public String getTitre();

}
