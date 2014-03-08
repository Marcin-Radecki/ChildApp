package sdm.application.childapp;

import java.util.Date;
import java.util.Random;

import android.animation.ObjectAnimator;
import android.os.AsyncTask;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;

public class UnfoldTask extends AsyncTask<Integer, Integer, Integer> {

	boolean resume = true;
	boolean pause = false;
	private String WATCH_DOG = "barabulka";

	View view;
	Button[] catchButtons;
	private Random random;
	int screenWidth, screenHeight;
	private final int ROUNDS = 10;
	int counter;
	Animation animation;
	ObjectAnimator transAnimationX;
	ObjectAnimator transAnimationY;
	LayoutParams[] params;
	CatchCatchActivity ac;
	private int level;

	public UnfoldTask(Button catchButtons[], int screenWidth, int screenHeight,
			CatchCatchActivity ac) {
		counter = 0;
		this.catchButtons = catchButtons;
		random = new Random(new Date().getTime());
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		this.ac = ac;
		level = 1;
		params = new LayoutParams[5];
	}

	@Override
	protected Integer doInBackground(Integer... maxHeight) {

		while (resume) {

			for (level = 1; level <= 5; level++) {
				int time = random.nextInt(1000 + level * 400) + 700;
				publishProgress(level);
				for (counter = 0; counter < ROUNDS; counter++) {
					for (int i = 0; i < level; i++) {
						int randomWidth = screenWidth / 6;
						int randomHeight = randomWidth;

						int x = random.nextInt(screenWidth - randomWidth);
						int y = random.nextInt(screenHeight / 3);

						params[i] = new LayoutParams(randomWidth, randomHeight);
						params[i].setMargins(x, y, 0, 0);

					}
					
					if (pause) {
						synchronized (WATCH_DOG) {
							try {
								WATCH_DOG.wait();

							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							pause = false;
						}
					}
					
					publishProgress(0);
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			resume = false;
		}

		return 0;
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		if (values[0] == 0) {
			for (int i = 0; i < level; i++) {
				catchButtons[i].setLayoutParams(params[i]);
			}

		} else {
			ac.nextLevel(values[0]);
		}

	}

	@Override
	protected void onPostExecute(Integer result) {
		ac.showScoreMessage();
	}

	public void pause() {
		pause = true;
	}

	public void wakeUp() {
		synchronized (WATCH_DOG) {
			WATCH_DOG.notify();
		}
	}

	public boolean getPause() {
		return pause;
	}
}