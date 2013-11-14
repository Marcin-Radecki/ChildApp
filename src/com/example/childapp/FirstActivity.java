package com.example.childapp;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class FirstActivity extends Activity {

	Button playButton;
	Button settingsButton;
	Button highScoresButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);

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

				Intent myIntent = new Intent(FirstActivity.this,
						SecondActivity.class);
				startActivity(myIntent);

			}
		});

		highScoresButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {

				Intent myIntent = new Intent(FirstActivity.this,
						SecondActivity.class);
				startActivity(myIntent);

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

		/* Según el elemento activado */
		switch (item.getItemId()) {
		case R.id.aboutus:
			showMessageAbout(
					"About us",
					"Aitor Baragaño Fernández\nAntonio Cueva Fernández\nMarcin Radecki",
					"ok");
			break;
		case R.id.help:
			showMessageHelp("Help", R.string.HelpCont, "ok");
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
								// Lo que se hace en el click

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
								// Lo que se hace en el click

							}
						}).show();
	}

}
