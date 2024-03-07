package com.dsi.application.entities;

import lombok.Data;

@Data
public class SMSSendRequest {
	
	private String destinationSMSNumber;
	private String smsMessage;
	public String getDestinationSMSNumber() {
		return destinationSMSNumber;
	}
	public void setDestinationSMSNumber(String destinationSMSNumber) {
		this.destinationSMSNumber = destinationSMSNumber;
	}
	public String getSmsMessage() {
		return smsMessage;
	}
	public void setSmsMessage(String smsMessage) {
		this.smsMessage = smsMessage;
	}
	
	
}
