package ui.packages.tabs;

import java.awt.EventQueue;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

public class ManagePackages extends KTab {
	private JTextField PackageDetails;
	private JTextField PackageName;
	private JTextField Ip_Config;
	


	private JTable table;
	private JTextField ConnectingFees;
	private JTextField Email_Boxes;
	private JTextField Night_Time;
	private JTextField Web;
	private JTextField Total_Monthly;
	private JTextField Any_Time;
	private JTextField Rental_Fee;
	private JTextField No_Of_Channels;
	private JTable table_1;
	private JTextField TvPackageID;
	private JTextField MPackageID;
	private JTextField ConnectingFee;
	private JTextField PackageNames;
	
	
	
	public void LoadTable() {
		try {
			
		
		String query = "Select * from mobile_package";
		
		PreparedStatement pst = Database.getConnection().prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		table.setModel(Database.resultSetToTableModel(rs));	
		
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
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
					ManagePackages frame = new ManagePackages();
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
	public ManagePackages() {
		
		
		//setBounds(100, 100, 450, 300);
		super("Manage packages ");
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = JOptionPane.showConfirmDialog(null,"Do you want to add this");
		        
		        if(x == 0){
		        	
				
				
				
				String pid = MPackageID.getText();
				String nam = PackageName.getText();
				String pdetails  = PackageDetails.getText();
				int cfee = Integer.parseInt(ConnectingFees.getText());
				int ebox = Integer.parseInt(Email_Boxes.getText());
				String ipconfig = Ip_Config.getText();
				String nquota = Night_Time.getText();
				String wspace = Web.getText();
				String aquota = Any_Time.getText();
				String tquota = Total_Monthly.getText();
				
				
				
				if(pid.equals("")) {
					JOptionPane.showMessageDialog(null,"Please enter a valid Mobile Package ID");
				}
				else if(nam.equals("")){
					JOptionPane.showMessageDialog(null,"Name field is empty");
				}
				else if(pdetails.equals("")){
					JOptionPane.showMessageDialog(null,"Package Details field is empty");
				}
				else if(String.valueOf(cfee).equals("")){
					JOptionPane.showMessageDialog(null,"Connecting Fees field is empty");
				}
				else if(String.valueOf(ebox).equals("")){
					JOptionPane.showMessageDialog(null,"Email_Boxes field is empty");
				}
				else if(ipconfig.equals("")){
					JOptionPane.showMessageDialog(null,"Ip_Config field is empty");
				}
				else if(nquota.equals("")){
					JOptionPane.showMessageDialog(null,"Night Time field is empty");
				}
				else if(wspace.equals("")){
					JOptionPane.showMessageDialog(null,"Web field is empty");
				}
				else if(aquota.equals("")){
					JOptionPane.showMessageDialog(null,"Any Time field is empty");
				}
				else if(tquota.equals("")){
					JOptionPane.showMessageDialog(null,"Total Monthly field is empty");
				}
				else {
					
				}
				
				try {
				String query = "Insert INTO mobile_package(MPackageID,PackageName,PackageDetails,ConnectingFees,Email_Boxes,IP_Config,Night_Time,Web,Any_Time,Total_Monthly) values ('"+pid+"','"+nam+"','"+pdetails+"','"+cfee+"','"+ebox+"','"+ipconfig+"','"+nquota+"','"+wspace+"','"+aquota+"','"+tquota+"')";
				
				PreparedStatement pst = Database.getConnection().prepareStatement(query);
				pst.execute();
				
				
				}catch(Exception e1) {
					e1.printStackTrace();
					LoadTable();
				}
				LoadTable();
			}
			}});
		btnAdd.setBounds(257, 547, 93, 37);
		getContentPane().add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = JOptionPane.showConfirmDialog(null,"Do you want to update this");
		        
		        if(x == 0){
				
				
				String pid = MPackageID.getText();
				String nam = PackageName.getText();
				String pdetails = PackageDetails.getText();
				int cfee = Integer.parseInt(ConnectingFees.getText());
				int ebox = Integer.parseInt(Email_Boxes.getText());
				String ipconfig = Ip_Config.getText();
				String nquota = Night_Time.getText();
				String wspace = Web.getText();
				String aquota = Any_Time.getText();
				String tquota = Total_Monthly.getText();
				
				
				try {
					String query = "Update mobile_package set PackageName='"+nam+"',PackageDetails='"+pdetails+"',ConnectingFees='"+cfee+"',Email_Boxes='"+ebox+"',Ip_Config='"+ipconfig+"',Night_Time='"+nquota+"',Web='"+wspace+"',Any_Time='"+aquota+"',Total_Monthly='"+tquota+"' where MPackageId='"+pid+"'";
					
					PreparedStatement pst = Database.getConnection().prepareStatement(query);
					pst.execute();
					LoadTable();
					
				}catch(Exception e1) {
					e1.printStackTrace();
					
				}
				LoadTable();
			}
			}});
		btnUpdate.setBounds(140, 546, 93, 38);
		getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = JOptionPane.showConfirmDialog(null,"Do you want to delete this");
		        
		        if(x == 0){
				
				String pid = MPackageID.getText();
				
				
				String query = "Delete from mobile_package where MPackageID='"+pid+"'";
				
				try {
					PreparedStatement ps = Database.getConnection().prepareStatement(query);
					ps.execute();
					
				} catch (SQLException e1) {
			
					e1.printStackTrace();
					//LoadTable();
				}
				LoadTable();
			}
			}});
		btnDelete.setBounds(33, 546, 85, 38);
		getContentPane().add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("Package Name");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel.setBounds(33, 113, 96, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPackageDetails = new JLabel("Package Details");
		lblPackageDetails.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPackageDetails.setBounds(33, 153, 96, 33);
		getContentPane().add(lblPackageDetails);
		
		JLabel lblConnectingFee = new JLabel("Connecting Fee");
		lblConnectingFee.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblConnectingFee.setBounds(33, 196, 107, 33);
		getContentPane().add(lblConnectingFee);
		
		PackageDetails = new JTextField();
		PackageDetails.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		PackageDetails.setBounds(171, 158, 137, 22);
		getContentPane().add(PackageDetails);
		PackageDetails.setColumns(10);
		
		PackageName = new JTextField();
		PackageName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		PackageName.setColumns(10);
		PackageName.setBounds(171, 117, 137, 22);
		getContentPane().add(PackageName);
		
		Ip_Config = new JTextField();
		Ip_Config.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Ip_Config.setColumns(10);
		Ip_Config.setBounds(171, 283, 137, 22);
		getContentPane().add(Ip_Config);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(376, 494, 476, 106);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		LoadTable();
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"12", "Mini Package", "Small Talk", "2000.00", "2", "Dynamic", "8GB", "25MB", "15GB", "25GB"},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Package ID", "Package Name", "Package Details", "Connecting Fee", "e-mail Boxes", "IP Configuratuon Type", "Night Time Quota", "Web Space", "Any Time Quota", "Total Monthly Quota"
			}
		));
		
		JLabel lblMobilePackages = new JLabel("Mobile Packages");
		lblMobilePackages.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblMobilePackages.setBounds(66, 32, 129, 37);
		getContentPane().add(lblMobilePackages);
		
		JLabel lblTvPackages = new JLabel("TV Packages");
		lblTvPackages.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTvPackages.setBounds(599, 32, 129, 37);
		getContentPane().add(lblTvPackages);
		
		JLabel lblEmailBoxes = new JLabel("e-mail Boxes");
		lblEmailBoxes.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblEmailBoxes.setBounds(33, 239, 96, 30);
		getContentPane().add(lblEmailBoxes);
		
		JLabel lblIpConfigurationType = new JLabel("IP Configuration Type");
		lblIpConfigurationType.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblIpConfigurationType.setBounds(33, 279, 129, 30);
		getContentPane().add(lblIpConfigurationType);
		
		JLabel lblNightTimeQuota = new JLabel("Night Time Quota");
		lblNightTimeQuota.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNightTimeQuota.setBounds(33, 323, 115, 30);
		getContentPane().add(lblNightTimeQuota);
		
		JLabel lblWebSpace = new JLabel("Web Space");
		lblWebSpace.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblWebSpace.setBounds(33, 377, 96, 30);
		getContentPane().add(lblWebSpace);
		
		JLabel lblAnyTimeQuota = new JLabel("Any Time Quota");
		lblAnyTimeQuota.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblAnyTimeQuota.setBounds(33, 417, 96, 30);
		getContentPane().add(lblAnyTimeQuota);
		
		JLabel lblTotalMonthlyQuota = new JLabel("Total Monthly Quota");
		lblTotalMonthlyQuota.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblTotalMonthlyQuota.setBounds(33, 460, 129, 30);
		getContentPane().add(lblTotalMonthlyQuota);
		
		ConnectingFees = new JTextField();
		ConnectingFees.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		ConnectingFees.setColumns(10);
		ConnectingFees.setBounds(171, 201, 137, 22);
		getContentPane().add(ConnectingFees);
		
		Email_Boxes = new JTextField();
		Email_Boxes.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Email_Boxes.setColumns(10);
		Email_Boxes.setBounds(171, 243, 137, 22);
		getContentPane().add(Email_Boxes);
		
		Night_Time = new JTextField();
		Night_Time.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Night_Time.setColumns(10);
		Night_Time.setBounds(171, 327, 137, 23);
		getContentPane().add(Night_Time);
		
		Web = new JTextField();
		Web.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Web.setColumns(10);
		Web.setBounds(171, 381, 137, 22);
		getContentPane().add(Web);
		
		Total_Monthly = new JTextField();
		Total_Monthly.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Total_Monthly.setColumns(10);
		Total_Monthly.setBounds(171, 464, 137, 22);
		getContentPane().add(Total_Monthly);
		
		Any_Time = new JTextField();
		Any_Time.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Any_Time.setColumns(10);
		Any_Time.setBounds(171, 421, 137, 22);
		getContentPane().add(Any_Time);
		
		JLabel lblRentalFee = new JLabel("Rental Fee");
		lblRentalFee.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblRentalFee.setBounds(459, 224, 96, 30);
		getContentPane().add(lblRentalFee);
		
		JLabel lblNoofchannels = new JLabel("No.Of.Channels");
		lblNoofchannels.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNoofchannels.setBounds(459, 265, 96, 30);
		getContentPane().add(lblNoofchannels);
		
		Rental_Fee = new JTextField();
		Rental_Fee.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Rental_Fee.setColumns(10);
		Rental_Fee.setBounds(609, 223, 137, 22);
		getContentPane().add(Rental_Fee);
		
		No_Of_Channels = new JTextField();
		No_Of_Channels.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		No_Of_Channels.setColumns(10);
		No_Of_Channels.setBounds(609, 264, 137, 22);
		getContentPane().add(No_Of_Channels);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(456, 331, 452, 106);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		LoadTables();
		
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"34", "Macro Package", "3000.00", "200.00", "48"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Package ID", "Package Name", "Connecting Fee", "Rental Fee", "No.Of.Channels"
			}
		));
		
		JLabel label = new JLabel("Mobile Package");
		label.setFont(new Font("Segoe UI", Font.BOLD, 15));
		label.setBounds(376, 447, 129, 37);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("TV Package");
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		label_1.setBounds(376, 283, 129, 37);
		getContentPane().add(label_1);
		
		JButton button_1 = new JButton("Delete");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = JOptionPane.showConfirmDialog(null,"Do you want to delete this");
		        
		        if(x == 0){
				
				String tpid = TvPackageID.getText();
				
				
				String query = "Delete from tv_package where TvPackageID='"+tpid+"'";
				
				
				try {
					PreparedStatement ps = Database.getConnection().prepareStatement(query);
				    ps.execute();
				
				} catch (SQLException e1) {
					
					e1.printStackTrace();
					//LoadTables();
				}
				LoadTables();
				
				
				
			}
			}});
		button_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		button_1.setBounds(799, 109, 93, 38);
		getContentPane().add(button_1);
		
		JButton button_3 = new JButton("Update");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = JOptionPane.showConfirmDialog(null,"Do you want to update this");
		        
		        if(x == 0){
				
				String tpid = TvPackageID.getText();
				String tnam = PackageNames.getText();
				int tcfee = Integer.parseInt(ConnectingFee.getText());
				double rfee = Double.parseDouble(Rental_Fee.getText());
				int nchannels = Integer.parseInt(No_Of_Channels.getText());
				
				try {
					String query = "Update tv_package set PackageName='"+tnam+"',ConnectingFee='"+tcfee+"',Rental_Fee='"+rfee+"',No_Of_Channels='"+nchannels+"' where TvPackageID='"+tpid+"'";
					
					PreparedStatement pst = Database.getConnection().prepareStatement(query);
					pst.execute();
					
					LoadTables();
				}catch(Exception e1) {
					e1.printStackTrace();
					//LoadTables();
				}
				LoadTables();
			}
			}});
		button_3.setFont(new Font("Segoe UI", Font.BOLD, 13));
		button_3.setBounds(799, 173, 93, 38);
		getContentPane().add(button_3);
		
		JButton button_5 = new JButton("Add");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = JOptionPane.showConfirmDialog(null,"Do you want to add this");
		        
		        if(x == 0){
				
				String tpid = TvPackageID.getText();
				String tnam = PackageNames.getText();
				String tcfee = ConnectingFee.getText();
				String rfee = Rental_Fee.getText();
				String nchannels = No_Of_Channels.getText();
				
				if(tpid.equals("")) {
					JOptionPane.showMessageDialog(null,"Please enter a valid TV Package ID");
				}
				else if(tnam.equals("")){
					JOptionPane.showMessageDialog(null,"Package Name field is empty");
				}
				else if(tcfee.equals("")){
					JOptionPane.showMessageDialog(null,"Connecting Fee field is empty");
				}
				else if(rfee.equals("")){
					JOptionPane.showMessageDialog(null,"Rental Fee field is empty");
				}
				else if(nchannels.equals("")){
					JOptionPane.showMessageDialog(null,"No.Of.Channels field is empty");
				}
				else {
					
				}
				
				
				try {
				String query = "Insert INTO tv_package(TvPackageID,PackageName,ConnectingFee,Rental_Fee,No_Of_Channels) values ('"+tpid+"','"+tnam+"','"+tcfee+"','"+rfee+"','"+nchannels+"')";
				
				PreparedStatement pst = Database.getConnection().prepareStatement(query);
				pst.execute();
				
				LoadTables();
				
				}catch(Exception e2) {
					e2.printStackTrace();
					//LoadTables();
				}
				
				LoadTables();
				
				
				
			}
			}});
		button_5.setFont(new Font("Segoe UI", Font.BOLD, 13));
		button_5.setBounds(799, 236, 93, 37);
		getContentPane().add(button_5);
		
		JLabel label_2 = new JLabel("Package ID");
		label_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_2.setBounds(33, 73, 85, 30);
		getContentPane().add(label_2);
		
		TvPackageID = new JTextField();
		TvPackageID.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		TvPackageID.setColumns(10);
		TvPackageID.setBounds(609, 90, 137, 22);
		getContentPane().add(TvPackageID);
		
		JLabel label_3 = new JLabel("Package ID");
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_3.setBounds(459, 86, 85, 30);
		getContentPane().add(label_3);
		
		MPackageID = new JTextField();
		MPackageID.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		MPackageID.setColumns(10);
		MPackageID.setBounds(171, 79, 137, 22);
		getContentPane().add(MPackageID);
		
		JLabel label_4 = new JLabel("Package Name");
		label_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_4.setBounds(459, 133, 96, 30);
		getContentPane().add(label_4);
		
		
		JLabel label_5 = new JLabel("Connecting Fee");
		label_5.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_5.setBounds(460, 178, 107, 33);
		getContentPane().add(label_5);
		
		ConnectingFee = new JTextField();
		ConnectingFee.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		ConnectingFee.setColumns(10);
		ConnectingFee.setBounds(609, 181, 137, 22);
		getContentPane().add(ConnectingFee);
		
		PackageNames = new JTextField();
		PackageNames.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		PackageNames.setColumns(10);
		PackageNames.setBounds(609, 137, 137, 22);
		getContentPane().add(PackageNames);
		
		LoadTable();
		LoadTables();
	}
}
