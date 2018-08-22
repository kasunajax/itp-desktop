package ui.inventory.tabs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JScrollPane;
import java.awt.Font;

public class Home extends KTab { 

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
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void tableLoad(){
        try{
            String sql = "select * from items";
            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            table.setModel(Database.resultSetToTableModel(rs));
            
        
        }catch(Exception e){}
    }
	
	
	/**
	 * Create the frame.
	 */
	public Home() {
		super("Home");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 840, 313);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableLoad();
		JButton button = new JButton("All");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  tableLoad();
			}
		});
		button.setBounds(860, 162, 99, 25);
		getContentPane().add(button);
		
		JLabel label = new JLabel("To view Branch vise details enter Branch Code");
		label.setBounds(44, 411, 369, 16);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(43, 449, 116, 22);
		getContentPane().add(textField);
		
		JButton button_1 = new JButton("View");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String text = textField.getText();
				 	String sql = "select items.ItemID,items.Serial_Number,items.Name,items.Added_Date,items.Sold_Date,items.Status,items.Executive,items.cost,office.OfficeID,office.Reigon_Name from items,sales_executives,office where items.Executive = sales_executives.EmployeeID and sales_executives.OfficeID = office.OfficeID and office.OfficeID = '"+text+"'";
		            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
		            ResultSet rs = stmt.executeQuery();
		            table.setModel(Database.resultSetToTableModel(rs));
				}
				catch(SQLException ex) {}

		       
			}
		});
		button_1.setBounds(201, 447, 99, 25);
		getContentPane().add(button_1);
		
		JLabel label_1 = new JLabel("To view Executive vise details enter Executive Code");
		label_1.setBounds(43, 494, 357, 16);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(43, 534, 116, 22);
		getContentPane().add(textField_1);
		
		JButton button_2 = new JButton("View");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String text = textField_1.getText();
				 	String sql = "select * from items where Executive = '"+ text +"'";
		            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
		            ResultSet rs = stmt.executeQuery();
		            table.setModel(Database.resultSetToTableModel(rs));
				}
				catch(SQLException ex) {}
				
			}
		});
		button_2.setBounds(201, 532, 99, 25);
		getContentPane().add(button_2);
		
		JLabel lblInventoryDetails = new JLabel("Inventory Details");
		lblInventoryDetails.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblInventoryDetails.setBounds(10, 41, 637, 37);
		getContentPane().add(lblInventoryDetails);
		
		
		



	}

}
