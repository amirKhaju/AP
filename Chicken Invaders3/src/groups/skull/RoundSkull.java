package groups.skull;

import java.awt.Graphics;
import java.awt.Point;

public class RoundSkull extends GeneralSkull {
//	private AffineTransform transform;
	private Point center;
	private int radius;
	private double teta;
	public int number;

	public RoundSkull(double teta, int radius, Point center, int number, int level) {
		super(level);
		this.radius = radius;
		this.teta = teta;
		this.center = center;
		this.number = number;
		initOrbital();
	}

	private void initOrbital() {
		this.x = (float) ((this.radius * Math.cos(Math.toRadians(teta))) + center.getX());
		this.y = (float) ((this.radius * Math.sin(Math.toRadians(teta))) + center.getY());
//		this.transform = AffineTransform.getTranslateInstance(this.x - this.width, this.y - this.height);
//		transform.setToTranslation(x - image.getWidth() / 2, y - image.getHeight() / 2);
//		transform.rotate(Math.toRadians(teta - 90), image.getWidth() / 2, image.getHeight() / 2);
	}

	public double getTeta() {
		return teta;
	}

	public void setTeta(double teta) {
		this.teta = teta;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(image, (int) (x - this.getWidth() / 2), (int) (y - this.getHeight() / 2), 60, 60, null);
//		Graphics2D g2 = (Graphics2D) g;
//		g2.drawImage(image, this.transform, null);
	}

	@Override
	public void orbit(double v) {
		this.teta += v;
//		this.transform = AffineTransform.getTranslateInstance(this.x - this.width, this.y - this.height);
//		transform.setToTranslation(x - image.getWidth() / 2, y - image.getHeight() / 2);
//		transform.rotate(Math.toRadians(90 - teta), image.getWidth() / 2, image.getHeight() / 2);	
//		transform.scale(100, 100);
		initOrbital();
	}

	public void moveToR(int radius2) {
		if (this.radius > radius2) {
			this.radius--;
			initOrbital();
		}
	}
}
