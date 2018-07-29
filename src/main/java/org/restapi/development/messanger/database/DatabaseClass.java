package org.restapi.development.messanger.database;

import java.util.HashMap;
import java.util.Map;

import org.restapi.development.messanger.model.Message;
import org.restapi.development.messanger.model.Profile;

public class DatabaseClass {
	
	private static Map<String , Profile> profiles = new HashMap<>();
	private static Map<Long, Message> messages = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
	

}
