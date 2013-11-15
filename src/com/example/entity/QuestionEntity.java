package com.example.entity;

import java.util.ArrayList;

public class QuestionEntity extends Entity {
	private String question;
	private String type;
	private ArrayList<AnswerEntity> answers;
	private int trueAnswer;
	
	public int getAnswer() {
		return trueAnswer;
	}

	public ArrayList<AnswerEntity> getAnswers() {
		return answers;
	}

	public String getType() {
		return this.type;
	}
	
	public String getQuestion() {

		return this.question;
	}
	
	public QuestionEntity(String question, String type, ArrayList<AnswerEntity> answers, 
			int answer) {
		super();
		this.question = question;
		this.type = type;
		this.answers = answers;
		this.trueAnswer = answer;
	}
}
