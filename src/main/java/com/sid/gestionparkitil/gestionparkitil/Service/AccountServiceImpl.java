package com.sid.gestionparkitil.gestionparkitil.Service;

import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import com.sid.gestionparkitil.gestionparkitil.Repo.UtilisateurRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private final UtilisateurRepo appUserRepo;
    private final PasswordEncoder passwordEncoder;

    public AccountServiceImpl(UtilisateurRepo appUserRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Utilisateur addNewUser(Utilisateur appUser) {
        String pw = appUser.getPass();
        appUser.setPass(passwordEncoder.encode(pw));
        System.out.println(appUser);
        return appUserRepo.save(appUser);
    }

    public Utilisateur loadUserByUsername(String email) {
        return appUserRepo.findUtilisateurByEmailAndIsdeleted(email, false);
    }

    public Utilisateur getUser(String email, String pass) {
        return appUserRepo.findUtilisateurByEmailAndPassAndIsdeleted(email, passwordEncoder.encode(pass), false);
    }
}
