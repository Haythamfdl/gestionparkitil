package com.sid.gestionparkitil.gestionparkitil.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idagent;
	private String numero;
	private String nom;
	private String email;
	private String tel;
	private String departement;
	private String fonction;
	private Boolean isdeleted;

}
