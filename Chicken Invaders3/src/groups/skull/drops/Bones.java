package groups.skull.drops;

import Manager.Assets;
import Panels.UserPanels.GamePanel;
import player.Rocket;

public class Bones extends SkullDrops {
	public Bones(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		image = Assets.bone;
		width = 15;
		height = 30;
		this.radius = 8;
	}

	@Override
	public void intersect(Rocket rocket) {
		if (getDistance(rocket) <= this.radius + rocket.radius) {
			GamePanel.getCurrent().getController().wave.drops.remove(this);
			rocket.die();
		}
	}

}
