package ui.payroll.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

public class NewEmployeeSalary extends KTab {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewEmployeeSalary frame = new NewEmployeeSalary();
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
	public NewEmployeeSalary() {
		super("New Employee Payroll");
		
		JLabel lblNewLabel = new JLabel("New Employee Payroll");
		lblNewLabel.setBounds(32, 26, 123, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setBounds(32, 111, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(205, 108, 110, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Basic Salary");
		lblNewLabel_2.setBounds(32, 274, 86, 14);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Validate");
		btnNewButton.setBounds(366, 107, 89, 23);
		getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(205, 271, 110, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Commission %");
		lblNewLabel_3.setBounds(32, 309, 86, 14);
		getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(205, 306, 110, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("EPF Employee Contribution");
		lblNewLabel_4.setBounds(32, 460, 149, 14);
		getContentPane().add(lblNewLabel_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("8%");
		rdbtnNewRadioButton.setBounds(205, 456, 51, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("9%");
		rdbtnNewRadioButton_1.setBounds(312, 456, 46, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("Payment Type");
		lblNewLabel_7.setBounds(32, 516, 76, 14);
		getContentPane().add(lblNewLabel_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bank Transfer", "Cheque", "Cash"}));
		comboBox.setBounds(205, 512, 110, 22);
		getContentPane().add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBounds(269, 574, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setBounds(434, 574, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JTextPane txtpnFvhyugkkl = new JTextPane();
		txtpnFvhyugkkl.setText("Add new employee payroll details below after validating the employee using employee ID");
		txtpnFvhyugkkl.setBounds(32, 51, 536, 20);
		getContentPane().add(txtpnFvhyugkkl);
		
		JLabel lblNewLabel_6 = new JLabel("Employee Name");
		lblNewLabel_6.setBounds(32, 158, 86, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Designation");
		lblNewLabel_8.setBounds(32, 185, 76, 14);
		getContentPane().add(lblNewLabel_8);
		
		JTextPane txtpnGlrwughruh = new JTextPane();
		txtpnGlrwughruh.setBounds(205, 158, 267, 20);
		getContentPane().add(txtpnGlrwughruh);
		
		JTextPane txtpnDycyhgfjl = new JTextPane();
		txtpnDycyhgfjl.setBounds(205, 185, 267, 20);
		getContentPane().add(txtpnDycyhgfjl);
		
		JTextPane txtpnepfEmployerContribution = new JTextPane();
		txtpnepfEmployerContribution.setText("**EPF Employer Contribution will be 12% and ETF will be 3% for all employees");
		txtpnepfEmployerContribution.setBounds(32, 485, 472, 20);
		getContentPane().add(txtpnepfEmployerContribution);
		
		JLabel lblNewLabel_5 = new JLabel("Target Bonus %");
		lblNewLabel_5.setBounds(32, 345, 86, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_9 = new JLabel("Achieved");
		lblNewLabel_9.setBounds(135, 345, 46, 14);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Exceeded");
		lblNewLabel_10.setBounds(135, 376, 66, 14);
		getContentPane().add(lblNewLabel_10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(205, 342, 51, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(205, 373, 51, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Target Penalty %");
		lblNewLabel_11.setBounds(32, 416, 99, 14);
		getContentPane().add(lblNewLabel_11);
		
		textField_5 = new JTextField();
		textField_5.setBounds(204, 413, 86, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Category");
		lblNewLabel_12.setBounds(32, 239, 46, 14);
		getContentPane().add(lblNewLabel_12);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Management");
		rdbtnNewRadioButton_2.setBounds(206, 235, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Sales");
		rdbtnNewRadioButton_3.setBounds(346, 235, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_3);

	}
}
