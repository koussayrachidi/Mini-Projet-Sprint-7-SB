package com.koussay.jeux.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koussay.jeux.entities.Jeu;
import com.koussay.jeux.entities.Entreprise;

import com.koussay.jeux.service.JeuService;


@Controller
public class JeuController {
@Autowired
JeuService jeuService;

@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
	List<Entreprise> cats = jeuService.getAllEntreprises();
	Jeu prod = new Jeu();

	Entreprise cat = new Entreprise();
	cat = cats.get(0);
	prod.setEntreprise(cat);
	modelMap.addAttribute("jeu", prod);
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("entreprises", cats);

    modelMap.addAttribute("page",0);

	modelMap.addAttribute("entreprises", cats);
return "formJeu";
}
/*
@RequestMapping("/saveJeu")
public String saveJeu(@Valid Jeu jeu,
		 BindingResult bindingResult,@RequestParam(name="size",defaultValue="3")int size,
			@RequestParam(name="page",defaultValue="0")int page
			, RedirectAttributes redirectAtt)
{
	if (bindingResult.hasErrors()) return "formJeu";

 jeuService.saveJeu(jeu);
 Page<Jeu> equipe1= jeuService.getAllJeuxParPage(page, size);
	page=equipe1.getTotalPages()-1;
	redirectAtt.addAttribute("page", page);
	 jeuService.saveJeu(jeu);

		return "redirect:/ListeJeux";
}
*/
@RequestMapping("/saveJeu")
public String saveProduit(@Valid Jeu jeu,
BindingResult bindingResult,
@ModelAttribute("page") int pageFromPrevious,
@RequestParam (name="size", defaultValue = "3") int size,
RedirectAttributes redirectAttributes,ModelMap modelMap)
{
int page;
if (bindingResult.hasErrors()) { 
	List<Entreprise> cats = jeuService.getAllEntreprises();
	modelMap.addAttribute("entreprises", cats);
	//même on est en mode ajout (mode="new"), en passe le mode edit pour garder la catégorie 
	//selectionnée dans la liste, pour mieux le comprendre essayer de passer le mode "new"
	 modelMap.addAttribute("mode", "edit");
	return "formJeu";
}
if (jeu.getIdJeu()==null) //adding
    page = jeuService.getAllJeux().size()/size; // calculer le nbr de pages
else //updating
    page = pageFromPrevious;

jeuService.saveJeu(jeu);

redirectAttributes.addAttribute("page", page);
return "redirect:/ListeJeux";
}


@RequestMapping("/ListeJeux")
public String listeJeux(ModelMap modelMap,
		@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "3") int size)
{
	Page<Jeu> prods = jeuService.getAllJeuxParPage(page, size);
	modelMap.addAttribute("jeux", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);

	return "listeJeux";
}

@RequestMapping("/supprimerJeu")
public String supprimerJeu(@RequestParam("id") Long id,
 ModelMap modelMap,
 @RequestParam (name="page",defaultValue = "0") int page,
 @RequestParam (name="size", defaultValue = "2") int size)
{
	jeuService.deleteJeuById(id);
	Page<Jeu> prods = jeuService.getAllJeuxParPage(page,size);
	modelMap.addAttribute("jeux", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeJeux";

}

@RequestMapping("/modifierJeu")
public String editerJeu(@RequestParam("id") Long id,
        @RequestParam("page") int page,ModelMap modelMap)
{
	
	List<Entreprise> cats = jeuService.getAllEntreprises();

Jeu p= jeuService.getJeu(id);
modelMap.addAttribute("jeu", p);
modelMap.addAttribute("mode", "edit");
modelMap.addAttribute("page",page);

modelMap.addAttribute("entreprises", cats);


return "formJeu";
}
@RequestMapping("/updateJeu")
public String updateJeu(@ModelAttribute("jeu") Jeu jeu,
@RequestParam("date") String date,
ModelMap modelMap) throws ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 jeu.setDateCreation(dateCreation);

 jeuService.updateJeu(jeu);
 List<Jeu> prods = jeuService.getAllJeux();
 modelMap.addAttribute("jeux", prods);
return "listeJeux";
}


}