package com.dsi.application.entities;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="compagnie")
public class Compagnie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idcomp;
	@NotNull
	private String nom;
	@NotNull
	@Lob
	private byte[] logo;
	@NotNull
	private String siege;
	@NotNull
	private String tel;
	
	@OneToMany(mappedBy = "compagnie", cascade = CascadeType.ALL,
			orphanRemoval = true)
			    private List<Offre> offres = new ArrayList<>();
	
	
	public int getIdcomp() {
		return idcomp;
	}
	public void setIdcomp(int idcomp) {
		this.idcomp = idcomp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	public String getSiege() {
		return siege;
	}
	public void setSiege(String siege) {
		this.siege = siege;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	public List<Offre> getOffres() {
        return offres;
    }

    public void setOffres(List<Offre> offres) {
        this.offres = offres;
    }

}
