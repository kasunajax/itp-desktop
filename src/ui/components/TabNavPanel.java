package ui.components;

import java.awt.Color;
import javax.swing.JPanel;

public class TabNavPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public TabNavPanel(KFrame frame) {

		setBackground(new Color(0, 51, 153));
		setBounds(0, 50, 980, 50);
		setLayout(null);
		frame.add(this);
		
	}

	public void add(TabNavButton btn, int index) {
		
		btn.setBounds(index*120, 10, 100, 30);
		add(btn);
		
	}

}
