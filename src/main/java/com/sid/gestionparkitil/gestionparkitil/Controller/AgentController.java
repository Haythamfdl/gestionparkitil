package com.sid.gestionparkitil.gestionparkitil.Controller;

import com.sid.gestionparkitil.gestionparkitil.Dto.AgentDto;
import com.sid.gestionparkitil.gestionparkitil.Model.Agent;
import com.sid.gestionparkitil.gestionparkitil.Repo.AgentRepo;
import com.sid.gestionparkitil.gestionparkitil.Util.FromDtoToEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AgentController {

    private AgentRepo agentRepo;
    private Agent agent = new Agent();

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
        agentRepo.save(FromDtoToEntity.attribut(agentdto, agent));
    }

    @PutMapping(value = "/agents", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAgent(@RequestBody AgentDto agentdto) {
        agentRepo.save(FromDtoToEntity.attribut(agentdto, agent));
    }
}
