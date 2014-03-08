package sdm.application.childapp;

import java.util.Locale;
import sdm.application.childapp.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
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

		if (Locale.getDefault().getLanguage().equals("es")) {
			playButton.setBackground(getResources().getDrawable(
					R.drawable.jugarbutton));
		} else {
			playButton.setBackground(getResources().getDrawable(
					R.drawable.playbutton));
		}

		playButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {

				finish();
				Intent myIntent = new Intent(FirstActivity.this,
						SecondActivity.class);
				startActivity(myIntent);

			}
		});

		settingsButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				finish();
				Intent myIntent = new Intent(FirstActivity.this,
						SettingsActivity.class);
				startActivity(myIntent);
			}
		});

		highScoresButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				finish();
				Intent myIntent = new Intent(FirstActivity.this,
						HighScoreActivity.class);
				startActivity(myIntent);
			}
		});
	}

	protected void onPause() {
		super.onPause();
		if (!this.isFinishing()) {
			GameAudio.pause();
		}
	}

	protected void onStart() {
		super.onStart();
		GameAudio.play(getApplicationContext(), R.raw.upbeat_feeling);
		onCreate(null);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			finish();
			GameAudio.stop();
			return true;
		}
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.first, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.aboutus:
			showMessageAbout();
			break;
		case R.id.help:
			showMessageHelp();
			break;
		}
		return false;

	}

	private void showMessageAbout() {
		
		final Dialog aboutUsDialog = new Dialog(this);
		aboutUsDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		aboutUsDialog.setCancelable(false);
		aboutUsDialog.setContentView(R.layout.menu_dialog);
		
		ImageView icon = (ImageView) aboutUsDialog
				.findViewById(R.id.MenuIcon);
		icon.setImageResource(R.drawable.about_us_icon);

		Typeface font = Typeface.createFromAsset(getAssets(),
				"HelvetiHand.ttf");
		TextView msg = (TextView) aboutUsDialog.findViewById(R.id.textMenu);
		msg.setTypeface(font);
		msg.setText(R.string.aboutus);
		font = Typeface.createFromAsset(getAssets(),
				"children_one.otf");
		TextView title = (TextView) aboutUsDialog.findViewById(R.id.textMenuTitle);
		title.setTypeface(font);
		title.setText(R.string.aboutustitle);
		
		Button acceptButton = (Button) aboutUsDialog.findViewById(R.id.buttonAcceptMenu);
		acceptButton.setTypeface(font);
		acceptButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				aboutUsDialog.dismiss();
			}
		});
		
		aboutUsDialog.show();
		
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
		msg.setText(R.string.HelpContFirst);
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
