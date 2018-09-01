package ui.employees.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import ui.components.KTab;

import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerModel;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Attendance extends KTab {
	private JTextField txtEmployeeID;
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

	
	private JDateChooser CDate;
	/**
	 * Create the frame.
	 */
	public Attendance() {
		
		JLabel lblFullName = new JLabel("Full Name            :");
		lblFullName.setBounds(26, 46, 95, 20);
		getContentPane().add(lblFullName);
		
		JTextArea txtAFullName = new JTextArea();
		txtAFullName.setDisabledTextColor(SystemColor.textInactiveText);
		txtAFullName.setBackground(Color.LIGHT_GRAY);
		txtAFullName.setBounds(131, 44, 110, 22);
		getContentPane().add(txtAFullName);
		
		JLabel lblEmployeeId = new JLabel("Employee ID       :");
		lblEmployeeId.setBounds(26, 81, 95, 20);
		getContentPane().add(lblEmployeeId);
		
		JLabel lblEmployeeType = new JLabel("Employee Type   :");
		lblEmployeeType.setBounds(26, 114, 95, 20);
		getContentPane().add(lblEmployeeType);
		
		JComboBox cmbType = new JComboBox();
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"Select Type", "DEPARTMENT_EMPLOYEE", "DEPARTMENT_MANAGER", "REGIONAL_MANAGER", "REGIONAL_STAFF", "COORDINATOR"}));
		cmbType.setBounds(131, 112, 110, 20);
		getContentPane().add(cmbType);
		
		JLabel lblDate = new JLabel("Date                    :");
		lblDate.setBounds(295, 47, 95, 20);
		getContentPane().add(lblDate);
		
		CDate = new JDateChooser();
		CDate.setBounds(400, 46, 110, 20);
		getContentPane().add(CDate);
		
		JLabel lblStartTime = new JLabel("Start Time           :");
		lblStartTime.setBounds(295, 80, 95, 20);
		getContentPane().add(lblStartTime);
		
		JLabel lblEndTime = new JLabel("End Time             :");
		lblEndTime.setBounds(295, 113, 95, 20);
		getContentPane().add(lblEndTime);
		
		JLabel lblFullName_1 = new JLabel("Route                 :");
		lblFullName_1.setBounds(296, 145, 95, 20);
		getContentPane().add(lblFullName_1);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Select Route", "COLR1", "COLR2", "COLR5", "COL3", "KANR1", "KANR2"}));
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
		
		txtEmployeeID = new JTextField();
		txtEmployeeID.setBounds(131, 79, 110, 20);
		getContentPane().add(txtEmployeeID);
		txtEmployeeID.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(131, 143, 110, 20);
		getContentPane().add(textField_1);
		
		JLabel lblPaidLeave = new JLabel("Paid Leave          :");
		lblPaidLeave.setBounds(566, 48, 95, 20);
		getContentPane().add(lblPaidLeave);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Current leave count", "1 ", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		comboBox_5.setBounds(671, 47, 110, 22);
		getContentPane().add(comboBox_5);
		
		JLabel lblNoPayLeave = new JLabel("No Pay leave      :");
		lblNoPayLeave.setBounds(566, 83, 95, 20);
		getContentPane().add(lblNoPayLeave);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setEditable(true);
		comboBox_6.setBounds(671, 82, 110, 22);
		getContentPane().add(comboBox_6);
		
		JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
		timeSpinner.setLocation(400, 110);
		timeSpinner.setSize(110, 22);
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss a");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date());
		getContentPane().add(timeSpinner);
		
		JSpinner timeSpinner1 = new JSpinner( new SpinnerDateModel() );
		timeSpinner1.setLocation(400, 111);
		timeSpinner1.setSize(110, 22);
		timeSpinner1.setLocation(400, 77);
		timeSpinner1.setSize(110, 22);
		JSpinner.DateEditor timeEditor1 = new JSpinner.DateEditor(timeSpinner1, "HH:mm:ss a");
		timeSpinner1.setEditor(timeEditor1);
		timeSpinner1.setValue(new Date());
		getContentPane().add(timeSpinner1);

	}
}
