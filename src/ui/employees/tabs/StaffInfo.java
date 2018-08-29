package ui.employees.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.components.KTab;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StaffInfo extends KTab {
	private JTable table;
	private JLabel label_12;
	private JTextField textField_9;
	private JLabel label_13;
	private JTextField textField_10;
	private JLabel label_14;
	private JTextField textField_11;
	private JLabel label_15;
	private JTextField textField_12;
	private JLabel label_16;
	private JTextField textField_13;
	private JLabel label_17;
	private JTextField textField_14;
	private JLabel label_6;
	private JTextField textField_4;
	private JLabel label_7;
	private JTextField textField_5;
	private JLabel label_8;
	private JTextField textField_6;
	private JLabel label_9;
	private JTextField textField_7;
	private JLabel label_10;
	private JTextField textField_8;
	private JLabel label_11;
	private JComboBox comboBox_2;
	private JLabel label;
	private JTextField textField;
	private JLabel label_1;
	private JTextField textField_1;
	private JLabel label_2;
	private JTextField textField_2;
	private JLabel label_3;
	private JComboBox comboBox;
	private JLabel label_4;
	private JComboBox comboBox_1;
	private JLabel label_5;
	private JTextField textField_3;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffInfo frame = new StaffInfo();
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
	public StaffInfo() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 245, 959, 271);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		label_12 = new JLabel("EmployeeID    :");
		label_12.setBounds(481, 44, 89, 20);
		getContentPane().add(label_12);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(571, 44, 110, 20);
		getContentPane().add(textField_9);
		
		label_13 = new JLabel("IVR No            :");
		label_13.setBounds(481, 75, 89, 20);
		getContentPane().add(label_13);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(571, 75, 110, 20);
		getContentPane().add(textField_10);
		
		label_14 = new JLabel("Start Date      :");
		label_14.setBounds(481, 106, 89, 20);
		getContentPane().add(label_14);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(571, 106, 110, 20);
		getContentPane().add(textField_11);
		
		label_15 = new JLabel("End Date        :");
		label_15.setBounds(481, 137, 89, 20);
		getContentPane().add(label_15);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(571, 137, 110, 20);
		getContentPane().add(textField_12);
		
		label_16 = new JLabel(" OfficeID        :");
		label_16.setBounds(481, 168, 89, 20);
		getContentPane().add(label_16);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(571, 168, 110, 20);
		getContentPane().add(textField_13);
		
		label_17 = new JLabel("PayrollID        :");
		label_17.setBounds(481, 199, 89, 20);
		getContentPane().add(label_17);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(571, 199, 110, 20);
		getContentPane().add(textField_14);
		
		label_6 = new JLabel("Fixed Line       :");
		label_6.setBounds(253, 44, 89, 20);
		getContentPane().add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(343, 44, 110, 20);
		getContentPane().add(textField_4);
		
		label_7 = new JLabel("Address          :");
		label_7.setBounds(253, 75, 89, 20);
		getContentPane().add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(343, 75, 110, 20);
		getContentPane().add(textField_5);
		
		label_8 = new JLabel("User Name      :");
		label_8.setBounds(253, 106, 89, 20);
		getContentPane().add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(343, 106, 110, 20);
		getContentPane().add(textField_6);
		
		label_9 = new JLabel("Password        :");
		label_9.setBounds(253, 137, 89, 20);
		getContentPane().add(label_9);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(343, 137, 110, 20);
		getContentPane().add(textField_7);
		
		label_10 = new JLabel("Designation    :");
		label_10.setBounds(253, 168, 89, 20);
		getContentPane().add(label_10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(343, 168, 110, 20);
		getContentPane().add(textField_8);
		
		label_11 = new JLabel("Type               :");
		label_11.setBounds(253, 199, 89, 20);
		getContentPane().add(label_11);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(343, 199, 110, 20);
		getContentPane().add(comboBox_2);
		
		label = new JLabel("First Name      :");
		label.setBounds(26, 44, 89, 20);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(116, 44, 110, 20);
		getContentPane().add(textField);
		
		label_1 = new JLabel("Middle Name   :");
		label_1.setBounds(26, 75, 89, 20);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 75, 110, 20);
		getContentPane().add(textField_1);
		
		label_2 = new JLabel("Last Name       :");
		label_2.setBounds(26, 106, 89, 20);
		getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 106, 110, 20);
		getContentPane().add(textField_2);
		
		label_3 = new JLabel("Gender            :");
		label_3.setBounds(26, 137, 89, 20);
		getContentPane().add(label_3);
		
		comboBox = new JComboBox();
		comboBox.setBounds(116, 137, 110, 20);
		getContentPane().add(comboBox);
		
		label_4 = new JLabel("D.O.B              :");
		label_4.setBounds(26, 168, 89, 20);
		getContentPane().add(label_4);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(116, 167, 110, 20);
		getContentPane().add(comboBox_1);
		
		label_5 = new JLabel("Mobile No        :");
		label_5.setBounds(26, 199, 89, 20);
		getContentPane().add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(116, 199, 110, 20);
		getContentPane().add(textField_3);
		
		button = new JButton("Create");
		button.setBounds(855, 44, 89, 31);
		getContentPane().add(button);
		
		button_1 = new JButton("Update");
		button_1.setBounds(855, 85, 89, 31);
		getContentPane().add(button_1);
		
		button_2 = new JButton("Delete");
		button_2.setBounds(855, 128, 89, 31);
		getContentPane().add(button_2);
		
		button_3 = new JButton("Report");
		button_3.setBounds(855, 172, 89, 31);
		getContentPane().add(button_3);

	}
}
