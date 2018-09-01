package ui.sales.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JLabel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Test", "Test1"}));
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
				String dateFrom = dateChooserFrom.getDateFormatString();
				String dateTo = dateChooserTo.getDateFormatString();
				String EmpId = textField.getText();
			try {	
				String sql = "SELECT * FROM items WHERE Sold_Date BETWEEN '"+dateFrom+"' AND '"+dateTo+"' AND Executive = '"+EmpId+"'";
				
				PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				
				table.setModel(Database.resultSetToTableModel(rs));
				
			
			}catch(Exception e1) {
				
				e1.printStackTrace();
			}
			}
		});
		btnNewButton.setBounds(413, 159, 135, 35);
		getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(170, 107, 663, 112);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 224, 860, 350);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		tableLoad();

	}
	
	public void tableLoad(){
		        
				
				try {
					String sql = "SELECT * FROM items WHERE Status='Sold' ";
							
					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					table.setModel(Database.resultSetToTableModel(rs));
					
				
				}catch(Exception e1) {
					
					e1.printStackTrace();
				}
	}
}
