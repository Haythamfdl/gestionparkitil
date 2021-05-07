package com.sid.gestionparkitil.gestionparkitil.Controller;


import com.sid.gestionparkitil.gestionparkitil.Dto.AgentDto;
import com.sid.gestionparkitil.gestionparkitil.Dto.EquipementDto;
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
    public void addEquipement(@RequestBody EquipementDto equipementdto) {
        equipementRepo.save(attribut(equipementdto));
    }

    @PutMapping(value = "/equipements", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEquipement(@RequestBody EquipementDto equipementdto) {
        equipementRepo.save(attribut(equipementdto));
    }

    //Permet d'attribuer les valeurs de l'objet Dto a l'objet Entité
    private Equipement attribut(EquipementDto equipementdto){
        Equipement equipement = new Equipement();
        equipement.setIdequip(equipementdto.getIdequip());
        equipement.setNumero(equipementdto.getNumero());
        equipement.setDesignation(equipementdto.getDesignation());
        equipement.setFabriquant(equipementdto.getFabriquant());
        equipement.setDateaquisition(equipementdto.getDateaquisition());
        equipement.setDateservice(equipementdto.getDateservice());
        equipement.setValeuraquisition(equipementdto.getValeuraquisition());
        equipement.setDureegarantie(equipementdto.getDureegarantie());
        equipement.setPoids(equipementdto.getPoids());
        equipement.setTaille(equipementdto.getTaille());
        equipement.setAgent(equipementdto.getAgent());
        equipement.setDateaffectation(equipementdto.getDateaffectation());
        equipement.setIsdeleted(equipementdto.getIsdeleted());
        return equipement;
    }
}
