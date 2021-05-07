package com.sid.gestionparkitil.gestionparkitil.Controller;

import com.sid.gestionparkitil.gestionparkitil.Dto.AgentDto;
import com.sid.gestionparkitil.gestionparkitil.Model.Agent;
import com.sid.gestionparkitil.gestionparkitil.Repo.AgentRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AgentController {

    private AgentRepo agentRepo;

    public AgentController(AgentRepo agentRepo) {
        this.agentRepo = agentRepo;
    }

    @GetMapping("/agents")
    public List<Agent> getAllAgents() {
        return agentRepo.findAllByIsdeleted(false);
    }

    @GetMapping("/agents/{num}")
    public Agent getAgent(@PathVariable(name = "num") String numero) {
        return agentRepo.findByNumero(numero);
    }

    @PostMapping(value = "/agents", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addAgent(@RequestBody AgentDto agentdto) {
        agentRepo.save(attribut(agentdto));
    }

    @PutMapping(value = "/agents", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAgent(@RequestBody AgentDto agentdto) {
        agentRepo.save(attribut(agentdto));
    }

    //Permet d'attribuer les valeurs de l'objet Dto a l'objet Entité
    private Agent attribut(AgentDto agentdto){
        Agent agent= new Agent();
        agent.setIdagent(agentdto.getIdagent());
        agent.setNumero(agentdto.getNumero());
        agent.setNom(agentdto.getNom());
        agent.setEmail(agentdto.getEmail());
        agent.setTel(agentdto.getTel());
        agent.setDepartement(agentdto.getDepartement());
        agent.setFonction(agentdto.getFonction());
        agent.setIsdeleted(agentdto.getIsdeleted());
        return agent;
    }
}
