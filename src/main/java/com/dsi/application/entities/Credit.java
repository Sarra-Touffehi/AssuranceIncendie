package com.dsi.application.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="credit")
public class Credit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numCredit;
	private String typeCredit;
	private float montant;
	private Date dateAccord;
	private Date dateEcheance;
	private String duree;
	
	@ManyToOne
    @JoinColumn(name = "idClient")
    @JsonBackReference

    private Client client;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getNumCredit() {
		return numCredit;
	}
	public void setNumCredit(int numCredit) {
		this.numCredit = numCredit;
	}
	public String getTypeCredit() {
		return typeCredit;
	}
	public void setTypeCredit(String typeCredit) {
		this.typeCredit = typeCredit;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public Date getDateAccord() {
		return dateAccord;
	}
	public void setDateAccord(Date dateAccord) {
		this.dateAccord = dateAccord;
	}
	public Date getDateEcheance() {
		return dateEcheance;
	}
	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	
	


}
