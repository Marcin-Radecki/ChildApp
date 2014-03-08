package sdm.application.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sdm.application.childapp.R;

public class QuestionEntity extends Entity {
	private int question;
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
	
	public int getQuestion() {

		return this.question;
	}					

	public QuestionEntity(int question, String type,
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
								R.string.camelQuestion,
								"animals",
								new ArrayList<AnswerEntity>(
										Arrays.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.camel,
														R.drawable.camel),
												new AnswerEntity(R.string.lion,
														R.drawable.lion),
												new AnswerEntity(R.string.crocodile,
														R.drawable.crocodile) })),
								0 // correct answer
						),
						new QuestionEntity(R.string.catQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.dog,
														R.drawable.dog),
												new AnswerEntity(R.string.donkey,
														R.drawable.donkey),
												new AnswerEntity(R.string.cat,
														R.drawable.cat) })), 2 // correct
																				// answer
						),
						new QuestionEntity(R.string.cowQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.elephant,
														R.drawable.elephant),
												new AnswerEntity(R.string.cow,
														R.drawable.cow),
												new AnswerEntity(R.string.cat,
														R.drawable.cat) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.crocodileQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.giraffe,
														R.drawable.giraffe),
												new AnswerEntity(R.string.crocodile,
														R.drawable.crocodile),
												new AnswerEntity(R.string.mouse,
														R.drawable.mouse) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.dogQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.dog,
														R.drawable.dog),
												new AnswerEntity(R.string.lion,
														R.drawable.lion),
												new AnswerEntity(R.string.hippo,
														R.drawable.hippo) })), 0 // correct
																				// answer
						),
						new QuestionEntity(R.string.donkeyQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.elephant,
														R.drawable.elephant),
												new AnswerEntity(R.string.monkey,
														R.drawable.monkey),
												new AnswerEntity(R.string.donkey,
														R.drawable.donkey) })), 2 // correct
																				// answer
						),
						new QuestionEntity(R.string.elephantQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.elephant,
														R.drawable.elephant),
												new AnswerEntity(R.string.pig,
														R.drawable.pig),
												new AnswerEntity(R.string.goat,
														R.drawable.goat) })), 0 // correct
																				// answer
						),
						new QuestionEntity(R.string.giraffeQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.mouse,
														R.drawable.mouse),
												new AnswerEntity(R.string.giraffe,
														R.drawable.giraffe),
												new AnswerEntity(R.string.dog,
														R.drawable.dog) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.goatQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.sheep,
														R.drawable.sheep),
												new AnswerEntity(R.string.goat,
														R.drawable.goat),
												new AnswerEntity(R.string.monkey,
														R.drawable.monkey) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.hippoQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.tortoise,
														R.drawable.tortoise),
												new AnswerEntity(R.string.hippo,
														R.drawable.hippo),
												new AnswerEntity(R.string.rabbit,
														R.drawable.rabbit) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.lionQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.lion,
														R.drawable.lion),
												new AnswerEntity(R.string.rhino,
														R.drawable.rhino),
												new AnswerEntity(R.string.giraffe,
														R.drawable.giraffe) })), 0 // correct
																				// answer
						),
						new QuestionEntity(R.string.monkeyQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.elephant,
														R.drawable.elephant),
												new AnswerEntity(R.string.pig,
														R.drawable.pig),
												new AnswerEntity(R.string.monkey,
														R.drawable.monkey) })), 2 // correct
																				// answer
						),
						new QuestionEntity(R.string.mouseQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.dog,
														R.drawable.dog),
												new AnswerEntity(R.string.mouse,
														R.drawable.mouse),
												new AnswerEntity(R.string.cat,
														R.drawable.cat) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.pigQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.pig,
														R.drawable.pig),
												new AnswerEntity(R.string.sheep,
														R.drawable.sheep),
												new AnswerEntity(R.string.camel,
														R.drawable.camel) })), 0 // correct
																				// answer
						),
						new QuestionEntity(R.string.rabbitQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.crocodile,
														R.drawable.crocodile),
												new AnswerEntity(R.string.cow,
														R.drawable.cow),
												new AnswerEntity(R.string.rabbit,
														R.drawable.rabbit) })), 2 // correct
																				// answer
						),
						new QuestionEntity(R.string.rhinoQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.hippo,
														R.drawable.hippo),
												new AnswerEntity(R.string.rhino,
														R.drawable.rhino),
												new AnswerEntity(R.string.crocodile,
														R.drawable.crocodile) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.sheepQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.sheep,
														R.drawable.sheep),
												new AnswerEntity(R.string.tortoise,
														R.drawable.tortoise),
												new AnswerEntity(R.string.monkey,
														R.drawable.monkey) })), 0 // correct
																				// answer
						),
						new QuestionEntity(R.string.tortoiseQuestion, "animals",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.elephant,
														R.drawable.elephant),
												new AnswerEntity(R.string.donkey,
														R.drawable.donkey),
												new AnswerEntity(R.string.tortoise,
														R.drawable.tortoise) })), 2 // correct
																				// answer
						),
						new QuestionEntity(R.string.zeroQuestion, "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.eight,
														R.drawable.eight),
												new AnswerEntity(R.string.zero,
														R.drawable.zero),
												new AnswerEntity(R.string.seven,
														R.drawable.seven) })),
								1 // correct answer
						),
						new QuestionEntity(R.string.oneQuestion, "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.one,
														R.drawable.one),
												new AnswerEntity(R.string.nine,
														R.drawable.nine),
												new AnswerEntity(R.string.eight,
														R.drawable.eight) })),
								0 // correct answer
						),
						new QuestionEntity(R.string.twoQuestion, "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.zero,
														R.drawable.zero),
												new AnswerEntity(R.string.six,
														R.drawable.six),
												new AnswerEntity(R.string.two,
														R.drawable.two) })),
								2 // correct answer
						),
						new QuestionEntity(R.string.threeQuestion, "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.seven,
														R.drawable.seven),
												new AnswerEntity(R.string.three,
														R.drawable.three),
												new AnswerEntity(R.string.one,
														R.drawable.one) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.fourQuestion, "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.four,
														R.drawable.four),
												new AnswerEntity(R.string.two,
														R.drawable.two),
												new AnswerEntity(R.string.five,
														R.drawable.five) })),
								0 // correct answer
						),
						new QuestionEntity(R.string.fiveQuestion, "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.seven,
														R.drawable.seven),
												new AnswerEntity(R.string.eight,
														R.drawable.eight),
												new AnswerEntity(R.string.five,
														R.drawable.five) })),
								2 // correct answer
						),
						new QuestionEntity(R.string.sixQuestion, "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.three,
														R.drawable.three),
												new AnswerEntity(R.string.six,
														R.drawable.six),
												new AnswerEntity(R.string.nine,
														R.drawable.nine) })),
								1 // correct answer
						),
						new QuestionEntity(R.string.sevenQuestion, "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.seven,
														R.drawable.seven),
												new AnswerEntity(R.string.four,
														R.drawable.four),
												new AnswerEntity(R.string.zero,
														R.drawable.zero) })),
								0 // correct answer
						),
						new QuestionEntity(R.string.eightQuestion, "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.two,
														R.drawable.two),
												new AnswerEntity(R.string.one,
														R.drawable.one),
												new AnswerEntity(R.string.eight,
														R.drawable.eight) })),
								2 // correct answer
						),
						new QuestionEntity(R.string.nineQuestion, "numbers",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.five,
														R.drawable.five),
												new AnswerEntity(R.string.nine,
														R.drawable.nine),
												new AnswerEntity(R.string.six,
														R.drawable.six) })),
								1 // correct answer
						),
						new QuestionEntity(R.string.blackQuestion, "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.black,
														R.drawable.black),
												new AnswerEntity(R.string.yellow,
														R.drawable.yellow),
												new AnswerEntity(R.string.blue,
														R.drawable.blue) })),
								0 // correct answer
						),
						new QuestionEntity(R.string.blueQuestion, "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.white,
														R.drawable.white),
												new AnswerEntity(R.string.blue,
														R.drawable.blue),
												new AnswerEntity(R.string.red,
														R.drawable.red) })),
								1 // correct answer
						),
						new QuestionEntity(R.string.brownQuestion, "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.green,
														R.drawable.green),
												new AnswerEntity(R.string.pink,
														R.drawable.pink),
												new AnswerEntity(R.string.brown,
														R.drawable.brown) })),
								2 // correct answer
						),
						new QuestionEntity(R.string.grayQuestion, "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.gray,
														R.drawable.gray),
												new AnswerEntity(R.string.orange,
														R.drawable.orange),
												new AnswerEntity(R.string.purple,
														R.drawable.purple) })),
								0 // correct answer
						),
						new QuestionEntity(R.string.greenQuestion, "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.blue,
														R.drawable.blue),
												new AnswerEntity(R.string.green,
														R.drawable.green),
												new AnswerEntity(R.string.pink,
														R.drawable.pink) })),
								1 // correct answer
						),
						new QuestionEntity(R.string.orangeQuestion, "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.yellow,
														R.drawable.yellow),
												new AnswerEntity(R.string.gray,
														R.drawable.gray),
												new AnswerEntity(R.string.orange,
														R.drawable.orange) })),
								2 // correct answer
						),
						new QuestionEntity(R.string.pinkQuestion, "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.pink,
														R.drawable.pink),
												new AnswerEntity(R.string.white,
														R.drawable.white),
												new AnswerEntity(R.string.brown,
														R.drawable.brown) })),
								0 // correct answer
						),
						new QuestionEntity(R.string.purpleQuestion, "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.red,
														R.drawable.red),
												new AnswerEntity(R.string.purple,
														R.drawable.purple),
												new AnswerEntity(R.string.black,
														R.drawable.black) })),
								1 // correct answer
						),
						new QuestionEntity(R.string.redQuestion, "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.white,
														R.drawable.white),
												new AnswerEntity(R.string.purple,
														R.drawable.purple),
												new AnswerEntity(R.string.red,
														R.drawable.red) })),
								2 // correct answer
						),
						new QuestionEntity(R.string.whiteQuestion, "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.white,
														R.drawable.white),
												new AnswerEntity(R.string.green,
														R.drawable.green),
												new AnswerEntity(R.string.black,
														R.drawable.black) })),
								0 // correct answer
						),
						new QuestionEntity(R.string.yellowQuestion, "colors",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.red,
														R.drawable.red),
												new AnswerEntity(R.string.yellow,
														R.drawable.yellow),
												new AnswerEntity(R.string.purple,
														R.drawable.purple) })),
								1 // correct answer
						),
						new QuestionEntity(R.string.aQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.a,
														R.drawable.a),
												new AnswerEntity(R.string.f,
														R.drawable.f),
												new AnswerEntity(R.string.r,
														R.drawable.r) })), 0 // correct
																				// answer
						),
						new QuestionEntity(R.string.bQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.e,
														R.drawable.e),
												new AnswerEntity(R.string.b,
														R.drawable.b),
												new AnswerEntity(R.string.z,
														R.drawable.z) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.cQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.y,
														R.drawable.y),
												new AnswerEntity(R.string.m,
														R.drawable.m),
												new AnswerEntity(R.string.c,
														R.drawable.c) })), 2 // correct
																				// answer
						),
						new QuestionEntity(R.string.dQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.d,
														R.drawable.d),
												new AnswerEntity(R.string.s,
														R.drawable.s),
												new AnswerEntity(R.string.i,
														R.drawable.i) })), 0 // correct
																				// answer
						),
						new QuestionEntity(R.string.eQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.n,
														R.drawable.n),
												new AnswerEntity(R.string.e,
														R.drawable.e),
												new AnswerEntity(R.string.x,
														R.drawable.x) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.fQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.h,
														R.drawable.h),
												new AnswerEntity(R.string.q,
														R.drawable.q),
												new AnswerEntity(R.string.f,
														R.drawable.f) })), 2 // correct
																				// answer
						),
						new QuestionEntity(R.string.gQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.g,
														R.drawable.g),
												new AnswerEntity(R.string.u,
														R.drawable.u),
												new AnswerEntity(R.string.p,
														R.drawable.p) })), 0 // correct
																				// answer
						),
						new QuestionEntity(R.string.hQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.a,
														R.drawable.a),
												new AnswerEntity(R.string.h,
														R.drawable.h),
												new AnswerEntity(R.string.d,
														R.drawable.d) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.iQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.t,
														R.drawable.t),
												new AnswerEntity(R.string.k,
														R.drawable.k),
												new AnswerEntity(R.string.i,
														R.drawable.i) })), 2 // correct
																				// answer
						),
						new QuestionEntity(R.string.jQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.j,
														R.drawable.j),
												new AnswerEntity(R.string.n,
														R.drawable.n),
												new AnswerEntity(R.string.o,
														R.drawable.o) })), 0 // correct
																				// answer
						),
						new QuestionEntity(R.string.kQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.b,
														R.drawable.b),
												new AnswerEntity(R.string.k,
														R.drawable.k),
												new AnswerEntity(R.string.r,
														R.drawable.r) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.lQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.w,
														R.drawable.w),
												new AnswerEntity(R.string.q,
														R.drawable.q),
												new AnswerEntity(R.string.l,
														R.drawable.l) })), 2 // correct
																				// answer
						),
						new QuestionEntity(R.string.mQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.m,
														R.drawable.m),
												new AnswerEntity(R.string.e,
														R.drawable.e),
												new AnswerEntity(R.string.t,
														R.drawable.t) })), 0 // correct
																				// answer
						),
						new QuestionEntity(R.string.nQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.d,
														R.drawable.d),
												new AnswerEntity(R.string.n,
														R.drawable.n),
												new AnswerEntity(R.string.g,
														R.drawable.g) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.oQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.z,
														R.drawable.z),
												new AnswerEntity(R.string.i,
														R.drawable.i),
												new AnswerEntity(R.string.o,
														R.drawable.o) })), 2 // correct
																				// answer
						),
						new QuestionEntity(R.string.pQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.p,
														R.drawable.p),
												new AnswerEntity(R.string.s,
														R.drawable.s),
												new AnswerEntity(R.string.l,
														R.drawable.l) })), 0 // correct
																				// answer
						),
						new QuestionEntity(R.string.qQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.u,
														R.drawable.u),
												new AnswerEntity(R.string.q,
														R.drawable.q),
												new AnswerEntity(R.string.y,
														R.drawable.y) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.rQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.f,
														R.drawable.f),
												new AnswerEntity(R.string.h,
														R.drawable.h),
												new AnswerEntity(R.string.r,
														R.drawable.r) })), 2 // correct
																				// answer
						),
						new QuestionEntity(R.string.sQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.s,
														R.drawable.s),
												new AnswerEntity(R.string.n,
														R.drawable.n),
												new AnswerEntity(R.string.x,
														R.drawable.x) })), 0 // correct
																				// answer
						),
						new QuestionEntity(R.string.tQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.c,
														R.drawable.c),
												new AnswerEntity(R.string.t,
														R.drawable.t),
												new AnswerEntity(R.string.m,
														R.drawable.m) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.uQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.g,
														R.drawable.g),
												new AnswerEntity(R.string.k,
														R.drawable.k),
												new AnswerEntity(R.string.u,
														R.drawable.u) })), 2 // correct
																				// answer
						),
						new QuestionEntity(R.string.vQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.v,
														R.drawable.v),
												new AnswerEntity(R.string.a,
														R.drawable.a),
												new AnswerEntity(R.string.a,
														R.drawable.p) })), 0 // correct
																				// answer
						),
						new QuestionEntity(R.string.wQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.r,
														R.drawable.r),
												new AnswerEntity(R.string.w,
														R.drawable.w),
												new AnswerEntity(R.string.v,
														R.drawable.v) })), 1 // correct
																				// answer
						),
						new QuestionEntity(R.string.xQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.b,
														R.drawable.b),
												new AnswerEntity(R.string.f,
														R.drawable.f),
												new AnswerEntity(R.string.x,
														R.drawable.x) })), 2 // correct
																				// answer
						),
						new QuestionEntity(R.string.yQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.y,
														R.drawable.y),
												new AnswerEntity(R.string.m,
														R.drawable.m),
												new AnswerEntity(R.string.l,
														R.drawable.l) })), 0 // correct
																				// answer
						),
						new QuestionEntity(R.string.zQuestion, "letters",
								new ArrayList<AnswerEntity>(Arrays
										.asList(new AnswerEntity[] {
												new AnswerEntity(R.string.q,
														R.drawable.q),
												new AnswerEntity(R.string.z,
														R.drawable.z),
												new AnswerEntity(R.string.o,
														R.drawable.o) })), 1 // correct
																				// answer
						),

				}));

	}
}
