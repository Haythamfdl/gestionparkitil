package com.sid.gestionparkitil.gestionparkitil.Controller;

import com.sid.gestionparkitil.gestionparkitil.Dto.UtilisateurDto;
import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import com.sid.gestionparkitil.gestionparkitil.Repo.UtilisateurRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UtilisateurController {
    private UtilisateurRepo utilisateurRepo;

    public UtilisateurController(UtilisateurRepo utilisateurRepo) {
        this.utilisateurRepo = utilisateurRepo;
    }

    @GetMapping("/utilisateurs/id/{id}")
    public Optional<Utilisateur> getUtilisateur(@PathVariable(name = "id") Long id) {
        return utilisateurRepo.findById(id);
    }

    @GetMapping("/utilisateurs/{email}")
    public Utilisateur getUtilisateur(@PathVariable(name = "email") String email) {
        return utilisateurRepo.findUtilisateurByEmailAndIsdeleted(email, false);
    }

    @GetMapping("/utilisateurs/{email}/{pass}")
    public Utilisateur login(@PathVariable String email, @PathVariable String pass) {
        return utilisateurRepo.findUtilisateurByEmailAndPassAndIsdeleted(email, pass, false);
    }

    @PutMapping(value = "/utilisateurs", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUtilisateur(@RequestBody UtilisateurDto utilisateurdto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIduser(utilisateurdto.getIduser());
        utilisateur.setNom(utilisateurdto.getNom());
        utilisateur.setEmail(utilisateurdto.getEmail());
        utilisateur.setPass(utilisateurdto.getPass());
        utilisateur.setTel(utilisateurdto.getTel());
        utilisateur.setDatemodifpass(utilisateurdto.getDatemodifpass());
        utilisateur.setIsdeleted(utilisateurdto.getIsdeleted());
        utilisateurRepo.save(utilisateur);
    }

}
