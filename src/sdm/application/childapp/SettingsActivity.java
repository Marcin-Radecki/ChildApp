package sdm.application.childapp;

import java.util.Locale;
import sdm.application.childapp.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SettingsActivity extends Activity {

	
	private SeekBar volumeSeekBar = null;
	private AudioManager audioManager = null;
	private Button EnglishButton = null;
	private Button SpanishButton = null;
	private Button backButton = null;
	private TextView soundControl, languages;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		
		backButton = (Button) findViewById(R.id.backButton);
		
		if(Locale.getDefault().getLanguage().equals("es")){
			backButton.setBackground(getResources().getDrawable(R.drawable.atrasbutton));
		}
		else{
			backButton.setBackground(getResources().getDrawable(R.drawable.backbutton));
		}
		
		backButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				finish();
				Intent myIntent = new Intent(SettingsActivity.this,
						FirstActivity.class);
				startActivity(myIntent);
			}
		});
		
		soundControl = (TextView) findViewById(R.id.textViewSound);
		languages = (TextView) findViewById(R.id.textViewLanguages);
		Typeface font = Typeface.createFromAsset(getAssets(), "HelvetiHand.ttf");
		soundControl.setTypeface(font);
		languages.setTypeface(font);
		language();
		
		initControls();
		
	}

	private void initControls() {
		try {
			volumeSeekBar = (SeekBar)findViewById(R.id.seekBarControlSound);
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            volumeSeekBar.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            volumeSeekBar.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC)); 
            
            volumeSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				
				public void onStopTrackingTouch(SeekBar seekBar) {
					
				}
				
				public void onStartTrackingTouch(SeekBar seekBar) {
					
				}
				
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
					
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void language(){
		EnglishButton = (Button) findViewById(R.id.buttonEnglish);
		SpanishButton = (Button) findViewById(R.id.buttonSpanish);
		
		EnglishButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {

				Locale locale = new Locale("en");
				Locale.setDefault(locale);
				 
				Configuration config = new Configuration();
				config.locale = locale;
				getApplicationContext().getResources().updateConfiguration(config, null);
				onCreate(null);

			}
		});
		
		SpanishButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {

				Locale locale = new Locale("es");
				Locale.setDefault(locale);
				 
				Configuration config = new Configuration();
				config.locale = locale;
				getApplicationContext().getResources().updateConfiguration(config, null);
				onCreate(null);
				
			}
		});
	}
	
	protected void onPause(){
		super.onPause();
		if (!this.isFinishing()){
			GameAudio.pause();
	    }
	}
	
	protected void onResume(){
		super.onResume();
		GameAudio.play(getApplicationContext(), R.raw.upbeat_feeling);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			finish();
			Intent myIntent = new Intent(SettingsActivity.this,
					FirstActivity.class);
			startActivity(myIntent);
			return true;
		}
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
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
