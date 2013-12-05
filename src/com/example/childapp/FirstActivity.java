package com.example.childapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.db.DAO;

public class FirstActivity extends Activity {

	Button playButton;
	Button settingsButton;
	Button highScoresButton;
	private DAO dao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
<<<<<<< HEAD
						
		gameAudio.play(getApplicationContext(), R.raw.upbeat_feeling);
=======
		
//		// database Data Object Model
//		// use it for getting object from the database
//		dao = new DAO(this);
//		// just for first start
//		dao.FillDatabaseWithData();
				
		gameAudio.play(getApplicationContext(), R.raw.main_melody);
>>>>>>> d50c07cc0266843d819ac474050f06d72342984d

		playButton = (Button) findViewById(R.id.playButton);

		settingsButton = (Button) findViewById(R.id.settingsButton);

		highScoresButton = (Button) findViewById(R.id.highScoresButton);

		playButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {

				Intent myIntent = new Intent(FirstActivity.this,
						SecondActivity.class);
				startActivity(myIntent);

			}
		});

		settingsButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {


			}
		});

		highScoresButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {


			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.aboutus:
			showMessageAbout(
					"About Us",
					"Aitor Baragaño Fernández\nAntonio Cueva Fernández\nMarcin Radecki",
					"OK");
			break;
		case R.id.help:
			showMessageHelp("Help", R.string.HelpCont, "OK");
			break;
		}
		return false;

	}

	private void showMessageAbout(String title, String msg, String txtButton) {
		new AlertDialog.Builder(this)
				.setTitle(title)
				.setIcon(R.drawable.about)
				.setMessage(msg)
				.setNeutralButton(txtButton,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
		
							}
						}).show();
	}

	private void showMessageHelp(String title, int helpcont, String txtButton) {
		new AlertDialog.Builder(this)
				.setTitle(title)
				.setIcon(R.drawable.help)
				.setMessage(helpcont)
				.setNeutralButton(txtButton,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								
							}
						}).show();
	}

}
