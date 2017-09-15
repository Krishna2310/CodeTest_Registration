package org.gati.codetest.registration.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gati.codetest.registration.database.DatabaseClass;
import org.gati.codetest.registration.exception.DataNotFoundException;
import org.gati.codetest.registration.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	//start1
/*	public List<Message> getAllMessages() {	
		
		
		Message m1 = new Message(1L,"Hello World","Gati");
		Message m2 = new Message(2L,"Hello World1","Gati1");
		
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
		
	}*/
	//end1
	
	public MessageService (){
		messages.put(1L, new Message(1L,"Hello World","Gati"));
		messages.put(2L, new Message(2L,"Hello World2","Gati2"));
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		
		return messages.remove(id);
	}
	
	public Message getMessage(long id){
		Message message = messages.get(id);
		if(message==null){
			throw new DataNotFoundException("Message not found with ID : " +id);
		}
		return message;
	}
	
	
	
	
}