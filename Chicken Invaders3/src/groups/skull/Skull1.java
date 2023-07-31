package groups.skull;

import java.awt.Graphics;

public class Skull1 extends GeneralSkull {

	public Skull1(float x, float y, float v_x, float v_y, int level) {
		super(level);
		this.setX(x);
		this.setY(y);
		this.setV_x(v_x);
		this.setV_y(v_y);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(image, (int) (x - this.getWidth() / 2), (int) (y - this.getHeight() / 2), 60, 60, null);
	}

	@Override
	public void orbit(double v) {
	}

}
