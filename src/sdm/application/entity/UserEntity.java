package sdm.application.entity;

import android.content.Context;

import sdm.application.childapp.R;



public class UserEntity extends Entity{
	private String name;
	private long score;
	private Context context;
	
	public UserEntity(Context context){
		this.context = context;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return  name + "\n" + context.getString(R.string.score) + " " + score;
	}

	@Override
	public long compareTo(UserEntity obj1,UserEntity obj2) {
		return (obj1.getScore()) - (obj2.getScore());
	}
	
	
}
