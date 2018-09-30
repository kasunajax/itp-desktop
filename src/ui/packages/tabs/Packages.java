package ui.packages.tabs;

import java.awt.EventQueue;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Packages extends KTab {
	private JTable table;
	private JTable table_1;
	
	
	public void LoadTable() {
		try {
		String query = "Select * from mobile_package";
		
		PreparedStatement pst= Database.getConnection().prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		table.setModel(Database.resultSetToTableModel(rs));
	}catch(Exception e1) {
		e1.printStackTrace();}
	}
	
	
	public void LoadTables() {
		try {
			
		
		String query = "Select * from tv_package";
		
		PreparedStatement pst = Database.getConnection().prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		table_1.setModel(Database.resultSetToTableModel(rs));	
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Packages frame = new Packages();
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
	public Packages() {
		
		JButton btnPackages = new JButton("Display Mobile Package");
		btnPackages.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnPackages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadTable();
			}
		});
		btnPackages.setBounds(640, 59, 195, 56);
		getContentPane().add(btnPackages);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 150, 884, 106);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"12", "Mini Package", "Small talk", "2000.00", "2", "Dynamic", "8GB", "25MB", "15GB", "25GB"},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Package ID", "Package Name", "Package Details", "Connecting Fee", "e-mail Boxes", "IP Configuration Type", "Night Time Quota", "Web Space", "Any Time Quota", "Total Monthly Quota"
			}
		));
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(49, 395, 884, 106);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"34", "Macro Package", null, "200.00", "48"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Package ID", "Package Name", "Connecting Fee", "Rental Fee", "No.Of.Channels"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton button = new JButton("Display TV Package");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadTables();
			}
		});
		button.setFont(new Font("Segoe UI", Font.BOLD, 13));
		button.setBounds(640, 304, 195, 56);
		getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setBounds(461, 59, 45, 13);
		getContentPane().add(label);
		
		JLabel lblMobilePackage = new JLabel("Mobile Package");
		lblMobilePackage.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblMobilePackage.setBounds(405, 59, 129, 37);
		getContentPane().add(lblMobilePackage);
		
		JLabel lblTvPackage = new JLabel("TV Package");
		lblTvPackage.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTvPackage.setBounds(405, 304, 129, 37);
		getContentPane().add(lblTvPackage);
		//setBounds(100, 100, 450, 300);

	}
}
