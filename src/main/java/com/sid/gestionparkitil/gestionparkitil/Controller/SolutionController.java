package com.sid.gestionparkitil.gestionparkitil.Controller;

import com.sid.gestionparkitil.gestionparkitil.Model.Probleme;
import com.sid.gestionparkitil.gestionparkitil.Model.Solution;
import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import com.sid.gestionparkitil.gestionparkitil.Repo.SolutionRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class SolutionController {
	private SolutionRepo solutionRepo;

	public SolutionController(SolutionRepo solutionRepo) {
		this.solutionRepo = solutionRepo;
	}

	@GetMapping("/solutions/problem/{id}")
	public List<Solution> getProblemeSolutions(@PathVariable(name = "id") Long id_probleme) {
		Probleme probleme =new Probleme();
		probleme.setIdprob(id_probleme);
		return solutionRepo.findAllByProblemeAndIsdeletedOrderByDatesoumissionDesc(probleme,false);
	}

	@GetMapping("/solutions/user/{id}")
	public List<Solution> getUserSolutions(@PathVariable(name = "id") Long id_user) {
		Utilisateur utilisateur=new Utilisateur();
		utilisateur.setIduser(id_user);
		return solutionRepo.findAllByUserAndIsdeletedOrderByDatesoumissionDesc(utilisateur,false);
	}

	@GetMapping("/solutions/{id}")
	public Optional<Solution> getSolution(@PathVariable(name = "id") Long id) {
		return solutionRepo.findById(id);
	}

	@RequestMapping(value = "/solutions",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addSolution(@RequestBody Solution solution) {
		solutionRepo.save(solution);
	}

	@RequestMapping(value = "/solutions",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateSolution(@RequestBody Solution solution) {
		solutionRepo.save(solution);
	}

}
