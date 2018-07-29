package org.restapi.development.messanger.resouces;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.restapi.development.messanger.service.MessageService;
import org.restapi.development.messanger.model.Message;

@Path("/messages")
public class messageResource {
	
	MessageService messageService = new MessageService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML) 
	public List<Message> getMessges() { 
		return messageService.getAllMessage();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)  
	public Message getMessge(@PathParam("messageId") long id) { 
		return messageService.getMessage(id);
	}
	
	

}
