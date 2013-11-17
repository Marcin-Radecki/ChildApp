package com.example.entity;

public class AnswerEntity extends Entity{
	private String label;
	private int imagePathId;
	private int questionId;

	
	public int getImagePathId() {
		return imagePathId;
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
	
	public AnswerEntity(String label, int imagePathId) {
		super();
		this.label = label;
		this.imagePathId = imagePathId;
		this.questionId = -1;
	}
	
	
	
}
