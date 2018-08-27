package ui.finance.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import utils.common.database.Database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;



import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import java.awt.Font;

public class CreateExpenses extends KTab {
	private JTextField t1;
	private JTextField t2;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTable table;
	
	
   

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateExpenses frame = new CreateExpenses();
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
	public CreateExpenses() {
		super("Create Expenses ");
		
		
		JDateChooser t3 = new JDateChooser();
		t3.setBounds(221, 240, 183, 32);
		getContentPane().add(t3);
		

		
		t1 = new JTextField();
		t1.setBounds(221, 80, 183, 32);
		getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Expense Id");
		lblNewLabel.setBounds(78, 89, 97, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Description ");
		lblNewLabel_1.setBounds(78, 165, 97, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(78, 248, 69, 14);
		getContentPane().add(lblDate);
		
		JLabel lblNewLabel_2 = new JLabel("NetAmount");
		lblNewLabel_2.setBounds(78, 330, 97, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Type");
		lblNewLabel_3.setBounds(78, 418, 69, 14);
		getContentPane().add(lblNewLabel_3);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(221, 156, 183, 32);
		getContentPane().add(t2);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(221, 321, 183, 32);
		getContentPane().add(t4);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(221, 409, 183, 32);
		getContentPane().add(t5);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String expensId = t1.getText();
				String dscrp = t2.getText();
				Date dat = t3.getDate();
				String Netexpens = t4.getText();
				String Types = t5.getText();
				String empid = t6.getText();
				
				DateFormat fmt = new SimpleDateFormat("YYYY-MM-dd");
	            String expdate = fmt.format(dat);
				
	            
	           
	            
	             
								
						Pattern patrn = Pattern.compile("\\d{5}||\\d{4}||\\d{3}");
						Matcher matc = patrn.matcher(expensId);
				if(matc.matches()) {
							
						}else {
							JOptionPane.showMessageDialog(null,"Please enter a valid ExpensId");
						}
						
				
					
					 Pattern patrn1 = Pattern.compile("\\w+");
					 Matcher matc1 = patrn1.matcher(dscrp);
					 
				 if(matc1.matches()) {
						 
					 }else {
						 JOptionPane.showMessageDialog(null,"Please Enter a valid Description");
					 }
					
				
					Pattern patrn11 = Pattern.compile("\\d+.*");
					 Matcher matc11 = patrn11.matcher(Netexpens);
					
				if(matc11.matches()) {
						
					}else {
						JOptionPane.showMessageDialog(null,"Please Enter a valid Net Expenses");
					}
					
	
					 Pattern patrn111 = Pattern.compile("\\w+");
					 Matcher matc111 = patrn111.matcher(Types);
					
				if(matc111.matches()) {
					 }else {
						 JOptionPane.showMessageDialog(null,"Please Enter valid Types");
					 }
				
				
					
					Pattern patrn1111 = Pattern.compile("\\d");
					 Matcher matc1111 = patrn1111.matcher(empid);
					 
				 if(matc1111.matches()) {
						 
					 }else {
						 JOptionPane.showMessageDialog(null,"Please Enter valid Employee Id");
					 }
				 if(t3.equals("")) {
					JOptionPane.showMessageDialog(null,"Plaease select the date");
				}else{
					
					
					String sql = "INSERT INTO expenses(ExpenseID,NetExpense,Date,Description,EmployeeID,Type) Values ('"+expensId+"','"+Netexpens+"','"+expdate+"','"+dscrp+"','"+empid+"','"+Types+"')";
					
				try {
					
				PreparedStatement ps = Database.getConnection().prepareStatement(sql);
				ps.executeUpdate();
					
				tableLoad(); 
				
				t1.setText(null);
				t2.setText(null);
				t3.setDate(null);
				t4.setText(null);
				t5.setText(null);
				t6.setText(null);
				
				}catch(Exception e1) {
					
					e1.printStackTrace();
				
					
				}
				
				}
			}
		});
		
		
		
		
		btnNewButton_1.setBounds(686, 494, 117, 32);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Create Expenses");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(43, 38, 150, 20);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Employee Id");
		lblNewLabel_5.setBounds(78, 503, 82, 14);
		getContentPane().add(lblNewLabel_5);
		
		t6 = new JTextField();
		t6.setBounds(221, 494, 183, 32);
		getContentPane().add(t6);
		t6.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(431, 80, 509, 303);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Expense Id", "Description", "Date", "Net Expenses", "Type", "Employee ID"
			}
		));
		scrollPane.setViewportView(table);
		tableLoad();

	}
}
