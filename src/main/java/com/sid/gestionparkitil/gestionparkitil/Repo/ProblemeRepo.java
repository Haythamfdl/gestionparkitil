package com.sid.gestionparkitil.gestionparkitil.Repo;

import com.sid.gestionparkitil.gestionparkitil.Model.Agent;
import com.sid.gestionparkitil.gestionparkitil.Model.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProblemeRepo extends JpaRepository<Probleme, Long> {
	public List<Probleme> findAllByIsdeletedOrderbydAndDate_soumissionDesc(Boolean isdeleted);
	public List<Probleme> findAllByAgentAndIsdeletedOrderbyDate_soumissionDesc(Agent agent, Boolean isdeleted);
	public Probleme findById_prob(Long id);
	public List<Probleme> findAllByResoluAndIsdeletedOrderbyDate_soumissionDesc(Boolean resolu, Boolean isdeleted);
}
