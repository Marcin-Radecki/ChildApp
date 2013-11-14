package com.example.childapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class QuestionsActivity extends Activity {

	TextView question;
	Button answer1, answer2, answer3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_questions);

		question = (TextView) findViewById(R.id.questionTextView);
		answer1 = (Button) findViewById(R.id.answer1Button);
		answer2 = (Button) findViewById(R.id.answer2Button);
		answer3 = (Button) findViewById(R.id.answer3Button);

		question.setText("Who is the leon?");

		answer1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showAnswerMessage("FAIL", R.string.fail_msg, "OK");
			}
		});

		answer2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showAnswerMessage("CORRECT!", R.string.correct_msg, "OK");
			}
		});

		answer3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
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
