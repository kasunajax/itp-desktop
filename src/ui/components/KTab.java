package ui.components;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.SwingWorker;

public class KTab extends JInternalFrame {


	private static final long serialVersionUID = 1L;
	private String title;

	
	public KTab(String title) {
		setLayout(null);
		setBorder(null);
		setBounds(0, -50, 980, 650);
		getContentPane().setLayout(null);
		this.title = title;
		setBackground(new Color(255, 255, 255));
	}
	
	public KTab() {
		setLayout(null);
		setBorder(null);
		setBounds(0, -50, 980, 650);
		getContentPane().setLayout(null);
		setBackground(new Color(255, 255, 255));
	}
	
	public String getTitle() {
		return title;
	}
	


}
