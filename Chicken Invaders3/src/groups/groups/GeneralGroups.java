package groups.groups;

import static Manager.Dimentions.screenSize;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import groups.skull.GeneralSkull;
import player.Animatable;

public abstract class GeneralGroups implements Animatable {
	public ArrayList<GeneralSkull> skulls = new ArrayList<GeneralSkull>();
	protected final int maximumSkulls = 50;
	protected int level;
	protected int x = 90;
	protected int y = -1000;

	public void paint(Graphics g) {
		for (int i = skulls.size() - 1; i >= 0; i--) {
			skulls.get(i).paint(g);
		}
	}

	protected GeneralSkull RandomSkull() {
		Random r = new Random();
		try {
			return skulls.get(r.nextInt(skulls.size() - 1));
		} catch (Exception e) {
		}
		return skulls.get(0);
	}

	protected int getRandomX() {
		Random r = new Random();
		return 30 + r.nextInt((int) screenSize.getWidth() - 60);
	}

	protected int getRandomY() {
		Random r = new Random();
		return 90 + r.nextInt((int) screenSize.getHeight() - 300);
	}

	protected abstract void initArr();

}