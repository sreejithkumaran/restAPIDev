package org.restapi.development.messanger.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.restapi.development.messanger.database.DatabaseClass;
import org.restapi.development.messanger.model.Message;

public class MessageService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		messages.put(1L,new Message(1L,"Message-1",date, "Sreejith"));
		messages.put(2L,new Message(2L,"Message-2",date, "Kumaran"));	
		messages.put(3L,new Message(3L,"Message-3",date, "Ajeet"));
		messages.put(4L,new Message(4L,"Message-4",date, "Singh"));
		messages.put(5L,new Message(5L,"Message-5",date, "Jeethi"));
		messages.put(6L,new Message(6L,"Message-6",date, "Jayagopal"));
	}

	public List<Message> getAllMessage(){
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message); 	
		return message;
	}

	public Message updateMessage(Message message) {
		if(message.getId()<=0) {
			return null;
		}
		messages.put(message.getId(), message); 	
		return message;
	}

	public Message deleteMessage(long id) {
		return messages.remove(id);
	}

}
