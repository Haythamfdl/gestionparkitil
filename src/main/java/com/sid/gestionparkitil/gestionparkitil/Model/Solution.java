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
	private Date date_soumission;
	@OneToOne()
	@JoinColumn(name = "id_probleme", referencedColumnName = "id_prob")
	private Probleme probleme;
	@OneToOne()
	@JoinColumn(name = "id_utilisateur", referencedColumnName = "id_user")
	private Utilisateur user;
	private Boolean isdeleted;


}
