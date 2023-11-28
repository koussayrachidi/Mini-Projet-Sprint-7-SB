package com.koussay.jeux;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.koussay.jeux.JeuxApplication;
import com.koussay.jeux.entities.Jeu;
import com.koussay.jeux.entities.Entreprise;

import com.koussay.jeux.service.JeuService;

@SpringBootApplication
public class JeuxApplication implements CommandLineRunner{

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(JeuxApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Jeu.class,Entreprise.class);

		/*jeuService.saveJeu(new Jeu("lol", 30.1,"easy", new Date()));
	jeuService.saveJeu(new Jeu("csgo", 10.1,"easy", new Date()));
	jeuService.saveJeu(new Jeu("cod", 20.3,"easy", new Date()));*/
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}
}
