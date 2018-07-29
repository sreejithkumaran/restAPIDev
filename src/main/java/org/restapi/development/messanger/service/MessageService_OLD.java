 package org.restapi.development.messanger.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.restapi.development.messanger.model.Message;

public class MessageService_OLD {

	public List<Message> getAllMessage(){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); 
		
		List<Message>list = new ArrayList<>();
		Message m1 = new Message(1L,"Message-1",date, "Sreejith");
		Message m2 = new Message(2L,"Message-2",date, "Kumaran");
		Message m3 = new Message(3L,"Message-3",date, "Ajeet");
		Message m4 = new Message(4L,"Message-4",date, "Singh");
		Message m5 = new Message(5L,"Message-5",date, "Jeethi");
		Message m6 = new Message(6L,"Message-6",date, "Jayagopal");
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		list.add(m6);
	
		return list;
	}
}
