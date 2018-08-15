package ui.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class TabNavButton extends JButton {

	private static final long serialVersionUID = 1L;
	private int pos;
	private TabNavPanel panel;
	
	public TabNavButton(String name, int pos, TabNavPanel panel) {
		super(name);
		this.pos = pos;
		this.panel = panel;
	}
	
	public void reset() {
		
		setForeground(new Color(255, 255, 255));
		setFont(new Font("Segoe UI", Font.BOLD, 14));
		setBorder(null);
		setBackground(new Color(0, 51, 153));
		setBounds(pos*160, 0, 160, 50);
		setFocusable(false);
		
	}
	
	public void clicked() {

		panel.resetAll();
		setForeground(new Color(255, 255, 255));
		setFont(new Font("Segoe UI", Font.BOLD, 14));
		setBorder(null);
		setBackground(new Color(102, 153, 255));
		setBounds(pos*160, 0, 160, 50);
		setFocusable(false);
	}

}
