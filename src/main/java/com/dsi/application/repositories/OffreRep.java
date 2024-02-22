package com.dsi.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.application.entities.Offre;

public interface OffreRep extends JpaRepository<Offre,Integer> {

}