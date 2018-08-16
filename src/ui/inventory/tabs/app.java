package ui.inventory.tabs;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;

public class app {

	private JFrame frame;
	
	com.mysql.jdbc.Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTable table_1;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app window = new app();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public app() {
		initialize();
		
		conn = DBconnector.connect();
		 tableLoad();
		 tableLoad2();
	}
	
	public void tableLoad(){
        try{
            String sql = "select * from items";
            pst = ((java.sql.Connection) conn).prepareStatement(sql);
            rs = pst.executeQuery();
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e){}
    }
	
	public void tableLoad2(){
        try{
            String sql = "select * from items";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            table_1.setModel(DbUtils.resultSetToTableModel(rs));
            
        
        }catch(Exception e){}
    }
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 728, 774);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 13, 712, 724);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 700, 155);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblInventoryManagementSystem = new JLabel("Inventory Management System");
		lblInventoryManagementSystem.setForeground(Color.GRAY);
		lblInventoryManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInventoryManagementSystem.setBounds(210, 24, 327, 27);
		panel_1.add(lblInventoryManagementSystem);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(28, 95, 99, 25);
		panel_1.add(btnHome);
		
		JButton btnMakeChanges = new JButton("Make Changes");
		btnMakeChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMakeChanges.setBounds(168, 95, 117, 25);
		panel_1.add(btnMakeChanges);
		
		JButton btnForcasting = new JButton("Forcasting");
		btnForcasting.setBounds(311, 95, 117, 25);
		panel_1.add(btnForcasting);
		
		JButton btnCostCalculation = new JButton("Cost Calculation");
		btnCostCalculation.setBounds(480, 95, 133, 25);
		panel_1.add(btnCostCalculation);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 156, 700, 565);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel changes = new JPanel();
		changes.setLayout(null);
		changes.setBounds(618, 0, 82, 70);
		panel_2.add(changes);
		
		JLabel lblMakeChangesTo = new JLabel("Make changes to Inventory");
		lblMakeChangesTo.setForeground(Color.GRAY);
		lblMakeChangesTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMakeChangesTo.setBounds(12, 13, 327, 27);
		changes.add(lblMakeChangesTo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(201, 256, 116, 22);
		changes.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(201, 291, 116, 22);
		changes.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(201, 326, 116, 22);
		changes.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(201, 361, 116, 22);
		changes.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(201, 396, 116, 22);
		changes.add(textField_6);
		
		JLabel lblItemId = new JLabel("Item Id");
		lblItemId.setBounds(12, 256, 150, 22);
		changes.add(lblItemId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 291, 150, 22);
		changes.add(lblName);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(12, 326, 150, 22);
		changes.add(lblCost);
		
		JLabel lblExecutive = new JLabel("Executive");
		lblExecutive.setBounds(12, 361, 150, 22);
		changes.add(lblExecutive);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(12, 396, 150, 22);
		changes.add(lblBranch);
		
		JLabel lblPurchasedDate = new JLabel("Purchased Date");
		lblPurchasedDate.setBounds(12, 434, 150, 22);
		changes.add(lblPurchasedDate);
		
		JLabel lblSoldDate = new JLabel("Sold Date");
		lblSoldDate.setBounds(12, 465, 150, 22);
		changes.add(lblSoldDate);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int r = table_1.getSelectedRow();
		        
		        String id = table_1.getValueAt(r, 0).toString();
		        String name = table_1.getValueAt(r, 1).toString();
		        String c =  table_1.getValueAt(r, 2).toString();
		        String ex = table_1.getValueAt(r, 3).toString();
		        String br = table_1.getValueAt(r, 4).toString();
		        Date pd = (Date) table_1.getValueAt(r, 5);
		        Date sd = (Date) table_1.getValueAt(r, 6);
		        
		        textField_2.setText(id);
		        textField_3.setText(name);
		        textField_4.setText(c);
		        textField_5.setText(ex);
		        textField_6.setText(br);
		        
		        
		        
		       
			}
		});
		table_1.setBounds(22, 53, 572, 189);
		changes.add(table_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(201, 434, 116, 22);
		changes.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(201, 465, 116, 22);
		changes.add(dateChooser_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 	textField_2.setText(null);
			        textField_3.setText(null);
			        textField_4.setText(null);
			        textField_5.setText(null);
			        textField_6.setText(null);
			        dateChooser.setDate(null);
			        dateChooser_1.setDate(null);
			}
		});
		btnReset.setBounds(12, 502, 99, 25);
		changes.add(btnReset);
		
		JButton btnAddEntry = new JButton("Add Entry");
		btnAddEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String q;
				float cc = 0;
				String id = textField_2.getText();
				String name = textField_3.getText();
				String c = textField_4.getText();
				String ex  = textField_5.getText();
				String br = textField_6.getText();
				Date pd = dateChooser.getDate();
				Date sd = dateChooser_1.getDate();
				
				if(id == null||name == null||ex == null||br == null||pd == null||c == null)
		            JOptionPane.showMessageDialog(null, "One or more Required fields are empty!!");
				else{
		            cc = Float.valueOf(c);
		            DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		            String ppdate = df.format(pd);
		            String ssdate = null;
		            if(sd != null)
		                ssdate = df.format(sd);

		            if(sd == null)
		                q = "insert into items values( '"+id+"','"+name+"','"+cc+"','"+ex+"','"+br+"','"+ppdate+"',null)";
		            else
		                q = "insert into items values( '"+id+"','"+name+"','"+cc+"','"+ex+"','"+br+"','"+ppdate+"','"+ssdate+"')";
		            
		                try {
							pst = conn.prepareStatement(q);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            
		                try {
							pst.execute();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                
		                tableLoad2();
		            
		        }
				
			}
		});
		btnAddEntry.setBounds(142, 502, 99, 25);
		changes.add(btnAddEntry);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q;
				float cc = 0;
				String id = textField_2.getText();
				String name = textField_3.getText();
				String c = textField_4.getText();
				String ex  = textField_5.getText();
				String br = textField_6.getText();
				Date pd = dateChooser.getDate();
				Date sd = dateChooser_1.getDate();
				
				if(id == null||name == null||ex == null||br == null||pd == null||c == null)
		            JOptionPane.showMessageDialog(null, "One or more Required fields are empty!!");
				else{
	                int x = JOptionPane.showConfirmDialog(null, "Do you really want to Update?");
	                if(x == 0){
	                	cc = Float.valueOf( textField_4.getText());
	                    DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
	                    String ppdate = df.format(pd);
	                    String ssdate = null;
	                    if(sd != null)
	                      ssdate = df.format(sd);
	             
	                    if(sd == null)
	                        q = "update items set Name = '"+name+"',Cost = '"+cc+"',Executive = '"+ex+"',Branch = '"+br+"',Purchased_Date = '"+ppdate+"',Sold_Date = null where Item_Id = '"+id+"'";
	                    else  
	                        q = "update items set Name = '"+name+"',Cost = '"+cc+"',Executive = '"+ex+"',Branch = '"+br+"',Purchased_Date = '"+ppdate+"',Sold_Date = '"+ssdate+"' where Item_Id = '"+id+"'";
	                   
	                        try {
								pst = conn.prepareStatement(q);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	                   
	                        try {
								pst.execute();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	                  
	                    tableLoad2();
	                }
	              } 
				
				
			}
		});
		btnUpdate.setBounds(280, 502, 99, 25);
		changes.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = JOptionPane.showConfirmDialog(null, "Do you really want to Delete?");
		        
		        if(x == 0){
		        
					String id = textField_2.getText();
		        
		            String sql = "delete from items where Item_Id = '"+id+"'";
		           
		                try {
							pst = conn.prepareStatement(sql);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            
		                try {
							pst.execute();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		          
		            tableLoad2();
		            tableLoad();
		        }
			}
		});
		btnDelete.setBounds(411, 502, 99, 25);
		changes.add(btnDelete);
		
		JPanel forcast = new JPanel();
		forcast.setLayout(null);
		forcast.setBounds(0, 0, 700, 552);
		panel_2.add(forcast);
		
		JLabel lblForcastingOfFuture = new JLabel("Forcasting of Future Demand for Products");
		lblForcastingOfFuture.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblForcastingOfFuture.setBounds(23, 13, 420, 34);
		forcast.add(lblForcastingOfFuture);
		
		JLabel lblGetForcastOn = new JLabel("Get Forcast on Branch basis");
		lblGetForcastOn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGetForcastOn.setBounds(23, 77, 306, 34);
		forcast.add(lblGetForcastOn);
		
		JLabel lblEnterBranchCode = new JLabel("Enter Branch Code:");
		lblEnterBranchCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterBranchCode.setBounds(23, 124, 140, 23);
		forcast.add(lblEnterBranchCode);
		
		JLabel lblEnterItemId = new JLabel("Enter Item Name:");
		lblEnterItemId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterItemId.setBounds(23, 172, 140, 23);
		forcast.add(lblEnterItemId);
		
		textField_7 = new JTextField();
		textField_7.setBounds(168, 125, 116, 22);
		forcast.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(168, 173, 116, 22);
		forcast.add(textField_8);
		
		JLabel label_9 = new JLabel("Get Forcast on Branch basis");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_9.setBounds(23, 288, 306, 34);
		forcast.add(label_9);
		
		JLabel label_10 = new JLabel("Enter Branch Code:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_10.setBounds(23, 347, 140, 23);
		forcast.add(label_10);
		
		JLabel lblEnterItemName = new JLabel("Enter Item Name:");
		lblEnterItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterItemName.setBounds(23, 383, 140, 23);
		forcast.add(lblEnterItemName);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(168, 348, 116, 22);
		forcast.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(168, 384, 116, 22);
		forcast.add(textField_10);
		
		JButton btnGetForcast = new JButton("Get Forcast");
		btnGetForcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int month = localDate.getMonthValue();
				 //JOptionPane.showMessageDialog(null, month);
				
				int count = 0;
				String br = textField_7.getText();
				String item = textField_8.getText();
				
				
				for(int i = 1;i<= month;++i) {
					String sql = "select count(*) from items where Branch = '"+br+"' and Name = '"+item+"' and MONTH(Purchased_Date) = '"+i+"'";
					try {
						Statement st=(Statement) conn.createStatement();
						ResultSet rs=st.executeQuery(sql);
						while(rs.next())
							count = count +  rs.getInt(1);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				JOptionPane.showMessageDialog(null, count);			
			}
		});
		btnGetForcast.setBounds(168, 208, 99, 25);
		forcast.add(btnGetForcast);
		
		JButton button_3 = new JButton("Get Forcast");
		button_3.setBounds(168, 419, 99, 25);
		forcast.add(button_3);
		
		JPanel cost = new JPanel();
		cost.setLayout(null);
		cost.setBounds(624, 0, 76, 70);
		panel_2.add(cost);
		
		JPanel home = new JPanel();
		home.setLayout(null);
		home.setBounds(618, 0, 82, 70);
		panel_2.add(home);
		
		table = new JTable();
		table.setBounds(12, 45, 532, 189);
		home.add(table);
		
		JButton button = new JButton("All");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  tableLoad();
			}
		});
		button.setBounds(589, 102, 99, 25);
		home.add(button);
		
		JLabel label = new JLabel("To view Branch vise details enter Branch Code");
		label.setBounds(12, 245, 309, 16);
		home.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(12, 274, 116, 22);
		home.add(textField);
		
		JButton button_1 = new JButton("View");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();

		        
		            String sql = "select * from items where Branch = '"+ text +"'";
		            try {
						pst = conn.prepareStatement(sql);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            try {
						rs = pst.executeQuery();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

		            table.setModel(DbUtils.resultSetToTableModel(rs));

		       
			}
		});
		button_1.setBounds(157, 273, 99, 25);
		home.add(button_1);
		
		JLabel label_1 = new JLabel("To view Executive vise details enter Executive Code");
		label_1.setBounds(12, 326, 309, 16);
		home.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 355, 116, 22);
		home.add(textField_1);
		
		JButton button_2 = new JButton("View");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField_1.getText();

		        
	            String sql = "select * from items where Executive = '"+ text +"'";
	            try {
					pst = conn.prepareStatement(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            try {
					rs = pst.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

	            table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		});
		button_2.setBounds(157, 354, 99, 25);
		home.add(button_2);
		
		JLabel label_2 = new JLabel("Item Id");
		label_2.setBounds(22, 21, 70, 16);
		home.add(label_2);
		
		JLabel label_3 = new JLabel("Name");
		label_3.setBounds(92, 21, 76, 16);
		home.add(label_3);
		
		JLabel label_4 = new JLabel("Cost");
		label_4.setBounds(167, 22, 76, 16);
		home.add(label_4);
		
		JLabel label_5 = new JLabel("Executive");
		label_5.setBounds(245, 22, 76, 16);
		home.add(label_5);
		
		JLabel label_6 = new JLabel("Branch");
		label_6.setBounds(320, 22, 76, 16);
		home.add(label_6);
		
		JLabel label_7 = new JLabel("Purchased_Date");
		label_7.setBounds(395, 22, 76, 16);
		home.add(label_7);
		
		JLabel label_8 = new JLabel("Sold_Date");
		label_8.setBounds(470, 21, 76, 16);
		home.add(label_8);
	}
}
