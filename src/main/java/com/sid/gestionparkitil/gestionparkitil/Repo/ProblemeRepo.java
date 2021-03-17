package com.sid.gestionparkitil.gestionparkitil.Repo;

import com.sid.gestionparkitil.gestionparkitil.Model.Agent;
import com.sid.gestionparkitil.gestionparkitil.Model.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProblemeRepo extends JpaRepository<Probleme, Long> {
	public List<Probleme> findAllByIsdeletedOrderByDatesoumissionDesc(Boolean isdeleted);
	public List<Probleme> findAllByAgentAndIsdeletedOrderByDatesoumissionDesc(Agent agent, Boolean isdeleted);
	public List<Probleme> findAllByResoluAndIsdeletedOrderByDatesoumissionDesc(Boolean resolu, Boolean isdeleted);
}
