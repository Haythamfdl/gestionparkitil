package com.sid.gestionparkitil.gestionparkitil.Controller;


import com.sid.gestionparkitil.gestionparkitil.Model.Agent;
import com.sid.gestionparkitil.gestionparkitil.Model.Equipement;
import com.sid.gestionparkitil.gestionparkitil.Repo.EquipementRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EquipementController {

    private EquipementRepo equipementRepo;

    public EquipementController(EquipementRepo equipementRepo) {
        this.equipementRepo = equipementRepo;
    }

    @GetMapping("/equipements")
    public List<Equipement> getAllEquipements() {
        return equipementRepo.findAllByIsdeleted(false);
    }

    @GetMapping("/equipements/{num}")
    public Equipement getEquipement(@PathVariable(name = "num") String numero) {
        return equipementRepo.findByNumero(numero);
    }

    @GetMapping("/equipements/agent/{id}")
    public List<Equipement> getEquipementAgents(@PathVariable(name = "id") Long idagent) {
        Agent agent = new Agent();
        agent.setIdagent(idagent);
        return equipementRepo.findAllByAgentAndIsdeleted(agent, false);
    }

    @PostMapping(value = "/equipements", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addEquipement(@RequestBody Equipement equipement) {
        equipementRepo.save(equipement);
    }

    @PutMapping(value = "/equipements", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEquipement(@RequestBody Equipement equipement) {
        equipementRepo.save(equipement);
    }

}
