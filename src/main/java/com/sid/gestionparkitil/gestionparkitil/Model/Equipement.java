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
public class Equipement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idequip;
	private String numero;
	private String designation;
	private String fabriquant;
	private Date dateaquisition;
	private Date dateservice;
	private Float valeur_aquisition;
	private Long dureegarantie;
	private String poids;
	private String taille;
	@ManyToOne
	@JoinColumn(name = "idagent")
	private Agent agent;
	private Date date_affectation;
	private Boolean isdeleted;
}
