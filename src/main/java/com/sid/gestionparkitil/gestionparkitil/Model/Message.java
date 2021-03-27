package com.sid.gestionparkitil.gestionparkitil.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idamess;
    private String sujet;
    private String message;
    private Boolean ouvert;
    @ManyToOne()
    @JoinColumn(name = "idenvoyeur")
    private Utilisateur envoyeur;
    @ManyToOne()
    @JoinColumn(name = "idrecepteur")
    private Utilisateur recepteur;
    private Date dateenvoie;
    private Boolean isdeleted;
}
