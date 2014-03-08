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

public class CategoriesActivity extends Activity {

	public static String CATEGORY_NAME = "CATEGORY_NAME";
	public static String QUESTIONS_NUMBER = "QUESTIONS_NUMBER";
	
	Button lettersButton;
	Button colorsButton;
	Button animalsButton;
	Button numbersButton;
	Button backButton;
	ImageView categories;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_categories);
		
		categories = (ImageView) findViewById(R.id.categories);

		lettersButton = (Button) findViewById(R.id.buttonLetters);

		colorsButton = (Button) findViewById(R.id.buttonColors);

		animalsButton = (Button) findViewById(R.id.buttonAnimals);

		numbersButton = (Button) findViewById(R.id.buttonNumbers);
		
		backButton = (Button) findViewById(R.id.backButton);
		
		if(Locale.getDefault().getLanguage().equals("es")){
			categories.setImageDrawable(getResources().getDrawable(R.drawable.categorias_text));
			lettersButton.setBackground(getResources().getDrawable(R.drawable.letrasbutton));
			colorsButton.setBackground(getResources().getDrawable(R.drawable.coloresbutton));
			animalsButton.setBackground(getResources().getDrawable(R.drawable.animalesbutton));
			numbersButton.setBackground(getResources().getDrawable(R.drawable.numerosbutton));
			backButton.setBackground(getResources().getDrawable(R.drawable.atrasbutton));
		}
		else{
			categories.setImageDrawable(getResources().getDrawable(R.drawable.categories_text));
			lettersButton.setBackground(getResources().getDrawable(R.drawable.lettersbutton));
			colorsButton.setBackground(getResources().getDrawable(R.drawable.colorsbutton));
			animalsButton.setBackground(getResources().getDrawable(R.drawable.animalsbutton));
			numbersButton.setBackground(getResources().getDrawable(R.drawable.numbersbutton));
			backButton.setBackground(getResources().getDrawable(R.drawable.backbutton));
		}

		lettersButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				finish();
				Intent myIntent = new Intent(CategoriesActivity.this,
						QuestionsActivity.class);
				myIntent.putExtra(CATEGORY_NAME, "letters");
				myIntent.putExtra(QUESTIONS_NUMBER, "10");
				myIntent.putExtra("LANGUAGE", Locale.getDefault().getLanguage());
				startActivity(myIntent);
				
			}
		});

		colorsButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				finish();
				Intent myIntent = new Intent(CategoriesActivity.this,
						QuestionsActivity.class);
				myIntent.putExtra(CATEGORY_NAME, "colors");
				myIntent.putExtra(QUESTIONS_NUMBER, "6");
				myIntent.putExtra("LANGUAGE", Locale.getDefault().getLanguage());
				startActivity(myIntent);

			}
		});

		animalsButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				finish();
				Intent myIntent = new Intent(CategoriesActivity.this,
						QuestionsActivity.class);
				myIntent.putExtra(CATEGORY_NAME, "animals");
				myIntent.putExtra(QUESTIONS_NUMBER, "10");
				myIntent.putExtra("LANGUAGE", Locale.getDefault().getLanguage());
				startActivity(myIntent);

			}
		});

		numbersButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				finish();
				Intent myIntent = new Intent(CategoriesActivity.this,
						QuestionsActivity.class);
				myIntent.putExtra(CATEGORY_NAME, "numbers");
				myIntent.putExtra(QUESTIONS_NUMBER, "5");
				myIntent.putExtra("LANGUAGE", Locale.getDefault().getLanguage());
				startActivity(myIntent);

			}
		});
		
		backButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View arg0) {
				finish();
				Intent myIntent = new Intent(CategoriesActivity.this,
						SecondActivity.class);
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
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			finish();
			Intent myIntent = new Intent(CategoriesActivity.this,
					SecondActivity.class);
			startActivity(myIntent);
			return true;
		}
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.chosse_question, menu);
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
		msg.setText(R.string.HelpContCategories);
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
