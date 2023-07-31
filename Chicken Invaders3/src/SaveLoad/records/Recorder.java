package SaveLoad.records;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Panels.hallOfFame.HallPanel;
import player.Player;

public class Recorder {
	private static File records = new File("records.txt");
	private static PrintWriter writer;
	private static ArrayList<String> allRecords = new ArrayList<>();
	static {
		try {
			records.createNewFile();
			writer = new PrintWriter(records);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Recorder() {

	}

	public static void record(Player p) {
		String s = p.name + " " + p.getLevel() + " " + p.score + " " + p.time_in_game;
		allRecords.add(s);
		//addToHall(s);
		writer.println(s);
		writer.flush();
	}

	private static void addToHall(String s) {
		HallPanel h = HallPanel.create();
		h.addLabel(s.split(" "));
	}

	public static void loadRecords() {
		Scanner s = new Scanner("records.txt");
		while(s.hasNext()) {
			allRecords.add(s.next());
		}
		s.close();
	}
}
