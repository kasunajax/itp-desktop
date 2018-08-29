package ui.employees.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.components.KTab;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollBar;

public class DealerInfo extends KTab {
	private JTable table;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;
	private JTextField textField_7;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField textField_1;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DealerInfo frame = new DealerInfo();
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
	public DealerInfo() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 244, 959, 275);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setRowHeaderView(table);
		
		JLabel lblNewLabel = new JLabel("Full Name         :");
		lblNewLabel.setBounds(26, 44, 95, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblIvrNo = new JLabel("IVR No            :");
		lblIvrNo.setBounds(26, 137, 95, 20);
		getContentPane().add(lblIvrNo);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(131, 137, 110, 20);
		getContentPane().add(textField_3);
		
		JLabel lblContactNo = new JLabel("Contact No      :");
		lblContactNo.setBounds(26, 168, 95, 20);
		getContentPane().add(lblContactNo);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(131, 168, 110, 20);
		getContentPane().add(textField_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setDisabledTextColor(new Color(109, 109, 109));
		textArea.setBounds(131, 42, 110, 22);
		getContentPane().add(textArea);
		
		JLabel lblJoinedDate = new JLabel("Joined Date     :");
		lblJoinedDate.setBounds(287, 108, 95, 20);
		getContentPane().add(lblJoinedDate);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(392, 108, 110, 20);
		getContentPane().add(textField);
		
		JLabel lblAddress = new JLabel("Address           :");
		lblAddress.setBounds(287, 77, 95, 20);
		getContentPane().add(lblAddress);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(392, 77, 110, 20);
		getContentPane().add(textField_7);
		
		JLabel lblExecutivesid = new JLabel("Executive ID    :");
		lblExecutivesid.setBounds(26, 106, 95, 20);
		getContentPane().add(lblExecutivesid);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(131, 106, 110, 20);
		getContentPane().add(textField_2);
		
		JLabel label_1 = new JLabel("Region             :");
		label_1.setBounds(287, 44, 95, 20);
		getContentPane().add(label_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(392, 44, 110, 20);
		getContentPane().add(textField_6);
		
		JLabel lblDealerid = new JLabel("DealerID          :");
		lblDealerid.setBounds(26, 75, 95, 20);
		getContentPane().add(lblDealerid);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(131, 75, 110, 20);
		getContentPane().add(textField_1);
		
		JLabel label_3 = new JLabel("Fixed No          :");
		label_3.setBounds(26, 199, 95, 20);
		getContentPane().add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(131, 199, 110, 20);
		getContentPane().add(textField_5);
		
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

	}
}
