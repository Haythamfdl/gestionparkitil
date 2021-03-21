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
public class Solution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsol;
	private String titre;
	private String solution;
	private Date datesoumission;
	@ManyToOne()
	@JoinColumn(name = "idprobleme")
	private Probleme probleme;
	@ManyToOne()
	@JoinColumn(name = "iduser")
	private Utilisateur user;
	private Boolean isdeleted;


}
