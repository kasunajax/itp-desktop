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

public class ViewPayslip extends KTab {
	private JTextField empID;
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
		lblNewLabel.setBounds(80, 78, 126, 14);
		getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(80, 295, 739, 229);
		getContentPane().add(panel_1);
		
		table = new JTable();
		panel_1.add(table);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(80, 99, 438, 171);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox month = new JComboBox();
		month.setBounds(203, 63, 73, 19);
		panel.add(month);
		month.setModel(new DefaultComboBoxModel(new String[] {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		
		empID = new JTextField();
		empID.setBounds(203, 25, 104, 20);
		panel.add(empID);
		empID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setBounds(56, 25, 93, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Month");
		lblNewLabel_2.setBounds(56, 65, 46, 14);
		panel.add(lblNewLabel_2);
		
		JButton display = new JButton("Display");
		display.setBounds(247, 109, 89, 23);
		panel.add(display);
		
		
		
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EmpID = empID.getText();
				String mon = (String)month.getSelectedItem();
				
				
				String sql = "select * from monthly_pay where Salary_Month = '"+mon+"' and Payroll_ID IN (select PayrollID from payroll where EmpID = '"+EmpID+"')";
				try {
					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            		ResultSet rs = stmt.executeQuery();
            		
            		if (rs.next()) {
                       table.setModel(Database.resultSetToTableModel(rs));
            			
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
