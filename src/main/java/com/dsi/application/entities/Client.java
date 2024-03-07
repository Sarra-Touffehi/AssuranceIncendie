package com.dsi.application.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jakarta.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idClient;
	private int numCompte;
	private String cin;
	private String nom;
	private String prenom;
	private String email;
	private Date dateNaissance;
	private String tel;
	private float revenu;
	

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL,
			orphanRemoval = true)
	@JsonManagedReference
			    private List<Credit> credits = new ArrayList<>();
	
	public List<Credit> getCredits() {
		return credits;
	}

	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}


@ManyToMany(cascade= {CascadeType.ALL})
@JoinTable(
		name = "client_offre",
		joinColumns={ @JoinColumn(name= "client_id") },
        inverseJoinColumns = { @JoinColumn(name = "offre_id") }
)
private Set<Offre> offres=new HashSet<>();

	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public int getNumCompte() {
		return numCompte;
	}
	
	
	
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public float getRevenu() {
		return revenu;
	}
	public void setRevenu(float revenu) {
		this.revenu = revenu;
	}

	

	

}
