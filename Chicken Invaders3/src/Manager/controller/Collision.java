package Manager.controller;

import java.util.ArrayList;

import Panels.UserPanels.GamePanel;
import groups.skull.GeneralSkull;
import groups.skull.Monster;
import groups.skull.drops.SkullDrops;
import player.Rocket;

public class Collision {
//polygon
	public static void skullDropCollision(Rocket rocket, ArrayList<SkullDrops> drops) {
		for (int i = drops.size() - 1; i >= 0; i--) {
			if (drops.get(i) instanceof groups.skull.drops.Bones && rocket.has_shield == false) {
				drops.get(i).intersect(rocket);
			} else if (drops.get(i) instanceof groups.skull.drops.Coin) {
				drops.get(i).intersect(rocket);
			} else if (drops.get(i) instanceof groups.skull.drops.HeatEnhancer) {
				drops.get(i).intersect(rocket);
			} else if (drops.get(i) instanceof groups.skull.drops.Fire_Enhancer) {
				drops.get(i).intersect(rocket);
			}
		}
	}

	public static void rocketSkullCollapse(Rocket rocket, ArrayList<GeneralSkull> skulls) {
		a: for (int i = skulls.size() - 1; i >= 0; i--) {
			if (skulls.get(i).intersects(rocket) && !rocket.has_shield) {
				rocket.die();
				skulls.get(i).die();
				skulls.remove(i);
				break a;
			}
			for (int j = rocket.tirs.size() - 1; j >= 0 && rocket.tirs.size() >= 0; j--) {
				if (skulls.get(i).intersects(rocket.tirs.get(j))) {
					if (skulls.get(i).joon <= 0) {
						skulls.get(i).die();
						GamePanel.getCurrent().getPlayer().score+=skulls.get(i).level;
						GamePanel.getCurrent().updateState();
						skulls.remove(skulls.get(i));
					} else {
						skulls.get(i).joon -=rocket.tirs.get(j).getDamage();
					}
					rocket.tirs.remove(j);
					break a;
				}
			}

		}
	}

	public static void rocketGhoolCollapse(Rocket rocket, ArrayList<Monster> ghool) {
		a: for (int i = ghool.size() - 1; i >= 0 && ghool.size() > 0; i--) {
			if (ghool.get(i).intersect(rocket) && !rocket.has_shield) {
				rocket.die();
				if (ghool.get(i).joon > 20) {
					ghool.get(i).joon -= 20;
				} else {
					ghool.get(i).die();
					ghool.remove(i);
				}
				break a;
			}
			for (int j = rocket.tirs.size() - 1; j >= 0 && rocket.tirs.size() >= 0; j--) {
				if (ghool.get(i).intersect(rocket.tirs.get(j))) {
					if (ghool.get(i).joon <= 0) {
						ghool.get(i).die();
						ghool.remove(ghool.get(i));
					} else {
						ghool.get(i).joon -= 6;
					}
					rocket.tirs.remove(j);
					break a;
				}
			}
		}
	}
}