package ui.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class KButton extends JButton {


	private static final long serialVersionUID = 1L;
	
	
	public KButton(String name) {
		
		super(name); 
		setBorderPainted(false);
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setForeground(new Color(255, 255, 255));
		setBorder(null);
		setBackground(new Color(0, 51, 204));

	}

	public KButton() {
		
	}
}
