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
public class Probleme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_prob;
	private String titre;
	private String probleme;
	private Date datesoumission;
	@ManyToOne
	@JoinColumn(name = "id_agent")
	private Agent agent;
	private String type;
	private Boolean resolu;
	@OneToOne()
	@JoinColumn(name = "id_equip")
	private Equipement equipement;

	private Boolean isdeleted;

}
