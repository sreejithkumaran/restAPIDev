package org.restapi.development.messanger.resouces;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.restapi.development.messanger.model.Profile;
import org.restapi.development.messanger.service.ProfileService;

@Path("/profiles")
public class profileResource {

	ProfileService profileService = new ProfileService(); 

	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Profile> getProfiles(){
		return profileService.getAllProfile();
	}

}
