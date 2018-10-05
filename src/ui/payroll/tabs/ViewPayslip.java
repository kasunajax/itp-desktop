package ui.payroll.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ViewPayslip extends KTab {
	private JTextField empID;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	
	//notes

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
		lblNewLabel.setBounds(83, 75, 126, 14);
		getContentPane().add(lblNewLabel);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(80, 99, 769, 106);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		empID = new JTextField();
		empID.setBounds(153, 60, 104, 20);
		panel.add(empID);
		empID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setBounds(37, 62, 93, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("You can view the last paid salary statement here");
		lblNewLabel_2.setBounds(36, 25, 338, 14);
		panel.add(lblNewLabel_2);
		
		JButton display = new JButton("View Salary Statement");
		display.setBounds(368, 58, 169, 23);
		panel.add(display);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(80, 232, 769, 358);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Salary ID");
		lblNewLabel_3.setBounds(28, 4, 120, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Salary Profile ID:");
		lblNewLabel_4.setBounds(28, 27, 120, 21);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblAccountedFrom = new JLabel("Accounted from");
		lblAccountedFrom.setBounds(28, 46, 120, 21);
		panel_1.add(lblAccountedFrom);
		
		JLabel lblAccountedTo = new JLabel("Accounted to");
		lblAccountedTo.setBounds(349, 50, 120, 21);
		panel_1.add(lblAccountedTo);
		
		JLabel lblBasic = new JLabel("Basic");
		lblBasic.setBounds(28, 89, 120, 13);
		panel_1.add(lblBasic);
		
		JLabel lblEpfContribution = new JLabel("Additions");
		lblEpfContribution.setBounds(28, 133, 120, 13);
		panel_1.add(lblEpfContribution);
		
		JLabel lblTargetBonus = new JLabel("Target Bonus");
		lblTargetBonus.setBounds(28, 179, 120, 21);
		panel_1.add(lblTargetBonus);
		
		JLabel lblStarBonus = new JLabel("Star Bonus");
		lblStarBonus.setBounds(28, 202, 120, 21);
		panel_1.add(lblStarBonus);
		
		JLabel lblEpf = new JLabel("EPF");
		lblEpf.setBounds(28, 267, 60, 21);
		panel_1.add(lblEpf);
		
		JLabel lblSalesPenalty = new JLabel("Sales Commission");
		lblSalesPenalty.setBounds(28, 156, 120, 21);
		panel_1.add(lblSalesPenalty);
		
		JLabel lblDeductions = new JLabel("Deductions");
		lblDeductions.setBounds(28, 244, 120, 21);
		panel_1.add(lblDeductions);
		
		JLabel lblNetSalary = new JLabel("Net Salary");
		lblNetSalary.setBounds(28, 322, 120, 21);
		panel_1.add(lblNetSalary);
		
		JLabel lblPaymentDate = new JLabel("Paid On");
		lblPaymentDate.setBounds(349, 4, 120, 21);
		panel_1.add(lblPaymentDate);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(151, 4, 120, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(151, 27, 120, 21);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(151, 46, 120, 21);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(456, 45, 120, 23);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(151, 89, 120, 21);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(151, 156, 120, 21);
		panel_1.add(textField_5);
		
		JLabel label = new JLabel("Sales Penalty");
		label.setBounds(28, 290, 120, 21);
		panel_1.add(label);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(151, 179, 120, 21);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(151, 202, 120, 21);
		panel_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(151, 290, 120, 21);
		panel_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(151, 264, 120, 24);
		panel_1.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(151, 321, 120, 24);
		panel_1.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(456, 4, 120, 21);
		panel_1.add(textField_11);
		
		JLabel lblOtherInformation = new JLabel("Other information");
		lblOtherInformation.setBounds(353, 97, 137, 21);
		panel_1.add(lblOtherInformation);
		
		JLabel lblNumberOfWorking = new JLabel("Number of Working Days");
		lblNumberOfWorking.setBounds(349, 144, 183, 25);
		panel_1.add(lblNumberOfWorking);
		
		JLabel lblEpfEmployerContribution = new JLabel("EPF Employer contribution");
		lblEpfEmployerContribution.setBounds(349, 179, 204, 21);
		panel_1.add(lblEpfEmployerContribution);
		
		JLabel lblEtfEmployerContribution = new JLabel("ETF Employer contribution");
		lblEtfEmployerContribution.setBounds(349, 208, 183, 19);
		panel_1.add(lblEtfEmployerContribution);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(504, 144, 110, 21);
		panel_1.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(504, 175, 110, 21);
		panel_1.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(504, 202, 110, 25);
		panel_1.add(textField_14);
		
		
		
		
		
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EmpID = empID.getText();
				String mpID, pID, sDate, eDate, bas, comm, aBon, eBon, pen, empEpf, net, pDate, wDays, emprEpf, etf;
				
				
				try {
					String sql = "Select * from monthly_pay where Monthly_Payroll_ID IN (Select MAX(Monthly_Payroll_ID) from monthly_pay where Payroll_ID IN (select PayrollID from payroll where EmpID = '"+EmpID+"'))";
					//String sql = " Select * from monthly_pay";
					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            		ResultSet rs = stmt.executeQuery();
            		
            		if (rs.next()) {
                       mpID = rs.getString(1);
                       pID = rs.getString(2);
                       sDate = rs.getString(3);
                       eDate = rs.getString(4);
                       bas = rs.getString(5);
                       comm = rs.getString(6);
                       aBon = rs.getString(7);
                       eBon = rs.getString(8);
                       pen = rs.getString(9);
                       empEpf = rs.getString(10);
                       net = rs.getString(11);
                       pDate = rs.getString(12);
                       wDays = rs.getString(13);
                       emprEpf = rs.getString(14);
                       etf = rs.getString(15);
            			
                       textField.setText(mpID);
                       textField_1.setText(pID);
                       textField_2.setText(sDate);
                       textField_3.setText(eDate);
                       textField_4.setText(bas);
                       textField_5.setText(comm);
                       textField_6.setText(aBon);
                       textField_7.setText(eBon);
                       textField_8.setText(pen);
                       textField_9.setText(empEpf);
                       textField_10.setText(net);
                       textField_11.setText(pDate);
                       textField_12.setText(wDays);
                       textField_13.setText(emprEpf);
                       textField_14.setText(etf);
                       
                       
            		}
            		else {
            			JOptionPane.showMessageDialog(null, "Could not find any records.");
            			
            		}
				}catch (SQLException es) {
					
				}
			}
		});

	}
}
