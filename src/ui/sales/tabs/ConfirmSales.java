package ui.sales.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ConfirmSales extends KTab {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmSales frame = new ConfirmSales();
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
	public ConfirmSales() {
		super("Confirm Sales");
		
		textField = new JTextField();
		textField.setBounds(96, 148, 400, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Browse");
		btnNewButton.setBounds(646, 147, 125, 40);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Add Dialog Sales Confirmation Report");
		lblNewLabel.setBounds(96, 80, 350, 40);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Add Report");
		btnNewButton_1.setBounds(425, 253, 125, 40);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Confirm Sales");
		btnNewButton_2.setBounds(425, 416, 125, 40);
		getContentPane().add(btnNewButton_2);

	}
}
