package ui.employees;

import java.awt.EventQueue;

import ui.components.KFrame;
import ui.components.KTab;
import ui.components.TabNavPanel;
import ui.components.TabPanel;
import ui.employees.tabs.AddEmployeeFrame;
import ui.employees.tabs.ViewEmployees;

public class EmployeeFrame extends KFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFrame frame = new EmployeeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeFrame() {
		
		KTab[] tabs = new KTab[2];
		tabs[0] = new AddEmployeeFrame();
		tabs[1] = new ViewEmployees();
		

		new TabPanel(this, tabs, new TabNavPanel(this));

	}
}
