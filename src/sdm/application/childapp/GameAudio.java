package sdm.application.childapp;

import android.content.Context;
import android.media.MediaPlayer;

public class GameAudio {

	private static MediaPlayer musicPlayer = null;
	private static MediaPlayer efectPlayer = null;

	public static void play(Context context, int resource) {

		if(musicPlayer == null){
		musicPlayer = MediaPlayer.create(context, resource);
		musicPlayer.setLooping(true);
		}
		
		musicPlayer.start();

	}

	public static void stop() {

		if (musicPlayer != null) {
			musicPlayer.stop();
			musicPlayer.release();
			musicPlayer = null;
		}
	}
	
	public static void pause(){
		if(musicPlayer != null){
			musicPlayer.pause();
		}
	}
	
	public static void playEfect(Context context, int resource) {

		stopEfect();

		efectPlayer = MediaPlayer.create(context, resource);
		efectPlayer.start();

	}

	public static void stopEfect() {

		if (efectPlayer != null) {
			efectPlayer.stop();
			efectPlayer.release();
			efectPlayer = null;
		}
	}

	public static MediaPlayer getMusicPlayer() {
		return musicPlayer;
	}
	
	public static MediaPlayer getEfectPlayer(){
		return efectPlayer;
	}

}
