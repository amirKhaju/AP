package groups.groups;

import static Manager.Dimentions.screenSize;

import java.awt.Point;

import groups.skull.RoundSkull;

public class SimpleRound extends GeneralGroups {
	private int radius = 190;
	private final Point center = new Point(screenSize.width / 2, screenSize.height / 2);

	public SimpleRound(int level) {
		this.level = level;
		initArr();
	}

	@Override
	protected void initArr() {
		for (byte i = 0; i < maximumSkulls; i++) {
			if (i < 10) {
				skulls.add(new RoundSkull(i * 360 / 10, radius * 5, center, i, this.level));
			} else if (i < 25) {
				skulls.add(new RoundSkull(i * 360 / 15, radius * 5 + 100, center, i, this.level));
			} else {
				skulls.add(new RoundSkull(i * 360 / 25, radius * 5 + 200, center, i, this.level));
			}
		}
	}

	@Override
	public void move() {
		for (byte j = 0; j < skulls.size(); j++) {
			RoundSkull s = (RoundSkull) skulls.get(j);
			if (s.number < 10) {
				if (s.getRadius() > radius)
					s.moveToR(radius);
			} else if (s.number >= 10 && s.number < 25) {
				if (s.getRadius() > radius + 100)
					s.moveToR(radius + 100);
			} else {
				if (s.getRadius() > radius + 200)
					s.moveToR(radius + 200);
			}
			s.orbit(-1.2);
		}
	}
}
