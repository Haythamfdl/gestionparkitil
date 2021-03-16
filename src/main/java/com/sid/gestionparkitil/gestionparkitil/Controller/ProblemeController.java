package com.sid.gestionparkitil.gestionparkitil.Controller;

import com.sid.gestionparkitil.gestionparkitil.Model.Agent;
import com.sid.gestionparkitil.gestionparkitil.Model.Probleme;
import com.sid.gestionparkitil.gestionparkitil.Repo.ProblemeRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProblemeController {
	private ProblemeRepo problemeRepo;

	public ProblemeController(ProblemeRepo problemeRepo) {
		this.problemeRepo = problemeRepo;
	}

	@GetMapping("/problems")
	public List<Probleme> getAllProblemes() {
		return problemeRepo.findAllByIsdeletedOrderbydAndDate_soumissionDesc(false);
	}

	@GetMapping("/problemsagent/{id}")
	public List<Probleme> getAgentProblemes(@PathVariable(name = "id") Long id) {
		Agent agent = new Agent();
		agent.setId_agent(id);
		return problemeRepo.findAllByAgentAndIsdeletedOrderbyDate_soumissionDesc(agent,false);
	}

	@GetMapping("/problem/{id}")
	public Probleme getProbleme(@PathVariable(name = "id") Long id) {
		return problemeRepo.findById_prob(id);
	}

	@GetMapping("/problem/{res}")
	public List<Probleme> getProblemesResolu(@PathVariable(name = "res") Boolean resolu) {
		return problemeRepo.findAllByResoluAndIsdeletedOrderbyDate_soumissionDesc(resolu,false);
	}

	@RequestMapping(value = "/problem",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addProbleme(@RequestBody Probleme probleme) {
		problemeRepo.save(probleme);
	}

	@RequestMapping(value = "/problem",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateProbleme(@RequestBody Probleme probleme) {
		problemeRepo.save(probleme);
	}

}
