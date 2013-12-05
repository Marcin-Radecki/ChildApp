package com.example.childapp;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
=======
import java.util.Date;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
>>>>>>> d50c07cc0266843d819ac474050f06d72342984d
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.db.DAO;
import com.example.entity.QuestionEntity;

<<<<<<< HEAD
public class QuestionsActivity extends Activity implements OnInitListener {
=======
public class QuestionsActivity extends Activity {
>>>>>>> d50c07cc0266843d819ac474050f06d72342984d

	TextView question, score;
	Button answer1, answer2, answer3;
<<<<<<< HEAD
	QuestionEntity qe;
	Dialog answerDialog, scoreDialog;
	TextToSpeech tts;
	private DAO dao;
	private Random random = new Random();
	private ArrayList<QuestionEntity> questions = new ArrayList<QuestionEntity>();
	private int goodAnswer;
	private int questionsNum;
	private int restAttempts;
	private int points;
=======
	private DAO dao;
	private Random random = new Random(new Date().getTime());
>>>>>>> d50c07cc0266843d819ac474050f06d72342984d

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_questions);

<<<<<<< HEAD
		gameAudio.play(getApplicationContext(), R.raw.funny_loop);

		// get all questions from database
		dao = new DAO(this);
		ArrayList<QuestionEntity> questionsAll = (ArrayList<QuestionEntity>) dao
				.getQuestions();
		// pick only questions with given category
		String category = getIntent().getStringExtra(
				CategoriesActivity.CATEGORY_NAME);
		for (int i = 0; i < questionsAll.size(); i++) {
=======
		// get all questions from database
		dao = new DAO(this);
		ArrayList<QuestionEntity> questionsAll = (ArrayList<QuestionEntity>)dao.getQuestions();
		// pick only questions with given category
		String category = getIntent().getStringExtra(CategoriesActivity.CATEGORY_NAME);
		ArrayList<QuestionEntity> questions = new ArrayList<QuestionEntity>();
		for(int i = 0;i < questionsAll.size();i++) {
>>>>>>> d50c07cc0266843d819ac474050f06d72342984d
			QuestionEntity q = questionsAll.get(i);
			if (q.getQuestionType().equals(category))
				questions.add(q);
		}
<<<<<<< HEAD
		// catch the max number of questions
		questionsNum = Integer.parseInt(getIntent().getStringExtra(
				CategoriesActivity.QUESTIONS_NUMBER));

=======
		// pick random question
		int questionNumber = random.nextInt(questions.size());
		QuestionEntity qe = questions.get(questionNumber);
		
>>>>>>> d50c07cc0266843d819ac474050f06d72342984d
		question = (TextView) findViewById(R.id.questionTextView);
		Typeface font = Typeface.createFromAsset(getAssets(), "children_one.otf");
		question.setTypeface(font);
		score = (TextView) findViewById(R.id.textScore);
		font = Typeface.createFromAsset(getAssets(), "scoreboard.ttf");
		score.setTypeface(font);
		answer1 = (Button) findViewById(R.id.answer1Button);
		answer2 = (Button) findViewById(R.id.answer2Button);
		answer3 = (Button) findViewById(R.id.answer3Button);
<<<<<<< HEAD
		tts = new TextToSpeech(this, this);

		// restart score
		points = 00;
		score.setText(getString(R.string.score) + String.valueOf(points));

		// pick random question
		goodAnswer = nextQuestion();
=======
		

		question.setText(qe.getQuestion());
		Drawable d = this.getResources().getDrawable(qe.getAnswers().get(0).getImagePathId());
		answer1.setBackground(d);
	    d = this.getResources().getDrawable(qe.getAnswers().get(1).getImagePathId());
		answer2.setBackground(d);
	    d = this.getResources().getDrawable(qe.getAnswers().get(2).getImagePathId());
		answer3.setBackground(d);
>>>>>>> d50c07cc0266843d819ac474050f06d72342984d

		final int goodAnswer = qe.getAnswer();
		
		answer1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
<<<<<<< HEAD
				tts.speak(qe.getAnswers().get(0).getLabel(),
						TextToSpeech.QUEUE_ADD, null);
				if (goodAnswer == 0)
					showAnswerMessage(R.string.correct_title, R.drawable.sun,
							true);
				else
					showAnswerMessage(R.string.fail_title, R.drawable.cloud,
							false);
=======
				if (goodAnswer == 0)
					showAnswerMessage("CORRECT!", R.string.correct_msg, "OK");
				else
					showAnswerMessage("FAIL", R.string.fail_msg, "OK");
>>>>>>> d50c07cc0266843d819ac474050f06d72342984d
			}
		});

		answer2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
<<<<<<< HEAD
				tts.speak(qe.getAnswers().get(1).getLabel(),
						TextToSpeech.QUEUE_ADD, null);
				if (goodAnswer == 1)
					showAnswerMessage(R.string.correct_title, R.drawable.sun,
							true);
				else
					showAnswerMessage(R.string.fail_title, R.drawable.cloud,
							false);
=======
				if (goodAnswer == 1)
					showAnswerMessage("CORRECT!", R.string.correct_msg, "OK");
				else
					showAnswerMessage("FAIL", R.string.fail_msg, "OK");
>>>>>>> d50c07cc0266843d819ac474050f06d72342984d
			}
		});

		answer3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
<<<<<<< HEAD
				tts.speak(qe.getAnswers().get(2).getLabel(),
						TextToSpeech.QUEUE_ADD, null);
				if (goodAnswer == 2)
					showAnswerMessage(R.string.correct_title, R.drawable.sun,
							true);
				else
					showAnswerMessage(R.string.fail_title, R.drawable.cloud,
							false);
=======
				if (goodAnswer == 2)
					showAnswerMessage("CORRECT!", R.string.correct_msg, "OK");
				else
					showAnswerMessage("FAIL", R.string.fail_msg, "OK");
>>>>>>> d50c07cc0266843d819ac474050f06d72342984d
			}
		});

	}

	private int nextQuestion() {
		restAttempts = 2;
		int questionNumber = random.nextInt(questions.size());
		qe = questions.get(questionNumber);

		question.setText(qe.getQuestion());
		Drawable d = this.getResources().getDrawable(
				qe.getAnswers().get(0).getImagePathId());
		answer1.setBackground(d);
		d = this.getResources().getDrawable(
				qe.getAnswers().get(1).getImagePathId());
		answer2.setBackground(d);
		d = this.getResources().getDrawable(
				qe.getAnswers().get(2).getImagePathId());
		answer3.setBackground(d);

		questions.remove(questionNumber);
		questionsNum--;

		tts.speak(question.getText().toString(), TextToSpeech.QUEUE_ADD, null);

		return qe.getAnswer();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.questions, menu);
		return true;
	}

	private void showAnswerMessage(int text, int img, final boolean correct) {
		answerDialog = new Dialog(this);
		answerDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		answerDialog.setCancelable(false);
		answerDialog.setContentView(R.layout.answer_dialog);

		TextView title = (TextView) answerDialog.findViewById(R.id.answerTitle);
		Typeface font = Typeface.createFromAsset(getAssets(), "children_one.otf");
		title.setTypeface(font);
		title.setText(text);

		ImageView image = (ImageView) answerDialog
				.findViewById(R.id.answerImage);
		image.setImageResource(img);
		
		if(correct)
			gameAudio.playEfect(getApplicationContext(), R.raw.right_answer);
		else
			gameAudio.playEfect(getApplicationContext(), R.raw.wrong_answer);
		
		Button acceptButton = (Button) answerDialog.findViewById(R.id.acceptButton);
		acceptButton.setTypeface(font);
		acceptButton.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View view) {
						answerDialog.dismiss();
						if (correct) {
							points += restAttempts + 1;
							score.setText(getString(R.string.score)
									+ String.valueOf(points));
							if (questionsNum > 0)
								goodAnswer = nextQuestion();
							else {
								showScoreMessage();
							}
						} else if (restAttempts == 0) {
							if (questionsNum > 0)
								goodAnswer = nextQuestion();
							else{
								showScoreMessage();
							}
						} else {
							restAttempts--;
							tts.speak(question.getText().toString(),
									TextToSpeech.QUEUE_ADD, null);
						}

					}
				});

		answerDialog.show();
	}
	
	private void showScoreMessage() {
		scoreDialog = new Dialog(this);
		scoreDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		scoreDialog.setCancelable(false);
		scoreDialog.setContentView(R.layout.score_dialog);

		TextView score = (TextView) scoreDialog.findViewById(R.id.scoreNumber);
		Typeface font = Typeface.createFromAsset(getAssets(), "pointy.ttf");
		score.setTypeface(font);
		score.setText(String.valueOf(points));
		
		TextView title = (TextView) scoreDialog.findViewById(R.id.scoreTitle);
		font = Typeface.createFromAsset(getAssets(), "children_one.otf");
		title.setTypeface(font);
		
		Button acceptButton = (Button) scoreDialog.findViewById(R.id.acceptButton);
		acceptButton.setTypeface(font);
		acceptButton.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View view) {
						scoreDialog.dismiss();
						finish();
						gameAudio.play(getApplicationContext(),
								R.raw.upbeat_feeling);
					}
				});

		scoreDialog.show();
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub

	}

}
