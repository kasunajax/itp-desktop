package ui.payroll.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ViewPayslip extends KTab {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPayslip frame = new ViewPayslip();
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
	public ViewPayslip() {
		super("View Payslip");
		
		JLabel lblNewLabel = new JLabel("View Monthly Payslip");
		lblNewLabel.setBounds(70, 65, 126, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setBounds(70, 102, 93, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Month");
		lblNewLabel_2.setBounds(70, 150, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(184, 99, 104, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setBounds(184, 146, 104, 22);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(476, 98, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBounds(476, 196, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Print");
		btnNewButton_2.setBounds(476, 146, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Employee ID", null},
				{"Employee Name", null},
				{"Designation", null},
				{"Payroll Month", null},
				{"Number of working days", null},
				{"Basic Salary", null},
				{"EPF Employee", null},
				{"EPF Employer", null},
				{"ETF", null},
				{"Commission paid", null},
				{"Target Bonus", null},
				{"Target Penalty", null},
				{"Net Salary", null},
			},
			new String[] {
				"Title", "Value"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(147);
		table.getColumnModel().getColumn(1).setPreferredWidth(145);
		table.setBounds(42, 598, 453, -313);
		getContentPane().add(table);

	}
}
