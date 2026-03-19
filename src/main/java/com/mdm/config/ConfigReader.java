package com.mdm.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties prop;

	public ConfigReader() throws IOException {

		try {
			FileInputStream fis = new FileInputStream("src\\test\\resources\\config.properties");

			prop = new Properties();
			prop.load(fis);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public String getURL() {
		return prop.getProperty("URL");
		
	}
	public String getUserName() {
		return prop.getProperty("Username");
		
	}
	public String getPassWord() {
		return prop.getProperty("Password");
		
	}
	
	
	
	

}
