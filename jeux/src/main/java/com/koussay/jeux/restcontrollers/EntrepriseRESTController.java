package com.koussay.jeux.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.koussay.jeux.entities.Entreprise;
import com.koussay.jeux.repos.EntrepriseRepository;
@RestController
@RequestMapping("/api/ent")
@CrossOrigin("*")
public class EntrepriseRESTController {
@Autowired
EntrepriseRepository entrepriseRepository;
@RequestMapping(method=RequestMethod.GET)
public List<Entreprise> getAllEntreprises()
{
return entrepriseRepository.findAll();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Entreprise getEntrepriseById(@PathVariable("id") Long id) {
return entrepriseRepository.findById(id).get();
}
}
