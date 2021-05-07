package com.sid.gestionparkitil.gestionparkitil.Dto;

import com.sid.gestionparkitil.gestionparkitil.Model.Probleme;
import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;

import java.util.Date;

public class SolutionDto {
    private Long idsol;
    private String titre;
    private String solution;
    private Date datesoumission;
    private Probleme probleme;
    private Utilisateur user;
    private Boolean isdeleted;

    public Long getIdsol() {
        return idsol;
    }

    public void setIdsol(Long idsol) {
        this.idsol = idsol;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Date getDatesoumission() {
        return datesoumission;
    }

    public void setDatesoumission(Date datesoumission) {
        this.datesoumission = datesoumission;
    }

    public Probleme getProbleme() {
        return probleme;
    }

    public void setProbleme(Probleme probleme) {
        this.probleme = probleme;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
}
