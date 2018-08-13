package ui.employees.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import ui.components.TabNavPanel;
import ui.components.TabPanel;

import javax.swing.JButton;

public class AddEmp extends KTab {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmp frame = new AddEmp();
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
	public AddEmp() {
		super("Manage Employee Details");
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setBounds(91, 45, 112, 23);
		getContentPane().add(btnAddEmployee);
		
		
	}
}
