package com.sid.gestionparkitil.gestionparkitil.Controller;


import com.sid.gestionparkitil.gestionparkitil.Dto.EquipementDto;
import com.sid.gestionparkitil.gestionparkitil.Model.Agent;
import com.sid.gestionparkitil.gestionparkitil.Model.Equipement;
import com.sid.gestionparkitil.gestionparkitil.Repo.EquipementRepo;
import com.sid.gestionparkitil.gestionparkitil.Util.FromDtoToEntity;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EquipementController {

    private final EquipementRepo equipementRepo;

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
    @PreAuthorize("hasAnyAuthority('AJE','MDE','SPE','AFE')")
    public void addEquipement(@RequestBody EquipementDto equipementdto) {
        Equipement equipement = new Equipement();
        equipementRepo.save(FromDtoToEntity.attribut(equipementdto, equipement));
    }

    @PutMapping(value = "/equipements", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('AJE','MDE','SPE','AFE')")
    public void updateEquipement(@RequestBody EquipementDto equipementdto) {
        Equipement equipement = new Equipement();
        equipementRepo.save(FromDtoToEntity.attribut(equipementdto, equipement));
    }
}
