package com.sid.gestionparkitil.gestionparkitil.Dto;

import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;

import java.util.Date;

public class MessageDto {
    private Long idmess;
    private String sujet;
    private String message;
    private Boolean ouvert;
    private Utilisateur envoyeur;
    private Utilisateur recepteur;
    private Date dateenvoie;
    private Boolean isdeleted;

    public Long getIdmess() {
        return idmess;
    }

    public void setIdmess(Long idmess) {
        this.idmess = idmess;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getOuvert() {
        return ouvert;
    }

    public void setOuvert(Boolean ouvert) {
        this.ouvert = ouvert;
    }

    public Utilisateur getEnvoyeur() {
        return envoyeur;
    }

    public void setEnvoyeur(Utilisateur envoyeur) {
        this.envoyeur = envoyeur;
    }

    public Utilisateur getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Utilisateur recepteur) {
        this.recepteur = recepteur;
    }

    public Date getDateenvoie() {
        return dateenvoie;
    }

    public void setDateenvoie(Date dateenvoie) {
        this.dateenvoie = dateenvoie;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
}
