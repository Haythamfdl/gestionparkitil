package com.sid.gestionparkitil.gestionparkitil.Dto;


import com.sid.gestionparkitil.gestionparkitil.Model.Permission;

import java.util.Date;
import java.util.Set;

public class UtilisateurDto {
    private Long iduser;
    private String nom;
    private String email;
    private String pass;
    private String tel;
    private Date datemodifpass;
    private Set<Permission> permissions;
    private Boolean isdeleted;

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDatemodifpass() {
        return datemodifpass;
    }

    public void setDatemodifpass(Date datemodifpass) {
        this.datemodifpass = datemodifpass;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
}
