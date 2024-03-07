package com.dsi.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.application.entities.Client;

import com.dsi.application.services.ClientService;

@RestController
public class ClientController {
@Autowired 
ClientService clientservice;

@GetMapping("/clients")
public List<Client> getAll(){
	return clientservice.getAllClients();
}	


@GetMapping("/clients/{numCompte}")
public Client getOne(@PathVariable("numCompte") int numCompte) {
	return clientservice.findClientByNumCompte(numCompte);
}


@PostMapping("/clients")
public boolean addClient(@RequestBody Client client) {
	return clientservice.saveClient(client);
}
}
