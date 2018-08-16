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
		scrollPane.setBounds(163, 120, 532, 186);
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
		button.setBounds(740, 174, 99, 25);
		getContentPane().add(button);
		
		JLabel label = new JLabel("To view Branch vise details enter Branch Code");
		label.setBounds(163, 317, 309, 16);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(163, 346, 116, 22);
		getContentPane().add(textField);
		
		JButton button_1 = new JButton("View");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String text = textField.getText();
				 	String sql = "select * from items where Branch = '"+ text +"'";
		            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
		            ResultSet rs = stmt.executeQuery();
		            table.setModel(Database.resultSetToTableModel(rs));
				}
				catch(SQLException ex) {}

		       
			}
		});
		button_1.setBounds(308, 345, 99, 25);
		getContentPane().add(button_1);
		
		JLabel label_1 = new JLabel("To view Executive vise details enter Executive Code");
		label_1.setBounds(430, 315, 265, 16);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(431, 346, 116, 22);
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
		button_2.setBounds(596, 342, 99, 25);
		getContentPane().add(button_2);
		
		JLabel label_2 = new JLabel("Item Id");
		label_2.setBounds(173, 93, 70, 16);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Name");
		label_3.setBounds(243, 93, 76, 16);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Cost");
		label_4.setBounds(318, 94, 76, 16);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Executive");
		label_5.setBounds(396, 94, 76, 16);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Branch");
		label_6.setBounds(471, 94, 76, 16);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Purchased_Date");
		label_7.setBounds(546, 94, 76, 16);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Sold_Date");
		label_8.setBounds(632, 93, 76, 16);
		getContentPane().add(label_8);
		
		
		



	}

}
