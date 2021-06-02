package com.sid.gestionparkitil.gestionparkitil.Repo;

import com.sid.gestionparkitil.gestionparkitil.Model.Probleme;
import com.sid.gestionparkitil.gestionparkitil.Model.Solution;
import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface SolutionRepo extends JpaRepository<Solution, Long> {
    List<Solution> findAllByProblemeAndIsdeletedOrderByDatesoumissionDesc(Probleme probleme, Boolean isdeleted);

    List<Solution> findAllByUserAndIsdeletedOrderByDatesoumissionDesc(Utilisateur utilisateur, Boolean isdeleted);
}
