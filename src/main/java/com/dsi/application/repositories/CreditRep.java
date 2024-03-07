package com.dsi.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.application.entities.Credit;

public interface CreditRep extends JpaRepository<Credit,Integer>{

}
