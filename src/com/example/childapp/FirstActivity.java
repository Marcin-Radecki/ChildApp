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

	Button ButtonPlay;
	Button ButtonHelp;
	Button ButtonOption;
	Button ButtonScores;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		
		ButtonPlay = (Button) findViewById(R.id.buttonPlay);
		
		ButtonHelp = (Button) findViewById(R.id.buttonHelp);
		
		ButtonOption = (Button) findViewById(R.id.buttonOption);
		
		ButtonScores = (Button) findViewById(R.id.buttonScores);
		
		
		
		
		ButtonPlay.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				
				Intent myIntent = new Intent(FirstActivity.this, SecondActivity.class);
				startActivity(myIntent);
				
				//Toast.makeText(getApplicationContext(), "Valoraciones guardadas", Toast.LENGTH_SHORT).show();
				
				
			}
		});
		ButtonHelp.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				
				showMessageHelp("Help", R.string.HelpCont, "ok");
				
				
			}
		});
		ButtonOption.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				
				Intent myIntent = new Intent(FirstActivity.this, SecondActivity.class);
				startActivity(myIntent);
				
				//Toast.makeText(getApplicationContext(), "Valoraciones guardadas", Toast.LENGTH_SHORT).show();
				
				
			}
		});
		ButtonScores.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				
				Intent myIntent = new Intent(FirstActivity.this, SecondActivity.class);
				startActivity(myIntent);
				
				//Toast.makeText(getApplicationContext(), "Valoraciones guardadas", Toast.LENGTH_SHORT).show();
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item){
		
		/* Según el elemento activado */
		switch (item.getItemId()) {
		case R.id.aboutus:
			showMessageAbout("About us", "Antonio Cueva Fernández\nAitor Baragaño Fernández\nMarcin Radecki", "ok");
		
		break;
		
		}
		return false;
		
	}
	private void showMessageAbout(String title, String msg, String txtButton) {
		 new AlertDialog.Builder(this)
		 	 .setTitle(title)
		 	 .setIcon(R.drawable.about)
		 	 .setMessage(msg)
		 	 .setNeutralButton(txtButton, new DialogInterface.OnClickListener() {
					 public void onClick(DialogInterface dialog, int which) {
							 // Lo que se hace en el click
						 
					 }
		 	 })
		 	 .show();
	}
	private void showMessageHelp(String title, int helpcont, String txtButton) {
		 new AlertDialog.Builder(this)
		 	 .setTitle(title)
		 	 .setIcon(R.drawable.help) 
		 	 .setMessage(helpcont)
		 	 .setNeutralButton(txtButton, new DialogInterface.OnClickListener() {
					 public void onClick(DialogInterface dialog, int which) {
							 // Lo que se hace en el click
						 
					 }
		 	 })
		 	 .show();
	}

}
