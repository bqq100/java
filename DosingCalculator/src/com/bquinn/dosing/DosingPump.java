package com.bquinn.dosing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.xml.sax.InputSource;

class DosingPump {
	
	private Configuration oConfig;
	private float fDosingTime;
	private float fPumpCalibration;
	
	public DosingPump( Configuration config, String pumpName, float calibration ) {
		fPumpCalibration = calibration;
		oConfig = config;
		getPumpInfo( pumpName );
	}
	
	private void getPumpInfo ( String pumpName ) {	
		try{
			setAuthentication();
			Document doc = loadXMLFromString( getWebsite() );
			
			NodeList outlets = doc.getElementsByTagName("outlet");
			for ( int i = 0; i < outlets.getLength(); i++ ){
				String thisOutlet = "";
				String thisProgram = "";
				NodeList elements = outlets.item(i).getChildNodes();
				for ( int j = 0; j < elements.getLength(); j++ ){
					if ( elements.item(j).getNodeName() == "name"){
						thisOutlet = elements.item(j).getTextContent();
					}else if ( elements.item(j).getNodeName() == "program"){
						thisProgram = elements.item(j).getTextContent();
					}
				}
				if ( thisOutlet.equals(pumpName) ){
					System.out.println(thisProgram);
					break;
				}
			}
		}
		catch (Exception exception){
			System.out.println( "Error... " + exception.getMessage() );
		}
	}
		
	public static Document loadXMLFromString(String xml) throws Exception
	{
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    InputSource is = new InputSource(new StringReader(xml));
	    return builder.parse(is);
	}
	
	private String getWebsite() {
		String html = "";
		try {
			URL url = new URL(oConfig.getURL());
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		
			for (String line; (line = reader.readLine()) != null;) {
				html += line;
			}
		}
		catch ( Exception exception ) {
			System.out.println("Error..." + exception.getMessage() );
		}
		return html;
	}

	private void setAuthentication() {
		Authenticator.setDefault(
			new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
			         return new PasswordAuthentication(
			        		 oConfig.getUsername(), oConfig.getPassword().toCharArray()
	        		 );
		        }
			}
		);
		return;
	}
}

