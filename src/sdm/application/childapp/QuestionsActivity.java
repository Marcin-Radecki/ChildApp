package sdm.application.childapp;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import sdm.application.childapp.R;
import sdm.application.db.DAO;
import sdm.application.db.ScoresData;
import sdm.application.entity.QuestionEntity;
import sdm.application.entity.UserEntity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
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


public class QuestionsActivity extends Activity implements OnInitListener {

	private TextView question, score;
	private Button answer1, answer2, answer3;
	private Drawable drawable;
	private QuestionEntity qe;
	private Dialog answerDialog, scoreDialog, usernameDialog;
	private TextToSpeech tts;
	private DAO dao;
	private Random random = new Random();
	private String category;
	private ArrayList<QuestionEntity> questions = new ArrayList<QuestionEntity>();
	private int goodAnswer;
	private int questionsNum;
	private int restAttempts;
	private int points;
	private String language;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_questions);

		GameAudio.stop();
		GameAudio.play(getApplicationContext(), R.raw.funny_loop);

		language = getIntent().getStringExtra("LANGUAGE");
		Locale locale = new Locale(language);
		Locale.setDefault(locale);

		Configuration config = new Configuration();
		config.locale = locale;
		getApplicationContext().getResources()
				.updateConfiguration(config, null);

		// get all questions from database
		dao = new DAO(this);
		ArrayList<QuestionEntity> questionsAll = (ArrayList<QuestionEntity>) dao
				.getQuestions();
		// pick only questions with given category
		category = getIntent().getStringExtra(CategoriesActivity.CATEGORY_NAME);
		for (int i = 0; i < questionsAll.size(); i++) {
			QuestionEntity q = questionsAll.get(i);
			if (q.getQuestionType().equals(category))
				questions.add(q);
		}

		// catch the max number of questions
		questionsNum = Integer.parseInt(getIntent().getStringExtra(
				CategoriesActivity.QUESTIONS_NUMBER));

		question = (TextView) findViewById(R.id.questionTextView);
		Typeface font = Typeface.createFromAsset(getAssets(),
				"HelvetiHand.ttf");
		question.setTypeface(font);
		score = (TextView) findViewById(R.id.textScore);
		font = Typeface.createFromAsset(getAssets(), "scoreboard.ttf");
		score.setTypeface(font);
		answer1 = (Button) findViewById(R.id.answer1Button);
		answer2 = (Button) findViewById(R.id.answer2Button);
		answer3 = (Button) findViewById(R.id.answer3Button);

		tts = new TextToSpeech(this, this);

		// restart score
		points = 0;
		score.setText(getString(R.string.score) + String.valueOf(points));

		// pick random question
		goodAnswer = nextQuestion();

		answer1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				tts.speak(
						getResources().getString(
								qe.getAnswers().get(0).getLabel()),
						TextToSpeech.QUEUE_ADD, null);
				if (goodAnswer == 0)
					showAnswerMessage(R.string.correct_title, R.drawable.sun,
							true);
				else
					showAnswerMessage(R.string.fail_title, R.drawable.cloud,
							false);
			}
		});

		answer2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				tts.speak(
						getResources().getString(
								qe.getAnswers().get(1).getLabel()),
						TextToSpeech.QUEUE_ADD, null);
				if (goodAnswer == 1)
					showAnswerMessage(R.string.correct_title, R.drawable.sun,
							true);
				else
					showAnswerMessage(R.string.fail_title, R.drawable.cloud,
							false);
			}
		});

		answer3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				tts.speak(
						getResources().getString(
								qe.getAnswers().get(2).getLabel()),
						TextToSpeech.QUEUE_ADD, null);
				if (goodAnswer == 2)
					showAnswerMessage(R.string.correct_title, R.drawable.sun,
							true);
				else
					showAnswerMessage(R.string.fail_title, R.drawable.cloud,
							false);
			}
		});

	}

	private int nextQuestion() {
		System.gc();
		restAttempts = 2;
		int questionNumber = random.nextInt(questions.size());
		qe = questions.get(questionNumber);

		if (category.equals("letters"))
			question.setText(getResources().getString(R.string.letterQuestion));
		else
			question.setText(getResources().getString(qe.getQuestion()));

		drawable = this.getResources().getDrawable(
				qe.getAnswers().get(0).getImagePathId());
		answer1.setBackground(drawable);
		drawable = this.getResources().getDrawable(
				qe.getAnswers().get(1).getImagePathId());
		answer2.setBackground(drawable);
		drawable = this.getResources().getDrawable(
				qe.getAnswers().get(2).getImagePathId());
		answer3.setBackground(drawable);

		questions.remove(questionNumber);
		questionsNum--;

		tts.speak(getResources().getString(qe.getQuestion()),
				TextToSpeech.QUEUE_ADD, null);

		return qe.getAnswer();
	}

	private void showAnswerMessage(int text, int img, final boolean correct) {
		answerDialog = new Dialog(this);
		answerDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		answerDialog.setCancelable(false);
		answerDialog.setContentView(R.layout.answer_dialog);

		TextView title = (TextView) answerDialog.findViewById(R.id.answerTitle);
		Typeface font = Typeface.createFromAsset(getAssets(),
				"HelvetiHand.ttf");
		title.setTypeface(font);
		title.setText(text);

		ImageView image = (ImageView) answerDialog
				.findViewById(R.id.answerImage);
		image.setImageResource(img);

		if (correct)
			GameAudio.playEfect(getApplicationContext(), R.raw.right_answer);
		else
			GameAudio.playEfect(getApplicationContext(), R.raw.wrong_answer);

		Button acceptButton = (Button) answerDialog
				.findViewById(R.id.acceptButton);
		acceptButton.setTypeface(font);
		acceptButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				answerDialog.dismiss();
				if (correct) {
					points += restAttempts + 1;
					score.setText(getString(R.string.score)
							+ String.valueOf(points));
					if (questionsNum > 0)
						goodAnswer = nextQuestion();
					else {
						showScoreMessage();
					}
				} else if (restAttempts == 0) {
					if (questionsNum > 0)
						goodAnswer = nextQuestion();
					else {
						showScoreMessage();
					}
				} else {
					restAttempts--;
					tts.speak(question.getText().toString(),
							TextToSpeech.QUEUE_ADD, null);
				}

			}
		});

		answerDialog.show();
	}

	private void showScoreMessage() {
		scoreDialog = new Dialog(this);
		scoreDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		scoreDialog.setCancelable(false);
		scoreDialog.setContentView(R.layout.score_dialog);

		GameAudio.stop();
		GameAudio.play(getApplicationContext(), R.raw.high_score);

		TextView score = (TextView) scoreDialog.findViewById(R.id.scoreNumber);
		Typeface font = Typeface.createFromAsset(getAssets(), "pointy.ttf");
		score.setTypeface(font);
		score.setText(String.valueOf(points));

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
					Intent myIntent = new Intent(QuestionsActivity.this,
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
			tts.speak(getResources().getString(qe.getQuestion()),
					TextToSpeech.QUEUE_ADD, null);
		}
	}

	protected void onPause() {
		super.onPause();
		if (!this.isFinishing()) {
			GameAudio.pause();
		}
	}

	protected void onStart() {
		super.onStart();
		GameAudio.play(getApplicationContext(), R.raw.funny_loop);

		language = getIntent().getStringExtra("LANGUAGE");
		Locale locale = new Locale(language);
		Locale.setDefault(locale);

		Configuration config = new Configuration();
		config.locale = locale;
		getApplicationContext().getResources()
				.updateConfiguration(config, null);

		tts.speak(getResources().getString(qe.getQuestion()),
				TextToSpeech.QUEUE_ADD, null);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			finish();
			Intent myIntent = new Intent(QuestionsActivity.this,
					SecondActivity.class);
			myIntent.putExtra("LANGUAGE", language);
			startActivity(myIntent);
			GameAudio.stop();
			GameAudio.play(getApplicationContext(), R.raw.upbeat_feeling);
			tts.stop();
			tts.shutdown();
			return true;
		}
		return super.onKeyDown(keyCode, event);
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
		getMenuInflater().inflate(R.menu.questions, menu);
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
		msg.setText(R.string.HelpContQuestions);
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
