package com.sid.gestionparkitil.gestionparkitil.Repo;

import com.sid.gestionparkitil.gestionparkitil.Model.Message;
import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface MessageRepo extends JpaRepository<Message, Long> {
    public List<Message> findAllByRecepteurAndIsdeletedOrderByDateenvoieDesc(Utilisateur recepteur, Boolean isdeleted);
    public List<Message> findAllByRecepteurAndOuvertAndIsdeletedOrderByDateenvoieDesc(Utilisateur recepteur, Boolean ouvert, Boolean isdeleted);
}
