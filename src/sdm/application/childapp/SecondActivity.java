package sdm.application.childapp;

import java.util.Locale;
import sdm.application.childapp.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends Activity {

	Button questionsButton;
	Button catchButton;
	Button backButton;
	ImageView games;
	private String language;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		games = (ImageView) findViewById(R.id.games);

		questionsButton = (Button) findViewById(R.id.questionsButton);

		catchButton = (Button) findViewById(R.id.catchButton);

		backButton = (Button) findViewById(R.id.backButton);
		
		if(getIntent().getStringExtra("LANGUAGE") == null)
			language = Locale.getDefault().getLanguage();
		else{
			language = getIntent().getStringExtra("LANGUAGE");
			Locale locale = new Locale(language);
			Locale.setDefault(locale);
			 
			Configuration config = new Configuration();
			config.locale = locale;
			getApplicationContext().getResources().updateConfiguration(config, null);
		}
		
		if(language.equals("es")){
			games.setImageDrawable(getResources().getDrawable(R.drawable.juegos_text));
			questionsButton.setBackground(getResources().getDrawable(R.drawable.preguntasbutton));
			catchButton.setBackground(getResources().getDrawable(R.drawable.pillabutton));
			backButton.setBackground(getResources().getDrawable(R.drawable.atrasbutton));
		}
		else{
			games.setImageDrawable(getResources().getDrawable(R.drawable.games_text));
			questionsButton.setBackground(getResources().getDrawable(R.drawable.questionsbutton));
			catchButton.setBackground(getResources().getDrawable(R.drawable.catchbutton));
			backButton.setBackground(getResources().getDrawable(R.drawable.backbutton));
		}

		questionsButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				finish();
				Intent myIntent = new Intent(SecondActivity.this,
						CategoriesActivity.class);
				startActivity(myIntent);

			}
		});

		catchButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				finish();
				Intent myIntent = new Intent(SecondActivity.this,
						CatchCatchActivity.class);
				myIntent.putExtra("LANGUAGE", Locale.getDefault().getLanguage());
				startActivity(myIntent);
			}
		});

		backButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				finish();
				Intent myIntent = new Intent(SecondActivity.this,
						FirstActivity.class);
				startActivity(myIntent);
			}
		});
	}
	
	protected void onPause(){
		super.onPause();
		if (!this.isFinishing()){
			GameAudio.pause();
	    }
	}
	
	protected void onStart(){
		super.onStart();
		GameAudio.play(getApplicationContext(), R.raw.upbeat_feeling);
		onCreate(null);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			finish();
			Intent myIntent = new Intent(SecondActivity.this,
					FirstActivity.class);
			startActivity(myIntent);
			return true;
		}
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.help:
			showMessageHelp();
			break;
		}
		return false;

	}
	
	private void showMessageHelp() {

		final Dialog helpDialog = new Dialog(this);
		helpDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		helpDialog.setCancelable(false);
		helpDialog.setContentView(R.layout.menu_dialog);
		
		ImageView icon = (ImageView) helpDialog
				.findViewById(R.id.MenuIcon);
		icon.setImageResource(R.drawable.help_icon);

		Typeface font = Typeface.createFromAsset(getAssets(),
				"HelvetiHand.ttf");
		TextView msg = (TextView) helpDialog.findViewById(R.id.textMenu);
		msg.setText(R.string.HelpContSecond);
		msg.setTypeface(font);
		font = Typeface.createFromAsset(getAssets(),
				"children_one.otf");
		TextView title = (TextView) helpDialog.findViewById(R.id.textMenuTitle);
		title.setTypeface(font);
		title.setText(R.string.help);
		
		Button acceptButton = (Button) helpDialog.findViewById(R.id.buttonAcceptMenu);
		acceptButton.setTypeface(font);
		acceptButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				helpDialog.dismiss();
			}
		});
		
		helpDialog.show();

	}
	
	@Override
    protected void onDestroy() {
        super.onDestroy();

        unbindDrawables(getWindow().getDecorView().getRootView());
        System.gc();
    }

    private void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                unbindDrawables(((ViewGroup) view).getChildAt(i));
            }
            ((ViewGroup) view).removeAllViews();
        }
    }
}
