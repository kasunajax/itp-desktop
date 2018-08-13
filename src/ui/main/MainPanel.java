package ui.main;

import javax.swing.JPanel;

public class MainPanel extends JPanel {


	private static final long serialVersionUID = 1L;

	public MainPanel() {
		setBounds(300, 0, 980, 800);
		setLayout(null);
		
		DesktopPane desktopPane = DesktopPane.getInstance();
		desktopPane.setBounds(0, 150, 980, 650);
		add(desktopPane);
	}
}
