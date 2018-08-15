package ui.finance.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

public class CreateExpenses extends KTab {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateExpenses frame = new CreateExpenses();
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
	public CreateExpenses() {
		super("Create Expenses");
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(62, 44, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(296, 48, 46, 14);
		getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(90, 130, 405, 240);
		getContentPane().add(table);
		

	}
}
