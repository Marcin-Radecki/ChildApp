package com.example.entity;

public class AnswerEntity extends Entity{
	private String label;
	private String imagePath;
	private int questionId;

	
	public String getImagePath() {
		return imagePath;
	}
	
	public String getLabel() {
		return label;
	}
	
	public int getQuestionId() 
	{
		return questionId;
	}
	
	public void setQuesionId(int id) {
		questionId = id;
	}
	
	public AnswerEntity(String label, String imagePath) {
		super();
		this.label = label;
		this.imagePath = imagePath;
		this.questionId = -1;
	}
	
	
}
