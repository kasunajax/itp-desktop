package ui.components;

import javax.swing.JDesktopPane;

public class TabPane extends JDesktopPane {

	private static final long serialVersionUID = 1L;
	
	public TabPane(TabPanel panel) {
		
		setBounds(0, 0, 980, 600);
		panel.add(this);
		
	}

}
