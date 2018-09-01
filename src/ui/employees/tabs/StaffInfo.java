package ui.employees.tabs;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

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
	private JLabel lblStartDate;
	private JLabel lblEndDate;
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
	private JLabel lblLastName;
	private JTextField txtLName;
	private JLabel lblGender;
	private JComboBox txtGender;
	private JLabel lblDOB;
	private JLabel lblMobile;
	private JTextField txtMobNo;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	
	private JDateChooser dob;
	
	private JDateChooser SDate;

	private JDateChooser EDate;
	private JTextField txtNIC;
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
			ResultSet rs = Database.getConnection().prepareStatement("SELECT * FROM employees e, contact_no c WHERE e.EmployeeID = c.EmployeeID").executeQuery();
			
			
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
		scrollPane.setBounds(10, 246, 959, 271);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		dob = new JDateChooser();
		dob.setBounds(571, 75, 110, 20);
		getContentPane().add(dob);
		
		SDate = new JDateChooser();
		SDate.setBounds(571, 106, 110, 20);
		getContentPane().add(SDate);
		
		EDate = new JDateChooser();
		EDate.setBounds(116, 137, 110, 20);
		getContentPane().add(EDate);
		
		lblEmployeeID = new JLabel("EmployeeID    :");
		lblEmployeeID.setBounds(481, 44, 89, 20);
		getContentPane().add(lblEmployeeID);
		
		txtEmpID = new JTextField();
		txtEmpID.setColumns(10);
		txtEmpID.setBounds(571, 44, 110, 20);
		getContentPane().add(txtEmpID);
		
		lblStartDate = new JLabel("Start Date      :");
		lblStartDate.setBounds(481, 75, 89, 20);
		getContentPane().add(lblStartDate);
		
		lblEndDate = new JLabel("End Date        :");
		lblEndDate.setBounds(481, 106, 89, 20);
		getContentPane().add(lblEndDate);
		
		lblOfficeID = new JLabel(" OfficeID        :");
		lblOfficeID.setBounds(481, 137, 89, 20);
		getContentPane().add(lblOfficeID);
		
		txtOfficeID = new JTextField();
		txtOfficeID.setColumns(10);
		txtOfficeID.setBounds(571, 137, 110, 20);
		getContentPane().add(txtOfficeID);
		
		lblPayrollID = new JLabel("PayrollID        :");
		lblPayrollID.setBounds(481, 168, 89, 20);
		getContentPane().add(lblPayrollID);
		
		txtPayrollID = new JTextField();
		txtPayrollID.setColumns(10);
		txtPayrollID.setBounds(571, 168, 110, 20);
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
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"Select Type", "DEPARTMENT_EMPLOYEE", "DEPARTMENT_MANAGER", "REGIONAL_MANAGER", "REGIONAL_STAFF", "COORDINATOR"}));
		cmbType.setBounds(343, 199, 110, 20);
		getContentPane().add(cmbType);
		
		lblFirstName = new JLabel("First Name      :");
		lblFirstName.setBounds(26, 44, 89, 20);
		getContentPane().add(lblFirstName);
		
		txtFName = new JTextField();
		txtFName.setColumns(10);
		txtFName.setBounds(116, 44, 110, 20);
		getContentPane().add(txtFName);
		
		lblLastName = new JLabel("Last Name       :");
		lblLastName.setBounds(26, 75, 89, 20);
		getContentPane().add(lblLastName);
		
		txtLName = new JTextField();
		txtLName.setColumns(10);
		txtLName.setBounds(116, 75, 110, 20);
		getContentPane().add(txtLName);
		
		lblGender = new JLabel("Gender            :");
		lblGender.setBounds(26, 106, 89, 20);
		getContentPane().add(lblGender);
		
		txtGender = new JComboBox();
		txtGender.setModel(new DefaultComboBoxModel(new String[] {"Select Gender", "MALE", "FEMALE"}));
		txtGender.setBounds(116, 106, 110, 20);
		getContentPane().add(txtGender);
		
		lblDOB = new JLabel("D.O.B              :");
		lblDOB.setBounds(26, 137, 89, 20);
		getContentPane().add(lblDOB);
		
		lblMobile = new JLabel("Mobile No        :");
		lblMobile.setBounds(26, 199, 89, 20);
		getContentPane().add(lblMobile);
		
		txtMobNo = new JTextField();
		txtMobNo.setColumns(10);
		txtMobNo.setBounds(116, 199, 110, 20);
		getContentPane().add(txtMobNo);
		
		button = new JButton("Create");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Create();
			}
		});
		button.setBounds(855, 44, 89, 31);
		getContentPane().add(button);
		
		button_1 = new JButton("Update");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update();
			}
		});
		button_1.setBounds(855, 85, 89, 31);
		getContentPane().add(button_1);
		
		button_2 = new JButton("Delete");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete();
			}
		});
		button_2.setBounds(855, 128, 89, 31);
		getContentPane().add(button_2);
		
		button_3 = new JButton("Refresh");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Refresh();
				
			}
		});
		button_3.setBounds(855, 172, 89, 31);
		getContentPane().add(button_3);
		
		JLabel lblNic = new JLabel("NIC                  :");
		lblNic.setBounds(26, 168, 89, 20);
		getContentPane().add(lblNic);
		
		txtNIC = new JTextField();
		txtNIC.setColumns(10);
		txtNIC.setBounds(116, 168, 110, 20);
		getContentPane().add(txtNIC);
		
		
		
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
			int r = table.getSelectedRow();				
				
				String EmpID = table.getValueAt(r, 0).toString();
				String FName = table.getValueAt(r, 1).toString();
				String LName = table.getValueAt(r, 2).toString();
				String Gender = table.getValueAt(r, 3).toString();
				Date DOB = Date.valueOf(table.getValueAt(r , 4).toString());
				String NIC = table.getValueAt(r, 5).toString();
				String Address = table.getValueAt(r, 6).toString();
				String Designation = table.getValueAt(r, 7).toString();
				String UName = table.getValueAt(r, 8).toString();
				String PWord = table.getValueAt(r, 9).toString();
				String Type = table.getValueAt(r, 10).toString();
				Date Sdate = Date.valueOf(table.getValueAt(r, 11).toString());
				Date Edate = Date.valueOf(table.getValueAt(r, 12).toString());
				String PayrollID = table.getValueAt(r, 13).toString();
				String OfficeID = table.getValueAt(r, 14).toString();
				String MobNo = table.getValueAt(r, 16).toString();
				String FixedNo = table.getValueAt(r, 17).toString();
				
				
				
				txtFName.setText(FName);
				txtLName.setText(LName);
				txtGender.setSelectedItem(Gender.toString());
				dob.setDate(DOB);
				txtNIC.setText(NIC);
				txtMobNo.setText(MobNo.toString());
				txtFixedL.setText(FixedNo.toString());
				txtAddress.setText(Address.toString());
				txtUserName.setText(UName.toString());
				txtPassword.setText(PWord.toString());
				txtDesignation.setText(Designation.toString());
				cmbType.setSelectedItem(Type.toString());
				txtEmpID.setText(EmpID.toString());
				SDate.setDate(Sdate);
				
				
				EDate.setDate(Edate);
				txtOfficeID.setText(OfficeID.toString());
				txtPayrollID.setText(PayrollID.toString());
				
			}//end of implementation of annonymous interface
			
		});//end of annonymous class
				

		loads()	;//calling method loads to get values from database and convert it to the jtable type values
		
		 
	}
	public void Create() {
		{
		String EmpID = txtEmpID.getText();
		String FName = txtFName.getText();
		String LName = txtLName.getText();
		String NIC = txtNIC.getText();
		String Address = txtAddress.getText();
		String Designation = txtDesignation.getText();
		String UName = txtUserName.getText();
		String PWord = txtPassword.getText();
		String PayrollID = txtPayrollID.getText();
		String OfficeID = txtOfficeID.getText();		
	
		String MobNo = txtMobNo.getText();
		
		
		Pattern pattern1 = Pattern.compile("\\d{10}");
		Matcher mobile = pattern1.matcher(MobNo);
        
		String FixedNo = txtFixedL.getText();
		Pattern pattern2 = Pattern.compile("\\d{10}");
		Matcher match2 = pattern2.matcher(FixedNo);
		
		 if(!mobile.matches() || mobile.equals("")) {
			JOptionPane.showMessageDialog(null,"Please enter a valid Mobile no");
		}
		
		else if(!match2.matches() || match2.equals("")) {
			JOptionPane.showMessageDialog(null,"Please enter a valid Fixed Line no");
		}
		else if(EmpID.equals("")){
			JOptionPane.showMessageDialog(null,"Enter EmployeeID");
			}
		else if(FName.equals("")){
			JOptionPane.showMessageDialog(null,"Enter First Name");
			}
		else if(LName.equals("")){
			JOptionPane.showMessageDialog(null,"Enter Last Name");
			}
		else if(NIC.equals("")){
			JOptionPane.showMessageDialog(null,"NIC");
			}
		else if(Address.equals("")){
			JOptionPane.showMessageDialog(null,"Enter Address");
			}
		else if(Designation.equals("")){
			JOptionPane.showMessageDialog(null,"Enter Designation");
			}
		else if(UName.equals("")){
			JOptionPane.showMessageDialog(null,"Enter UserName");
			}
		else if(PWord.equals("")){
			JOptionPane.showMessageDialog(null,"Enter Password");
			}
		else if(PayrollID.equals("")){
			JOptionPane.showMessageDialog(null,"Enter PayrollID");
			}
		else if(OfficeID.equals("")){
			JOptionPane.showMessageDialog(null,"Enter OfficeID");
			}
		
		 
		else {
		
		
		
		
		String sql = "INSERT INTO `employees` (`EmployeeID`, `FirstName`, `LastName`, `Gender`, `DOB`, `NIC`, `Address`, `Designation`,`Username`, `Password`, `Type`, `StartDate`, `EndDate`, `SalaryProfileID`, `OfficeID`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try { 
						PreparedStatement stmt = Database.getConnection().prepareStatement(sql);

			stmt.setString(1, txtEmpID.getText());
			stmt.setString(2, txtFName.getText());
			stmt.setString(3, txtLName.getText());
			stmt.setString(4, txtGender.getSelectedItem().toString());
			stmt.setDate(5, new Date(dob.getDate().getTime()));
			stmt.setString(6, txtNIC.getText());
			stmt.setString(7, txtAddress.getText());
			stmt.setString(8, txtDesignation.getText());
			stmt.setString(9, txtUserName.getText());
			stmt.setString(10, txtPassword.getText());
			stmt.setString(11, cmbType.getSelectedItem().toString());
			stmt.setDate(12, new Date(SDate.getDate().getTime()));
			stmt.setDate(13, new Date(SDate.getDate().getTime()));
			stmt.setString(14, txtPayrollID.getText());
			stmt.setString(15, txtOfficeID.getText());
			

			stmt.execute();
			loads()	;
			
			
			
			
			
		} catch (SQLException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
	
		String sql1 = "INSERT INTO `contact_no` (`EmployeeID`, `Telephone_No`, `FIXED_NO`) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql1);
			
			stmt.setString(1, txtEmpID.getText());
			stmt.setString(2, txtMobNo.getText());
			stmt.setString(3, txtFixedL.getText());
			
			stmt.execute();
			loads()	;
			
		}
		
		catch(SQLException e1){
			e1.printStackTrace();
		}
		}}
	}
	
	
	public void Refresh() {
		
		txtFName.setText(null);
		txtLName.setText(null);
		txtGender.setSelectedItem("Select Gender");
		dob.setDate(null);
		txtNIC.setText(null);
		txtMobNo.setText(null);
		txtFixedL.setText(null);
		txtAddress.setText(null);
		txtUserName.setText(null);
		txtPassword.setText(null);
		txtDesignation.setText(null);
		cmbType.setSelectedItem("Select Type");
		txtEmpID.setText(null);
		SDate.setDate(null);
		EDate.setDate(null);
		txtOfficeID.setText(null);
		txtPayrollID.setText(null);
		loads()	;
	}
	
	public void Update(){
			String sql = "UPDATE `employees` SET `FirstName` = ?, `LastName` = ?, `Gender` = ?, `DOB` = ?, `NIC` = ?, `Address` = ?, `Designation` = ?, `Username` = ?, `Password` = ?, `Type` = ?, `StartDate` = ?, `EndDate` = ?, `SalaryProfileID` = ?, `OfficeID` = ? WHERE `employees`.`EmployeeID` = ?"; 
			
		try { 
						PreparedStatement stmt = Database.getConnection().prepareStatement(sql);

			stmt.setString(15, txtEmpID.getText());
			stmt.setString(1, txtFName.getText());
			stmt.setString(2, txtLName.getText());
			stmt.setString(3, txtGender.getSelectedItem().toString());
			stmt.setDate(4, new Date(dob.getDate().getTime()));
			stmt.setString(5, txtNIC.getText());
			stmt.setString(6, txtAddress.getText());
			stmt.setString(7, txtDesignation.getText());
			stmt.setString(8, txtUserName.getText());
			stmt.setString(9, txtPassword.getText());
			stmt.setString(10, cmbType.getSelectedItem().toString());
			stmt.setDate(11, new Date(SDate.getDate().getTime()));
			stmt.setDate(12, new Date(SDate.getDate().getTime()));
			stmt.setString(13, txtPayrollID.getText());
			stmt.setString(14, txtOfficeID.getText());
			

			stmt.execute();
			loads()	;
			
			
			
			
			
		} catch (SQLException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		String sql1 = "UPDATE `contact_no` SET `Telephone_No` = ?, `FIXED_NO` = ? WHERE EmployeeID = ? "; 
		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql1);
			
			stmt.setString(3, txtEmpID.getText());
			stmt.setString(1, txtMobNo.getText());
			stmt.setString(2, txtFixedL.getText());
			
			stmt.execute();
			loads()	;
			
		}
		
		catch(SQLException e1){
			e1.printStackTrace();
		}

		

			
	}
	
	public void Delete() {
		
		String sql = "DELETE FROM `employees` WHERE `EmployeeID` = ?";
		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
			
			stmt.setString(1, txtEmpID.getText());
			
			stmt.execute();
			loads()	;
			
		}
		
		catch(SQLException e1){
			e1.printStackTrace();
		}
	
	String sql1 = "DELETE FROM `contact_no` WHERE `EmployeeID` = ?";

	try {
		PreparedStatement stmt = Database.getConnection().prepareStatement(sql1);
		
		stmt.setString(1, txtEmpID.getText());
		
		stmt.execute();
		loads()	;
		
	}
	
	catch(SQLException e1){
		e1.printStackTrace();
	}
}
	
}
	