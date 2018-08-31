package ui.packages.tabs;

import java.awt.EventQueue;

import ui.components.KTab;
import utils.common.database.Database;



import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ManagePromotions extends KTab {
	private JTextField Name;
	private JTextField Details;
	private JTextField Package_Type;
	private JTextField Promotion_Id;
	private JTextField Valid_Period;
	private JTextField Devise_Type;
	private JTable table;
	private JTextField Venue;
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
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
					ManagePromotions frame = new ManagePromotions();
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
	public ManagePromotions() {
		
		
		JDateChooser val = new JDateChooser();
		val.setBounds(289, 254, 149, 22);
		getContentPane().add(val);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblName.setBounds(123, 161, 70, 35);
		getContentPane().add(lblName);
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDetails.setBounds(123, 206, 63, 35);
		getContentPane().add(lblDetails);
		
		JLabel lblDateTime = new JLabel("Date");
		lblDateTime.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDateTime.setBounds(121, 251, 125, 35);
		getContentPane().add(lblDateTime);
		
		JLabel lblPackageType = new JLabel("Package Type");
		lblPackageType.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPackageType.setBounds(123, 342, 116, 47);
		getContentPane().add(lblPackageType);
		
		JLabel lblPromotionId = new JLabel("Promotion ID");
		lblPromotionId.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPromotionId.setBounds(123, 104, 89, 47);
		getContentPane().add(lblPromotionId);
		
		JLabel lblValidPeriod = new JLabel("Valid Period");
		lblValidPeriod.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblValidPeriod.setBounds(123, 434, 89, 35);
		getContentPane().add(lblValidPeriod);
		
		JLabel lblDeviceType = new JLabel("Device Type");
		lblDeviceType.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDeviceType.setBounds(123, 388, 105, 35);
		getContentPane().add(lblDeviceType);
		
		Name = new JTextField();
		Name.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Name.setBounds(289, 167, 149, 22);
		getContentPane().add(Name);
		Name.setColumns(10);
		
		Details = new JTextField();
		Details.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Details.setBounds(289, 212, 149, 22);
		getContentPane().add(Details);
		Details.setColumns(10);
		
		Package_Type = new JTextField();
		Package_Type.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Package_Type.setBounds(289, 354, 149, 22);
		getContentPane().add(Package_Type);
		Package_Type.setColumns(10);
		
		Promotion_Id = new JTextField();
		Promotion_Id.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Promotion_Id.setBounds(289, 116, 149, 22);
		getContentPane().add(Promotion_Id);
		Promotion_Id.setColumns(10);
		
		Valid_Period = new JTextField();
		Valid_Period.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Valid_Period.setBounds(289, 440, 149, 22);
		getContentPane().add(Valid_Period);
		Valid_Period.setColumns(10);
		
		Devise_Type = new JTextField();
		Devise_Type.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Devise_Type.setBounds(289, 394, 149, 22);
		getContentPane().add(Devise_Type);
		Devise_Type.setColumns(10);
		
		JButton button = new JButton("Delete");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int proid = Integer.parseInt(Promotion_Id.getText());
				
				
				String query = "Delete from promotion where Promotion_Id='"+proid+"'";
				
				try {
					PreparedStatement ps = Database.getConnection().prepareStatement(query);
				    ps.execute();
				
				} catch (SQLException e1) {
					
					e1.printStackTrace();
					LoadTable();
				}
				LoadTable();
			}
		});
		button.setFont(new Font("Segoe UI", Font.BOLD, 13));
		button.setBounds(123, 538, 85, 38);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Update");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int proid = Integer.parseInt(Promotion_Id.getText());
				String proname = Name.getText();
				String prodetails = Details.getText();
			
				
				Date prod = val.getDate();
				
			//	DateFormat obj = new SimpleDateFormat("YYYY-MM-DD");
				//String prodate = obj.format(prod);
				
				String prodate = new java.sql.Date(prod.getTime()).toString();
				
				String provenue = Venue.getText();
				String proptype = Package_Type.getText();
				String prodtype = Devise_Type.getText();
				int properiod = Integer.parseInt(Valid_Period.getText());
				
				
				try {
					String query = "Update promotion set Name='"+proname+"',Details='"+prodetails+"',Date='"+prodate+"',Venue='"+provenue+"',Package_Type='"+proptype+"',Devise_Type='"+prodtype+"',Valid_Period='"+properiod+"' where Promotion_Id='"+proid+"'";
					
					PreparedStatement pst = Database.getConnection().prepareStatement(query);
					pst.execute();
					
				}catch(Exception e1) {
					e1.printStackTrace();
					LoadTable();
				}
				LoadTable();
			}
		});
		button_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		button_1.setBounds(289, 538, 93, 38);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Add");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int proid = Integer.parseInt(Promotion_Id.getText());
				String proname = Name.getText();
				String prodetails = Details.getText();
	
				Date prod = val.getDate();
				
						
				String provenue = Venue.getText();
				String proptype = Package_Type.getText();
				String prodtype = Devise_Type.getText();
				int properiod = Integer.parseInt(Valid_Period.getText());
				
//				DateFormat obj = new SimpleDateFormat("DD-MM-YYYY");
//				String prodate = obj.format(prod);
				
				String prodate = new java.sql.Date(prod.getTime()).toString();
				
				
				try {
				String query = "Insert INTO promotion(Promotion_Id,Name,Details,Date,Venue,Package_Type,Devise_Type,Valid_Period) values ('"+proid+"','"+proname+"','"+prodetails+"','"+prodate+"','"+provenue+"','"+proptype+"','"+prodtype+"','"+properiod+"')";
				
				PreparedStatement pst = Database.getConnection().prepareStatement(query);
				pst.execute();
				
				}catch(Exception e3) {
					e3.printStackTrace();
					LoadTable();
				}
				LoadTable();
				
			}
		});
		button_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		button_2.setBounds(449, 538, 93, 37);
		getContentPane().add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(448, 123, 522, 106);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"34", "Triple Bonus", "Get 1MB Data Free", "2/2/2018", "BMICH", "Double Bonanza", "Mobile", "6 months"},
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
		
		JLabel lblVenue = new JLabel("Venue");
		lblVenue.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblVenue.setBounds(123, 297, 125, 35);
		getContentPane().add(lblVenue);
		
		Venue = new JTextField();
		Venue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Venue.setColumns(10);
		Venue.setBounds(289, 306, 149, 22);
		getContentPane().add(Venue);
		//setBounds(100, 100, 450, 300);
		
		LoadTable();
		

	}
}
