package ui.sales.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import javax.swing.JButton;

public class ViewReports extends KTab {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewReports frame = new ViewReports();
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
	public ViewReports() {
		super("View Reports");
		
		JButton btnNewButton = new JButton("Confirmed Sales");
		btnNewButton.setBounds(351, 103, 206, 40);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Unconfirmed Sales");
		btnNewButton_1.setBounds(351, 263, 206, 40);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sales not yet entered to the system");
		btnNewButton_2.setBounds(351, 424, 206, 40);
		getContentPane().add(btnNewButton_2);

	}
}
