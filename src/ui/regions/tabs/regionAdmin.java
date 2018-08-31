package ui.regions.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import ui.components.KTab;
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
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp", "root", "");
			PreparedStatement stmt = con.prepareStatement(sql);
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
		txtOfficeId.setBounds(201, 126, 162, 20);
		getContentPane().add(txtOfficeId);
		txtOfficeId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Office Id : ");
		lblNewLabel.setBounds(60, 132, 107, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Region Name : ");
		lblNewLabel_1.setBounds(60, 165, 95, 19);
		getContentPane().add(lblNewLabel_1);
		
		txtRegionName = new JTextField();
		txtRegionName.setBounds(201, 162, 162, 20);
		getContentPane().add(txtRegionName);
		txtRegionName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contact No : ");
		lblNewLabel_2.setBounds(60, 199, 82, 25);
		getContentPane().add(lblNewLabel_2);
		
		txtContact = new JTextField();
		txtContact.setBounds(201, 201, 162, 20);
		getContentPane().add(txtContact);
		txtContact.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Address  : ");
		lblNewLabel_3.setBounds(60, 245, 95, 19);
		getContentPane().add(lblNewLabel_3);
		
		JTextArea areaAddress = new JTextArea();
		areaAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
		areaAddress.setBounds(201, 243, 162, 66);
		getContentPane().add(areaAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(420, 126, 500, 226);
		getContentPane().add(scrollPane);
		
		JComboBox comboRegionType = new JComboBox();
		comboRegionType.setModel(new DefaultComboBoxModel(new String[] {"Head Office", "Region Office"}));
		comboRegionType.setBounds(201, 332, 162, 20);
		getContentPane().add(comboRegionType);
		
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {

				
				String officeId = txtOfficeId.getText();
				String address = areaAddress.getText();
				String contact = txtContact.getText();
				String regionName = txtRegionName.getText();
				String regionType = (String) comboRegionType.getSelectedItem();
				
				officeId = "REG_" + officeId;
				
				
				String sql = "INSERT INTO office(OfficeID, Address, Reigon_Name, Reigon_Type, Contact) VALUES (?, ?, ?, ?,?)";
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp", "root", "");
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, officeId);
					stmt.setString(2, address);
					stmt.setString(3, regionName);
					stmt.setString(4, regionType);
					stmt.setString(5, contact);
					
					
				
					stmt.execute();
					
			/*		long result = String.valueOf(contact).length();
					boolean numeric = true;
					
					numeric = contact.matches("[0-9]");
					
			if(numeric) {
					if(result == 10) {
						stmt.execute();
					}
					else {
						String st = "length is wrong";
						JOptionPane.showMessageDialog(null, st);
					}
				}
				else {
					String st = "Enter only number";
					JOptionPane.showMessageDialog(null, st);
				}
					
				*/	getTable();
					
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
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
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(642, 500, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String officeId = txtOfficeId.getText();
				String sql = "Delete from office where officeID = ?";
		
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp", "root", "");
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, officeId);
					stmt.execute();
					
					getTable();
					
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
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
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(750, 500, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String officeId = txtOfficeId.getText();
				String address = areaAddress.getText();
				String contact = txtContact.getText();
				String regionName = txtRegionName.getText();
				String regionType = (String) comboRegionType.getSelectedItem();
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp", "root", "");
					
					String regionUpdate = "UPDATE office SET Address = ? , Reigon_Name = ?,Reigon_Type=?, Contact=?  WHERE OfficeID = ?";
					PreparedStatement stmt = con.prepareStatement(regionUpdate);
					
					stmt.setString(1, address);
					stmt.setString(2, regionName);
					stmt.setString(3, regionType);
					stmt.setString(4, contact);
					stmt.setString(5, officeId);
					
					stmt.execute();
	
					getTable();
					
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
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
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(856, 500, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Admin Managment");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(60, 50, 920, 31);
		getContentPane().add(lblNewLabel_4);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("Region Type : ");
		lblNewLabel_5.setBounds(60, 332, 95, 20);
		getContentPane().add(lblNewLabel_5);
		
			
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
