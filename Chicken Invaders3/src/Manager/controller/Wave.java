package Manager.controller;

import static Manager.Dimentions.screenSize;

import java.awt.Graphics;
import java.util.ArrayList;

import Manager.generals.Button.WaveLabel;
import groups.groups.GeneralGroups;
import groups.skull.GeneralSkull;
import groups.skull.Monster;
import groups.skull.drops.Bones;
import groups.skull.drops.SkullDrops;
import player.Animatable;

public class Wave implements Animatable {
	public ArrayList<SkullDrops> drops = new ArrayList<SkullDrops>();
	public ArrayList<GeneralGroups> groups = new ArrayList<GeneralGroups>();
	public Monster monster;
	int wave_Num;
	int stage;
	long Wave_Massage_Time;
	WaveLabel label;
	public int state = 1;

	public String startMassage(int stage, int wave, String massage) {
		return "Stage " + stage + " Wave " + wave + "\r" + massage;
	}

	public Wave(int wave_Num, int stage, ArrayList<GeneralGroups> groups) {
		this.wave_Num = wave_Num;
		this.stage = stage;
		this.groups.addAll(groups);
		label = new WaveLabel(startMassage(stage, wave_Num, ""), 300, 300, 30);
	}

	public Wave(int wave_Num, int stage, Monster ghool) {
		this.wave_Num = wave_Num;
		this.stage = stage;
		this.monster = ghool;
		label = new WaveLabel(startMassage(stage, wave_Num, ""), 300, 300, 30);
	}

	private void showMassage() {
		if (System.currentTimeMillis() - Wave_Massage_Time >= 1 && this.state == 1) {
			label.move();
			Wave_Massage_Time = System.currentTimeMillis();
		}
		if (label.y > screenSize.height) {
			this.state = 2;
		}
	}

	private boolean waveEnded() {
		for (GeneralGroups g : groups) {
			if (g.skulls.size() != 0 || drops.size() != 0)
				return false;
		}
		if (monster != null && (monster.ghools.size() > 0 || drops.size() != 0)) {
			return false;
		}
		return true;
	}

	@Override
	public void paint(Graphics g) {
		paintDrops(g);
		for (GeneralGroups group : groups) {
			group.paint(g);
		}
		if (monster != null)
			monster.paint(g);

	}

	@Override
	public void move() {
		switch (this.state) {
		case 1:
			showMassage();
			break;
		case 2:
			if (this.wave_Num < 5) {
				for (GeneralGroups g : groups) {
					g.move();
				}
				dropBones();
			} else if (this.wave_Num == 5) {
				monster.move();
			}
			if (waveEnded()) {
				this.state = 3;
			}
			moveDrops();
			break;
		case 3:
			break;

		}
	}

	long drop_time = 0;

	public void dropBones() {
		if (System.currentTimeMillis() - drop_time > 1000) {
			for (int j = groups.size() - 1; j >= 0 && groups.size() != 0; j--) {
				for (int i = groups.get(j).skulls.size() - 1; i >= 0 && groups.get(j).skulls.size() > 0; i--) {
					GeneralSkull s = groups.get(j).skulls.get(i);
					if (s.chance() <= s.getTir_chance() && s.getY() > 0) {
						drops.add(new Bones(s.getX(), s.getY(), 0, s.getTir_velocity()));
					}
				}
			}
			drop_time = System.currentTimeMillis();
		}
	}

	private void paintDrops(Graphics g) {
		for (int i = drops.size() - 1; i >= 0 && drops.size() > 0; i--) {
			try {
				drops.get(i).paint(g);
			} catch (Exception e) {
				System.out.println("drop paint error");
			}
		}
	}

	private void moveDrops() {
		for (int i = drops.size() - 1; i >= 0 && drops != null; i--) {
			drops.get(i).move();
			if (drops.get(i).getY() > screenSize.getHeight() || drops.get(i).getY() < 0 || drops.get(i).getX() < 0
					|| drops.get(i).getX() > screenSize.getWidth()) {
				drops.remove(i);
			}
		}
	}
}
