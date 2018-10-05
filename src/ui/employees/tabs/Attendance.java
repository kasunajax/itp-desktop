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
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;

public class Attendance extends KTab {
	private JTextField textFiel10;

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
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	/**
	 * Create the frame.
	 */
	public Attendance() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 312, 959, 175);
		getContentPane().add(scrollPane);
		
		JButton button = new JButton("Create");
		button.setBounds(856, 79, 89, 31);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Update");
		button_1.setBounds(856, 121, 89, 31);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Delete");
		button_2.setBounds(856, 163, 89, 31);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Report");
		button_3.setBounds(856, 205, 89, 31);
		getContentPane().add(button_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(482, 54, 338, 150);
		panel.setBorder(new TitledBorder(null, "Leave", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{54, 54, 54, 54, 54, 54, 0};
		gbl_panel.rowHeights = new int[]{25, 0, 25, 25, 0, 0, 25, 25, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label_9 = new JLabel("");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.fill = GridBagConstraints.BOTH;
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 0;
		panel.add(label_9, gbc_label_9);
		
		JLabel label_10 = new JLabel("");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.fill = GridBagConstraints.BOTH;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 1;
		gbc_label_10.gridy = 0;
		panel.add(label_10, gbc_label_10);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		JLabel label_11 = new JLabel("");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.fill = GridBagConstraints.BOTH;
		gbc_label_11.insets = new Insets(0, 0, 5, 0);
		gbc_label_11.gridx = 5;
		gbc_label_11.gridy = 0;
		panel.add(label_11, gbc_label_11);
		
		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.BOTH;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		panel.add(label_1, gbc_label_1);
		
		JLabel label_12 = new JLabel("");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.fill = GridBagConstraints.BOTH;
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 1;
		gbc_label_12.gridy = 2;
		panel.add(label_12, gbc_label_12);
		
		JLabel label_2 = new JLabel("");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.BOTH;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 2;
		panel.add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.BOTH;
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 5;
		gbc_label_3.gridy = 2;
		panel.add(label_3, gbc_label_3);
		
		JLabel label_13 = new JLabel("");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.fill = GridBagConstraints.BOTH;
		gbc_label_13.insets = new Insets(0, 0, 5, 5);
		gbc_label_13.gridx = 0;
		gbc_label_13.gridy = 3;
		panel.add(label_13, gbc_label_13);
		
		JLabel label_14 = new JLabel("");
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.fill = GridBagConstraints.BOTH;
		gbc_label_14.insets = new Insets(0, 0, 5, 5);
		gbc_label_14.gridx = 1;
		gbc_label_14.gridy = 3;
		panel.add(label_14, gbc_label_14);
		
		JLabel lblPaidLeave = new JLabel("Paid Leave          :");
		GridBagConstraints gbc_lblPaidLeave = new GridBagConstraints();
		gbc_lblPaidLeave.fill = GridBagConstraints.BOTH;
		gbc_lblPaidLeave.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaidLeave.gridx = 2;
		gbc_lblPaidLeave.gridy = 3;
		panel.add(lblPaidLeave, gbc_lblPaidLeave);
		
		JLabel label_4 = new JLabel("");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.fill = GridBagConstraints.BOTH;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 3;
		panel.add(label_4, gbc_label_4);
		
		JComboBox comboBox_5 = new JComboBox();
		GridBagConstraints gbc_comboBox_5 = new GridBagConstraints();
		gbc_comboBox_5.fill = GridBagConstraints.BOTH;
		gbc_comboBox_5.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_5.gridx = 4;
		gbc_comboBox_5.gridy = 3;
		panel.add(comboBox_5, gbc_comboBox_5);
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Current leave count", "1 ", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel label_15 = new JLabel("");
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.fill = GridBagConstraints.BOTH;
		gbc_label_15.insets = new Insets(0, 0, 5, 0);
		gbc_label_15.gridx = 5;
		gbc_label_15.gridy = 3;
		panel.add(label_15, gbc_label_15);
		
		JLabel lblNoPayLeave = new JLabel("No Pay leave      :");
		GridBagConstraints gbc_lblNoPayLeave = new GridBagConstraints();
		gbc_lblNoPayLeave.fill = GridBagConstraints.BOTH;
		gbc_lblNoPayLeave.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoPayLeave.gridx = 2;
		gbc_lblNoPayLeave.gridy = 4;
		panel.add(lblNoPayLeave, gbc_lblNoPayLeave);
		
		JComboBox comboBox_6 = new JComboBox();
		GridBagConstraints gbc_comboBox_6 = new GridBagConstraints();
		gbc_comboBox_6.fill = GridBagConstraints.BOTH;
		gbc_comboBox_6.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_6.gridx = 4;
		gbc_comboBox_6.gridy = 4;
		panel.add(comboBox_6, gbc_comboBox_6);
		comboBox_6.setEditable(true);
		
		JLabel lblStatus = new JLabel("Status                 :");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.fill = GridBagConstraints.BOTH;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 2;
		gbc_lblStatus.gridy = 5;
		panel.add(lblStatus, gbc_lblStatus);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 5;
		panel.add(textField, gbc_textField);
		textField.setText("");
		textField.setColumns(10);
		
		JLabel label_5 = new JLabel("");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.fill = GridBagConstraints.BOTH;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 6;
		panel.add(label_5, gbc_label_5);
		
		JLabel label_16 = new JLabel("");
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.fill = GridBagConstraints.BOTH;
		gbc_label_16.insets = new Insets(0, 0, 5, 5);
		gbc_label_16.gridx = 1;
		gbc_label_16.gridy = 6;
		panel.add(label_16, gbc_label_16);
		
		JLabel label_17 = new JLabel("");
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.fill = GridBagConstraints.BOTH;
		gbc_label_17.insets = new Insets(0, 0, 5, 5);
		gbc_label_17.gridx = 2;
		gbc_label_17.gridy = 6;
		panel.add(label_17, gbc_label_17);
		
		JLabel label_6 = new JLabel("");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.fill = GridBagConstraints.BOTH;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 3;
		gbc_label_6.gridy = 6;
		panel.add(label_6, gbc_label_6);
		
		JLabel label_18 = new JLabel("");
		GridBagConstraints gbc_label_18 = new GridBagConstraints();
		gbc_label_18.fill = GridBagConstraints.BOTH;
		gbc_label_18.insets = new Insets(0, 0, 5, 5);
		gbc_label_18.gridx = 4;
		gbc_label_18.gridy = 6;
		panel.add(label_18, gbc_label_18);
		
		JLabel label_7 = new JLabel("");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.fill = GridBagConstraints.BOTH;
		gbc_label_7.insets = new Insets(0, 0, 5, 0);
		gbc_label_7.gridx = 5;
		gbc_label_7.gridy = 6;
		panel.add(label_7, gbc_label_7);
		
		JLabel label_19 = new JLabel("");
		GridBagConstraints gbc_label_19 = new GridBagConstraints();
		gbc_label_19.fill = GridBagConstraints.BOTH;
		gbc_label_19.insets = new Insets(0, 0, 0, 5);
		gbc_label_19.gridx = 0;
		gbc_label_19.gridy = 7;
		panel.add(label_19, gbc_label_19);
		
		JLabel label_20 = new JLabel("");
		GridBagConstraints gbc_label_20 = new GridBagConstraints();
		gbc_label_20.fill = GridBagConstraints.BOTH;
		gbc_label_20.insets = new Insets(0, 0, 0, 5);
		gbc_label_20.gridx = 1;
		gbc_label_20.gridy = 7;
		panel.add(label_20, gbc_label_20);
		
		JLabel label_21 = new JLabel("");
		GridBagConstraints gbc_label_21 = new GridBagConstraints();
		gbc_label_21.fill = GridBagConstraints.BOTH;
		gbc_label_21.insets = new Insets(0, 0, 0, 5);
		gbc_label_21.gridx = 2;
		gbc_label_21.gridy = 7;
		panel.add(label_21, gbc_label_21);
		
		JLabel label_8 = new JLabel("");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.fill = GridBagConstraints.BOTH;
		gbc_label_8.insets = new Insets(0, 0, 0, 5);
		gbc_label_8.gridx = 3;
		gbc_label_8.gridy = 7;
		panel.add(label_8, gbc_label_8);
		
		JLabel label_22 = new JLabel("");
		GridBagConstraints gbc_label_22 = new GridBagConstraints();
		gbc_label_22.fill = GridBagConstraints.BOTH;
		gbc_label_22.insets = new Insets(0, 0, 0, 5);
		gbc_label_22.gridx = 4;
		gbc_label_22.gridy = 7;
		panel.add(label_22, gbc_label_22);
		
		JLabel label_23 = new JLabel("");
		GridBagConstraints gbc_label_23 = new GridBagConstraints();
		gbc_label_23.fill = GridBagConstraints.BOTH;
		gbc_label_23.gridx = 5;
		gbc_label_23.gridy = 7;
		panel.add(label_23, gbc_label_23);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(44, 44, 428, 234);
		getContentPane().add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "General Attendance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{87, 31, 292, 0};
		gbl_panel_1.rowHeights = new int[]{20, 20, 20, 20, 20, 20, 20, 20, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblFullName = new JLabel("Full Name            :");
		GridBagConstraints gbc_lblFullName = new GridBagConstraints();
		gbc_lblFullName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFullName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFullName.gridx = 0;
		gbc_lblFullName.gridy = 0;
		panel_1.add(lblFullName, gbc_lblFullName);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 0;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmployeeId = new JLabel("Employee ID       :");
		GridBagConstraints gbc_lblEmployeeId = new GridBagConstraints();
		gbc_lblEmployeeId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEmployeeId.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmployeeId.gridx = 0;
		gbc_lblEmployeeId.gridy = 1;
		panel_1.add(lblEmployeeId, gbc_lblEmployeeId);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.NORTH;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 1;
		panel_1.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmployeeType = new JLabel("Employee Type   :");
		GridBagConstraints gbc_lblEmployeeType = new GridBagConstraints();
		gbc_lblEmployeeType.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEmployeeType.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmployeeType.gridx = 0;
		gbc_lblEmployeeType.gridy = 2;
		panel_1.add(lblEmployeeType, gbc_lblEmployeeType);
		
		JComboBox cmbType = new JComboBox();
		GridBagConstraints gbc_cmbType = new GridBagConstraints();
		gbc_cmbType.anchor = GridBagConstraints.NORTH;
		gbc_cmbType.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbType.insets = new Insets(0, 0, 5, 0);
		gbc_cmbType.gridx = 2;
		gbc_cmbType.gridy = 2;
		panel_1.add(cmbType, gbc_cmbType);
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"Select Type", "DEPARTMENT_EMPLOYEE", "DEPARTMENT_MANAGER", "REGIONAL_MANAGER", "REGIONAL_STAFF", "COORDINATOR"}));
		
		JLabel lblOfficeId = new JLabel("Office ID             :");
		GridBagConstraints gbc_lblOfficeId = new GridBagConstraints();
		gbc_lblOfficeId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblOfficeId.insets = new Insets(0, 0, 5, 5);
		gbc_lblOfficeId.gridx = 0;
		gbc_lblOfficeId.gridy = 3;
		panel_1.add(lblOfficeId, gbc_lblOfficeId);
		
		textFiel10 = new JTextField();
		GridBagConstraints gbc_textFiel10 = new GridBagConstraints();
		gbc_textFiel10.anchor = GridBagConstraints.NORTH;
		gbc_textFiel10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFiel10.insets = new Insets(0, 0, 5, 0);
		gbc_textFiel10.gridx = 2;
		gbc_textFiel10.gridy = 3;
		panel_1.add(textFiel10, gbc_textFiel10);
		textFiel10.setColumns(10);
		
		JLabel lblDate = new JLabel("Date                    :");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 4;
		panel_1.add(lblDate, gbc_lblDate);
		
		CDate = new JDateChooser();
		GridBagConstraints gbc_CDate = new GridBagConstraints();
		gbc_CDate.anchor = GridBagConstraints.NORTH;
		gbc_CDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_CDate.insets = new Insets(0, 0, 5, 0);
		gbc_CDate.gridx = 2;
		gbc_CDate.gridy = 4;
		panel_1.add(CDate, gbc_CDate);
		
		JLabel lblStartTime = new JLabel("Start Time           :");
		GridBagConstraints gbc_lblStartTime = new GridBagConstraints();
		gbc_lblStartTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStartTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartTime.gridx = 0;
		gbc_lblStartTime.gridy = 5;
		panel_1.add(lblStartTime, gbc_lblStartTime);
		
		JSpinner timeSpinner1 = new JSpinner( new SpinnerDateModel() );
		GridBagConstraints gbc_timeSpinner1 = new GridBagConstraints();
		gbc_timeSpinner1.anchor = GridBagConstraints.NORTH;
		gbc_timeSpinner1.fill = GridBagConstraints.HORIZONTAL;
		gbc_timeSpinner1.insets = new Insets(0, 0, 5, 0);
		gbc_timeSpinner1.gridx = 2;
		gbc_timeSpinner1.gridy = 5;
		panel_1.add(timeSpinner1, gbc_timeSpinner1);
		JSpinner.DateEditor timeEditor1 = new JSpinner.DateEditor(timeSpinner1, "HH:mm:ss a");
		timeSpinner1.setEditor(timeEditor1);
		timeSpinner1.setValue(new Date());
		
		JLabel lblEndTime = new JLabel("End Time             :");
		GridBagConstraints gbc_lblEndTime = new GridBagConstraints();
		gbc_lblEndTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEndTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndTime.gridx = 0;
		gbc_lblEndTime.gridy = 6;
		panel_1.add(lblEndTime, gbc_lblEndTime);
		
		JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
		GridBagConstraints gbc_timeSpinner = new GridBagConstraints();
		gbc_timeSpinner.anchor = GridBagConstraints.NORTH;
		gbc_timeSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_timeSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_timeSpinner.gridx = 2;
		gbc_timeSpinner.gridy = 6;
		panel_1.add(timeSpinner, gbc_timeSpinner);
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss a");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date());
		
		JLabel lblFullName_1 = new JLabel("Route                 :");
		GridBagConstraints gbc_lblFullName_1 = new GridBagConstraints();
		gbc_lblFullName_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFullName_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblFullName_1.gridx = 0;
		gbc_lblFullName_1.gridy = 7;
		panel_1.add(lblFullName_1, gbc_lblFullName_1);
		
		JComboBox comboBox_4 = new JComboBox();
		GridBagConstraints gbc_comboBox_4 = new GridBagConstraints();
		gbc_comboBox_4.anchor = GridBagConstraints.NORTH;
		gbc_comboBox_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_4.gridx = 2;
		gbc_comboBox_4.gridy = 7;
		panel_1.add(comboBox_4, gbc_comboBox_4);
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Select Route", "COLR1", "COLR2", "COLR5", "COL3", "KANR1", "KANR2"}));

	}
}
