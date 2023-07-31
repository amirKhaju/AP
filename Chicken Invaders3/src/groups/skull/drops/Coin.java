package groups.skull.drops;

import Manager.Assets;
import Panels.UserPanels.GamePanel;
import player.Rocket;

public class Coin extends SkullDrops {
	public Coin(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		image = Assets.coin;
		width = 35;
		height = 35;
	}

	@Override
	public void intersect(Rocket rocket) {
		if (this.getDistance(rocket) <= this.radius + rocket.radius) {
			GamePanel.getCurrent().getController().wave.drops.remove(this);
			rocket.setCoins(rocket.getCoins() + 1);
		}
		for (int i = rocket.tirs.size() - 1; i >= 0; i--) {
			if (this.getDistance(rocket.tirs.get(i)) <= this.radius + rocket.tirs.get(i).radius) {
				GamePanel.getCurrent().getController().wave.drops.remove(this);
			}
		}
	}

}
