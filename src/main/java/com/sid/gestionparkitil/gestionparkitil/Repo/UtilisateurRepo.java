package com.sid.gestionparkitil.gestionparkitil.Repo;

import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
    public Utilisateur findUtilisateurByEmailAndPassAndIsdeleted(String email, String pass, Boolean isdeleted);

    public Utilisateur findUtilisateurByEmailAndIsdeleted(String email, Boolean isdeleted);
}
