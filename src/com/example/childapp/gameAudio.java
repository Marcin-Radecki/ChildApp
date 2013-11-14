package com.example.childapp;

import android.content.Context;
import android.media.MediaPlayer;

public class gameAudio {

	private static MediaPlayer player = null;

	public static void play(Context context, int resource) {

		stop();

		player = MediaPlayer.create(context, resource);
		player.setLooping(true);
		player.start();

	}

	public static void stop() {

		if (player != null) {
			player.stop();
			player.release();
			player = null;
		}
	}

	public static MediaPlayer get_mireproductor() {
		return player;
	}

}
