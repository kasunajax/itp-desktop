package ui.employees.tabs;

import java.awt.EventQueue;


import ui.components.KTab;

import javax.swing.JButton;

public class ViewEmployees extends KTab {

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
					ViewEmployees frame = new ViewEmployees();
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
	public ViewEmployees() {
		super("View Employees");
		
		JButton btnViewEmployee = new JButton("View Employee");
		btnViewEmployee.setBounds(160, 126, 129, 23);
		getContentPane().add(btnViewEmployee);

	}
}
