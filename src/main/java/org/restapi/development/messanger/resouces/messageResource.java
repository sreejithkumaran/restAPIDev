package org.restapi.development.messanger.resouces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Message addMessge(Message m) { 
		return messageService.addMessage(m);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Message updateMessage(@PathParam("messageId") long id,Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_XML)
	public String deleteMessage(@PathParam("messageId") long id) {
		messageService.deleteMessage(id);
		return "Delete Successful";
	}
	
	
	
	

}
