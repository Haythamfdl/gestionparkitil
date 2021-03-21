package com.sid.gestionparkitil.gestionparkitil.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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
	private Boolean isdeleted;

}
