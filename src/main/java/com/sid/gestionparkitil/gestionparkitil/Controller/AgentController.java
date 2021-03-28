package com.sid.gestionparkitil.gestionparkitil.Controller;

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

    @RequestMapping(value = "/agents", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addAgent(@RequestBody Agent agent) {
        agentRepo.save(agent);
    }

    @RequestMapping(value = "/agents", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAgent(@RequestBody Agent agent) {
        agentRepo.save(agent);
    }

}
