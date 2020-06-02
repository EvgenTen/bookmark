package com.evgen.mockDataBase;

import java.util.ArrayList;
import java.util.List;


import daoImpl.Dao;
import entities.Course;
import entities.Message;

public class MockDataBase {

	List<Message> messages;
	List<Course> courses;
	

	
	public MockDataBase() {
		
		messages = new ArrayList<>();
		
		Message m1 = new Message();
		m1.setId(1);
		m1.setMessage("Java introduction");
		
		Message m2 = new Message();
		m2.setId(2);
		m2.setMessage("Arts of East Asia");
		
		Message m3 = new Message();
		m3.setId(3);
		m3.setMessage("algorithms");
		
		Message m4 = new Message();
		m4.setId(4);
		m4.setMessage("Linear algebra");
		
		Message m5 = new Message();
		m5.setId(5);
		m5.setMessage("ZEN Buddhism");
		
		
		messages.add(m1);
		messages.add(m2);
		messages.add(m3);
		messages.add(m4);
		messages.add(m5);

		
       courses = new ArrayList<>();
		
		Course c1 = new Course();
		c1.setId(1);
		c1.setUsername("Java introduction");
		
		Course c2 = new Course();
		c2.setId(2);
		c2.setUsername("Arts of East Asia");
		
		Course c3 = new Course();
		c3.setId(3);
		c3.setUsername("algorithms");
		
		Course c4 = new Course();
		c4.setId(4);
		c4.setUsername("Linear algebra");
		
		Course c5 = new Course();
		c5.setId(5);
		c5.setUsername("ZEN Buddhism");
		
		
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		courses.add(c4);
		courses.add(c5);

		
	}

	public List<Message> getMessages() {
		return messages;
	}
	
	public List<Course> getCourses() {
		return courses;
	}
	
	public void createMessage(Message m) {
		
		Dao d = new Dao();
		
		d.createMessage(m);
		
		System.out.println(m.toString());
		
	
	}
}
