package Manager.generals;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import javax.swing.JApplet;

public class sound extends JApplet{
	
		private AudioClip song; // Sound player
		private URL songPath; // Sound path

	public sound(String filename) {
			try {
				songPath = new URL(getCodeBase(), filename); // Get the Sound URL
				song = Applet.newAudioClip(songPath); // Load the Sound
			} catch (Exception e) {
			}
		}

		public void playSound() {
			song.loop(); // Play
		}

		public void stopSound() {
			song.stop(); // Stop
		}

		public void playSoundOnce() {
			song.play(); // Play only once
		}
	

	public static void Main(String...args) {
		sound testsong = new sound("4.wav");
		testsong.playSound();
	}
}
