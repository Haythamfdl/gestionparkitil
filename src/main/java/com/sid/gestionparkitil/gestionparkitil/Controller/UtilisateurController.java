package com.sid.gestionparkitil.gestionparkitil.Controller;

import com.sid.gestionparkitil.gestionparkitil.Model.Solution;
import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import com.sid.gestionparkitil.gestionparkitil.Repo.UtilisateurRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UtilisateurController {
	private UtilisateurRepo utilisateurRepo;

	public UtilisateurController(UtilisateurRepo utilisateurRepo) {
		this.utilisateurRepo = utilisateurRepo;
	}

	@GetMapping("/utilisateurs/id/{id}")
	public Optional<Utilisateur> getUtilisateur(@PathVariable(name = "id") Long id) {
		return utilisateurRepo.findById(id);
	}

	@GetMapping("/utilisateurs/{email}")
	public Utilisateur getUtilisateur(@PathVariable(name = "email") String email) {
		return utilisateurRepo.findUtilisateurByEmailAndIsdeleted(email,false);
	}

	@GetMapping("/utilisateurs/{email}/{pass}")
	public Utilisateur login(@PathVariable String email, @PathVariable String pass) {
		return utilisateurRepo.findUtilisateurByEmailAndPassAndIsdeleted(email,pass,false);
	}

	@RequestMapping(value = "/utilisateurs",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateUtilisateur(@RequestBody Utilisateur utilisateur) {
		utilisateurRepo.save(utilisateur);
	}

}
