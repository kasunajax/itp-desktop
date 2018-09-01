package ui.payroll.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MonthlyPayroll extends KTab {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonthlyPayroll frame = new MonthlyPayroll();
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
	public MonthlyPayroll() {
		super("Monthly Payroll");
		
		JLabel lblNewLabel = new JLabel("Monthly Payroll");
		lblNewLabel.setBounds(68, 65, 86, 14);
		getContentPane().add(lblNewLabel);
		
		JTextPane txtpnSelectTheDates = new JTextPane();
		txtpnSelectTheDates.setText("Select the dates to define the period of salary payment and complete the calculation");
		txtpnSelectTheDates.setBounds(68, 90, 486, 20);
		getContentPane().add(txtpnSelectTheDates);
		
		JLabel lblNewLabel_1 = new JLabel("Start Date");
		lblNewLabel_1.setBounds(65, 168, 67, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("End Date");
		lblNewLabel_2.setBounds(68, 205, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Calculate Payroll");
		btnNewButton.setBounds(410, 177, 133, 23);
		getContentPane().add(btnNewButton);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(230, 168, 117, 20);
		getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(230, 199, 117, 20);
		getContentPane().add(dateChooser_1);
		
		JButton btnNewButton_1 = new JButton("Print Payslips");
		btnNewButton_1.setBounds(410, 325, 123, 23);
		getContentPane().add(btnNewButton_1);
		
		JTextPane txtpnPrintThePayslips = new JTextPane();
		txtpnPrintThePayslips.setText("Print the payslips only after payment processing");
		txtpnPrintThePayslips.setBounds(68, 328, 282, 20);
		getContentPane().add(txtpnPrintThePayslips);

	}
}
