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
<<<<<<< HEAD

	public int getAnswer() {
		return trueAnswer;
	}

	public ArrayList<AnswerEntity> getAnswers() {
		return answers;
	}

	public String getQuestionType() {
		return this.type;
	}
=======
	
	public int getAnswer() {
		return trueAnswer;
	}
>>>>>>> d50c07cc0266843d819ac474050f06d72342984d

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
						

<<<<<<< HEAD
	public QuestionEntity(String question, String type,
			ArrayList<AnswerEntity> answers, int answer) {
		super();
		this.question = question;
		this.type = type;
		this.answers = answers;
		this.trueAnswer = answer;
	}

	public static List<QuestionEntity> CreateQuestions() {
		return new ArrayList<QuestionEntity>(
				Arrays.asList(new QuestionEntity[] {
						new QuestionEntity(
								"What is the camel?",
								"animals",
								new ArrayList<AnswerEntity>(
										Arrays.asList(new AnswerEntity[] {
												new AnswerEntity("Camel",
														R.drawable.camel),
												new AnswerEntity("Lion",
														R.drawable.lion),
												new AnswerEntity("Crocodile",
														R.drawable.crocodile) })),
								0 // correct answer
						),
						new QuestionEntity("What is the cat?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Dog",
														R.drawable.dog),
												new AnswerEntity("Donkey",
														R.drawable.donkey),
												new AnswerEntity("Cat",
														R.drawable.cat) })), 2 // correct
																				// answer
						),
						new QuestionEntity("What is the cow?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Elephant",
														R.drawable.elephant),
												new AnswerEntity("Cow",
														R.drawable.cow),
												new AnswerEntity("Cat",
														R.drawable.cat) })), 1 // correct
																				// answer
						),
						new QuestionEntity("What is the crocodile?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Giraffe",
														R.drawable.giraffe),
												new AnswerEntity("Crocodile",
														R.drawable.crocodile),
												new AnswerEntity("Mouse",
														R.drawable.mouse) })), 1 // correct
																				// answer
						),
						new QuestionEntity("What is the dog?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Dog",
														R.drawable.dog),
												new AnswerEntity("Lion",
														R.drawable.lion),
												new AnswerEntity("Hippo",
														R.drawable.hippo) })), 0 // correct
																				// answer
						),
						new QuestionEntity("What is the donkey?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Elephant",
														R.drawable.elephant),
												new AnswerEntity("Monkey",
														R.drawable.monkey),
												new AnswerEntity("Donkey",
														R.drawable.donkey) })), 2 // correct
																				// answer
						),
						new QuestionEntity("What is the elephant?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Elephant",
														R.drawable.elephant),
												new AnswerEntity("Pig",
														R.drawable.pig),
												new AnswerEntity("Goat",
														R.drawable.goat) })), 0 // correct
																				// answer
						),
						new QuestionEntity("What is the giraffe?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Mouse",
														R.drawable.mouse),
												new AnswerEntity("Giraffe",
														R.drawable.giraffe),
												new AnswerEntity("Dog",
														R.drawable.dog) })), 1 // correct
																				// answer
						),
						new QuestionEntity("What is the goat?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Sheep",
														R.drawable.sheep),
												new AnswerEntity("Goat",
														R.drawable.goat),
												new AnswerEntity("Monkey",
														R.drawable.monkey) })), 1 // correct
																				// answer
						),
						new QuestionEntity("What is the hippo?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Tortoise",
														R.drawable.tortoise),
												new AnswerEntity("Hippo",
														R.drawable.hippo),
												new AnswerEntity("Rabbit",
														R.drawable.rabbit) })), 1 // correct
																				// answer
						),
						new QuestionEntity("What is the lion?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Lion",
														R.drawable.lion),
												new AnswerEntity("Rhino",
														R.drawable.rhino),
												new AnswerEntity("Giraffe",
														R.drawable.giraffe) })), 0 // correct
																				// answer
						),
						new QuestionEntity("What is the monkey?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Elephant",
														R.drawable.elephant),
												new AnswerEntity("Pig",
														R.drawable.pig),
												new AnswerEntity("Monkey",
														R.drawable.monkey) })), 2 // correct
																				// answer
						),
						new QuestionEntity("What is the mouse?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Dog",
														R.drawable.dog),
												new AnswerEntity("Mouse",
														R.drawable.mouse),
												new AnswerEntity("Cat",
														R.drawable.cat) })), 1 // correct
																				// answer
						),
						new QuestionEntity("What is the pig?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Pig",
														R.drawable.pig),
												new AnswerEntity("Sheep",
														R.drawable.sheep),
												new AnswerEntity("Camel",
														R.drawable.camel) })), 0 // correct
																				// answer
						),
						new QuestionEntity("What is the rabbit?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Crocodile",
														R.drawable.crocodile),
												new AnswerEntity("Cow",
														R.drawable.cow),
												new AnswerEntity("Rabbit",
														R.drawable.rabbit) })), 2 // correct
																				// answer
						),
						new QuestionEntity("What is the rhino?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Hippo",
														R.drawable.hippo),
												new AnswerEntity("Rhino",
														R.drawable.rhino),
												new AnswerEntity("Crocodile",
														R.drawable.crocodile) })), 1 // correct
																				// answer
						),
						new QuestionEntity("What is the sheep?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Shepp",
														R.drawable.sheep),
												new AnswerEntity("Tortoise",
														R.drawable.tortoise),
												new AnswerEntity("Monkey",
														R.drawable.monkey) })), 0 // correct
																				// answer
						),
						new QuestionEntity("What is the tortoise?", "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Elephant",
														R.drawable.elephant),
												new AnswerEntity("Donkey",
														R.drawable.donkey),
												new AnswerEntity("Tortoise",
														R.drawable.tortoise) })), 2 // correct
																				// answer
						),
						new QuestionEntity("Which number is zero?", "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Eight",
														R.drawable.eight),
												new AnswerEntity("Zero",
														R.drawable.zero),
												new AnswerEntity("Seven",
														R.drawable.seven) })),
								1 // correct answer
						),
						new QuestionEntity("Which number is one?", "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("One",
														R.drawable.one),
												new AnswerEntity("Nine",
														R.drawable.nine),
												new AnswerEntity("Eight",
														R.drawable.eight) })),
								0 // correct answer
						),
						new QuestionEntity("Which number is two?", "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Zero",
														R.drawable.zero),
												new AnswerEntity("Six",
														R.drawable.six),
												new AnswerEntity("Two",
														R.drawable.two) })),
								2 // correct answer
						),
						new QuestionEntity("Which number is three?", "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Seven",
														R.drawable.seven),
												new AnswerEntity("Three",
														R.drawable.three),
												new AnswerEntity("One",
														R.drawable.one) })), 1 // correct
																				// answer
						),
						new QuestionEntity("Which number is four?", "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Four",
														R.drawable.four),
												new AnswerEntity("Two",
														R.drawable.two),
												new AnswerEntity("Five",
														R.drawable.five) })),
								0 // correct answer
						),
						new QuestionEntity("Which number is five?", "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Seven",
														R.drawable.seven),
												new AnswerEntity("Eight",
														R.drawable.eight),
												new AnswerEntity("Five",
														R.drawable.five) })),
								2 // correct answer
						),
						new QuestionEntity("Which number is six?", "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Three",
														R.drawable.three),
												new AnswerEntity("Six",
														R.drawable.six),
												new AnswerEntity("Nine",
														R.drawable.nine) })),
								1 // correct answer
						),
						new QuestionEntity("Which number is seven?", "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Seven",
														R.drawable.seven),
												new AnswerEntity("Four",
														R.drawable.four),
												new AnswerEntity("Zero",
														R.drawable.zero) })),
								0 // correct answer
						),
						new QuestionEntity("Which number is eight?", "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Two",
														R.drawable.two),
												new AnswerEntity("One",
														R.drawable.one),
												new AnswerEntity("Eight",
														R.drawable.eight) })),
								2 // correct answer
						),
						new QuestionEntity("Which number is nine?", "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Five",
														R.drawable.five),
												new AnswerEntity("Nine",
														R.drawable.nine),
												new AnswerEntity("Six",
														R.drawable.six) })),
								1 // correct answer
						),
						new QuestionEntity("Which color is black?", "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Black",
														R.drawable.black),
												new AnswerEntity("Yellow",
														R.drawable.yellow),
												new AnswerEntity("Blue",
														R.drawable.blue) })),
								0 // correct answer
						),
						new QuestionEntity("Which color is blue?", "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("White",
														R.drawable.white),
												new AnswerEntity("Blue",
														R.drawable.blue),
												new AnswerEntity("Red",
														R.drawable.red) })),
								1 // correct answer
						),
						new QuestionEntity("Which color is brown?", "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Green",
														R.drawable.green),
												new AnswerEntity("Pink",
														R.drawable.pink),
												new AnswerEntity("Brown",
														R.drawable.brown) })),
								2 // correct answer
						),
						new QuestionEntity("Which color is gray?", "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Gray",
														R.drawable.gray),
												new AnswerEntity("Orange",
														R.drawable.orange),
												new AnswerEntity("Purple",
														R.drawable.purple) })),
								0 // correct answer
						),
						new QuestionEntity("Which color is green?", "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Blue",
														R.drawable.blue),
												new AnswerEntity("Green",
														R.drawable.green),
												new AnswerEntity("Pink",
														R.drawable.pink) })),
								1 // correct answer
						),
						new QuestionEntity("Which color is orange?", "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Yellow",
														R.drawable.yellow),
												new AnswerEntity("Gray",
														R.drawable.gray),
												new AnswerEntity("Orange",
														R.drawable.orange) })),
								2 // correct answer
						),
						new QuestionEntity("Which color is pink?", "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Pink",
														R.drawable.pink),
												new AnswerEntity("White",
														R.drawable.white),
												new AnswerEntity("Brown",
														R.drawable.brown) })),
								0 // correct answer
						),
						new QuestionEntity("Which color is purple?", "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Red",
														R.drawable.red),
												new AnswerEntity("Purple",
														R.drawable.purple),
												new AnswerEntity("Black",
														R.drawable.black) })),
								1 // correct answer
						),
						new QuestionEntity("Which color is red?", "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("White",
														R.drawable.white),
												new AnswerEntity("Purple",
														R.drawable.purple),
												new AnswerEntity("Red",
														R.drawable.red) })),
								2 // correct answer
						),
						new QuestionEntity("Which color is white?", "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("White",
														R.drawable.white),
												new AnswerEntity("Green",
														R.drawable.green),
												new AnswerEntity("Black",
														R.drawable.black) })),
								0 // correct answer
						),
						new QuestionEntity("Which color is yellow?", "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Red",
														R.drawable.red),
												new AnswerEntity("Yellow",
														R.drawable.yellow),
												new AnswerEntity("Purple",
														R.drawable.purple) })),
								1 // correct answer
						),
						new QuestionEntity("Which letter is a?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("A",
														R.drawable.a),
												new AnswerEntity("F",
														R.drawable.f),
												new AnswerEntity("R",
														R.drawable.r) })), 0 // correct
																				// answer
						),
						new QuestionEntity("Which letter is b?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("E",
														R.drawable.e),
												new AnswerEntity("B",
														R.drawable.b),
												new AnswerEntity("Z",
														R.drawable.z) })), 1 // correct
																				// answer
						),
						new QuestionEntity("Which letter is c?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Y",
														R.drawable.y),
												new AnswerEntity("M",
														R.drawable.m),
												new AnswerEntity("C",
														R.drawable.c) })), 2 // correct
																				// answer
						),
						new QuestionEntity("Which letter is d?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("D",
														R.drawable.d),
												new AnswerEntity("S",
														R.drawable.s),
												new AnswerEntity("I",
														R.drawable.i) })), 0 // correct
																				// answer
						),
						new QuestionEntity("Which letter is e?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("N",
														R.drawable.n),
												new AnswerEntity("E",
														R.drawable.e),
												new AnswerEntity("X",
														R.drawable.x) })), 1 // correct
																				// answer
						),
						new QuestionEntity("Which letter is f?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("H",
														R.drawable.h),
												new AnswerEntity("Q",
														R.drawable.q),
												new AnswerEntity("F",
														R.drawable.f) })), 2 // correct
																				// answer
						),
						new QuestionEntity("Which letter is g?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("G",
														R.drawable.g),
												new AnswerEntity("U",
														R.drawable.u),
												new AnswerEntity("P",
														R.drawable.p) })), 0 // correct
																				// answer
						),
						new QuestionEntity("Which letter is h?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("A",
														R.drawable.a),
												new AnswerEntity("H",
														R.drawable.h),
												new AnswerEntity("D",
														R.drawable.d) })), 1 // correct
																				// answer
						),
						new QuestionEntity("Which letter is i?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("T",
														R.drawable.t),
												new AnswerEntity("K",
														R.drawable.k),
												new AnswerEntity("I",
														R.drawable.i) })), 2 // correct
																				// answer
						),
						new QuestionEntity("Which letter is j?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("J",
														R.drawable.j),
												new AnswerEntity("N",
														R.drawable.n),
												new AnswerEntity("O",
														R.drawable.o) })), 0 // correct
																				// answer
						),
						new QuestionEntity("Which letter is k?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("B",
														R.drawable.b),
												new AnswerEntity("K",
														R.drawable.k),
												new AnswerEntity("R",
														R.drawable.r) })), 1 // correct
																				// answer
						),
						new QuestionEntity("Which letter is l?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("W",
														R.drawable.w),
												new AnswerEntity("Q",
														R.drawable.q),
												new AnswerEntity("L",
														R.drawable.l) })), 2 // correct
																				// answer
						),
						new QuestionEntity("Which letter is m?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("M",
														R.drawable.m),
												new AnswerEntity("E",
														R.drawable.e),
												new AnswerEntity("T",
														R.drawable.t) })), 0 // correct
																				// answer
						),
						new QuestionEntity("Which letter is n?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("D",
														R.drawable.d),
												new AnswerEntity("N",
														R.drawable.n),
												new AnswerEntity("G",
														R.drawable.g) })), 1 // correct
																				// answer
						),
						new QuestionEntity("Which letter is o?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Z",
														R.drawable.z),
												new AnswerEntity("I",
														R.drawable.i),
												new AnswerEntity("O",
														R.drawable.o) })), 2 // correct
																				// answer
						),
						new QuestionEntity("Which letter is p?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("P",
														R.drawable.p),
												new AnswerEntity("S",
														R.drawable.s),
												new AnswerEntity("L",
														R.drawable.l) })), 0 // correct
																				// answer
						),
						new QuestionEntity("Which letter is q?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("U",
														R.drawable.u),
												new AnswerEntity("Q",
														R.drawable.q),
												new AnswerEntity("Y",
														R.drawable.y) })), 1 // correct
																				// answer
						),
						new QuestionEntity("Which letter is r?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("F",
														R.drawable.f),
												new AnswerEntity("H",
														R.drawable.h),
												new AnswerEntity("R",
														R.drawable.r) })), 2 // correct
																				// answer
						),
						new QuestionEntity("Which letter is s?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("S",
														R.drawable.s),
												new AnswerEntity("N",
														R.drawable.n),
												new AnswerEntity("X",
														R.drawable.x) })), 0 // correct
																				// answer
						),
						new QuestionEntity("Which letter is t?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("C",
														R.drawable.c),
												new AnswerEntity("T",
														R.drawable.t),
												new AnswerEntity("M",
														R.drawable.m) })), 1 // correct
																				// answer
						),
						new QuestionEntity("Which letter is u?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("G",
														R.drawable.g),
												new AnswerEntity("K",
														R.drawable.k),
												new AnswerEntity("U",
														R.drawable.u) })), 2 // correct
																				// answer
						),
						new QuestionEntity("Which letter is v?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("V",
														R.drawable.v),
												new AnswerEntity("A",
														R.drawable.a),
												new AnswerEntity("P",
														R.drawable.p) })), 0 // correct
																				// answer
						),
						new QuestionEntity("Which letter is w?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("R",
														R.drawable.r),
												new AnswerEntity("W",
														R.drawable.w),
												new AnswerEntity("V",
														R.drawable.v) })), 1 // correct
																				// answer
						),
						new QuestionEntity("Which letter is x?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("B",
														R.drawable.b),
												new AnswerEntity("F",
														R.drawable.f),
												new AnswerEntity("X",
														R.drawable.x) })), 2 // correct
																				// answer
						),
						new QuestionEntity("Which letter is y?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Y",
														R.drawable.y),
												new AnswerEntity("M",
														R.drawable.m),
												new AnswerEntity("L",
														R.drawable.l) })), 0 // correct
																				// answer
						),
						new QuestionEntity("Which letter is z?", "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity("Q",
														R.drawable.q),
												new AnswerEntity("Z",
														R.drawable.z),
												new AnswerEntity("O",
														R.drawable.o) })), 1 // correct
																				// answer
						),

				}));
=======
				
		}));
>>>>>>> d50c07cc0266843d819ac474050f06d72342984d
	}
}
