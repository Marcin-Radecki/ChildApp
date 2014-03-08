package sdm.application.entity;

import java.util.Date;

public abstract class Entity {

	private String timeStamp;
	private int id;
	
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
		Date d = new Date();
		timeStamp = d.toString();
	}

	public long compareTo(UserEntity obj1, UserEntity obj2) {
		return 0;
	}
}
