package ui.orders.tabs;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ProcessOrders extends KTab {
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	
	public static String title;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcessOrders frame = new ProcessOrders();
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
	public ProcessOrders() {
		super("PROCESS ORDER");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 177, 500, 170);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(720, 177, 200, 170);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnAdd = new JButton("Add >>");
		btnAdd.setBounds(586, 324, 112, 23);
		getContentPane().add(btnAdd);
		
		JButton button = new JButton("<< Remove");
		button.setBounds(586, 290, 112, 23);
		getContentPane().add(button);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(60, 410, 859, 132);
		getContentPane().add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setBounds(586, 174, 112, 105);
		getContentPane().add(btnPlaceOrder);
		
		JLabel lblMyInventory = new JLabel("My Inventory Items:");
		lblMyInventory.setBounds(60, 136, 500, 40);
		getContentPane().add(lblMyInventory);
		
		JLabel lblAddedToOrder = new JLabel("Items added to Order:");
		lblAddedToOrder.setBounds(720, 136, 200, 40);
		getContentPane().add(lblAddedToOrder);
		
		JLabel lblAvailableOrdersDepending = new JLabel("Available Orders Depending on the Region:");
		lblAvailableOrdersDepending.setBounds(60, 370, 860, 40);
		getContentPane().add(lblAvailableOrdersDepending);
		
		JLabel lblOptions = new JLabel("Options:");
		lblOptions.setBounds(588, 136, 110, 40);
		getContentPane().add(lblOptions);
		
		JLabel lblNewLabel = new JLabel("PROCESS AN ORDER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(60, 70, 859, 73);
		getContentPane().add(lblNewLabel);
		
		
		try {
			String sql = "SELECT ItemID, SerialNO, Executive, Package FROM inventory_items WHERE Executive = 'EMP_L0_321' AND Status = 'INITIAL'";
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			table.setModel(Database.resultSetToTableModel(res));
			
		} catch (SQLException e) {e.printStackTrace();}
		
		
		try {
			String sql = "SELECT ItemID, Package FROM inventory_items WHERE Executive = 'EMP_L0_321' AND Status = 'ASSIGNED'";
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			table_1.setModel(Database.resultSetToTableModel(res));
			
		} catch (SQLException e) {e.printStackTrace();}
		
		try {
			String sql = "SELECT * FROM orders WHERE  Status = 'INITIAL'";
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			table_2.setModel(Database.resultSetToTableModel(res));

		} catch (SQLException e) {e.printStackTrace();}
	}
}
