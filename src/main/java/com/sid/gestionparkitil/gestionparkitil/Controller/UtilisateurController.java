package com.sid.gestionparkitil.gestionparkitil.Controller;

import com.sid.gestionparkitil.gestionparkitil.Dto.UtilisateurDto;
import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import com.sid.gestionparkitil.gestionparkitil.Repo.UtilisateurRepo;
import com.sid.gestionparkitil.gestionparkitil.Securiter.JwtTokenRefresher;
import com.sid.gestionparkitil.gestionparkitil.Service.AccountService;
import com.sid.gestionparkitil.gestionparkitil.Util.FromDtoToEntity;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UtilisateurController {
    private final UtilisateurRepo utilisateurRepo;
    private final AccountService accountService;
    private final JwtTokenRefresher jwtTokenRefresher;

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
        return accountService.getUser(email, pass);
    }

    @PostMapping(value = "/utilisateurs", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('AJU','MDU')")
    public void addUtilisateur(@RequestBody UtilisateurDto utilisateurdto) {
        Utilisateur utilisateur = new Utilisateur();
        accountService.addNewUser(FromDtoToEntity.attribut(utilisateurdto, utilisateur));
    }

    @PutMapping(value = "/utilisateurs", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('AJU','MDU')")
    public void updateUtilisateur(@RequestBody UtilisateurDto utilisateurdto) {
        Utilisateur utilisateur = new Utilisateur();
        accountService.addNewUser(FromDtoToEntity.attribut(utilisateurdto, utilisateur));
    }

    @GetMapping(path = "/refreshToken")
    public Map<String, String> refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return jwtTokenRefresher.refreshToken(request, response);
    }

    //Tester si le access Token est valable
    @GetMapping(path = "/testToken")
    public void testToken() throws Exception {
    }
}
