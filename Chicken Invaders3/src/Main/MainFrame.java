package Main;

import javax.swing.JFrame;

import Manager.Assets;
import Panels.UserPanels.UserChooser;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public Assets assets =new Assets();
	static MainFrame Frame = new MainFrame();
	public UserChooser chooser = UserChooser.create();

	private MainFrame() {
		initialize();
	}

	public static MainFrame Launch() {
		return Frame;

	}

	private void initialize() {
		 setUndecorated(true);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		setTitle("Chicken Invaders");
		setContentPane(chooser);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
