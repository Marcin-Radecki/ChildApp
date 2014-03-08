package sdm.application.childapp;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import sdm.application.childapp.R;
import sdm.application.db.ScoresData;
import sdm.application.entity.UserEntity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


@SuppressLint("UseSparseArrays")
public class CatchCatchActivity extends Activity implements OnInitListener {

	private int points = 0;
	private TextView score, labelCatch;
	private TextToSpeech tts;
	private Button catchButton, playButton, catchButton2, catchButton3,
			catchButton4, catchButton5;
	private Button[] catchButtons;
	private int screenWidth, screenHeight;
	private Map<Integer, Integer> animals;
	private OnClickListener correct, fail;
	private Dialog scoreDialog, usernameDialog;
	private Random random = new Random();
	private UnfoldTask ut;
	private String language;
	private Configuration config;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_catch_catch);

		language = getIntent().getStringExtra("LANGUAGE");
		Locale locale = new Locale(language);
		Locale.setDefault(locale);

		config = new Configuration();
		config.locale = locale;
		getApplicationContext().getResources()
				.updateConfiguration(config, null);

		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		screenWidth = size.x;
		screenHeight = size.y;

		Typeface font = Typeface.createFromAsset(getAssets(),
				"HelvetiHand.ttf");
		labelCatch = (TextView) findViewById(R.id.labelCatch);
		labelCatch.setTypeface(font);
		labelCatch.setText(getResources().getString(R.string.catchcatchtitle));
		score = (TextView) findViewById(R.id.scoreText);
		font = Typeface.createFromAsset(getAssets(), "scoreboard.ttf");
		score.setTypeface(font);
		score.setText(getResources().getString(R.string.score) + points);

		catchButton = (Button) findViewById(R.id.buttonToCatch);
		catchButton2 = (Button) findViewById(R.id.buttonToCatch2);
		catchButton3 = (Button) findViewById(R.id.buttonToCatch3);
		catchButton4 = (Button) findViewById(R.id.buttonToCatch4);
		catchButton5 = (Button) findViewById(R.id.buttonToCatch5);
		playButton = (Button) findViewById(R.id.buttonPlay);
		catchButtons = new Button[] { catchButton, catchButton2, catchButton3,
				catchButton4, catchButton5 };

		animals = new HashMap<Integer, Integer>();
		animals.put(R.string.camelCatch, R.drawable.camel);
		animals.put(R.string.crocodileCatch, R.drawable.crocodile);
		animals.put(R.string.lionCatch, R.drawable.lion);
		animals.put(R.string.hippoCatch, R.drawable.hippo);
		animals.put(R.string.tortoiseCatch, R.drawable.tortoise);
		animals.put(R.string.rhinoCatch, R.drawable.rhino);
		animals.put(R.string.elephantCatch, R.drawable.elephant);
		animals.put(R.string.giraffeCatch, R.drawable.giraffe);
		animals.put(R.string.rabbitCatch, R.drawable.rabbit);
		animals.put(R.string.mouseCatch, R.drawable.mouse);
		animals.put(R.string.dogCatch, R.drawable.dog);
		animals.put(R.string.cowCatch, R.drawable.cow);
		animals.put(R.string.catCatch, R.drawable.cat);
		animals.put(R.string.donkeyCatch, R.drawable.donkey);
		animals.put(R.string.pigCatch, R.drawable.pig);
		animals.put(R.string.sheepCatch, R.drawable.sheep);
		animals.put(R.string.goatCatch, R.drawable.goat);

		if (Locale.getDefault().getLanguage().equals("es")) {
			playButton.setBackground(getResources().getDrawable(
					R.drawable.jugarbutton));
		} else {
			playButton.setBackground(getResources().getDrawable(
					R.drawable.playbutton));
		}

		tts = new TextToSpeech(this, this);

		correct = new OnClickListener() {
			@Override
			public void onClick(View v) {
				GameAudio.playEfect(getApplicationContext(),
						R.raw.funny_squeeze);
				points++;
				// actualize score text
				score.setText(getResources().getString(R.string.score) + points);
			}
		};

		fail = new OnClickListener() {
			@Override
			public void onClick(View v) {
				GameAudio.playEfect(getApplicationContext(), R.raw.twang);
				if (points > 0)
					points--;
				// actualize score text
				score.setText(getResources().getString(R.string.score) + points);
			}
		};

		ut = new UnfoldTask(catchButtons, screenWidth, screenHeight, this);

	}

	public void onPlay(View v) {
		playButton.setVisibility(View.GONE);
		GameAudio.stop();
		GameAudio.play(getApplicationContext(), R.raw.cartoon_mood);
		ut.execute(0, 0, 0);
	}

	public void nextLevel(int level) {
		int animal;
		Drawable drawable = null;
		do {
			animal = (Integer) animals.keySet().toArray()[random
					.nextInt(animals.size())];
			drawable = getResources().getDrawable(
					animals.get(animal).intValue());
		} while (drawable == null);
		labelCatch.setText(getResources().getString(animal));
		catchButtons[level - 1].setBackground(drawable);
		animals.remove(animal);
		catchButtons[level - 1].setVisibility(View.VISIBLE);
		catchButtons[level - 1].setOnClickListener(correct);
		for (int i = 0; i < level - 1; i++)
			catchButtons[i].setOnClickListener(fail);
		Toast.makeText(getApplicationContext(),
				this.getResources().getString(R.string.level) + " " + level,
				Toast.LENGTH_LONG).show();
		tts.speak(this.getResources().getString(R.string.level) + " " + level,
				TextToSpeech.QUEUE_ADD, null);
		tts.speak(labelCatch.getText().toString(), TextToSpeech.QUEUE_ADD, null);
	}

	public void showScoreMessage() {
		scoreDialog = new Dialog(this);
		scoreDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		scoreDialog.setCancelable(false);
		scoreDialog.setContentView(R.layout.score_dialog);

		GameAudio.stop();
		GameAudio.play(getApplicationContext(), R.raw.high_score);

		TextView score = (TextView) scoreDialog.findViewById(R.id.scoreNumber);
		Typeface font = Typeface.createFromAsset(getAssets(), "pointy.ttf");
		score.setTypeface(font);
		score.setText(String.valueOf(this.points));

		TextView title = (TextView) scoreDialog.findViewById(R.id.scoreTitle);
		font = Typeface.createFromAsset(getAssets(), "HelvetiHand.ttf");
		title.setTypeface(font);

		Button acceptButton = (Button) scoreDialog
				.findViewById(R.id.acceptButton);
		acceptButton.setTypeface(font);
		acceptButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				showUsernameMessage();
				scoreDialog.dismiss();
			}
		});

		scoreDialog.show();
	}

	private void showUsernameMessage() {
		usernameDialog = new Dialog(this);
		usernameDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		usernameDialog.setCancelable(false);
		usernameDialog.setContentView(R.layout.enter_name_dialog);

		Typeface font = Typeface.createFromAsset(getAssets(),
				"HelvetiHand.ttf");
		final EditText username = (EditText) usernameDialog
				.findViewById(R.id.username);
		username.setTypeface(font);
		TextView enter = (TextView) usernameDialog
				.findViewById(R.id.textEnterYourName);
		enter.setTypeface(font);

		Button acceptButton = (Button) usernameDialog
				.findViewById(R.id.acceptButton);
		acceptButton.setTypeface(font);
		acceptButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				if (!username.getText().toString().isEmpty()) {

					UserEntity user = new UserEntity(getApplicationContext());
					user.setName(username.getText().toString());
					user.setScore(points);

					// put in DB
					ScoresData scoresData = new ScoresData(
							getApplicationContext());
					scoresData.open();
					UserEntity existingUser = scoresData.findValoration(user.getName());
					if(existingUser != null){
						long newScore = user.getScore() + existingUser.getScore();
						scoresData.updateValoration(existingUser.getName(), newScore);
					}
					else
						scoresData.createValoration(user);
					scoresData.close();

					usernameDialog.dismiss();
					finish();
					Intent myIntent = new Intent(CatchCatchActivity.this,
							HighScoreActivity.class);
					myIntent.putExtra("LANGUAGE", language);
					startActivity(myIntent);
					GameAudio.stop();
					GameAudio.play(getApplicationContext(),
							R.raw.upbeat_feeling);
					tts.stop();
					tts.shutdown();
				}
			}
		});

		usernameDialog.show();

	}

	protected void onPause() {
		super.onPause();
		if (!this.isFinishing()) {
			ut.pause();
			GameAudio.pause();
		}
	}

	protected void onStart() {
		super.onStart();
		getApplicationContext().getResources()
				.updateConfiguration(config, null);
		GameAudio.play(getApplicationContext(), R.raw.cartoon_mood);
		if (ut.getPause())
			ut.wakeUp();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			if(ut.getStatus() != UnfoldTask.Status.RUNNING){
				finish();
				Intent myIntent = new Intent(CatchCatchActivity.this,
						SecondActivity.class);
				myIntent.putExtra("LANGUAGE", language);
				startActivity(myIntent);
				GameAudio.stop();
				GameAudio.play(getApplicationContext(),
						R.raw.upbeat_feeling);
				tts.stop();
				tts.shutdown();
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {
			Locale locale;
			if (Locale.getDefault().getLanguage().equals("es")) {
				locale = new Locale("es");
				tts.setLanguage(locale);
			} else {
				locale = new Locale("en");
				tts.setLanguage(locale);
			}
		}
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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.catch_catch, menu);
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
		msg.setText(R.string.HelpContCatchCatch);
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

}
