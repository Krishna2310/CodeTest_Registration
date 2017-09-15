package org.gati.codetest.registration.resources;

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

import org.gati.codetest.registration.model.Message;
import org.gati.codetest.registration.service.MessageService;


@Path("/messages")
public class MessageResource {
	
	MessageService messageservice = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return messageservice.getAllMessages();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessages(Message message) {
		return messageservice.addMessage(message);
	}
	
	@PUT
	@Path("/{test}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("test") long id,Message message){
		message.setId(id);
		return messageservice.updateMessage(message);
	}
	
	@DELETE
	@Path("/{test}")
	@Produces(MediaType.APPLICATION_JSON)
	public void removeMessage(@PathParam("test") long id){
		messageservice.removeMessage(id);
	}
	
	@GET
	@Path("/{test}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getTest(@PathParam("test") long id) {
		//return "Testing 123   :" + test;
		return messageservice.getMessage(id);
	}
}
