package ui.packages.tabs;

import java.awt.EventQueue;

import ui.components.KTab;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CustomerFeedBack extends KTab {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFeedBack frame = new CustomerFeedBack();
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
	public CustomerFeedBack() {
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		textField.setBounds(161, 191, 354, 101);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Type the feedback:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setBounds(161, 91, 328, 51);
		getContentPane().add(lblNewLabel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnSubmit.setBounds(161, 376, 99, 42);
		getContentPane().add(btnSubmit);
		//setBounds(100, 100, 450, 300);

	}
}
