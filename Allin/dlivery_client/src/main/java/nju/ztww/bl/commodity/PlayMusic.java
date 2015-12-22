package nju.ztww.bl.commodity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;

public class PlayMusic {
	public static void play(String soundFile) throws IOException {
		 InputStream inputStream = new FileInputStream(new File(soundFile));
		 AudioPlayer.player.start(inputStream);
		    }
}
