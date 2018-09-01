package ui.employees.tabs;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JInternalFrame;

import utils.common.database.Database;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import ui.components.KTab;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Executive extends KTab{
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtNIC;
	private JTextField txtMobNo;
	private JTextField txtFixedL;
	private JTextField txtAddress;
	private JTextField txtDesignation;
	private JTextField txtEmpID;
	private JTextField txtOfficeID;
	private JTextField txtPayrollID;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtIVRNo;
	private JTable table;

	private JDateChooser SDate;
	
	private JDateChooser EDate;

	private JDateChooser dob;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Executive frame = new Executive();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//Connecting to DB
	 public void loads() {
			
			try {
				ResultSet rs = Database.getConnection().prepareStatement("SELECT * FROM sales_executives e, contact_no c WHERE e.EmployeeID = c.EmployeeID").executeQuery();
				
				
				table.setModel(Database.resultSetToTableModel(rs));
				

				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
			}

	public Executive() {
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		
		SDate = new JDateChooser();
		SDate.setBounds(571, 75, 110, 20);
		getContentPane().add(SDate);
		
		EDate = new JDateChooser();
		EDate.setBounds(571, 106, 110, 20);
		getContentPane().add(EDate);
		
		dob = new JDateChooser();
		dob.setBounds(116, 137, 110, 20);
		getContentPane().add(dob);
		
		JLabel lblFName = new JLabel("First Name      :");
		lblFName.setBounds(26, 44, 89, 20);
		getContentPane().add(lblFName);
		
		txtFName = new JTextField();
		txtFName.setBounds(116, 44, 110, 20);
		txtFName.setColumns(10);
		getContentPane().add(txtFName);
		
		JLabel label_1 = new JLabel("Last Name       :");
		label_1.setBounds(26, 75, 89, 20);
		getContentPane().add(label_1);
		
		txtLName = new JTextField();
		txtLName.setBounds(116, 75, 110, 20);
		txtLName.setColumns(10);
		getContentPane().add(txtLName);
		
		JLabel lblGender = new JLabel("Gender            :");
		lblGender.setBounds(26, 106, 89, 20);
		getContentPane().add(lblGender);
		
		JComboBox txtGender = new JComboBox();
		txtGender.setBounds(116, 106, 110, 20);
		txtGender.setModel(new DefaultComboBoxModel(new String[] {"Select Gender", "MALE", "FEMALE"}));
		getContentPane().add(txtGender);
		
		JLabel lblDOB = new JLabel("D.O.B              :");
		lblDOB.setBounds(26, 137, 89, 20);
		getContentPane().add(lblDOB);
		
		JLabel lblNIC = new JLabel("NIC                  :");
		lblNIC.setBounds(26, 168, 89, 20);
		getContentPane().add(lblNIC);
		
		txtNIC = new JTextField();
		txtNIC.setBounds(116, 168, 110, 20);
		txtNIC.setColumns(10);
		getContentPane().add(txtNIC);
		
		JLabel lblMobile = new JLabel("Mobile No        :");
		lblMobile.setBounds(26, 199, 89, 20);
		getContentPane().add(lblMobile);
		
		txtMobNo = new JTextField();
		txtMobNo.setBounds(116, 199, 110, 20);
		txtMobNo.setColumns(10);
		getContentPane().add(txtMobNo);
		
		JLabel lblFixedLine = new JLabel("Fixed Line        :");
		lblFixedLine.setBounds(253, 44, 89, 20);
		getContentPane().add(lblFixedLine);
		
		txtFixedL = new JTextField();
		txtFixedL.setBounds(343, 44, 110, 20);
		txtFixedL.setColumns(10);
		getContentPane().add(txtFixedL);
		
		JLabel lblAddress = new JLabel("Address           :");
		lblAddress.setBounds(253, 75, 89, 20);
		getContentPane().add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(343, 76, 110, 20);
		txtAddress.setColumns(10);
		getContentPane().add(txtAddress);
		
		JLabel lblUserName = new JLabel("User Name      :");
		lblUserName.setBounds(253, 106, 89, 20);
		getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password        :");
		lblPassword.setBounds(253, 137, 89, 20);
		getContentPane().add(lblPassword);
		
		JLabel lblDesignation = new JLabel("Designation     :");
		lblDesignation.setBounds(253, 168, 89, 20);
		getContentPane().add(lblDesignation);
		
		txtDesignation = new JTextField();
		txtDesignation.setBounds(343, 168, 110, 20);
		txtDesignation.setColumns(10);
		getContentPane().add(txtDesignation);
		
		JLabel lblType = new JLabel("Type                :");
		lblType.setBounds(253, 199, 89, 20);
		getContentPane().add(lblType);
		
		JLabel lblEmployeeID = new JLabel("EmployeeID     :");
		lblEmployeeID.setBounds(481, 44, 89, 20);
		getContentPane().add(lblEmployeeID);
		
		txtEmpID = new JTextField();
		txtEmpID.setBounds(571, 44, 110, 20);
		txtEmpID.setColumns(10);
		getContentPane().add(txtEmpID);
		
		JLabel lblStartDate = new JLabel("Start Date       :");
		lblStartDate.setBounds(481, 75, 89, 20);
		getContentPane().add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date         :");
		lblEndDate.setBounds(481, 106, 89, 20);
		getContentPane().add(lblEndDate);
		
		JLabel lblIvrNo = new JLabel("IVR No             :");
		lblIvrNo.setBounds(481, 137, 89, 20);
		getContentPane().add(lblIvrNo);
		
		JLabel lblOfficeID = new JLabel("OfficeID           :");
		lblOfficeID.setBounds(481, 168, 89, 20);
		getContentPane().add(lblOfficeID);
		
		txtOfficeID = new JTextField();
		txtOfficeID.setBounds(571, 168, 110, 20);
		txtOfficeID.setColumns(10);
		getContentPane().add(txtOfficeID);
		
		JLabel lblPayrollID = new JLabel("PayrollID          :");
		lblPayrollID.setBounds(481, 199, 89, 20);
		getContentPane().add(lblPayrollID);
		
		txtPayrollID = new JTextField();
		txtPayrollID.setBounds(571, 199, 110, 20);
		txtPayrollID.setColumns(10);
		getContentPane().add(txtPayrollID);
		
		JButton button = new JButton("Create");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setBounds(855, 44, 89, 31);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Update");
		button_1.setBounds(855, 85, 89, 31);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Delete");
		button_2.setBounds(855, 128, 89, 31);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Refresh");
		button_3.setBounds(855, 172, 89, 31);
		getContentPane().add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 246, 959, 271);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(343, 107, 110, 20);
		txtUserName.setColumns(10);
		getContentPane().add(txtUserName);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(343, 137, 110, 20);
		txtPassword.setColumns(10);
		getContentPane().add(txtPassword);
		
		JComboBox cmbType = new JComboBox();
		cmbType.setBounds(342, 200, 110, 20);
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"Select Type", "DEPARTMENT_EMPLOYEE", "DEPARTMENT_MANAGER", "REGIONAL_MANAGER", "REGIONAL_STAFF", "COORDINATOR"}));
		getContentPane().add(cmbType);
		
		txtIVRNo = new JTextField();
		txtIVRNo.setBounds(571, 137, 110, 20);
		getContentPane().add(txtIVRNo);
		txtIVRNo.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(343, 44, 110, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

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
				String IVR = table.getValueAt(r, 11).toString();
				Date Sdate = Date.valueOf(table.getValueAt(r, 13).toString());
				Date Edate = Date.valueOf(table.getValueAt(r, 14).toString());
				String PayrollID = table.getValueAt(r, 15).toString();
				String OfficeID = table.getValueAt(r, 16).toString();
				String MobNo = table.getValueAt(r, 18).toString();
				String FixedNo = table.getValueAt(r, 19).toString();
				
				
				
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
				txtIVRNo.setText(IVR.toString());
				txtOfficeID.setText(OfficeID.toString());
				txtPayrollID.setText(PayrollID.toString());
				
			}//end of implementation of annonymous interface
			
		});//end of annonymous class
				

		loads()	;//calling method loads to get values from database and convert it to the jtable type values
		
		
		
		
	}
}
