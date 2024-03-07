package com.dsi.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.application.entities.Credit;
import com.dsi.application.services.CreditService;

@RestController
public class CreditController {
	@Autowired
	CreditService creditService;
	
	@GetMapping("/credits")
	public List<Credit> getAll(){
	return creditService.getAllCredits();
	}
	
	 @PostMapping("/clients/{idClient}/credits")
	    public ResponseEntity<String>
	ajouterCreditPourClient(@PathVariable("idClient") int idClient,@RequestBody Credit credit) {
	        boolean ajoutReussi = creditService.ajouterCreditPourClient(idClient, credit);
	        if (ajoutReussi) {
	            return ResponseEntity.ok().body("Credit ajouté avec succès pour le client avec l'ID : " + idClient);
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Erreur lors de l'ajout du crédit pour le client avec l'ID : " + idClient);
	        }
	    }

}
