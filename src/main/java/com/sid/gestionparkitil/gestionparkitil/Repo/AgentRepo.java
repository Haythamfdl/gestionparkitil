package com.sid.gestionparkitil.gestionparkitil.Repo;

import com.sid.gestionparkitil.gestionparkitil.Model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AgentRepo extends JpaRepository<Agent, Long> {

    public List<Agent> findAllByIsdeleted(Boolean isdeleted);

    public Agent findByNumero(String numero);

}
