package ui.packages.tabs;

import java.awt.EventQueue;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Promotions extends KTab {
	private JTable table;
	
	public void LoadTable() {
		try {
		String query = "Select * from promotion";
		
		PreparedStatement pst= Database.getConnection().prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		table.setModel(Database.resultSetToTableModel(rs));
	}catch(Exception e1) {
		e1.printStackTrace();}
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Promotions frame = new Promotions();
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
	public Promotions() {
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadTable();
			}
			
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setBounds(434, 519, 105, 49);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 111, 897, 104);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"34", "Triple Bonus", "Get 1MB Data Free", "2/2/2018 ", "BMICH", "Double Bonanza", "Mobile", "6 months"},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Promotion ID", "Name", "Details", "Date", "Venue", "Package Type", "Devise Type", "Valid Period"
			}
		));
		scrollPane.setViewportView(table);
		//setBounds(100, 100, 450, 300);

	}
}
