package Manager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Manager.generals.Background;

public class Assets {
	public static Background chooserBack = new Background("resources\\userChooserBackground.png");
	public static Background pauseBack = new Background("resources\\esc.png");
	public static Background userSettingBack = new Background("resources\\UserWellcome.JPG");
	public static Background optionBack = new Background("resources\\optionBack.jpg");
	public static Background hallBack = new Background("resources\\hall.jpg");
	public static Background movingback1 = new Background("resources\\back1.jpg");
	public static Background movingback2 = new Background("resources\\back2.jpg");
	public static Background movingback3 = new Background("resources\\back3.jpg");
	public static Background movingback4 = new Background("resources\\back4.jpg");
	public static Background movingback5 = new Background("resources\\back5.jpg");
	public static Background movingback6 = new Background("resources\\back6.png");
	public static Background movingback7 = new Background("resources\\back7.jpg");


	public static BufferedImage ghool1 = loadImage("resources\\ghool1.png");
	public static BufferedImage ghool2 = loadImage("resources\\ghool2.png");
	public static BufferedImage ghool3 = loadImage("resources\\ghool3.png");
	public static BufferedImage ghool4 = loadImage("resources\\ghool4.png");
	public static BufferedImage bar = loadImage("resources\\bar.png");
	public static BufferedImage fire1 = loadImage("resources\\fire1.png");
	public static BufferedImage fire2 = loadImage("resources\\fire2.png");
	public static BufferedImage fire22 = loadImage("resources\\fire22.png");

	public static BufferedImage fire3 = loadImage("resources\\fire3.png");

	public static BufferedImage skull1 = loadImage("resources\\skull1.png");
	public static BufferedImage skull2 = loadImage("resources\\skull2.png");
	public static BufferedImage skull3 = loadImage("resources\\skull3.png");
	public static BufferedImage skull4 = loadImage("resources\\skull4.png");
	public static BufferedImage missile = loadImage("resources\\missile2.png");
	public static BufferedImage bone = loadImage("resources\\bone.png");
	public static BufferedImage coin = loadImage("resources\\coin.png");
	public static BufferedImage cooler = loadImage("resources\\cooler.png");
	public static BufferedImage rocket1 = loadImage("resources\\Dragon1.png");
	public static BufferedImage rocket2 = loadImage("resources\\Rocket2.png");

	public static BufferedImage shield = loadImage("resources\\shield1.png");
	public static BufferedImage tir_prize1 = loadImage("resources\\3rd.png");
	public static BufferedImage tir_prize2 = loadImage("resources\\2nd.png");
	public static BufferedImage tir_prize3 = loadImage("resources\\1st.png");

	public static BufferedImage loadImage(String name) {
		try {
			return ImageIO.read(new File(name));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
