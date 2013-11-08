package com.example.childapp;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class SecondActivity extends Activity {

	Button buttonQuestions;
	Button ButtonCatch;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		buttonQuestions = (Button) findViewById(R.id.buttonQuestion);
		
		ButtonCatch = (Button) findViewById(R.id.buttonCatch);
		
		buttonQuestions.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				
				Intent myIntent2 = new Intent(SecondActivity.this, ChooseQuestionActivity.class);
				startActivity(myIntent2);
				
				
				
				
			}
		});
		ButtonCatch.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				
				Intent myIntent2 = new Intent(SecondActivity.this, CatchCatchActivity.class);
				startActivity(myIntent2);
				
				
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
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
