package ui.main;

import java.awt.Color;

import javax.swing.JPanel;

import ui.components.NavButton;

import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class NavPanel extends JPanel {


	private static final long serialVersionUID = 1L;

	public NavPanel() {
		setBackground(new Color(0, 51, 153));
		setBounds(0, 0, 300, 800);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NavPanel.class.getResource("/main/home.png")));
		lblNewLabel.setBounds(22, 22, 256, 256);
		add(lblNewLabel);
		

		new NavButton("Order Management", this, 0).setBounds(22, 350, 256, 50);
		new NavButton("Employee", this, 1).setBounds(22, 400, 256, 50);
		new NavButton("Sales", this, 2).setBounds(22, 450, 256, 50);
		new NavButton("Region", this, 3).setBounds(22, 500, 256, 50);
		new NavButton("Payroll", this, 4).setBounds(22, 550, 256, 50);
		new NavButton("Finance", this, 5).setBounds(22, 600, 256, 50);
		new NavButton("Packages & Promotions", this, 6).setBounds(22, 650, 256, 50);
		new NavButton("Inventory", this, 7).setBounds(22, 700, 256, 50);

		
		

	}
}
