package com.example.entity;

import java.util.Date;

public abstract class Entity {

	private String timeStamp;
	private int id;
	private static int idCounter = 0;
	
	public int getId()  { return id; }
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public Entity() {
		//id = idCounter++;
		Date d = new Date();
		timeStamp = d.toString();
	}
}
