package ui.finance.tabs;

import java.awt.EventQueue;

import ui.components.KTab;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class FinanceCalculation extends KTab {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinanceCalculation frame = new FinanceCalculation();
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
	
	public FinanceCalculation() {
		super("Finance Calculation");
		
		JLabel lblNewLabel = new JLabel("Total Expenses");
		lblNewLabel.setBounds(67, 31, 136, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Total income");
		lblNewLabel_1.setBounds(67, 174, 98, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("paid Salaries");
		lblNewLabel_2.setBounds(67, 334, 75, 30);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(103, 76, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(732, 76, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(732, 215, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("to");
		lblNewLabel_3.setBounds(236, 79, 46, 17);
		getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(292, 76, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Expenses");
		btnNewButton.setBounds(448, 75, 89, 23);
		getContentPane().add(btnNewButton);
		
		textField_4 = new JTextField();
		textField_4.setBounds(103, 215, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label = new JLabel("to");
		label.setBounds(236, 218, 46, 17);
		getContentPane().add(label);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(303, 215, 86, 20);
		getContentPane().add(textField_5);
		
		JButton btnIncome = new JButton("Income");
		btnIncome.setBounds(448, 214, 89, 23);
		getContentPane().add(btnIncome);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(103, 390, 86, 20);
		getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(303, 390, 86, 20);
		getContentPane().add(textField_7);
		
		JLabel label_1 = new JLabel("to");
		label_1.setBounds(236, 392, 46, 17);
		getContentPane().add(label_1);
		
		JButton btnPaidSalrries = new JButton("Paid Salaries");
		btnPaidSalrries.setBounds(448, 389, 98, 23);
		getContentPane().add(btnPaidSalrries);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(732, 390, 86, 20);
		getContentPane().add(textField_8);
		
		JLabel lblNewLabel_4 = new JLabel("Calculate the finance report ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(266, 11, 355, 20);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Calculation");
		btnNewButton_1.setBounds(652, 535, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		textField_9 = new JTextField();
		textField_9.setBounds(357, 531, 217, 30);
		getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JLabel label_2 = new JLabel("paid Salaries");
		label_2.setBounds(582, 385, 75, 30);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Total income");
		label_3.setBounds(578, 210, 98, 30);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Total Expenses");
		label_4.setBounds(578, 71, 136, 30);
		getContentPane().add(label_4);
		
		JLabel lblNewLabel_5 = new JLabel("Profit or Lost");
		lblNewLabel_5.setBounds(148, 539, 98, 14);
		getContentPane().add(lblNewLabel_5);

	}

}
