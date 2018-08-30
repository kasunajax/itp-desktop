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
		lblNewLabel.setBounds(28, 31, 85, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Generate Report");
		btnNewButton.setBounds(330, 374, 130, 23);
		getContentPane().add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Monthly Payroll Report");
		chckbxNewCheckBox.setBounds(28, 92, 138, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Commission Report");
		chckbxNewCheckBox_1.setBounds(28, 153, 138, 23);
		getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Target Bonus Report");
		chckbxNewCheckBox_2.setBounds(28, 219, 138, 23);
		getContentPane().add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Employee Payroll Report");
		chckbxNewCheckBox_3.setBounds(28, 283, 153, 23);
		getContentPane().add(chckbxNewCheckBox_3);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(203, 92, 99, 20);
		getContentPane().add(monthChooser);
		

	}
}
