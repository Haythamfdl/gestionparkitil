package com.sid.gestionparkitil.gestionparkitil.Dto;

public class AgentDto {
    private Long idagent;
    private String numero;
    private String nom;
    private String email;
    private String tel;
    private String departement;
    private String fonction;
    private Boolean isdeleted;

    public Long getIdagent() {
        return idagent;
    }

    public void setIdagent(Long idagent) {
        this.idagent = idagent;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
}
