package ui.sales.tabs;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import ui.finance.tabs.FinanceCalculation;
import ui.inventory.tabs.Home;
import utils.common.database.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UnconfirmedSales extends KTab {
	private JTable table;
	JDateChooser dateChooserFrom;
	JDateChooser dateChooserTo;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnconfirmedSales frame = new UnconfirmedSales();
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
	public UnconfirmedSales() {
		super("Unconfirmed Sales");
		
		JLabel lblNewLabel = new JLabel("View Unconfirmed Sales Report");
		lblNewLabel.setBounds(400, 25, 200, 45);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Branch");
		lblNewLabel_1.setBounds(65, 80, 123, 25);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(65, 115, 123, 21);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select the branch", "OFC001","OFC002","OFC003","OFC004","OFC005","OFC006","OFC007"}));
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Date from");
		lblNewLabel_2.setBounds(310, 80, 116, 25);
		getContentPane().add(lblNewLabel_2);
		
		dateChooserFrom = new JDateChooser();
		dateChooserFrom.setBounds(310, 115, 116, 22);
		getContentPane().add(dateChooserFrom);
		
		dateChooserTo = new JDateChooser();
		dateChooserTo.setBounds(547, 115, 116, 22);
		getContentPane().add(dateChooserTo);
		
		JLabel lblNewLabel_3 = new JLabel("Date to");
		lblNewLabel_3.setBounds(547, 80, 116, 25);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Employee ID");
		lblNewLabel_4.setBounds(754, 80, 96, 25);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(754, 115, 143, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Filter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String branch = comboBox.getSelectedItem().toString();
				Date dateFrom = dateChooserFrom.getDate();
				Date dateTo = dateChooserTo.getDate();
				String EmpId = textField.getText();
			
					
				if(branch == "Select the branch" && dateFrom == null && dateTo == null && EmpId.equals("")) {
					 tableLoad();
				}else if(branch != "Select the branch" && dateFrom == null && dateTo == null && EmpId.equals("")) {
					 branchF(branch);
				}else if(branch == "Select the branch" && dateFrom == null && dateTo == null && EmpId != null) {
					 empF(EmpId);							
				}else if(branch == "Select the branch" && dateFrom != null && dateTo != null && EmpId.equals("")) {
					 dateF(dateFrom,dateTo);
				}else if(branch != "Select the branch" && dateFrom != null && dateTo != null && EmpId.equals("")) {
					 monthlyBranchF(branch,dateFrom,dateTo);
				}else if(branch != "Select the branch" && dateFrom == null && dateTo == null && EmpId != null ) {
					 empBrF(branch,EmpId);
				}else if(branch == "Select the branch" && dateFrom != null && dateTo != null && EmpId != null ) {
					 empMonF(EmpId,dateFrom,dateTo);
				}else if(branch != "Select the branch" && dateFrom != null && dateTo != null && EmpId != null) {
					empBrMonF(branch,dateFrom,dateTo,EmpId);
				}}
		});
		btnNewButton.setBounds(413, 159, 135, 35);
		getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(170, 107, 663, 112);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 224, 860, 350);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Export Excel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getRowCount() == 0) {
					
					JOptionPane.showInternalMessageDialog(UnconfirmedSales.this, "There're no rows to be exported");
					
					return;
					
				}

				JFileChooser c = new JFileChooser();
				c.setSelectedFile(new File("CW_"+new SimpleDateFormat("ddMMyyyyHHmmss").format(new java.util.Date()) + ".xls"));
			    int rVal = c.showSaveDialog(UnconfirmedSales.this);
			    if (rVal == JFileChooser.APPROVE_OPTION) {
			    	toExcel(table, c.getSelectedFile());
			    }
			}
		});
		btnNewButton_1.setBounds(796, 189, 123, 25);
		getContentPane().add(btnNewButton_1);
		
		tableLoad();

	}
	
	public void tableLoad(){
		
        try{
            String sql = "select ItemID,Serial_Number,Name,Added_Date,Sold_Date,Status,Executive,cost from items WHERE Status='Sold'";
            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            table.setModel(Database.resultSetToTableModel(rs));
            
        
        }catch(Exception e){}
    }
	
	public void toExcel(JTable table, File file){
		
		FileWriter excel1 = null;
		    try{
		        TableModel model1 = table.getModel();
		        excel1 = new FileWriter(file);

		        for(int m = 0; m < model1.getColumnCount(); m++){
		            excel1.write(model1.getColumnName(m) + "\t");
		        }

		        excel1.write("\n");

		        for(int m=0; m< model1.getRowCount(); m++) {
		            for(int n=0; n < model1.getColumnCount(); n++) {
		            	if (model1.getValueAt(m,n) != null) {
		            		excel1.write(model1.getValueAt(m,n).toString()+"\t");
		            	}
		            }
		            excel1.write("\n");
		        }

		        excel1.close();
		        
		        if(!Desktop.isDesktopSupported()){
		            return;
		        }
		        
		        Desktop desktop = Desktop.getDesktop();
		        if(file.exists()) 
		        	desktop.open(file);
		

		    } catch (NullPointerException ne) {
		    	System.out.println(ne.getMessage());
		    	ne.printStackTrace();
		    	
		    } catch(IOException e){  
		    	
		    } finally {
		    	try {
					excel1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}
	
	public void branchF(String branch) {
		 try{
	            String sql ="select items.ItemID,items.Serial_Number,items.Name,items.Added_Date,items.Sold_Date,items.Status,items.Executive,items.cost from items,sales_executives,office WHERE Status='Sold' && items.Executive = sales_executives.EmployeeID and sales_executives.OfficeID = office.OfficeID and office.OfficeID = '"+branch+"'";
	            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            
	            table.setModel(Database.resultSetToTableModel(rs));
	            
	        
	        }catch(Exception e){}
	}
	
	public void empF(String EmpId) {
		 try{
	            String sql ="select ItemID,Serial_Number,Name,Added_Date,Sold_Date,Status,Executive,cost from items WHERE Status='Sold' && Executive='"+EmpId+"'";
	            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            
	            table.setModel(Database.resultSetToTableModel(rs));
	            
	        
	        }catch(Exception e){}
	}
	
	public void dateF(Date dateFrom, Date dateTo) {
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		String daFr = df.format(dateFrom);
		String daTo = df.format(dateTo);
		try{
            String sql = "select ItemID,Serial_Number,Name,Added_Date,Sold_Date,Status,Executive,cost from items WHERE Status='Sold' && Sold_Date between '"+daFr+"' and '"+daTo+"'";
            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            table.setModel(Database.resultSetToTableModel(rs));
            
        
        }catch(Exception e){}
	}
	
	public void monthlyBranchF(String branch, Date dateFrom, Date dateTo) {
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		String daFr = df.format(dateFrom);
		String daTo = df.format(dateTo);
		try{
            String sql = "select items.ItemID,items.Serial_Number,items.Name,items.Added_Date,items.Sold_Date,items.Status,items.Executive,items.cost from items,sales_executives,office WHERE Status='Sold' && items.Executive = sales_executives.EmployeeID and sales_executives.OfficeID = office.OfficeID and office.OfficeID = '"+branch+"' && Sold_Date between '"+daFr+"' and '"+daTo+"'";
            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            table.setModel(Database.resultSetToTableModel(rs));
            
        
        }catch(Exception e){}
	}
	
	public void empBrF(String branch, String EmpId) {
		try{
            String sql = "select items.ItemID,items.Serial_Number,items.Name,items.Added_Date,items.Sold_Date,items.Status,items.Executive,items.cost from items,sales_executives,office WHERE Status='Sold' && items.Executive = sales_executives.EmployeeID and sales_executives.OfficeID = office.OfficeID and office.OfficeID = '"+branch+"' && Executive='"+EmpId+"' ";
            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            table.setModel(Database.resultSetToTableModel(rs));
            
        
        }catch(Exception e){}
	}
	
	public void empMonF(String EmpId, Date dateFrom, Date dateTo) {
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		String daFr = df.format(dateFrom);
		String daTo = df.format(dateTo);
		try{
            String sql = "select ItemID,Serial_Number,Name,Added_Date,Sold_Date,Status,Executive,cost from items WHERE Status='Sold' && Sold_Date between '"+daFr+"' and '"+daTo+"' && Executive='"+EmpId+"' ";
            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            table.setModel(Database.resultSetToTableModel(rs));
            
        
        }catch(Exception e){}
	}
	
	public void empBrMonF(String branch, Date dateFrom, Date dateTo, String EmpId) {
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		String daFr = df.format(dateFrom);
		String daTo = df.format(dateTo);
		try{
            String sql = "select items.ItemID,items.Serial_Number,items.Name,items.Added_Date,items.Sold_Date,items.Status,items.Executive,items.cost from items,sales_executives,office WHERE Status='Sold' && items.Executive = sales_executives.EmployeeID and sales_executives.OfficeID = office.OfficeID and office.OfficeID = '"+branch+"' && Executive='"+EmpId+"' && Sold_Date between '"+daFr+"' and '"+daTo+"' ";
            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            table.setModel(Database.resultSetToTableModel(rs));
            
        
        }catch(Exception e){}
	}
}


