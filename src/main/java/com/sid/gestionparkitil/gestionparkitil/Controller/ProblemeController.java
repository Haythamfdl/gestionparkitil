package com.sid.gestionparkitil.gestionparkitil.Controller;

import com.sid.gestionparkitil.gestionparkitil.Dto.ProblemeDto;
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

    @GetMapping("/problemes")
    public List<Probleme> getAllProblemes() {
        return problemeRepo.findAllByIsdeletedOrderByDatesoumissionDesc(false);
    }

    @GetMapping("/problemes/agent/{id}")
    public List<Probleme> getAgentProblemes(@PathVariable(name = "id") Long id) {
        Agent agent = new Agent();
        agent.setIdagent(id);
        return problemeRepo.findAllByAgentAndIsdeletedOrderByDatesoumissionDesc(agent, false);
    }

    @GetMapping("/problemes/{id}")
    public Optional<Probleme> getProbleme(@PathVariable(name = "id") Long id) {
        return problemeRepo.findById(id);
    }

    @GetMapping("/problemes/resolu/{res}")
    public List<Probleme> getProblemesResolu(@PathVariable(name = "res") Boolean resolu) {
        return problemeRepo.findAllByResoluAndIsdeletedOrderByDatesoumissionDesc(resolu, false);
    }

    @PostMapping(value = "/problemes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProbleme(@RequestBody ProblemeDto problemedto) {
        problemeRepo.save(attribut(problemedto));
    }

    @PutMapping(value = "/problemes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateProbleme(@RequestBody ProblemeDto problemedto) {
        problemeRepo.save(attribut(problemedto));
    }

    private Probleme attribut(ProblemeDto problemedto){
        Probleme probleme = new Probleme();
        probleme.setIdprob(problemedto.getIdprob());
        probleme.setTitre(problemedto.getTitre());
        probleme.setProbleme(problemedto.getProbleme());
        probleme.setDatesoumission(problemedto.getDatesoumission());
        probleme.setAgent(problemedto.getAgent());
        probleme.setType(problemedto.getType());
        probleme.setResolu(problemedto.getResolu());
        probleme.setEquipement(problemedto.getEquipement());
        probleme.setIsdeleted(problemedto.getIsdeleted());
        return probleme;
    }
}
