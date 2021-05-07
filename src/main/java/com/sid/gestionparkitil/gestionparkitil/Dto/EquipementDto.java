package com.sid.gestionparkitil.gestionparkitil.Dto;

import com.sid.gestionparkitil.gestionparkitil.Model.Agent;

import java.util.Date;

public class EquipementDto {
    private Long idequip;
    private String numero;
    private String designation;
    private String fabriquant;
    private Date dateaquisition;
    private Date dateservice;
    private Float valeuraquisition;
    private Long dureegarantie;
    private String poids;
    private String taille;
    private Agent agent;
    private Date dateaffectation;
    private Boolean isdeleted;

    public Long getIdequip() {
        return idequip;
    }

    public void setIdequip(Long idequip) {
        this.idequip = idequip;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getFabriquant() {
        return fabriquant;
    }

    public void setFabriquant(String fabriquant) {
        this.fabriquant = fabriquant;
    }

    public Date getDateaquisition() {
        return dateaquisition;
    }

    public void setDateaquisition(Date dateaquisition) {
        this.dateaquisition = dateaquisition;
    }

    public Date getDateservice() {
        return dateservice;
    }

    public void setDateservice(Date dateservice) {
        this.dateservice = dateservice;
    }

    public Float getValeuraquisition() {
        return valeuraquisition;
    }

    public void setValeuraquisition(Float valeuraquisition) {
        this.valeuraquisition = valeuraquisition;
    }

    public Long getDureegarantie() {
        return dureegarantie;
    }

    public void setDureegarantie(Long dureegarantie) {
        this.dureegarantie = dureegarantie;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Date getDateaffectation() {
        return dateaffectation;
    }

    public void setDateaffectation(Date dateaffectation) {
        this.dateaffectation = dateaffectation;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
}
