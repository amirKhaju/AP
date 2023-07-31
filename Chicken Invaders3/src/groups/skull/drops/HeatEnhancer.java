package groups.skull.drops;

import Manager.Assets;
import Panels.UserPanels.GamePanel;
import player.Rocket;

public class HeatEnhancer extends SkullDrops {

	public HeatEnhancer(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		image = Assets.cooler;
		width = 35;
		height = 35;
	}

	@Override
	public void intersect(Rocket rocket) {

		if (getDistance(rocket) <= this.radius + rocket.radius) {
			GamePanel.getCurrent().getController().wave.drops.remove(this);
			rocket.setFan_strength(rocket.getFan_strength() + 0.005);
		}
	}
}
