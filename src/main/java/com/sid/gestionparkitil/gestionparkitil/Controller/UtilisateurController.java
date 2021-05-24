package com.sid.gestionparkitil.gestionparkitil.Controller;

import com.sid.gestionparkitil.gestionparkitil.Dto.UtilisateurDto;
import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import com.sid.gestionparkitil.gestionparkitil.Repo.UtilisateurRepo;
import com.sid.gestionparkitil.gestionparkitil.Util.FromDtoToEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UtilisateurController {
    private UtilisateurRepo utilisateurRepo;
    private Utilisateur utilisateur = new Utilisateur();

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

    @PostMapping(value = "/utilisateurs", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addAgent(@RequestBody UtilisateurDto utilisateurdto) {
        utilisateurRepo.save(FromDtoToEntity.attribut(utilisateurdto, utilisateur));
    }

    @PutMapping(value = "/utilisateurs", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUtilisateur(@RequestBody UtilisateurDto utilisateurdto) {
        utilisateurRepo.save(FromDtoToEntity.attribut(utilisateurdto, utilisateur));
    }
}
