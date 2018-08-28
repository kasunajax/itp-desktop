package ui.inventory.tabs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;


public class MakeChanges extends KTab {
	
	private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeChanges frame = new MakeChanges();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void tableLoad(){
        try{
            String sql = "select ItemID,Serial_Number,Name,Cost,Added_Date,Sold_Date,Status,Executive from items";
            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            table.setModel(Database.resultSetToTableModel(rs));
            
        
        }catch(Exception e){}
    }
	
	public boolean isEmpty(String id,String name,String serial,String cost,String ex,String status,Date pd) {
		if(id.equals("")||name.equals("")||serial.equals("")||cost.equals("")||ex.equals("")||status.equals("")||pd == null||status.equals("Select a Status")) {
			JOptionPane.showMessageDialog(null, "One or more Required fields are empty!!");
			return false;
		}
		else
			return true;
	}
	
	public boolean isSerial(String num) {
		String patternNum = "\\d+";
		
		if(num.matches(patternNum))
			return true;
		else
			return false;
	}
	
	public boolean isFloat(String num) {
		String patternNum = "([+-]?\\d*\\.\\d+)(?![-+0-9\\.])";
		
		if(num.matches(patternNum))
			return true;
		else
			return false;
	}
	
	public boolean isId(String id) {
		String patternId = "[A-Z][A-Z][A-Z]\\d\\d\\d";
		
		if(id.matches(patternId))
			return true;
		else
			return false;
	}
	
	public boolean isVarchar(String text) {
		String patternTxt = "\\w+";
		
		if(text.matches(patternTxt))
			return true;
		else {
			return false;
		}
	}
	
	public boolean validation(String id,String name,String serial,String cost,String ex,String status,Date pd) {
		
		if(isEmpty(id,name,serial,cost,ex,status,pd))
			if(isId(id))
				if(isVarchar(name))
					if(isSerial(serial))
						if(isFloat(cost))
							if(isId(ex))
								return true;
							else {
								JOptionPane.showMessageDialog(null, "Enter valid Executive ID!!");
								return false;
							}
						else {
							JOptionPane.showMessageDialog(null, "Enter valid Cost!!");
							return false;
						}
					else {
						JOptionPane.showMessageDialog(null, "Enter valid Serial Number!!");
						return false;
					}
				else {
					JOptionPane.showMessageDialog(null, "Enter valid Name!!");
					return false;
				}
			else {
				JOptionPane.showMessageDialog(null, "Enter valid Item ID!!");
				return false;
			}
		else
			return false;

	}

	/**
	 * Create the frame.
	 */
	public MakeChanges() {
		super("Changes");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select a Status", "Initial", "Sold"}));
		comboBox.setBounds(477, 409, 116, 21);
		getContentPane().add(comboBox);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(196, 441, 116, 22);
		getContentPane().add(dateChooser);
		
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(196, 473, 116, 22);
		getContentPane().add(dateChooser_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 62, 868, 242);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int r = table.getSelectedRow();
		        
		        String id = table.getValueAt(r, 0).toString();
		        String se = table.getValueAt(r, 1).toString(); 
		        String name = table.getValueAt(r, 2).toString();
		        String c =  table.getValueAt(r, 3).toString();
		        String status =  table.getValueAt(r, 6).toString();
		        String ex = table.getValueAt(r, 7).toString();
		        Date pd = (Date) table.getValueAt(r, 4);
		        Date sd = (Date) table.getValueAt(r, 5);
		        
		        textField_2.setText(id);
		        textField_6.setText(se);
		        textField_3.setText(name);
		        textField_4.setText(c);
		        textField_5.setText(ex);
		        comboBox.setSelectedItem(status);
		        dateChooser.setDate(pd);
		        dateChooser_1.setDate(sd);
		        
		        
		       
			}
		});
		
		tableLoad();
		
		JLabel lblMakeChangesTo = new JLabel("Make changes to Inventory");
		lblMakeChangesTo.setBounds(110, 88, 761, 27);
		getContentPane().add(lblMakeChangesTo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(196, 346, 116, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(477, 346, 116, 22);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(477, 378, 116, 22);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(196, 409, 116, 22);
		getContentPane().add(textField_5);
		
		JLabel lblItemId = new JLabel("Item Id");
		lblItemId.setBounds(93, 345, 70, 22);
		getContentPane().add(lblItemId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(373, 345, 70, 22);
		getContentPane().add(lblName);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(373, 377, 70, 22);
		getContentPane().add(lblCost);
		
		JLabel lblExecutive = new JLabel("Executive");
		lblExecutive.setBounds(93, 409, 81, 22);
		getContentPane().add(lblExecutive);
		
		JLabel lblPurchasedDate = new JLabel("Purchased Date");
		lblPurchasedDate.setBounds(93, 441, 99, 22);
		getContentPane().add(lblPurchasedDate);
		
		JLabel lblSoldDate = new JLabel("Sold Date");
		lblSoldDate.setBounds(93, 473, 99, 22);
		getContentPane().add(lblSoldDate);
		
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 	textField_2.setText(null);
			        textField_3.setText(null);
			        textField_4.setText(null);
			        textField_5.setText(null);
			        textField_6.setText(null);
			        comboBox.setSelectedItem("Select an Status");
			        dateChooser.setDate(null);
			        dateChooser_1.setDate(null);
			}
		});
		btnReset.setBounds(93, 555, 99, 25);
		getContentPane().add(btnReset);
		
		JButton btnAddEntry = new JButton("Add Entry");
		btnAddEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String q;
				int se;
				float cc = 0;
				int count = 0;
				String id = textField_2.getText();
				String name = textField_3.getText();
				String serial = textField_6.getText();
				String c = textField_4.getText();
				String ex  = textField_5.getText();
				String status = comboBox.getSelectedItem().toString();
				Date pd = dateChooser.getDate();
				Date sd = dateChooser_1.getDate();
				
				if(validation(id,name,serial,c,ex,status,pd)) {
		            cc = Float.valueOf(c);
		            se = Integer.parseInt(serial);
		            DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		            String ppdate = df.format(pd);
		            String ssdate = null;
		            if(sd != null)
		                ssdate = df.format(sd);
		            
		            q = "select count(*) from items where ItemID = '"+id+"'";
                    
                    try {
						PreparedStatement stmt = Database.getConnection().prepareStatement(q);
						ResultSet rs = stmt.executeQuery();
						if(rs.next())
							count = rs.getInt(1);
					} catch (SQLException exp) {
						exp.printStackTrace();
					}
                    
                    if(count == 1)
                    	JOptionPane.showMessageDialog(null, "Item Id '"+id+"' already exist!!");
                    else {
                    	if(sd == null)
                    		q = "insert into items(ItemID,Serial_Number,Name,Added_Date,Sold_Date,Status,Executive,cost) values( '"+id+"','"+se+"','"+name+"','"+ppdate+"',null,'"+status+"','"+ex+"','"+cc+"')";    
                    	else
                    		q = "insert into items(ItemID,Serial_Number,Name,Added_Date,Sold_Date,Status,Executive,cost) values( '"+id+"','"+se+"','"+name+"','"+ppdate+"','"+ssdate+"','"+status+"','"+ex+"','"+cc+"')";
		            
		            
                    	try {
                    		PreparedStatement stmt = Database.getConnection().prepareStatement(q);
                    		stmt.execute();
                    	} catch (SQLException e) {
                    		e.printStackTrace();
                    	}
		           
                    	tableLoad();
                    }
                    	
		            
		        }
				
			}
		});
		btnAddEntry.setBounds(258, 555, 99, 25);
		getContentPane().add(btnAddEntry);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q;
				int se;
				float cc = 0;
				String id = textField_2.getText();
				String name = textField_3.getText();
				String serial = textField_6.getText();
				String c = textField_4.getText();
				String ex  = textField_5.getText();
				String status = comboBox.getSelectedItem().toString();
				Date pd = dateChooser.getDate();
				Date sd = dateChooser_1.getDate();
				
				if(validation(id,name,serial,c,ex,status,pd)) {
	                int x = JOptionPane.showConfirmDialog(null, "Do you really want to Update?");
	                if(x == 0){
	                	cc = Float.valueOf( textField_4.getText());
	                	se = Integer.parseInt(serial);
	                    DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
	                    String ppdate = df.format(pd);
	                    String ssdate = null;
	                    if(sd != null)
	                      ssdate = df.format(sd);
	             
	                    if(sd == null)
	                    	q = "update items set Serial_Number = '"+se+"' ,Name = '"+name+"',Added_Date = '"+ppdate+"',Sold_Date = null,Status = '"+status+"',Executive = '"+ex+"',cost = '"+cc+"' where ItemID = '"+id+"'";  
	                    else
	                    	q = "update items set Serial_Number = '"+se+"' ,Name = '"+name+"',Added_Date = '"+ppdate+"',Sold_Date = '"+ssdate+"',Status = '"+status+"',Executive = '"+ex+"',cost = '"+cc+"' where ItemID = '"+id+"'";
						try {
							PreparedStatement stmt = Database.getConnection().prepareStatement(q);
							stmt.execute();
						} catch (SQLException exp) {
							exp.printStackTrace();
						}
	                    tableLoad();
	                }
	              } 
				
				
			}
		});
		btnUpdate.setBounds(426, 555, 99, 25);
		getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = JOptionPane.showConfirmDialog(null, "Do you really want to Delete?");
		        
		        if(x == 0){
		        
					String id = textField_2.getText();
		        
		            String sql = "delete from items where ItemID = '"+id+"'";
		           
					try {
						PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
						stmt.execute();
					} catch (SQLException exp) {}
					
		            tableLoad();
		        }
			}
		});
		btnDelete.setBounds(616, 555, 99, 25);
		getContentPane().add(btnDelete);
		
		JLabel lblSerialNumber = new JLabel("Serial Number");
		lblSerialNumber.setBounds(93, 377, 99, 22);
		getContentPane().add(lblSerialNumber);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(196, 377, 116, 22);
		getContentPane().add(textField_6);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(373, 408, 70, 22);
		getContentPane().add(lblStatus);
		
		JLabel lblAstericFielsAre = new JLabel("Asteric(*) fiels are required");
		lblAstericFielsAre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAstericFielsAre.setBounds(95, 314, 325, 22);
		getContentPane().add(lblAstericFielsAre);
		
		JLabel label = new JLabel("*");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(318, 350, 45, 13);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(318, 382, 45, 13);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(318, 418, 45, 13);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("*");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(318, 450, 45, 13);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(604, 350, 45, 13);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(603, 382, 45, 13);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("*");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(603, 413, 45, 13);
		getContentPane().add(label_6);
		
		JLabel lblMakeChangesTo_1 = new JLabel("Make Changes to Inventory Table");
		lblMakeChangesTo_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMakeChangesTo_1.setBounds(27, 30, 553, 27);
		getContentPane().add(lblMakeChangesTo_1);
		

		

	}
}
