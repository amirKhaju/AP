package groups.groups;

import Panels.UserPanels.GamePanel;
import groups.skull.Skull1;
import player.Rocket;

public class Snipers extends GeneralGroups {
	Rocket rocket = GamePanel.getCurrent().getPlayer().rocket;
	long shoot_time;

	public Snipers(int level) {
		this.level = level;
		initArr();
	}

	@Override
	public void move() {
		if (System.currentTimeMillis() - shoot_time > 5000 && skulls.size() > 0) {
			Skull1 s = (Skull1) RandomSkull();
			s.x_Destin = rocket.getX();
			s.y_Destin = rocket.getY();
			shoot_time = System.currentTimeMillis();
		}
		
		for (int i = 0; i < skulls.size(); i++) {
			if (skulls.get(i).getY() < 90 && skulls.get(i).getY() == -30) {
				skulls.get(i).move();
				skulls.get(i).x_Destin = skulls.get(i).getX();
				skulls.get(i).y_Destin = 90;
			} else if (reachedDestination((Skull1) skulls.get(i)) && skulls.get(i).getY() >= 0) {
				skulls.get(i).x_Destin = getRandomX();
				skulls.get(i).y_Destin = getRandomY();
			}
			skulls.get(i).moveDestin();
			reachedDestination((Skull1) skulls.get(i));
		}
	}

	private boolean reachedDestination(Skull1 skull) {
		if ((int) skull.getX() == (int) skull.x_Destin) {
			return true;
		}
		return false;
	}

	@Override
	protected void initArr() {
		for (int i = 0; i < maximumSkulls; i++) {
			skulls.add(new Skull1(getRandomX(), -31, 0, 1, this.level));
		}
	}

}
