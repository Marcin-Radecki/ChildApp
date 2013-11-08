package com.example.childapp;


import com.example.childapp.QuestionsActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ChooseQuestionActivity extends Activity {

	Button buttonLetters;
	Button buttonColors;
	Button buttonAnimals;
	Button buttonNumbers;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chosse_question);
		
		buttonLetters = (Button) findViewById(R.id.buttonLetters);
		
		buttonColors = (Button) findViewById(R.id.buttonColors);
		
		buttonAnimals = (Button) findViewById(R.id.buttonAnimals);
		
		buttonNumbers = (Button) findViewById(R.id.buttonNumbers);
		
		buttonLetters.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				
				Intent myIntent2 = new Intent(ChooseQuestionActivity.this, QuestionsActivity.class);
				startActivity(myIntent2);
				
				
				
				
			}
		});
		
		buttonColors.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				
				Intent myIntent2 = new Intent(ChooseQuestionActivity.this, QuestionsActivity.class);
				startActivity(myIntent2);
				
				
				
				
			}
		});
		
		buttonAnimals.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				
				Intent myIntent2 = new Intent(ChooseQuestionActivity.this, QuestionsActivity.class);
				startActivity(myIntent2);
				
				
				
				
			}
		});
		
		buttonNumbers.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				
				Intent myIntent2 = new Intent(ChooseQuestionActivity.this, QuestionsActivity.class);
				startActivity(myIntent2);
				
				
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chosse_question, menu);
		return true;
	}
public boolean onOptionsItemSelected(MenuItem item){
		
		/* Según el elemento activado */
		switch (item.getItemId()) {
		case R.id.atras:
			finish();
		
		break;
		
		}
		return false;
		
	}

}
