package Panels.options;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.Collections;

import Manager.controller.Manager;
import Manager.generals.Background;
import Manager.generals.Panel;
import Manager.generals.Button.Acts;
import Manager.generals.Button.LabelButton;
import Panels.UserPanels.UserSetting;
import player.Player;

@SuppressWarnings("serial")
public class OptionPanel extends Panel {
	private static OptionPanel optionPanel = new OptionPanel();
	Player player;

	LabelButton rocketSetting = new LabelButton("Costumize Spaceship", 220, 120, 550, 50, 47);
	LabelButton costumKey = new LabelButton("Controls", 220, 240, 200, 50, 47);
	LabelButton sound = new LabelButton("Sound", 220, 360, 160, 50, 47);
	LabelButton backgrounds = new LabelButton("Backgrounds", 220, 480, 330, 58, 47);

	public LabelButton back = new LabelButton("Back", 220, 600, 130, 50, 47);

	private OptionPanel() {
		super(Background.backs.get("resources\\optionBack.jpg"));
		init();
	}

	private void init() {
		Collections.addAll(drawables, back, costumKey, sound, rocketSetting, backgrounds);
		for (Component c : drawables) {
			this.add(c);
		}
		back.addMouseListener(new Acts(back) {

			@Override
			public void mousePressed(MouseEvent arg0) {
				UserSetting u = UserSetting.getcurrent();
				u.remove(u.resume);
				u.remove(u.newgame);
				u.options.setForeground(LabelButton.ExitColor);
				Manager.setPanel(u);
			}
		});
		costumKey.addMouseListener(new Acts(costumKey) {

			@Override
			public void mousePressed(MouseEvent arg0) {

			}
		});
		sound.addMouseListener(new Acts(sound) {

			@Override
			public void mousePressed(MouseEvent arg0) {

			}
		});
		rocketSetting.addMouseListener(new Acts(rocketSetting) {

			@Override
			public void mousePressed(MouseEvent arg0) {

			}
		});
		backgrounds.addMouseListener(new Acts(backgrounds) {

			@Override
			public void mousePressed(MouseEvent arg0) {
				Costumback u = Costumback.create();
				backgrounds.setForeground(LabelButton.ExitColor);
				u.back.setForeground(LabelButton.ExitColor);

				Manager.setPanel(u);
			}
		});
	}

	public static OptionPanel create(Player player) {
		optionPanel.player = player;
		return optionPanel;
	}

	public static OptionPanel getcurrent() {
		return optionPanel;
	}
}
