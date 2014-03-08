package sdm.application.childapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import sdm.application.childapp.R;
import sdm.application.db.ScoresData;
import sdm.application.entity.UserEntity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class HighScoreActivity extends Activity {
	
	private String language;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
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
		
		setContentView(R.layout.activity_high_score);

		ListView listView = (ListView) findViewById(R.id.listUser);

		TextView highscore = (TextView) findViewById(R.id.highscoreTitle);
		Typeface font = Typeface.createFromAsset(getAssets(), "pointy.ttf");
		highscore.setTypeface(font);

		final ScoresData score = new ScoresData(getApplicationContext());

		score.open();

		final List<UserEntity> values = score.getAllValorations();
		final ArrayList<UserEntity> highValues = new ArrayList<UserEntity>();
		if (values.size() >= 10) {
			for (int i = 0; i < 10; i++)
				highValues.add(values.get(i));
		} else {
			for (int i = 0; i < values.size(); i++)
				highValues.add(values.get(i));
		}
		
		ScoreItemAdapter adapter = new ScoreItemAdapter(this, highValues);

		listView.setAdapter(adapter);

		score.close();

		Button acceptButton = (Button) findViewById(R.id.acceptButtonHighScore);
		acceptButton.setTypeface(font);
		acceptButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				finish();
				Intent myIntent = new Intent(HighScoreActivity.this,
						FirstActivity.class);
				startActivity(myIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.high_score, menu);
		return true;
	}

	protected void onPause() {
		super.onPause();
		if (!this.isFinishing()) {
			GameAudio.pause();
		}
	}

	protected void onResume() {
		super.onResume();
		GameAudio.play(getApplicationContext(), R.raw.upbeat_feeling);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			finish();
			Intent myIntent = new Intent(HighScoreActivity.this,
					FirstActivity.class);
			startActivity(myIntent);
			return true;
		}
		return super.onKeyUp(keyCode, event);
	}

}
