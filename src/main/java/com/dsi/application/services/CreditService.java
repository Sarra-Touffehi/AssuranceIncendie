package com.dsi.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.application.entities.Client;
import com.dsi.application.entities.Credit;

import com.dsi.application.repositories.ClientRep;
import com.dsi.application.repositories.CreditRep;

@Service
public class CreditService {
@Autowired 
 CreditRep creditRep;
@Autowired 
ClientRep clientRep;


public boolean saveCredit (Credit credit) {
	if(creditRep.save(credit)!=null)
	return true;
	else
	return false;
}


public List<Credit> getAllCredits(){
return creditRep.findAll();
}


public boolean ajouterCreditPourClient(int idClient, Credit credit) {
    Client client = clientRep.findById(idClient)
                .orElseThrow(() -> new
IllegalArgumentException("Client non trouvée avec l'ID : " + idClient));

    credit.setClient(client);
    Credit savedCredit = creditRep.save(credit);
        client.getCredits().add(savedCredit);

        return savedCredit != null;
    }

}
