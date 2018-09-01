package ui.sales.tabs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ConfirmSales extends KTab {
	private JTextField textField;
	private JFileChooser jfc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmSales frame = new ConfirmSales();
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
	public ConfirmSales() {
		super("Confirm Sales");
		
		
		JButton btnNewButton = new JButton("Browse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
									
				int returnValue = jfc.showOpenDialog(null);
				
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					selectedFile.getAbsolutePath();
					textField.setText(jfc.getSelectedFile().getAbsolutePath());
				}
			}
		});
		
		btnNewButton.setBounds(646, 147, 125, 40);
		getContentPane().add(btnNewButton);
		
		
		textField = new JTextField();		
		textField.setBounds(96, 148, 400, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		

		
		JLabel lblNewLabel = new JLabel("Add Dialog Sales Confirmation Report");
		lblNewLabel.setBounds(96, 80, 350, 40);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Add Report");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql;
				
				String csvFile = textField.getText();
			    BufferedReader br = null;
		        String line = "";
		        String cvsSplitBy = ",";
		        
		        try {
		            br = new BufferedReader(new FileReader(csvFile));
		            while ((line = br.readLine()) != null) {

		                // use comma as separator
		            	String[] sale = line.split(cvsSplitBy);
		            	
		          	  SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	                  String dateInString = sale[2];
	                  
	                  Date date = new Date();

	                  try {

	                	  date = formatter.parse(dateInString);
	                  } catch (ParseException e1) {
	                      e1.printStackTrace();
	                  }
	                  
	                  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	                  
	            	
		            	
		            	String serialNumber = sale[0];
		            	String name = sale[1];
		            	String confirmedDate = df.format(date);
		            	String customerName = sale[3];
		            	String customerAddress = sale[4];
		            	String nic = sale[5];
		            	String customerContactNo = sale[6];
		            	String cost = sale[7];
		            	String status = sale[8];
		            	
		            			            
		                try {			                	
		                	sql = "INSERT INTO order_confirmation(Serial_Number,Name,Confirmed_Date,Customer_Name,Customer_Address,NIC,Customer_ContactNo,Cost,Status)"
		                			+ "Values('"+serialNumber+"','"+name+"','"+confirmedDate+"','"+customerName+"','"+customerAddress+"','"+nic+"','"+customerContactNo+"','"+cost+"','"+status+"')";
		                			
		                	PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
							stmt.execute();
		                }catch(SQLIntegrityConstraintViolationException e1) {
		                        	sql = "UPDATE order_confirmation SET Name = '"+name+"',Confirmed_Date = '"+confirmedDate+"',Customer_Name = '"+customerName+"',"
		                			+ "Customer_Address = '"+customerAddress+"',NIC = '"+nic+"' ,Customer_ContactNo = '"+customerContactNo+"',Cost = '"+cost+"',Status = '"+status+"' WHERE Serial_Number='"+serialNumber+"'";
		                			
		                	try {
		                	PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
							stmt.execute();
		                	}catch(Exception e11) {
		                		e11.printStackTrace();
		                	}
		                }catch(Exception e1) {
		                	e1.printStackTrace();
		                }         
               
		        }
			}catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(null, "No File is Selected","ERROR!",JOptionPane.ERROR_MESSAGE);
		            e1.printStackTrace();
		    }catch(IOException e1) {
		    	e1.printStackTrace();
		    }finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        }
		        
		}});
		btnNewButton_1.setBounds(425, 253, 125, 40);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Confirm Sales");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
					
				
					String sql = "UPDATE order_confirmation o, items i SET o.Status='Confirmed', i.Status='Confirmed' WHERE o.Serial_Number=i.Serial_Number";
					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);	 
			        stmt.executeQuery();
			        
				   
			        
				}catch(Exception e1) {
					e1.printStackTrace();
				
				}
			}
		});
		btnNewButton_2.setBounds(425, 416, 125, 40);
		getContentPane().add(btnNewButton_2);

	}
}
