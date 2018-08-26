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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ExpensesDetails extends KTab {
	private JTextField t1;
	private JTextField t2;
	private JTable table;
	private JTextField t3;
	
	
	

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
           
            String sql = "select * from expenses";
          
            
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
		            String sql = "Select ExpenseID,Description,Date,NetExpense,EmployeeID  from expenses where Type like '%"+name+"%' ";
		            
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
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(170, 176, 118, 23);
		getContentPane().add(t2);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stDate = t2.getText();
				String ltDate = t3.getText();
				
				try{
		            String sql = "Select ExpenseID,Description,NetExpense,EmployeeID,Type  from expenses where Date Between '"+stDate+"' and '"+ltDate+"' ";
		            
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
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(355, 177, 118, 23);
		getContentPane().add(t3);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setBounds(316, 179, 29, 23);
		getContentPane().add(lblTo);
		
		JLabel lblNewLabel_1 = new JLabel("Details of Expenses");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(39, 41, 170, 23);
		getContentPane().add(lblNewLabel_1);

	}

}
