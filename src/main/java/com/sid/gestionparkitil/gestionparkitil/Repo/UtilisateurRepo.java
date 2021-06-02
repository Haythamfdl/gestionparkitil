package com.sid.gestionparkitil.gestionparkitil.Repo;

import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
    Utilisateur findUtilisateurByEmailAndPassAndIsdeleted(String email, String pass, Boolean isdeleted);

    Utilisateur findUtilisateurByEmailAndIsdeleted(String email, Boolean isdeleted);
}
