package com.dsi.application.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dsi.application.entities.SMSSendRequest;
import com.dsi.application.services.SMSService;


@RestController
@RequestMapping("/api/v1")
public class SMSRestController {
	@Autowired
	SMSService smsservice;
	//private static final Logger log = LoggerFactory.getLogger(SMSRestController.class);

	/*@PostMapping("/processSMS")
	public String processSMS(@RequestBody SMSSendRequest sendRequest ) {
		
	//log.info("processSMS started sendRequest: "+ sendRequest.toString());
		System.out.println("processSMS started sendRequest: "+ sendRequest.toString());
		return smsservice.sendSMS(sendRequest.getDestinationSMSNumber(), sendRequest.getSmsMessage());
	}*/
	 @GetMapping("/testStartSendingSMS")	
	public void votreMethodePrincipale() {
        
        String message = "Votre message à envoyer à tous les clients";
        smsservice.notifyClients(message);
        
    }
	 /*
	 @GetMapping("/testSendSMS")
	    public String testSendSMS() {
	        String testMessage = "Ceci est un test de message SMS.";
	        return smsservice.sendSMS(Arrays.asList("+21620731161"), testMessage);
	    }*/
	
}
