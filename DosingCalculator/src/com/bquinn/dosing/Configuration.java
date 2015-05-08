package com.bquinn.dosing;

class Configuration {
	
	String sUsername;
	String sPassword;
	String sURL;
	
	public Configuration() {
		sUsername = "admin";
		sPassword = "1234";
		sURL = "http://192.168.0.99/cgi-bin/program.xml";
	}
	
	String getUsername() {
		return sUsername;
	}
	
	String getPassword() {
		return sPassword;
	}
	
	String getURL () {
		return sURL;
	}
	
}
