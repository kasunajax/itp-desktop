package ui.finance.tabs;

import java.awt.EventQueue;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FinanceCalculation extends KTab {
	private JTextField totex;
	private JTextField totincme;
	private JTextField totsal;
	private JTextField pro;

	/**
	 * Launch the application.
	 */
	
	double income =0;
	double paidSal =0;
	double expense = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinanceCalculation frame = new FinanceCalculation();
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
	
	
	public FinanceCalculation() {
		super("Finance Calculation");
		
		JComboBox month1 = new JComboBox();
		month1.setModel(new DefaultComboBoxModel(new String[] {"Select the month", "", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		month1.setBounds(148, 79, 112, 22);
		getContentPane().add(month1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select the month", "", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setBounds(148, 231, 112, 22);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select the month", "", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_1.setBounds(148, 389, 112, 22);
		getContentPane().add(comboBox_1);
		
		JLabel label_4 = new JLabel("Total Expenses");
		label_4.setBounds(582, 75, 136, 30);
		getContentPane().add(label_4);
		
		JLabel lblNewLabel = new JLabel("Total Expenses");
		lblNewLabel.setBounds(67, 31, 136, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Total income");
		lblNewLabel_1.setBounds(67, 174, 98, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("paid Salaries");
		lblNewLabel_2.setBounds(67, 334, 75, 30);
		getContentPane().add(lblNewLabel_2);
		
		totex = new JTextField();
		totex.setBounds(732, 80, 86, 20);
		getContentPane().add(totex);
		totex.setColumns(10);
		
		totincme = new JTextField();
		totincme.setBounds(732, 232, 86, 20);
		getContentPane().add(totincme);
		totincme.setColumns(10);
		
		JButton btnIncome = new JButton("Income");
		btnIncome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mon = comboBox.getSelectedItem().toString();
				
				int month = 0;
			//	double income =0;
				String typ = "Activated";

				if(mon == "Select a Month") {
					JOptionPane.showMessageDialog(null, "One or more Required fields are empty!!");
				}else {
					if(mon == "January")
						month = 1;
					else if(mon == "February")
						month = 2;
					else if(mon == "March")
						month = 3;
					else if(mon == "April")
						month = 4;
					else if(mon == "May")
						month = 5;
					else if(mon == "June")
						month = 6;
					else if(mon == "July")
						month = 7;
					else if(mon == "August")
						month = 8;
					else if(mon == "September")
						month = 9;
					else if(mon == "Octomber")
						month = 10;
					else if(mon == "November")
						month = 11;
					else if(mon== "December")
						month = 12;
					
					String query = "select sum(Cost) from order_confirmation where Status ='"+typ+"'  and Month(Confirmed_Date) ='"+month+"'";
					
					try {
						Statement st=(Statement) Database.getConnection().createStatement();
						ResultSet rs=st.executeQuery(query);
						
						while(rs.next())
							income = rs.getInt(1);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					totincme.setText(""+income);
				
				}
				
				
			}
		});
		btnIncome.setBounds(366, 231, 89, 23);
		getContentPane().add(btnIncome);
		
		JButton btnPaidSalrries = new JButton("Paid Salaries");
		btnPaidSalrries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mon = comboBox_1.getSelectedItem().toString();
				
				int month = 0;
				

				if(mon == "Select a Month") {
					JOptionPane.showMessageDialog(null, "One or more Required fields are empty!!");
				}else {
					if(mon == "January")
						month = 1;
					else if(mon == "February")
						month = 2;
					else if(mon == "March")
						month = 3;
					else if(mon == "April")
						month = 4;
					else if(mon == "May")
						month = 5;
					else if(mon == "June")
						month = 6;
					else if(mon == "July")
						month = 7;
					else if(mon == "August")
						month = 8;
					else if(mon == "September")
						month = 9;
					else if(mon == "Octomber")
						month = 10;
					else if(mon == "November")
						month = 11;
					else if(mon== "December")
						month = 12;
					
					String query = "select sum(Net_Salary) from monthly_pay where  Month(Payment_Date) ='"+month+"'";
					
					try {
						Statement st=(Statement) Database.getConnection().createStatement();
						ResultSet rs=st.executeQuery(query);
						
						while(rs.next())
							paidSal = rs.getInt(1);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					totsal.setText(""+paidSal);
				
				}
				
			}
		});
		btnPaidSalrries.setBounds(357, 389, 98, 23);
		getContentPane().add(btnPaidSalrries);
		
		totsal = new JTextField();
		totsal.setColumns(10);
		totsal.setBounds(732, 390, 86, 20);
		getContentPane().add(totsal);
		
		JLabel lblNewLabel_4 = new JLabel("Calculate the finance report ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(266, 11, 355, 20);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Calculation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			double val = income - (paidSal+expense);
			
			if(val>=0) {
				pro.setText("Profit is "+val);
			}else {
				pro.setText("Lost is "+val);
			}
				
			}
		});
		btnNewButton_1.setBounds(652, 535, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		pro = new JTextField();
		pro.setBounds(357, 531, 217, 30);
		getContentPane().add(pro);
		pro.setColumns(10);
		
		JLabel label_2 = new JLabel("paid Salaries");
		label_2.setBounds(582, 385, 75, 30);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Total income");
		label_3.setBounds(578, 227, 98, 30);
		getContentPane().add(label_3);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Profit or Lost");
		lblNewLabel_5.setBounds(148, 539, 98, 14);
		getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Expenses");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mon = month1.getSelectedItem().toString();
				//String typ = comboBox.getSelectedItem().toString();
				int month = 0;
				
				
				if(mon == "Select a Month") {
					JOptionPane.showMessageDialog(null, "One or more Required fields are empty!!");
				}else {
					if(mon == "January")
						month = 1;
					else if(mon == "February")
						month = 2;
					else if(mon == "March")
						month = 3;
					else if(mon == "April")
						month = 4;
					else if(mon == "May")
						month = 5;
					else if(mon == "June")
						month = 6;
					else if(mon == "July")
						month = 7;
					else if(mon == "August")
						month = 8;
					else if(mon == "September")
						month = 9;
					else if(mon == "Octomber")
						month = 10;
					else if(mon == "November")
						month = 11;
					else if(mon== "December")
						month = 12;
					
					String query = "select sum(NetExpense) from expenses where Month(Date) ='"+month+"'";
					
					try {
						Statement st=(Statement) Database.getConnection().createStatement();
						ResultSet rs=st.executeQuery(query);
						
						while(rs.next())
							expense = rs.getInt(1);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					totex.setText(""+expense);
				
				}
				
			}
		});
		btnNewButton.setBounds(357, 79, 89, 23);
		getContentPane().add(btnNewButton);
		
		
		
		
		
		

	}
}
