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
	private Long id_sol;
	private String titre;
	private String solution;
	private Date datesoumission;
	@ManyToOne()
	@JoinColumn(name = "id_probleme")
	private Probleme probleme;
	@ManyToOne()
	@JoinColumn(name = "id_user")
	private Utilisateur user;
	private Boolean isdeleted;


}
