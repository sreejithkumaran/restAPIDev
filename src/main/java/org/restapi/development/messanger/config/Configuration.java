package org.restapi.development.messanger.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	public static String URL;
	public static String UserName;
	public static String Password;

	static{
		Properties prop = new Properties();
		try {
			FileInputStream input;
			input = new FileInputStream("config.properties");
			prop.load(input);
			URL=prop.getProperty("Url");
			UserName=prop.getProperty("UserName");
			Password=prop.getProperty("Password");
			
			System.out.println("URL :: "+URL);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

