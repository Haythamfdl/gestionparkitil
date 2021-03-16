package com.sid.gestionparkitil.gestionparkitil.Controller;

import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import com.sid.gestionparkitil.gestionparkitil.Repo.UtilisateurRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UtilisateurController {
	private UtilisateurRepo utilisateurRepo;

	public UtilisateurController(UtilisateurRepo utilisateurRepo) {
		this.utilisateurRepo = utilisateurRepo;
	}

	@GetMapping("/utilisateur/{email}")
	public Utilisateur getUtilisateur(@PathVariable(name = "email") String email) {
		return utilisateurRepo.findUtilisateurByEmailAndIsdeleted(email,false);
	}

	@GetMapping("/login/{email}/{pass}")
	public Utilisateur login(@PathVariable(name = "email") String email,@PathVariable(name = "pass") String pass) {
		return utilisateurRepo.findUtilisateurByEmailAndPassAndIsdeleted(email,pass,false);
	}

}
