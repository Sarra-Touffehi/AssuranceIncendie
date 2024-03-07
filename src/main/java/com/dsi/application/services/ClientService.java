package com.dsi.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.application.entities.Client;
import com.dsi.application.repositories.ClientRep;

import java.util.List;
@Service
public class ClientService {
@Autowired 
	ClientRep clientrep;

public List<Client> getAllClients(){
	return clientrep.findAll();
}


public boolean saveClient(Client cl) {
	if(clientrep.save(cl)!=null) 
		return true;
	else
		return false;
	}

public Client findClientByNumCompte(int numCompte) {
		return clientrep.findByNumCompte(numCompte);
	
}


	
}

