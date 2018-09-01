package ui.main;

import java.awt.Color;

import javax.swing.JPanel;

import ui.components.NavButton;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;


public class NavPanel extends JPanel {


	private static final long serialVersionUID = 1L;
	
	
	private static NavPanel instance;
	private NavButton[] navButtons = new NavButton[8];
	
	public static NavPanel getInstance() {
		
		if(instance == null) {
			instance = new NavPanel();
		}
		
		return instance;
	}
	
	public NavButton[] getNavButtons() {
		return navButtons;
	}

	private NavPanel() {
		setBackground(new Color(0, 51, 153));
		setBounds(0, 0, 300, 800);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NavPanel.class.getResource("/main/home.png")));
		lblNewLabel.setBounds(22, 22, 256, 256);
		add(lblNewLabel);
		
		
		navButtons[0] = new NavButton("Order Management", this, 0);
		navButtons[0].setBounds(22, 350, 256, 50);
		
		navButtons[1] = new NavButton("Employee", this, 1);
		navButtons[1].setBounds(22, 400, 256, 50);
		
		navButtons[2] = new NavButton("Sales", this, 2);
		navButtons[2].setBounds(22, 450, 256, 50);
		
		navButtons[3] = new NavButton("Region", this, 3);
		navButtons[3].setBounds(22, 500, 256, 50);
		
		navButtons[4] = new NavButton("Payroll", this, 4);
		navButtons[4].setBounds(22, 550, 256, 50);
		
		navButtons[5] = new NavButton("Finance", this, 5);
		navButtons[5].setBounds(22, 600, 256, 50);
		
		navButtons[6] = new NavButton("Packages & Promotions", this, 6);
		navButtons[6].setBounds(22, 650, 256, 50);
		
		navButtons[7] = new NavButton("Inventory", this, 7);
		navButtons[7].setBounds(22, 700, 256, 50);

		
		

	}
}
