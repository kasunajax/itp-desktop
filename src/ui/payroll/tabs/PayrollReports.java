package ui.payroll.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JCheckBox;

public class PayrollReports extends KTab {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayrollReports frame = new PayrollReports();
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
	public PayrollReports() {
		super("Payroll Reports");
		
		JLabel lblNewLabel = new JLabel("Payroll Reports");
		lblNewLabel.setBounds(67, 70, 85, 23);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Generate Report");
		btnNewButton.setBounds(330, 374, 130, 23);
		getContentPane().add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Monthly Payroll Report");
		chckbxNewCheckBox.setBounds(84, 127, 138, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Commission Report");
		chckbxNewCheckBox_1.setBounds(84, 181, 138, 23);
		getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Target Bonus Report");
		chckbxNewCheckBox_2.setBounds(84, 238, 138, 23);
		getContentPane().add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Employee Payroll Report");
		chckbxNewCheckBox_3.setBounds(84, 295, 153, 23);
		getContentPane().add(chckbxNewCheckBox_3);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(306, 127, 99, 20);
		getContentPane().add(monthChooser);
		

	}
}
