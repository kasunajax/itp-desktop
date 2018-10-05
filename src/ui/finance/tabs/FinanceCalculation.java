package ui.finance.tabs;

import java.awt.Desktop;
import java.awt.EventQueue;

import ui.components.KTab;
import ui.orders.tabs.ManageOrders;
import utils.common.database.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JSpinner;

public class FinanceCalculation extends KTab {

	/**
	 * Launch the application.
	 */
	
	double income =0;
	double paidSal =0;
	double expense = 0;
	double val;
	String mon,mon1,mon2;
	String year,yea,yer;
	private JTable table;
	
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
	
	
	
	
public void tableLoad(){
	    
        try{
           
        	String sql = "select * from finance ";
          
            
            PreparedStatement ps = Database.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            table.setModel(Database.resultSetToTableModel(rs));
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }

	/**
	 * Create the frame.
	 */
	
	
	public FinanceCalculation() {
		super("Finance Calculation");
		
		JComboBox month1 = new JComboBox();
		month1.setModel(new DefaultComboBoxModel(new String[] {"Select the month", "", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		month1.setBounds(10, 79, 112, 22);
		getContentPane().add(month1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select the month", "", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setBounds(10, 227, 112, 22);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select the month", "", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_1.setBounds(10, 385, 112, 22);
		getContentPane().add(comboBox_1);
		
		JLabel lblTotalExpenses = new JLabel("  Total Expenses");
		lblTotalExpenses.setBounds(348, 75, 136, 30);
		getContentPane().add(lblTotalExpenses);
		
		JLabel lblNewLabel = new JLabel("Total Expenses");
		lblNewLabel.setBounds(67, 31, 136, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Total income");
		lblNewLabel_1.setBounds(67, 165, 98, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("paid Salaries");
		lblNewLabel_2.setBounds(67, 322, 75, 30);
		getContentPane().add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(67, 506, 327, 19);
		getContentPane().add(label);
		
		JLabel totex = new JLabel("");
		totex.setBounds(320, 138, 75, 14);
		getContentPane().add(totex);
		
		JComboBox year1 = new JComboBox();
		year1.setModel(new DefaultComboBoxModel(new String[] {"select the year", "", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"}));
		year1.setBounds(139, 79, 98, 22);
		getContentPane().add(year1);
		
		JComboBox year2 = new JComboBox();
		year2.setModel(new DefaultComboBoxModel(new String[] {"select the year", "", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"}));
		year2.setBounds(139, 227, 98, 22);
		getContentPane().add(year2);
		
		JComboBox year3 = new JComboBox();
		year3.setModel(new DefaultComboBoxModel(new String[] {"select the year", "", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"}));
		year3.setBounds(139, 385, 98, 22);
		getContentPane().add(year3);
		
		JLabel totincome = new JLabel("");
		totincome.setBounds(320, 285, 75, 14);
		getContentPane().add(totincome);
		
		JLabel totsal = new JLabel("");
		totsal.setBounds(320, 432, 75, 14);
		getContentPane().add(totsal);
		
		JButton btnIncome = new JButton("Income");
		btnIncome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					mon1 = comboBox.getSelectedItem().toString();
				
				int month = 0;
			//	double income =0;
				String typ = "Confirmed";
				
				yer = year2.getSelectedItem().toString();

				if(mon1 == "Select the month" || yer == "select the year") {
					JOptionPane.showMessageDialog(null, "One or more Required fields are empty!!");
				}else {
					if(mon1 == "January")
						month = 1;
					else if(mon1 == "February")
						month = 2;
					else if(mon1 == "March")
						month = 3;
					else if(mon1 == "April")
						month = 4;
					else if(mon1 == "May")
						month = 5;
					else if(mon1 == "June")
						month = 6;
					else if(mon1 == "July")
						month = 7;
					else if(mon1 == "August")
						month = 8;
					else if(mon1 == "September")
						month = 9;
					else if(mon1 == "Octomber")
						month = 10;
					else if(mon1 == "November")
						month = 11;
					else if(mon1 == "December")
						month = 12;
					
					String query = "select sum(Cost) from order_confirmation where Status ='"+typ+"'  and Month(Confirmed_Date) ='"+month+"'  and Year(Confirmed_Date)='"+yer+"'";
					
					try {
						Statement st=(Statement) Database.getConnection().createStatement();
						ResultSet rs=st.executeQuery(query);
						
						while(rs.next())
							income = rs.getInt(1);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					totincome.setText(""+income);
				
				}
				
				
			}
		});
		btnIncome.setBounds(266, 227, 89, 23);
		getContentPane().add(btnIncome);
		
		JButton btnPaidSalrries = new JButton("Paid Salaries");
		btnPaidSalrries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					mon2 = comboBox_1.getSelectedItem().toString();
				
				int month = 0;
				
					yea = year3.getSelectedItem().toString();
				
				if(mon2 == "Select the month" || yea == "select the year") {
					JOptionPane.showMessageDialog(null, "One or more Required fields are empty!!");
				}else {
					if(mon2 == "January")
						month = 1;
					else if(mon2 == "February")
						month = 2;
					else if(mon2 == "March")
						month = 3;
					else if(mon2 == "April")
						month = 4;
					else if(mon2 == "May")
						month = 5;
					else if(mon2 == "June")
						month = 6;
					else if(mon2 == "July")
						month = 7;
					else if(mon2 == "August")
						month = 8;
					else if(mon2 == "September")
						month = 9;
					else if(mon2 == "Octomber")
						month = 10;
					else if(mon2 == "November")
						month = 11;
					else if(mon2 == "December")
						month = 12;
					
					String query = "select sum(Net_Salary) from monthly_pay where  Month(Payment_Date) ='"+month+"' and Year(Payment_Date) ='"+yea+"'";
					
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
		btnPaidSalrries.setBounds(257, 385, 98, 23);
		getContentPane().add(btnPaidSalrries);
		
		JLabel lblNewLabel_4 = new JLabel("Calculate the finance report ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(266, 11, 355, 20);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Calculation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				val = income - (paidSal+expense);
			
			if(val>=0) {
				label.setText("The Profit of the company is "+val);
			}else {
				label.setText("The Lost of the company is "+val);
			}
				
			}
		});
		btnNewButton_1.setBounds(465, 502, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblPaidSalaries = new JLabel("   paid Salaries");
		lblPaidSalaries.setBounds(359, 381, 98, 30);
		getContentPane().add(lblPaidSalaries);
		
		JLabel lblTotalIncome = new JLabel("  Total income");
		lblTotalIncome.setBounds(359, 223, 98, 30);
		getContentPane().add(lblTotalIncome);
		
		
		
	
		
		JButton btnNewButton = new JButton("Expenses");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 mon = month1.getSelectedItem().toString();
				// int yr = 0;
				//String typ = comboBox.getSelectedItem().toString();
				int month = 0;
					
				year = year1.getSelectedItem().toString();
				
				if(mon == "Select the month" || year == "select the year") {
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
					
					
					
					String query = "select sum(NetExpense) from expenses where Month(Date) ='"+month+"' and Year(Date)='"+year+"'";
					
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
		btnNewButton.setBounds(260, 79, 89, 23);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(444, 79, 526, 238);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Year", "Month", "Total Expenses", "Total Income", "Total Paid Sal", "Status"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(64);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Export");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(table.getRowCount() == 0) {
					
					JOptionPane.showInternalMessageDialog(FinanceCalculation.this, "There're no rows to be exported");
					
					return;
					
				}

				JFileChooser c = new JFileChooser();
				c.setSelectedFile(new File("CW_"+new SimpleDateFormat("ddMMyyyyHHmmss").format(new java.util.Date()) + ".xls"));
			    int rVal = c.showSaveDialog(FinanceCalculation.this);
			    if (rVal == JFileChooser.APPROVE_OPTION) {
			    	toExcel(table, c.getSelectedFile());
			    }
				
				
			}
		});
		btnNewButton_2.setBounds(852, 385, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				if(mon.equalsIgnoreCase(mon1) && mon1.equalsIgnoreCase(mon2)  && year.equalsIgnoreCase(yer) && yer.equalsIgnoreCase(yea)) {
					
					

						String sql = "Insert into finance(Year,Month,TotalExpense,TotalIncome,TotalPaidSal,Status) value ('"+year+"','"+mon+"','"+expense+"','"+income+"','"+paidSal+"','"+val+"')";
						
						PreparedStatement ps = Database.getConnection().prepareStatement(sql);
						ps.executeUpdate();
						
						tableLoad();
					
									
				}else {
						
						JOptionPane.showMessageDialog(null, "Months and years should be same");
						
						
					}
					
				}catch(NullPointerException e1){
					
					JOptionPane.showInternalMessageDialog(FinanceCalculation.this, "You cant keep fields Empty");
					//e1.printStackTrace();
				}catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setBounds(703, 385, 89, 23);
		getContentPane().add(btnNewButton_3);
		
				
		
		
		

	}
	
	public void toExcel(JTable table, File file){
		
		
	    try{
	        TableModel model = table.getModel();
	        FileWriter excel = new FileWriter(file);

	        for(int i = 0; i < model.getColumnCount(); i++){
	            excel.write(model.getColumnName(i) + "\t");
	        }

	        excel.write("\n");

	        for(int i=0; i< model.getRowCount(); i++) {
	            for(int j=0; j < model.getColumnCount(); j++) {
	                excel.write(model.getValueAt(i,j).toString()+"\t");
	            }
	            excel.write("\n");
	        }

	        excel.close();
	        
	        if(!Desktop.isDesktopSupported()){
	            return;
	        }
	        
	        Desktop desktop = Desktop.getDesktop();
	        if(file.exists()) 
	        	desktop.open(file);
	

	    }catch(IOException e){  }
	}
}
