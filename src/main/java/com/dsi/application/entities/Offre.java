package com.dsi.application.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="offres")
public class Offre {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int idOffre;
private String nom;
private String conditions;
private String couverture;
private float frais;
private float taux_risque;
@ManyToOne
    @JoinColumn(name = "idcomp")
    private Compagnie compagnie;
public int getIdOffre() {
return idOffre;
}

public void setIdOffre(int idOffre) {
this.idOffre = idOffre;
}

public String getNom() {
return nom;
}

public void setNom(String nom) {
this.nom = nom;
}

public String getConditions() {
return conditions;
}

public void setConditions(String conditions) {
this.conditions = conditions;
}

public String getCouverture() {
return couverture;
}

public void setCouverture(String couverture) {
this.couverture = couverture;
}

public float getFrais() {
return frais;
}

public void setFrais(float frais) {
this.frais = frais;
}

public float getTaux_risque() {
return taux_risque;
}

public void setTaux_risque(float taux_risque) {
this.taux_risque = taux_risque;
}
}
