package com.sid.gestionparkitil.gestionparkitil.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;
    private String nom;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pass;
    private String tel;
    private Date datemodifpass;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "permission_accorde",
            joinColumns = @JoinColumn(name = "iduser"),
            inverseJoinColumns = @JoinColumn(name = "idpermission"))
    private Collection<Permission> permissions;
    private Boolean isdeleted;
}
