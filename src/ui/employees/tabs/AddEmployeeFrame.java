package ui.employees.tabs;

import java.awt.EventQueue;

import javax.swing.JLabel;

import ui.components.KTab;

public class AddEmployeeFrame extends KTab {

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
					AddEmployeeFrame frame = new AddEmployeeFrame();
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
	public AddEmployeeFrame() {
		super("Add Employee");
		
		JLabel lblAddAnEmployee = new JLabel("Add an Employee");
		lblAddAnEmployee.setBounds(99, 85, 153, 33);
		getContentPane().add(lblAddAnEmployee);

	}
}
