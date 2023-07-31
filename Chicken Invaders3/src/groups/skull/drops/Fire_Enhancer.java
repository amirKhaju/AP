package groups.skull.drops;

import Manager.Assets;
import Panels.UserPanels.GamePanel;
import player.Rocket;

public class Fire_Enhancer extends SkullDrops {
	int type;

	public Fire_Enhancer(double x, double y, double vx, double vy, int type) {
		super(x, y, vx, vy);
		this.type = type;
		width = 40;
		height = 50;
		switch (type) {
		case 1:
			image = Assets.tir_prize1;
			break;
		case 2:
			image = Assets.tir_prize2;
			break;
		case 3:
			image = Assets.tir_prize3;
			break;
		}

	}

	@Override
	public void intersect(Rocket rocket) {
		if (getDistance(rocket) <= this.radius + rocket.radius) {
			GamePanel.getCurrent().getController().wave.drops.remove(this);
			if (rocket.getFire_type() != type)
				rocket.setFire_type(type);
			else {
				rocket.setFire_stage(rocket.getFire_stage() + 1);
			}
			GamePanel.getCurrent().updateState();
		}
	}
}
