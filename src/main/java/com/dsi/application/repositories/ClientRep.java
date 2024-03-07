package com.dsi.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dsi.application.entities.Client;

public interface ClientRep extends JpaRepository<Client,Integer> {
// requête personnalisée
	@Query("SELECT c FROM Client c WHERE c.numCompte = :numCompte")
	Client findByNumCompte(@Param("numCompte") int numCompte);
}
