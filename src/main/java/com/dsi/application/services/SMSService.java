package com.dsi.application.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SMSService {
	@Value("${TWILIO_ACCOUNT_SID}")
	String ACCOUNT_SID;
	
	@Value("${TWILIO_AUTH_TOKEN}")
	String AUTH_TOKEN;
	
	@Value("${TWILIO_OUTDOING_SMS_NUMBER}")
	String OUTDOING_SMS_NUMBER;
	/*
	public SMSService() {
		System.out.println("creating class SMSService ");
		System.out.println("ACCOUNT_SID " + ACCOUNT_SID);

	}
	*/
	
	@PostConstruct
	private void setup() {
		//System.out.println("ACCOUNT_SID " + ACCOUNT_SID);
		Twilio.init( ACCOUNT_SID,AUTH_TOKEN);

	}
	/*
 public String sendSMS(String smsNumber, String smsMessage) {
	 Message message=Message.creator(
			new PhoneNumber(smsNumber),
			new PhoneNumber(OUTDOING_SMS_NUMBER),
			smsMessage).create();
		
	 return message.getStatus().toString();
 }*/
	
	public List<String> getClientPhoneNumbers() {
	    
	    return Arrays.asList( "+21693035231");
	}

	public void notifyClients(String smsMessage) {
	    List<String> clientPhoneNumbers = getClientPhoneNumbers();
	    sendSMS(clientPhoneNumbers, smsMessage);
	}

	public String sendSMS(List<String> smsNumbers, String smsMessage) {
	    for (String smsNumber : smsNumbers) {
	    	try {
	        Message message = Message.creator(
	                new PhoneNumber(smsNumber),
	                new PhoneNumber(OUTDOING_SMS_NUMBER),
	                smsMessage).create();
	        
	        //log.info("SMS sent to " + smsNumber + " SID: " + message.getSid());
	        System.out.println("SMS sent to " + smsNumber + " SID: " + message.getSid());
	    }
	    	catch(Exception e) {
	    		System.out.println("failed " );
	    	}
	    	}
	    return "SMS sent to all clients";
	}
}
