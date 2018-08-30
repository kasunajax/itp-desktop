package ui.employees.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.components.KTab;

import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class Attendance extends KTab {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Attendance frame = new Attendance();
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
	public Attendance() {
		
		JLabel lblFullName = new JLabel("Full Name            :");
		lblFullName.setBounds(26, 46, 95, 20);
		getContentPane().add(lblFullName);
		
		JTextArea textArea = new JTextArea();
		textArea.setDisabledTextColor(SystemColor.textInactiveText);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(131, 44, 110, 22);
		getContentPane().add(textArea);
		
		JLabel lblEmployeeId = new JLabel("Employee ID       :");
		lblEmployeeId.setBounds(26, 81, 95, 20);
		getContentPane().add(lblEmployeeId);
		
		JLabel lblEmployeeType = new JLabel("Employee Type   :");
		lblEmployeeType.setBounds(26, 114, 95, 20);
		getContentPane().add(lblEmployeeType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Item1", "Item2"}));
		comboBox.setBounds(131, 112, 110, 20);
		getContentPane().add(comboBox);
		
		JLabel lblDate = new JLabel("Date                    :");
		lblDate.setBounds(295, 47, 95, 20);
		getContentPane().add(lblDate);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(400, 46, 110, 22);
		getContentPane().add(comboBox_1);
		
		JLabel lblStartTime = new JLabel("Start Time           :");
		lblStartTime.setBounds(295, 80, 95, 20);
		getContentPane().add(lblStartTime);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(400, 79, 110, 22);
		getContentPane().add(comboBox_2);
		
		JLabel lblEndTime = new JLabel("End Time             :");
		lblEndTime.setBounds(295, 113, 95, 20);
		getContentPane().add(lblEndTime);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(400, 112, 110, 22);
		getContentPane().add(comboBox_3);
		
		JLabel lblFullName_1 = new JLabel("Route                 :");
		lblFullName_1.setBounds(296, 145, 95, 20);
		getContentPane().add(lblFullName_1);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(400, 144, 110, 22);
		getContentPane().add(comboBox_4);
		
		JLabel lblOfficeId = new JLabel("Office ID             :");
		lblOfficeId.setBounds(26, 145, 95, 20);
		getContentPane().add(lblOfficeId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 244, 959, 275);
		getContentPane().add(scrollPane);
		
		JButton button = new JButton("Create");
		button.setBounds(856, 44, 89, 31);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Update");
		button_1.setBounds(856, 85, 89, 31);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Delete");
		button_2.setBounds(855, 128, 89, 31);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Report");
		button_3.setBounds(855, 172, 89, 31);
		getContentPane().add(button_3);
		
		textField = new JTextField();
		textField.setBounds(131, 79, 110, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(131, 143, 110, 20);
		getContentPane().add(textField_1);
		
		JLabel lblPaidLeave = new JLabel("Paid Leave          :");
		lblPaidLeave.setBounds(566, 48, 95, 20);
		getContentPane().add(lblPaidLeave);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(671, 47, 110, 22);
		getContentPane().add(comboBox_5);
		
		JLabel lblNoPayLeave = new JLabel("No Pay leave      :");
		lblNoPayLeave.setBounds(566, 83, 95, 20);
		getContentPane().add(lblNoPayLeave);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(671, 82, 110, 22);
		getContentPane().add(comboBox_6);

	}
}
