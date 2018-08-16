package ui.components;

import java.awt.Color;

import javax.swing.JInternalFrame;

public class KFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	public KFrame() {
		setBorder(null);
		setBounds(0, 0, 980, 650);
		getContentPane().setLayout(null);
		setBackground(new Color(255, 255, 255));
	}

}
