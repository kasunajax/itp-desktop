package ui.regions.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import ui.components.KTab;
import ui.orders.tabs.ManageOrders;
import utils.common.database.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class regionAdmin extends KTab {
	
	private JTextField txtOfficeId;
	private JTextField txtRegionName;
	private JTextField txtContact;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regionAdmin frame = new regionAdmin();
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
	
	public void getTable() {
		String sql = "select * from office";
		
		try {
			
			 PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			
			TableModel tm = resultSetToTableModel(res);
			table.setModel(tm);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public regionAdmin() {
		super("Admin");

	
		txtOfficeId = new JTextField();
		txtOfficeId.setBounds(220, 131, 162, 20);
		getContentPane().add(txtOfficeId);
		txtOfficeId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Office Id : ");
		lblNewLabel.setBounds(60, 132, 107, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Region Name : ");
		lblNewLabel_1.setBounds(60, 165, 95, 19);
		getContentPane().add(lblNewLabel_1);
		
		txtRegionName = new JTextField();
		txtRegionName.setBounds(220, 164, 162, 20);
		getContentPane().add(txtRegionName);
		txtRegionName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contact No  : ");
		lblNewLabel_2.setBounds(60, 199, 162, 23);
		getContentPane().add(lblNewLabel_2);
		
		txtContact = new JTextField();
		txtContact.setBounds(220, 202, 162, 20);
		getContentPane().add(txtContact);
		txtContact.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Address  : ");
		lblNewLabel_3.setBounds(60, 245, 95, 19);
		getContentPane().add(lblNewLabel_3);
		
		JTextArea areaAddress = new JTextArea();
		areaAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
		areaAddress.setBounds(220, 243, 162, 66);
		getContentPane().add(areaAddress);
		
		JComboBox comboRegionType = new JComboBox();
		comboRegionType.setModel(new DefaultComboBoxModel(new String[] {"Select the type", "Head Office", "Region Office"}));
		comboRegionType.setBounds(220, 332, 162, 20);
		getContentPane().add(comboRegionType);
		
	
		
		
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int j = JOptionPane.showConfirmDialog(null,"Do you want to delete this");
				
				if(j == 0) {
					
					String officeId = txtOfficeId.getText();
					
					Pattern pattern1 = Pattern.compile("OFC\\d\\d\\d");
					Matcher match1 = pattern1.matcher(officeId);
					
					if(!match1.matches() && officeId.equals("")) {
		            	JOptionPane.showMessageDialog(null,"Please enter the office ID");
				}
					else {
						
						String sql = "Delete from office where officeID = ?";
						 try {
							PreparedStatement ps = Database.getConnection().prepareStatement(sql);
							
							ps.setString(1, officeId);
							ps.executeUpdate();
							
							getTable();
							
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						}
					}
				}
			}	
		});
		btnNewButton_1.setBounds(750, 500, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int j = JOptionPane.showConfirmDialog(null,"Do you really want to update");
				
				if(j == 0) {
					
					String officeId = txtOfficeId.getText();
					String address = areaAddress.getText();
					String contact = txtContact.getText();
					String regionName = txtRegionName.getText();
					String regionType = (String) comboRegionType.getSelectedItem();
				
					
					Pattern pattern1 = Pattern.compile("OFC\\d\\d\\d");
					Matcher match1 = pattern1.matcher(officeId);
		            
					Pattern pattern2 = Pattern.compile("\\d{3}-\\d{7}");
					Matcher match2 = pattern2.matcher(contact);
					
					if(!match1.matches() || officeId.equals("")) {
						JOptionPane.showMessageDialog(null,"Please enter a valid office id");
					}
					else if(regionName.equals("")){
						JOptionPane.showMessageDialog(null,"Region name field is empty");
					}
					else if(!match2.matches() && contact.equals("")) {
						JOptionPane.showMessageDialog(null,"Please enter a valid contact no");
					}
					else if(address.equals("")) {
						JOptionPane.showMessageDialog(null,"Address name field is empty");
					}
					else if(regionType == "Select the type") {
						JOptionPane.showMessageDialog(null,"Please Select a valid Type");
					}
					
					
					else {
						String sql = "UPDATE office SET Address = ? , Reigon_Name = ?,Reigon_Type=?, Contact=?  WHERE OfficeID = ?";
						
						try {
							PreparedStatement ps = Database.getConnection().prepareStatement(sql);
							
							ps.setString(1, address);
							ps.setString(2, regionName);
							ps.setString(3, regionType);
							ps.setString(4, contact);
							ps.setString(5, officeId);
							
							ps.execute();
							
							getTable();
							
						} catch (SQLException e1) {
						
							e1.printStackTrace();
						}

					}
					
				}
			}
		});
		btnNewButton_2.setBounds(856, 500, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Admin Managment");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(60, 50, 920, 31);
		getContentPane().add(lblNewLabel_4);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Region Type : ");
		lblNewLabel_5.setBounds(60, 332, 95, 20);
		getContentPane().add(lblNewLabel_5);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String officeId = txtOfficeId.getText();
				String address = areaAddress.getText();
				String contact = txtContact.getText();
				String regionName = txtRegionName.getText();
				String regionType = (String) comboRegionType.getSelectedItem();
				
				
				Pattern pattern1 = Pattern.compile("OFC\\d\\d\\d");
				Matcher match1 = pattern1.matcher(officeId);
	            
				Pattern pattern2 = Pattern.compile("\\d{3}-\\d{7}");
				Matcher match2 = pattern2.matcher(contact);
				
				if(!match1.matches() || officeId.equals("")) {
					JOptionPane.showMessageDialog(null,"Please enter a valid office id");
				}
				else if(regionName.equals("")){
					JOptionPane.showMessageDialog(null,"Region name field is empty");
				}
				else if(!match2.matches() || contact.equals("")) {
					JOptionPane.showMessageDialog(null,"Please enter a valid contact no");
				}
				else if(address.equals("")) {
					JOptionPane.showMessageDialog(null,"Address name field is empty");
				}
				else if(regionType == "Select the type") {
					JOptionPane.showMessageDialog(null,"Please Select a valid Type");
				}
				
		
				else {
					
				
					
					String sql = "INSERT INTO office(OfficeID, Address, Reigon_Name, Reigon_Type, Contact) VALUES (?,?,?,?,?)";
					
					try {
						PreparedStatement ps = Database.getConnection().prepareStatement(sql);
						
						ps.setString(1, officeId);
						ps.setString(2, address);
						ps.setString(3, regionName);
						ps.setString(4, regionType);
						ps.setString(5, contact);
						
						ps.executeUpdate();
						
						getTable();
						
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		btnInsert.setBounds(640, 500, 89, 23);
		getContentPane().add(btnInsert);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(422, 126, 523, 226);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String [] {
						"Office Id" , "Address" , "Region Name" , "Region Type" , "Contact"
				}
				));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				int r = table.getSelectedRow();
		        
			       String id = table.getValueAt(r, 0).toString();
			       String address = table.getValueAt(r, 1).toString();
			       String name = table.getValueAt(r, 2).toString();
			       String type = table.getValueAt(r, 3).toString();
			       String contact = table.getValueAt(r, 4).toString();
			       
			        txtOfficeId.setText(id);
			        areaAddress.setText(address);
			        txtRegionName.setText(name);
			        comboRegionType.setSelectedItem(type);
			        txtContact.setText(contact);
			}
		});
		
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_6 = new JLabel("(011-XXXXXXX)");
		lblNewLabel_6.setBounds(60, 220, 107, 14);
		getContentPane().add(lblNewLabel_6);
		getTable();
		
			
	}
	
	
	
	
	public static TableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();

            // Get the column names
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }

            // Get all rows.
            Vector rows = new Vector();

            while (rs.next()) {
                Vector newRow = new Vector();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }

                rows.addElement(newRow);
            }

            return new DefaultTableModel(rows, columnNames);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
