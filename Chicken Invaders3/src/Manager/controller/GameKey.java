package Manager.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Panels.UserPanels.GamePanel;

public class GameKey implements KeyListener {
	static GamePanel game = GamePanel.getCurrent();

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 32)
			game.getPlayer().rocket.shooting = true;
		if (e.getKeyCode() == 10)
			System.out.println("");
		if (e.getKeyCode() == 37)
			game.getPlayer().rocket.move_left = true;
		if (e.getKeyCode() == 38)
			game.getPlayer().rocket.move_up = true;
		if (e.getKeyCode() == 39)
			game.getPlayer().rocket.move_right = true;
		if (e.getKeyCode() == 40)
			game.getPlayer().rocket.move_down = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// System.out.println(e.getKeyCode());
		switch (e.getKeyCode()) {
		case 27:
			GameAction.pauseTheGame();
			break;
		}
		if (e.getKeyCode() == 32)
			game.getPlayer().rocket.shooting = false;
		if (e.getKeyCode() == 10)
			System.out.println("");
		if (e.getKeyCode() == 37)
			game.getPlayer().rocket.move_left = false;
		if (e.getKeyCode() == 38)
			game.getPlayer().rocket.move_up = false;
		if (e.getKeyCode() == 39)
			game.getPlayer().rocket.move_right = false;
		if (e.getKeyCode() == 40)
			game.getPlayer().rocket.move_down = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}


}
