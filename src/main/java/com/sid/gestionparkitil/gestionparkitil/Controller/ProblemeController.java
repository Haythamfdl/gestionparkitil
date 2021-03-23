package com.sid.gestionparkitil.gestionparkitil.Controller;

import com.sid.gestionparkitil.gestionparkitil.Model.Agent;
import com.sid.gestionparkitil.gestionparkitil.Model.Probleme;
import com.sid.gestionparkitil.gestionparkitil.Repo.ProblemeRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class ProblemeController {
	private ProblemeRepo problemeRepo;

	public ProblemeController(ProblemeRepo problemeRepo) {
		this.problemeRepo = problemeRepo;
	}

	@GetMapping("/problems")
	public List<Probleme> getAllProblemes() {
		return problemeRepo.findAllByIsdeletedOrderByDatesoumissionDesc(false);
	}

	@GetMapping("/problesmsagent/{id}")
	public List<Probleme> getAgentProblemes(@PathVariable(name = "id") Long id) {
		Agent agent = new Agent();
		agent.setIdagent(id);
		return problemeRepo.findAllByAgentAndIsdeletedOrderByDatesoumissionDesc(agent,false);
	}

	@GetMapping("/problems/{id}")
	public Optional<Probleme> getProbleme(@PathVariable(name = "id") Long id) {
		return problemeRepo.findById(id);
	}

	@GetMapping("/problems/{res}")
	public List<Probleme> getProblemesResolu(@PathVariable(name = "res") Boolean resolu) {
		return problemeRepo.findAllByResoluAndIsdeletedOrderByDatesoumissionDesc(resolu,false);
	}

	@RequestMapping(value = "/problems",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addProbleme(@RequestBody Probleme probleme) {
		problemeRepo.save(probleme);
	}

	@RequestMapping(value = "/problems",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateProbleme(@RequestBody Probleme probleme) {
		problemeRepo.save(probleme);
	}

}
