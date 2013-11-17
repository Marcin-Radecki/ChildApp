package com.example.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.childapp.R;

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

	public String getQuestionType() {
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
	
	public static List<QuestionEntity> CreateQuestions() {
		return new ArrayList<QuestionEntity>(Arrays.asList(new QuestionEntity[] {
				new QuestionEntity(
						"What is the lion?", 
						"animals",
						new ArrayList<AnswerEntity>(Arrays.asList(new AnswerEntity[] {
								new AnswerEntity("Lion", R.drawable.leon),
								new AnswerEntity("Camel", R.drawable.camel),
								new AnswerEntity("Lion", R.drawable.crocodile)
							})),					
						0  // correct answer
						),
				new QuestionEntity(
						"What is the goat?", 
						"animals",
						new ArrayList<AnswerEntity>(Arrays.asList(new AnswerEntity[] {
								new AnswerEntity("Dog", R.drawable.dog),
								new AnswerEntity("Donkey",R.drawable.donkey),
								new AnswerEntity("Goat", R.drawable.goat)
							})),					
						2  // correct answer
						),	
				new QuestionEntity(
						"Which number is one?", 
						"numbers",
						new ArrayList<AnswerEntity>(Arrays.asList(new AnswerEntity[] {
								new AnswerEntity("One", R.drawable.one),
								new AnswerEntity("Nine", R.drawable.nine),
								new AnswerEntity("Eight", R.drawable.eight)
							})),					
						0  // correct answer
						),
				new QuestionEntity(
						"Which number is three?", 
						"numbers",
						new ArrayList<AnswerEntity>(Arrays.asList(new AnswerEntity[] {
								new AnswerEntity("Seven", R.drawable.seven),
								new AnswerEntity("Three", R.drawable.three),
								new AnswerEntity("One", R.drawable.one)
							})),					
						1  // correct answer
						),
				new QuestionEntity(
						"Which color is red?", 
						"colors",
						new ArrayList<AnswerEntity>(Arrays.asList(new AnswerEntity[] {
								new AnswerEntity("Red", R.drawable.red),
								new AnswerEntity("Blue", R.drawable.blue),
								new AnswerEntity("Yellow", R.drawable.yellow)
							})),					
						0  // correct answer
						),
				new QuestionEntity(
						"Which color is yellow?", 
						"colors",
						new ArrayList<AnswerEntity>(Arrays.asList(new AnswerEntity[] {
								new AnswerEntity("White", R.drawable.white),
								new AnswerEntity("Black", R.drawable.black),
								new AnswerEntity("Yellow", R.drawable.yellow)
							})),					
						2  // correct answer
						),
				new QuestionEntity(
						"Which letter is B?", 
						"letters",
						new ArrayList<AnswerEntity>(Arrays.asList(new AnswerEntity[] {
								new AnswerEntity("A", R.drawable.a),
								new AnswerEntity("B", R.drawable.b),
								new AnswerEntity("D", R.drawable.d)
							})),					
						1  // correct answer
						),
				new QuestionEntity(
						"Which letter is K?", 
						"letters",
						new ArrayList<AnswerEntity>(Arrays.asList(new AnswerEntity[] {
								new AnswerEntity("K", R.drawable.k),
								new AnswerEntity("Z", R.drawable.z),
								new AnswerEntity("U", R.drawable.u)
							})),					
						0  // correct answer
						),
						

				
		}));
	}
}
