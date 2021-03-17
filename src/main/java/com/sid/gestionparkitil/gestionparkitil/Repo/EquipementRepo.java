package com.sid.gestionparkitil.gestionparkitil.Repo;


import com.sid.gestionparkitil.gestionparkitil.Model.Agent;
import com.sid.gestionparkitil.gestionparkitil.Model.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EquipementRepo extends JpaRepository<Equipement, Long> {
	public List<Equipement> findAllByIsdeleted(Boolean isdeleted);
	public List<Equipement> findAllByAgentAndIsdeleted(Agent agent, Boolean isdeleted);
	public Equipement findByNumero(String numero);
}
