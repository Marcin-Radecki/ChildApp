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

public class SecondActivity extends Activity {

	Button questionsButton;
	Button catchButton;
	Button backButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		questionsButton = (Button) findViewById(R.id.questionsButton);

		catchButton = (Button) findViewById(R.id.catchButton);

		backButton = (Button) findViewById(R.id.backButton);

		questionsButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {

				Intent myIntent2 = new Intent(SecondActivity.this,
						CategoriesActivity.class);
				startActivity(myIntent2);

			}
		});

		catchButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {

				Intent myIntent2 = new Intent(SecondActivity.this,
						CatchCatchActivity.class);
				startActivity(myIntent2);

			}
		});

		backButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		/* Según el elemento activado */
		switch (item.getItemId()) {
		case R.id.help:
			showMessageHelp("Help", R.string.HelpCont, "OK");
			break;

		}
		return false;

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
