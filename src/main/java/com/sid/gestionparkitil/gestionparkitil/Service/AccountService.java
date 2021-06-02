package com.sid.gestionparkitil.gestionparkitil.Service;

import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;


public interface AccountService {
    Utilisateur addNewUser(Utilisateur appUser);

    Utilisateur loadUserByUsername(String email);

    Utilisateur getUser(String email, String pass);
}
