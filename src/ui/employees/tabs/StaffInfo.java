package ui.employees.tabs;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class StaffInfo extends KTab {
	private JTable table;
	private JLabel lblEmployeeID;
	private JTextField txtEmpID;
	private JLabel lblIVRNo;
	private JTextField txtIVRNo;
	private JLabel lblStartDate;
	private JTextField txtStartDate;
	private JLabel lblEndDate;
	private JTextField txtEndDate;
	private JLabel lblOfficeID;
	private JTextField txtOfficeID;
	private JLabel lblPayrollID;
	private JTextField txtPayrollID;
	private JLabel lblFixedLine;
	private JTextField txtFixedL;
	private JLabel lblAddress;
	private JTextField txtAddress;
	private JLabel lblUserName;
	private JTextField txtUserName;
	private JLabel lblPassword;
	private JTextField txtPassword;
	private JLabel lblDesignation;
	private JTextField txtDesignation;
	private JLabel lblType;
	private JComboBox cmbType;
	private JLabel lblFirstName;
	private JTextField txtFName;
	private JLabel lblMiddleName;
	private JTextField txtMName;
	private JLabel lblLastName;
	private JTextField txtLName;
	private JLabel lblGender;
	private JComboBox txtGender;
	private JLabel lblDOB;
	private JComboBox cmbDOB;
	private JLabel lblMobile;
	private JTextField txtMobNo;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffInfo frame = new StaffInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//Here we are assigning all the values from the table employees and assigning it to object rs
	//Then we are calling a method of the table object and setting the result..method of the database object to it while passing the info through the captured object rs previously
   public void loads() {
		
		try {
			ResultSet rs = Database.getConnection().prepareStatement("SELECT * FROM employees").executeQuery();
			
			
			table.setModel(Database.resultSetToTableModel(rs));
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}

	
	/**
	 * Create the frame.
	 */
	public StaffInfo() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 245, 959, 271);
		getContentPane().add(scrollPane);
		
		table = new JTable();

		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"First Name", "Middle Name", "Last Name", "Gender", "D.O.B", "Mobile No.", "Fixed Line", "Address", "User Name", "Password", "Designation", "Type", "EmployeeID", "IVR No.", "Start Date", "OfficeID", "PayrollID"
				}
				));
		
		scrollPane.setViewportView(table);
		
		
		
		lblEmployeeID = new JLabel("EmployeeID    :");
		lblEmployeeID.setBounds(481, 44, 89, 20);
		getContentPane().add(lblEmployeeID);
		
		txtEmpID = new JTextField();
		txtEmpID.setColumns(10);
		txtEmpID.setBounds(571, 44, 110, 20);
		getContentPane().add(txtEmpID);
		
		lblIVRNo = new JLabel("IVR No            :");
		lblIVRNo.setBounds(481, 75, 89, 20);
		getContentPane().add(lblIVRNo);
		
		txtIVRNo = new JTextField();
		txtIVRNo.setColumns(10);
		txtIVRNo.setBounds(571, 75, 110, 20);
		getContentPane().add(txtIVRNo);
		
		lblStartDate = new JLabel("Start Date      :");
		lblStartDate.setBounds(481, 106, 89, 20);
		getContentPane().add(lblStartDate);
		
		txtStartDate = new JTextField();
		txtStartDate.setColumns(10);
		txtStartDate.setBounds(571, 106, 110, 20);
		getContentPane().add(txtStartDate);
		
		lblEndDate = new JLabel("End Date        :");
		lblEndDate.setBounds(481, 137, 89, 20);
		getContentPane().add(lblEndDate);
		
		txtEndDate = new JTextField();
		txtEndDate.setColumns(10);
		txtEndDate.setBounds(571, 137, 110, 20);
		getContentPane().add(txtEndDate);
		
		lblOfficeID = new JLabel(" OfficeID        :");
		lblOfficeID.setBounds(481, 168, 89, 20);
		getContentPane().add(lblOfficeID);
		
		txtOfficeID = new JTextField();
		txtOfficeID.setColumns(10);
		txtOfficeID.setBounds(571, 168, 110, 20);
		getContentPane().add(txtOfficeID);
		
		lblPayrollID = new JLabel("PayrollID        :");
		lblPayrollID.setBounds(481, 199, 89, 20);
		getContentPane().add(lblPayrollID);
		
		txtPayrollID = new JTextField();
		txtPayrollID.setColumns(10);
		txtPayrollID.setBounds(571, 199, 110, 20);
		getContentPane().add(txtPayrollID);
		
		lblFixedLine = new JLabel("Fixed Line       :");
		lblFixedLine.setBounds(253, 44, 89, 20);
		getContentPane().add(lblFixedLine);
		
		txtFixedL = new JTextField();
		txtFixedL.setColumns(10);
		txtFixedL.setBounds(343, 44, 110, 20);
		getContentPane().add(txtFixedL);
		
		lblAddress = new JLabel("Address          :");
		lblAddress.setBounds(253, 75, 89, 20);
		getContentPane().add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(343, 75, 110, 20);
		getContentPane().add(txtAddress);
		
		lblUserName = new JLabel("User Name      :");
		lblUserName.setBounds(253, 106, 89, 20);
		getContentPane().add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(343, 106, 110, 20);
		getContentPane().add(txtUserName);
		
		lblPassword = new JLabel("Password        :");
		lblPassword.setBounds(253, 137, 89, 20);
		getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(343, 137, 110, 20);
		getContentPane().add(txtPassword);
		
		lblDesignation = new JLabel("Designation    :");
		lblDesignation.setBounds(253, 168, 89, 20);
		getContentPane().add(lblDesignation);
		
		txtDesignation = new JTextField();
		txtDesignation.setColumns(10);
		txtDesignation.setBounds(343, 168, 110, 20);
		getContentPane().add(txtDesignation);
		
		lblType = new JLabel("Type               :");
		lblType.setBounds(253, 199, 89, 20);
		getContentPane().add(lblType);
		
		cmbType = new JComboBox();
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"DEPARTMENT_EMPLOYEE", "DEPARTMENT_MANAGER", "REGIONAL_MANAGER", "REGIONAL_STAFF", "COORDINATOR", "SALES_EXECUTIVE"}));
		cmbType.setBounds(343, 199, 110, 20);
		getContentPane().add(cmbType);
		
		lblFirstName = new JLabel("First Name      :");
		lblFirstName.setBounds(26, 44, 89, 20);
		getContentPane().add(lblFirstName);
		
		txtFName = new JTextField();
		txtFName.setColumns(10);
		txtFName.setBounds(116, 44, 110, 20);
		getContentPane().add(txtFName);
		
		lblMiddleName = new JLabel("Middle Name   :");
		lblMiddleName.setBounds(26, 75, 89, 20);
		getContentPane().add(lblMiddleName);
		
		txtMName = new JTextField();
		txtMName.setColumns(10);
		txtMName.setBounds(116, 75, 110, 20);
		getContentPane().add(txtMName);
		
		lblLastName = new JLabel("Last Name       :");
		lblLastName.setBounds(26, 106, 89, 20);
		getContentPane().add(lblLastName);
		
		txtLName = new JTextField();
		txtLName.setColumns(10);
		txtLName.setBounds(116, 106, 110, 20);
		getContentPane().add(txtLName);
		
		lblGender = new JLabel("Gender            :");
		lblGender.setBounds(26, 137, 89, 20);
		getContentPane().add(lblGender);
		
		txtGender = new JComboBox();
		txtGender.setModel(new DefaultComboBoxModel(new String[] {"MALE", "FEMALE"}));
		txtGender.setBounds(116, 137, 110, 20);
		getContentPane().add(txtGender);
		
		lblDOB = new JLabel("D.O.B              :");
		lblDOB.setBounds(26, 168, 89, 20);
		getContentPane().add(lblDOB);
		
		cmbDOB = new JComboBox();
		cmbDOB.setBounds(116, 167, 110, 20);
		getContentPane().add(cmbDOB);
		
		lblMobile = new JLabel("Mobile No        :");
		lblMobile.setBounds(26, 199, 89, 20);
		getContentPane().add(lblMobile);
		
		txtMobNo = new JTextField();
		txtMobNo.setColumns(10);
		txtMobNo.setBounds(116, 199, 110, 20);
		getContentPane().add(txtMobNo);
		
		button = new JButton("Create");
		button.setBounds(855, 44, 89, 31);
		getContentPane().add(button);
		
		button_1 = new JButton("Update");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		button_1.setBounds(855, 85, 89, 31);
		getContentPane().add(button_1);
		
		button_2 = new JButton("Delete");
		button_2.setBounds(855, 128, 89, 31);
		getContentPane().add(button_2);
		
		button_3 = new JButton("Report");
		button_3.setBounds(855, 172, 89, 31);
		getContentPane().add(button_3);
		
		
		
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
//				int r = table.getSelectedRow();
//				
//				
//				String FName = table.getValueAt(r, 0).toString();
//				String MName = table.getValueAt(r, 2).toString();
//				String LName = table.getValueAt(r, 3).toString();
//				String Gender = table.getValueAt(r, 3).toString();
//				String DOB = table.getValueAt(r, 4).toString();
//				String MobNo = table.getValueAt(r, 5).toString();
//				String FixedNo = table.getValueAt(r, 6).toString();
//				String Address = table.getValueAt(r, 7).toString();
//				String UName = table.getValueAt(r, 8).toString();
//				String PWord = table.getValueAt(r, 9).toString();
//				String Designation = table.getValueAt(r, 10).toString();
//				String Type = table.getValueAt(r, 11).toString();
//				String EmpID = table.getValueAt(r, 12).toString();
//				String IVRNo = table.getValueAt(r, 13).toString();
//				String SDate = table.getValueAt(r, 14).toString();
//				String EDate = table.getValueAt(r, 15).toString();
				
				
//				String OfficeID = table.getValueAt(r, 16).toString();
//				String PayrollID = table.getValueAt(r, 17).toString();
				
				
				int r = table.getSelectedRow();
		        
		        String empID = table.getValueAt(r, 0).toString();
		        String fn = table.getValueAt(r, 1).toString(); 
		        String ln = table.getValueAt(r, 2).toString();
		        String mn =  table.getValueAt(r, 3).toString();
		        String desig =  table.getValueAt(r, 4).toString();
		        String add = table.getValueAt(r, 5).toString();
		        String un = table.getValueAt(r, 6).toString();
		        String pw =  table.getValueAt(r, 7).toString();
		        
		        //String dob = table.getValueAt(r, 8).toString();
		        String type = table.getValueAt(r, 10).toString(); 
		        String sdate = table.getValueAt(r, 11).toString();
		        String edate = null;
		        
		        
		        if(table.getValueAt(r, 12) != null)
		        	 edate =  table.getValueAt(r, 12).toString();
		        
		        String sid = null;
		        if(table.getValueAt(r, 13) != null)
		        	 sid =  table.getValueAt(r, 13).toString();
		        
		        String ofc = null;
		        if(table.getValueAt(r, 14) != null)
		        	 ofc =  table.getValueAt(r, 14).toString();
		        
		        
		        
		        txtEmpID.setText(empID);
		        txtFName.setText(fn);
		        txtLName.setText(ln);
		        txtMName.setText(mn);
		        txtDesignation.setText(desig);
		        txtAddress.setText(add);
		        txtUserName.setText(un);
		        txtPassword.setText(pw);
		        cmbType.setSelectedItem(type.toString());
		        txtStartDate.setText(sdate);
		        
		        
		        if(edate != null)
		        	txtEndDate.setText(edate);
		        
		        if(sid != null)
		        	txtPayrollID.setText(sid);
		        
		        if(ofc != null) 
		        	txtOfficeID.setText(ofc);
				
				
				
				
				
				
				}
			
			
			
			
		});
		
	
	
	
			
			
		loads();	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		
		
		

	}
	
	public void update(){
		String sql = "UPDATE `employees` SET `FirstName` = ?, `LastName` = ?, `MiddleName` = ?, `Designation` = ?, `Address` = ?, `Username` = ?, `Password` = ?, `DOB` = ?, `Type` = ?, `StartDate` = ?, `EndDate` = ?, `SalaryProfileID` = ?, `OfficeID` = ?, `Gender` = ? WHERE `EmployeeID` = ?";

		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
			stmt.setString(15, txtEmpID.getText());
			stmt.setString(1, txtFName.getText());
			stmt.setString(2, txtLName.getText());
			stmt.setString(3, txtMName.getText());
			stmt.setString(4, txtDesignation.getText());
			stmt.setString(5, txtAddress.getText());
			stmt.setString(6, txtUserName.getText());
			stmt.setString(7, txtPassword.getText());
			stmt.setString(8, "1993-02-12");
			stmt.setString(9, cmbType.getSelectedItem().toString());
			stmt.setString(10, txtStartDate.getText());
			stmt.setString(11, txtEndDate.getText());
			stmt.setString(12, txtPayrollID.getText());
			stmt.setString(13, txtOfficeID.getText());
			stmt.setString(14, txtGender.getSelectedItem().toString());
			
			if(txtEndDate.getText().equals("")) {
				stmt.setString(12, null);
			}
			
			if(txtPayrollID.getText().equals("")) {
				stmt.setString(13, null);
			}
			
			if(txtOfficeID.getText().equals("")) {
				stmt.setString(14, null);
			}
			
			
			stmt.execute();
			
			loads();
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
}

}
	

	