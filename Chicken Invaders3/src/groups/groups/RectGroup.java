package groups.groups;

import java.util.ArrayList;

import groups.skull.GeneralSkull;
import groups.skull.Skull1;

public class RectGroup extends GeneralGroups {
	public RectGroup(int level) {
		this.level = level;
		skulls = new ArrayList<GeneralSkull>();
		initArr();
	}

	@Override
	protected void initArr() {
		for (int i = 1; i <= maximumSkulls; i++) {
			skulls.add(new Skull1(this.x, this.y, 0, 8,this.level));
			this.x += 75;
			if (i % 15 == 0) {
				this.y += 75;
				this.x = 90;
			}
		}
	}

	int r = 0;

	@Override
	public void move() {
		for (int i = skulls.size() - 1; i >= 0; i--) {
			if (skulls.get(0).getY() < 60) {
				skulls.get(i).move();
			} else {
				if (r < skulls.size()) {
					skulls.get(i).setV_x(1);
					skulls.get(i).setV_y(0);
					r++;
				}
				if (skulls.get(i).inEdgeX()) {
					skulls.get(i).move();
					for (int j = skulls.size() - 1; j >= 0; j--) {
						if(skulls.get(j).getY() == skulls.get(i).getY() && (i != j)) {
						skulls.get(j).setV_x(skulls.get(i).getV_x());
						}
					}
				}
				skulls.get(i).move();
			}
		}
	}
}
