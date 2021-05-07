package com.sid.gestionparkitil.gestionparkitil.Dto;

import com.sid.gestionparkitil.gestionparkitil.Model.Agent;
import com.sid.gestionparkitil.gestionparkitil.Model.Equipement;

import java.util.Date;

public class ProblemeDto {
    private Long idprob;
    private String titre;
    private String probleme;
    private Date datesoumission;
    private Agent agent;
    private String type;
    private Boolean resolu;
    private Equipement equipement;
    private Boolean isdeleted;

    public Long getIdprob() {
        return idprob;
    }

    public void setIdprob(Long idprob) {
        this.idprob = idprob;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getProbleme() {
        return probleme;
    }

    public void setProbleme(String probleme) {
        this.probleme = probleme;
    }

    public Date getDatesoumission() {
        return datesoumission;
    }

    public void setDatesoumission(Date datesoumission) {
        this.datesoumission = datesoumission;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getResolu() {
        return resolu;
    }

    public void setResolu(Boolean resolu) {
        this.resolu = resolu;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
}
