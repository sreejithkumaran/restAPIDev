package org.restapi.development.messanger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.restapi.development.messanger.model.Profile;

public class ProfileService {

	private static Map<String , Profile> profiles = new HashMap<>();
	
	public ProfileService() {	
		profiles.put("1",new Profile("Sreejith","Kumaran", "31","Male","Indian","001"));
		profiles.put("2",new Profile("Jeethi","Jayagopal", "27","Female","Indian","002"));
		profiles.put("3",new Profile("Steve","Austin", "40","Male","US","003"));
		profiles.put("4",new Profile("Dwayne","Johnson", "40","Male","US","004"));
		profiles.put("5",new Profile("Dyna","Hyden", "31","Female","British","005"));
	}
	
	public List<Profile> getAllProfile(){
		return new ArrayList<Profile>(profiles.values());
	}
}
