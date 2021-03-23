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
	private Float valeuraquisition;
	private Long dureegarantie;
	private String poids;
	private String taille;
	@ManyToOne
	@JoinColumn(name = "idagent")
	private Agent agent;
	private Date dateaffectation;
	private Boolean isdeleted;
}
