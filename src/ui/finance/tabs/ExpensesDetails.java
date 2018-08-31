package ui.finance.tabs;

import java.awt.EventQueue;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ExpensesDetails extends KTab {
	private JTextField t1;
	private JTable table;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpensesDetails frame = new ExpensesDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
public void tableLoad(){
	    
        try{
           
            String sql = "select * from expenses ORDER BY ExpenseID";
          
            
            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
                
            
            table.setModel(Database.resultSetToTableModel(rs));
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }

	/**
	 * Create the frame.
	 */
	public ExpensesDetails() {
		super("Expenses Details");
		
		
		JDateChooser d1 = new JDateChooser();
		d1.setBounds(170, 179, 116, 22);
		getContentPane().add(d1);
		
		JDateChooser d2 = new JDateChooser();
		d2.setBounds(355, 179, 116, 22);
		getContentPane().add(d2);
		
		
		JLabel lblNewLabel = new JLabel("Search by Type");
		lblNewLabel.setBounds(59, 102, 89, 14);
		getContentPane().add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setBounds(170, 98, 146, 23);
		getContentPane().add(t1);
		t1.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name = t1.getText();
		        
		        try{
		            String sql = "Select ExpenseID,NetExpense,Date,Description,EmployeeID,Type  from expenses where Type like '%"+name+"%' ";
		            
		            PreparedStatement ps = Database.getConnection().prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
		            
		            
		            table.setModel(Database.resultSetToTableModel(rs));
		            
		        }catch(Exception e1){
		            e1.printStackTrace();
		        }
				
				
			}
		});
		btnNewButton.setBounds(373, 98, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblSearchByDate = new JLabel("Search by date");
		lblSearchByDate.setBounds(59, 179, 89, 23);
		getContentPane().add(lblSearchByDate);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Date Date1 = d1.getDate();
				Date Date2 = d2.getDate();
				
	            DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
	            String stDate = df.format(Date1);
	            String ltDate = df.format(Date2);
				
				try{
		            String sql = "Select ExpenseID,NetExpense,Date,Description,EmployeeID,Type  from expenses where Date Between '"+stDate+"' and '"+ltDate+"' ";
		            
		            PreparedStatement ps = Database.getConnection().prepareStatement(sql);
		            ResultSet rs = ps.executeQuery();
		            
		            
		            table.setModel(Database.resultSetToTableModel(rs));
		            
		        }catch(Exception e1){
		          
		        	e1.printStackTrace();
		        }
				
			}
		});
		btnSearch.setBounds(511, 176, 89, 23);
		getContentPane().add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 247, 813, 256);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel( 
			new Object[][] {
			},
			new String[] {
			
					"Expense Id", "Description", "Date", "Net Expenses", "Type", "Employee Id"
			}
		));
		scrollPane.setViewportView(table);
		tableLoad();
		
		JLabel lblTo = new JLabel("to");
		lblTo.setBounds(316, 179, 29, 23);
		getContentPane().add(lblTo);
		
		JLabel lblNewLabel_1 = new JLabel("Details of Expenses");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(39, 41, 170, 23);
		getContentPane().add(lblNewLabel_1);
		
	

	}
}
