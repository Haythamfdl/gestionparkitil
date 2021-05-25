package com.sid.gestionparkitil.gestionparkitil.Controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sid.gestionparkitil.gestionparkitil.Dto.UtilisateurDto;
import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import com.sid.gestionparkitil.gestionparkitil.Repo.UtilisateurRepo;
import com.sid.gestionparkitil.gestionparkitil.Securiter.JWTUtil;
import com.sid.gestionparkitil.gestionparkitil.Securiter.JwtTokenRefresher;
import com.sid.gestionparkitil.gestionparkitil.Service.AccountService;
import com.sid.gestionparkitil.gestionparkitil.Util.FromDtoToEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UtilisateurController {
    private UtilisateurRepo utilisateurRepo;
    private Utilisateur utilisateur = new Utilisateur();
    private AccountService accountService;
    private JwtTokenRefresher jwtTokenRefresher;

    public UtilisateurController(UtilisateurRepo utilisateurRepo, AccountService accountService, JwtTokenRefresher jwtTokenRefresher) {
        this.utilisateurRepo = utilisateurRepo;
        this.accountService = accountService;
        this.jwtTokenRefresher = jwtTokenRefresher;
    }

    @GetMapping("/utilisateurs/id/{id}")
    public Optional<Utilisateur> getUtilisateur(@PathVariable(name = "id") Long id) {
        return utilisateurRepo.findById(id);
    }

    @GetMapping("/utilisateurs/{email}")
    public Utilisateur getUtilisateur(@PathVariable(name = "email") String email) {
        return utilisateurRepo.findUtilisateurByEmailAndIsdeleted(email, false);
    }

    @GetMapping("/utilisateurs/login/{email}/{pass}")
    public Utilisateur login(@PathVariable String email, @PathVariable String pass) {
        return utilisateurRepo.findUtilisateurByEmailAndPassAndIsdeleted(email, pass, false);
    }

    @PostMapping(value = "/utilisateurs", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addAgent(@RequestBody UtilisateurDto utilisateurdto) {
        accountService.addNewUser(FromDtoToEntity.attribut(utilisateurdto, utilisateur));
    }

    @PutMapping(value = "/utilisateurs", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUtilisateur(@RequestBody UtilisateurDto utilisateurdto) {
        accountService.addNewUser(FromDtoToEntity.attribut(utilisateurdto, utilisateur));
    }

    @GetMapping(path = "/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception{
        jwtTokenRefresher.refreshToken(request,response);
    }
}
