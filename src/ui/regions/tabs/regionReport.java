package ui.regions.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class regionReport extends KTab {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regionReport frame = new regionReport();
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
	public regionReport() {
		super("Sales");
		
		JLabel lblNewLabel = new JLabel("Reports");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(60, 50, 920, 23);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboMonth = new JComboBox();
		comboMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "Februay", "March", "Aipril", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboMonth.setBounds(152, 220, 162, 20);
		getContentPane().add(comboMonth);
		
		JLabel lblNewLabel_2 = new JLabel("Type : ");
		lblNewLabel_2.setBounds(60, 123, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JComboBox comboReportType = new JComboBox();
		comboReportType.setModel(new DefaultComboBoxModel(new String[] {"Inventory Report", "Sales Report"}));
		comboReportType.setBounds(152, 120, 162, 20);
		getContentPane().add(comboReportType);

		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton rdbtnYearly = new JRadioButton("Yearly ");
		rdbtnYearly.setBounds(249, 166, 65, 23);
		getContentPane().add(rdbtnYearly);
		
		JRadioButton rdbtnMonthly = new JRadioButton("Mothly");
		rdbtnMonthly.setBounds(152, 167, 65, 21);
		getContentPane().add(rdbtnMonthly);
		
		bg.add(rdbtnMonthly);
		bg.add(rdbtnYearly);
		
		JLabel lblNewLabel_1 = new JLabel("Frequency :");
		lblNewLabel_1.setBounds(60, 170, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Month :");
		lblNewLabel_3.setBounds(60, 223, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Year :");
		lblNewLabel_4.setBounds(60, 261, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JComboBox comboYear = new JComboBox();
		comboYear.setModel(new DefaultComboBoxModel(new String[] {"2017", "2016", "2015", "2014", "2013"}));
		comboYear.setBounds(152, 257, 162, 20);
		getContentPane().add(comboYear);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(785, 500, 79, 23);
		getContentPane().add(btnNewButton);
	}
}
