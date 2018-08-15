package ui.components;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class TabNavPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private List<TabNavButton> tabButtons;
	
	
	public TabNavPanel(KFrame frame) {
		tabButtons = new ArrayList<>();
		setBackground(new Color(0, 51, 153));
		setBounds(0, 50, 980, 50);
		setLayout(null);
		frame.add(this);
		
	}

	public void add(TabNavButton btn) {
		
		//btn.setBounds(index*120, 10, 100, 30);
		btn.reset();
		super.add(btn);
		tabButtons.add(btn);
		
		
	}
	
	public void resetAll() {
		for(TabNavButton btn : tabButtons) {
			btn.reset();
		}
	}

}
