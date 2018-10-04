package ui.payroll.tabs;

import java.awt.EventQueue;
import java.text.*;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;

public class MonthlyPayroll extends KTab {
	private JTextField days;
	private JTable table;
	Date payday;

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
		
		JPanel panel = new JPanel();
		panel.setBounds(68, 138, 602, 177);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Start Date");
		lblNewLabel_1.setBounds(42, 35, 89, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("End Date");
		lblNewLabel_2.setBounds(42, 78, 89, 21);
		panel.add(lblNewLabel_2);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(235, 78, 117, 20);
		panel.add(dateChooser_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(235, 36, 117, 20);
		panel.add(dateChooser);
		
		JButton btnNewButton = new JButton("Calculate Payroll");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//common for all records
				//Date sDate, eDate;
				int numOfDays = Integer.parseInt(days.getText());
				//sDate = dateChooser.getDate();
				//eDate = dateChooser_1.getDate();
				
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String sDate = sdf.format(dateChooser.getDate());
				
				String eDate = sdf.format(dateChooser_1.getDate());
				
				
				payday = new Date();
				String sql = "select * from payroll";
				
				try {
				PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            
	            //specific to single record
	            int payrollID, wDays;
				String empID, cat, sql1;
				double bsal, comm, ta, te, tp, eEmployee, eEmployer, etf;
				double bsalCal, sales, target, commCal=0, taCal=0, teCal = 0, tpCal=0, epfCalEmpe, epfCalEmpr, etfCal, netSal, add, deduct;
				
	            while (rs.next()) {
	            	payrollID = rs.getInt(1);
	            	empID = rs.getString(2);
	            	cat =rs.getString(3);
	            	bsal = rs.getDouble(4);
	            	comm = rs.getDouble(5);
	            	ta = rs.getDouble(6);
	            	te = rs.getDouble(7);
	            	tp = rs.getDouble(8);
	            	eEmployee = rs.getDouble(9);
	            	eEmployer = rs.getDouble(10);
	            	etf = rs.getDouble(11);
	            	
	            	sql1 = "select count (*) from attends where EmployeeID = '"+empID+"' and Date >='"+ sDate +"'and Date <= '"+eDate+"' ";
	            	PreparedStatement stmt1 = Database.getConnection().prepareStatement(sql1);
		            ResultSet rs1 = stmt1.executeQuery();
	            	wDays = rs1.getInt(1);
	            	
	            	bsalCal = (bsal/numOfDays)* wDays;
	            	epfCalEmpe = (bsalCal/100)*eEmployee;
	            	epfCalEmpr = (bsalCal/100)*eEmployer;
	            	etfCal = (bsalCal/100)*etf;
	            	
	            	if (cat == "Management") {
	            		commCal = 0;
	            		taCal = 0;
	            		teCal =0;
	            		tpCal = 0;
	            		
	            	}
	            	else if (cat == "Sales") {
	            		sql1 = "select sum(cost) from items where Executive = '"+empID+"' and Sold_Date >='"+ sDate +"'and Sold_Date <= '"+eDate+"'";
		            	stmt1 = Database.getConnection().prepareStatement(sql1);
			            rs1 = stmt1.executeQuery();
		            	
		            	sales = rs1.getDouble(1);
		            	
		            	sql1="select SalesTargets from sales_executives where EmployeeID = '"+empID+"'";
		            	stmt1 = Database.getConnection().prepareStatement(sql1);
			            rs1 = stmt1.executeQuery();
			            
			            target = rs1.getDouble(1);
			            
			            if (sales == target) {
			            	commCal = (sales/100.0)*comm;
			            	taCal = (sales/100.0)*ta;
			            	tpCal =0;
			            } else if (sales > target) {
			            	commCal = (sales/100.0)*comm;
			            	taCal = (sales/100.0)*ta;
			            	teCal = (sales/100.0)*te;
			            	tpCal =0.;
			            } else if (sales < target) {
			            	commCal = (sales/100.0)*comm;
			            	taCal = 0;
			            	teCal =0;
			            	tpCal = ((target - sales)/100)*tp;
			            }
			            
			           
	            	}
	            	
	            	 add = commCal + taCal + teCal;
			         deduct = tpCal + epfCalEmpe;
			         netSal = (bsalCal + add) - deduct;
			            
			         sql1 = "INSERT INTO monthly_pay (Payroll_ID, Basic_calc, Comm_calc, Target_Achieved_Bonus_calc, Target_Exceeded_Bonus_calc, Target_Penalty_calc, EPF_Employee_calc, Net_Salary, Payment_Date, Working_Days, EPF_Employer_calc, ETF_calc) VALUES ('"+payrollID+"', '"+commCal+"', '"+taCal+"', '"+teCal+"', '"+epfCalEmpe+"', '"+netSal+"', '"+payday+"', '"+wDays+"', '"+epfCalEmpr+"', '"+etfCal+"')";
				            	
	            
	            }
	            
	            tableLoad();
	            
				}catch (SQLException es) {
					es.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(417, 129, 133, 23);
		panel.add(btnNewButton);
		
		JLabel lblWorkingDaysFor = new JLabel("Working days for the month");
		lblWorkingDaysFor.setBounds(41, 131, 184, 18);
		panel.add(lblWorkingDaysFor);
		
		days = new JTextField();
		days.setBounds(235, 131, 52, 19);
		panel.add(days);
		days.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(68, 357, 758, 266);
		getContentPane().add(panel_1);
		
		table = new JTable();
		panel_1.add(table);
		
		

	}
	
	public void tableLoad(){
		
        try{
            String sql2 = "select * from monthly_pay where Payment_Date ='"+payday+"'";
            PreparedStatement stmt2 = Database.getConnection().prepareStatement(sql2);
            ResultSet rs2 = stmt2.executeQuery();
            
            table.setModel(Database.resultSetToTableModel(rs2));
            
        
        }catch(SQLException e){}
    }
}


