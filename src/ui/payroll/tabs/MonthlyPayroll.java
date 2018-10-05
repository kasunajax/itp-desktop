package ui.payroll.tabs;

import java.awt.EventQueue;
import java.text.*;

import ui.components.KTab;
import utils.common.database.Database;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MonthlyPayroll extends KTab {
	private JTextField days;
	String payday;
	private JTable table;

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
				payday = sdf.format(new Date());
				
				String sDate = sdf.format(dateChooser.getDate());
				String eDate = sdf.format(dateChooser_1.getDate());

				
				String sql = "select * from payroll";
				
				try {
				PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            
	            //specific to single record
	            int payrollID, wDays;
				String empID, cat, sql1, sql4;
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
	            	
	            	sql1 = "select count(Date) from attends where EmployeeID = '"+empID+"' and Date >='"+ sDate +"'and Date <= '"+eDate+"' ";
	            	PreparedStatement stmt1 = Database.getConnection().prepareStatement(sql1);
		            ResultSet rs1 = stmt1.executeQuery();
		            rs1.next();
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
	            		String sql2, sql3;
	            		sql2 = "select sum(cost) from items where Executive = '"+empID+"' and Sold_Date >='"+ sDate +"'and Sold_Date <= '"+eDate+"'";
	            		PreparedStatement stmt2 = Database.getConnection().prepareStatement(sql2);
			            ResultSet rs2 = stmt2.executeQuery();
		            	
		            	sales = rs2.getDouble(1);
		            	
		            	sql3="select SalesTargets from sales_executives where EmployeeID = '"+empID+"'";
		            	PreparedStatement stmt3 = Database.getConnection().prepareStatement(sql3);
			            ResultSet rs3 = stmt3.executeQuery();
			            
			            target = rs3.getDouble(1);
			            
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
			            
			         sql4 = "INSERT INTO monthly_pay (Payroll_ID, StartDate, EndDate, Basic_calc, Comm_calc, Target_Achieved_Bonus_calc, Target_Exceeded_Bonus_calc, Target_Penalty_calc, EPF_Employee_calc, Net_Salary, Payment_Date, Working_Days, EPF_Employer_calc, ETF_calc) VALUES ('"+payrollID+"', '"+sDate+"', '"+eDate + "','"+bsalCal+"','"+commCal+"', '"+taCal+"', '"+teCal+"', '"+tpCal+"','"+epfCalEmpe+"', '"+netSal+"', '"+payday+"', '"+wDays+"', '"+epfCalEmpr+"', '"+etfCal+"')";
			         PreparedStatement stmt4 = Database.getConnection().prepareStatement(sql4);
			         stmt4.execute();
	            
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 344, 855, 248);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "ProfileID", "From", "To", "Basic", "Comm", "TargetBonus", "StarBonus", "Penalty", "EPF", "Net", "PaidOn", "WorkedDays", "EPF Employer", "ETF"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.getColumnModel().getColumn(7).setPreferredWidth(60);
		table.getColumnModel().getColumn(8).setPreferredWidth(50);
		table.getColumnModel().getColumn(9).setPreferredWidth(50);
		table.getColumnModel().getColumn(10).setPreferredWidth(70);
		table.getColumnModel().getColumn(11).setPreferredWidth(50);
		table.getColumnModel().getColumn(12).setPreferredWidth(30);
		table.getColumnModel().getColumn(13).setPreferredWidth(50);
		table.getColumnModel().getColumn(14).setPreferredWidth(50);
		scrollPane.setViewportView(table);
		
		

	}
	
	public void tableLoad(){
		
        try{
            String sql5 = "select * from monthly_pay where Payment_Date ='"+payday+"'";
            PreparedStatement stmt5 = Database.getConnection().prepareStatement(sql5);
            ResultSet rs5 = stmt5.executeQuery();
            
            table.setModel(Database.resultSetToTableModel(rs5));
            
        
        }catch(SQLException e){}
    }
}


