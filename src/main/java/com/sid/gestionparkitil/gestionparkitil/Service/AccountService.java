package com.sid.gestionparkitil.gestionparkitil.Service;

import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;

import java.util.List;

public interface AccountService {
    Utilisateur addNewUser(Utilisateur appUser);
    Utilisateur loadUserByUsername(String email);
    List<Utilisateur> listUsers();
}
