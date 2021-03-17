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
	private Long id_equip;
	private String numero;
	private String designation;
	private String fabriquant;
	private Date date_aquisition;
	private Date date_service;
	private Float valeur_aquisition;
	private Long duree_garantie;
	private String poids;
	private String taille;
	@ManyToOne
	@JoinColumn(name = "id_agent")
	private Agent agent;
	private Date date_affectation;
	private Boolean isdeleted;



}
