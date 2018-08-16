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
		textField.setBounds(148, 147, 96, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Browse");
		btnNewButton.setBounds(685, 146, 85, 21);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Add Dialog Sales Confirmation Report");
		lblNewLabel.setBounds(173, 106, 45, 13);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Add Report");
		btnNewButton_1.setBounds(446, 254, 85, 21);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Confirm Sales");
		btnNewButton_2.setBounds(446, 460, 85, 21);
		getContentPane().add(btnNewButton_2);

	}
}
