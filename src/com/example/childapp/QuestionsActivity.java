package com.example.childapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.db.DAO;
import com.example.entity.QuestionEntity;

public class QuestionsActivity extends Activity {

	TextView question;
	Button answer1, answer2, answer3;
	private DAO dao;
	private Random random = new Random(new Date().getTime());

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_questions);

		// get all questions from database
		dao = new DAO(this);
		ArrayList<QuestionEntity> questionsAll = (ArrayList<QuestionEntity>)dao.getQuestions();
		// pick only questions with given category
		String category = getIntent().getStringExtra(CategoriesActivity.CATEGORY_NAME);
		ArrayList<QuestionEntity> questions = new ArrayList<QuestionEntity>();
		for(int i = 0;i < questionsAll.size();i++) {
			QuestionEntity q = questionsAll.get(i);
			if (q.getQuestionType().equals(category))
				questions.add(q);
		}
		// pick random question
		int questionNumber = random.nextInt(questions.size());
		QuestionEntity qe = questions.get(questionNumber);
		
		question = (TextView) findViewById(R.id.questionTextView);
		answer1 = (Button) findViewById(R.id.answer1Button);
		answer2 = (Button) findViewById(R.id.answer2Button);
		answer3 = (Button) findViewById(R.id.answer3Button);
		

		question.setText(qe.getQuestion());
		Drawable d = this.getResources().getDrawable(qe.getAnswers().get(0).getImagePathId());
		answer1.setBackground(d);
	    d = this.getResources().getDrawable(qe.getAnswers().get(1).getImagePathId());
		answer2.setBackground(d);
	    d = this.getResources().getDrawable(qe.getAnswers().get(2).getImagePathId());
		answer3.setBackground(d);

		final int goodAnswer = qe.getAnswer();
		
		answer1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (goodAnswer == 0)
					showAnswerMessage("CORRECT!", R.string.correct_msg, "OK");
				else
					showAnswerMessage("FAIL", R.string.fail_msg, "OK");
			}
		});

		answer2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (goodAnswer == 1)
					showAnswerMessage("CORRECT!", R.string.correct_msg, "OK");
				else
					showAnswerMessage("FAIL", R.string.fail_msg, "OK");
			}
		});

		answer3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (goodAnswer == 2)
					showAnswerMessage("CORRECT!", R.string.correct_msg, "OK");
				else
					showAnswerMessage("FAIL", R.string.fail_msg, "OK");
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.questions, menu);
		return true;
	}
	
	private void showAnswerMessage(String title, int msg, String txtButton) {
		new AlertDialog.Builder(this)
				.setTitle(title)
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setMessage(msg)
				.setNeutralButton(txtButton,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								
							}
						}).show();
	}

}
