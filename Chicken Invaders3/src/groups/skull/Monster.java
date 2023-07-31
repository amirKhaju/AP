package groups.skull;

import static Manager.Dimentions.screenSize;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import Manager.Assets;
import Panels.UserPanels.GamePanel;
import groups.skull.drops.Bones;
import groups.skull.drops.SkullDrops;
import player.Fire;
import player.Rocket;

public class Monster {
	private static final int DEFAULT_JOON = 250;
	public ArrayList<Monster> ghools = new ArrayList<Monster>();
	private double x = screenSize.getWidth() / 2;
	private double y = -500;
	@SuppressWarnings("unused")
	private double v_x;
	private double v_y;
	private BufferedImage image;
	private int width = 500;
	private int height = 550;
	public int joon;
	private int radius;
	private int level;
	private long bone_time;

	public Monster(int level) {
		this.level = level;
		makeGhool();
		ghools.add(this);
	}

	private void makeGhool() {
		switch (level) {
		case 1:
			this.radius = 175;
			this.image = Assets.ghool1;
			this.width = 500;
			this.height = 550;
			break;

		case 2:
			this.radius = 150;
			this.image = Assets.ghool2;
			break;
		case 3:
			this.radius = 210;
			this.image = Assets.ghool3;
			break;
		case 4:
			this.radius = 175;
			this.image = Assets.ghool4;
			break;
		}
		this.joon = this.level * DEFAULT_JOON;
		this.v_y = 4;
	}

	public void changeJoon(int t) {
		joon -= t;
	}

	private void addBones() {
		ArrayList<SkullDrops> drops = GamePanel.getCurrent().getController().wave.drops;
		if (chance() <= 0.25)
			drops.add(new Bones(x, y, 0, 1));
		if (chance() <= 0.25)
			drops.add(new Bones(x, y, 0, -1));
		if (chance() <= 0.25)
			drops.add(new Bones(x, y, 1, 0));
		if (chance() <= 0.25)
			drops.add(new Bones(x, y, -1, 0));
		if (chance() <= 0.25)
			drops.add(new Bones(x, y, 1, 1));
		if (chance() <= 0.25)
			drops.add(new Bones(x, y, -1, -1));
		if (chance() <= 0.25)
			drops.add(new Bones(x, y, -1, 1));
		if (chance() <= 0.25)
			drops.add(new Bones(x, y, 1, -1));
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public void move() {
		for (Monster s : ghools) {
			if (System.currentTimeMillis() - bone_time > 500) {
				s.addBones();
				bone_time = System.currentTimeMillis();
			}
			if (s.y + 150 < screenSize.height / 2) {
				s.y += s.v_y;
			}
		}
	}

	public void paint(Graphics g) {
		g.setColor(new Color(226, 0, 82));
		for (int i = ghools.size() - 1; i >= 0 && ghools.size() > 0; i--) {
			Monster s = ghools.get(i);
			g.drawRect(screenSize.width / 2 + 200, 10, s.level * DEFAULT_JOON / 3, 30);
			g.fillRect(screenSize.width / 2 + 200, 10, s.joon / 3, 30);
			g.drawImage(s.image, (int) (s.x - s.getWidth() / 2), (int) (s.y - s.getHeight() / 2), s.width, s.height,
					null);
		}
	}

	protected double chance() {
		return new Random().nextDouble();
	}

	public boolean intersect(Object obj) {
		if (obj instanceof Fire) {
			Fire o = (Fire) obj;
			int deltaX = (int) Math.sqrt(((o.getX() - this.getX()) * (o.getX() - this.getX())
					+ (o.getY() - this.getY()) * (o.getY() - this.getY())));
			if (deltaX <= o.radius + this.radius)
				return true;
		}
		if (obj instanceof Rocket) {
			Rocket o = (Rocket) obj;
			int deltaX = (int) Math.sqrt(((o.getX() - this.getX()) * (o.getX() - this.getX())
					+ (o.getY() - this.getY()) * (o.getY() - this.getY())));
			if (deltaX <= o.radius + this.radius)
				return true;
		}
		return false;
	}

	public void die() {

	}
}
