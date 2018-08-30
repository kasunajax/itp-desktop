package ui.employees.tabs;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ManageEmployees extends KTab {
	private JTextField txtEmpID;
	private JTextField txtFn;
	private JTextField txtLn;
	private JTextField txtMn;
	private JTextField txtDesig;
	private JTextField txtAdd;
	private JTextField txtUn;
	private JTextField txtPw;
	private JTextField txtDOB;
	private JTextField txtType;
	private JTextField txtSDate;
	private JTextField txtEDate;
	private JTextField txtSalaryID;
	private JTextField txtOFC;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageEmployees frame = new ManageEmployees();
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
	
	public void loads() {
		
		try {
			ResultSet rs = Database.getConnection().prepareStatement("SELECT * FROM employees").executeQuery();
			
			table.setModel(Database.resultSetToTableModel(rs));
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
	public ManageEmployees() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee ID:");
		lblNewLabel.setBounds(77, 100, 69, 14);
		getContentPane().add(lblNewLabel);
		
		txtEmpID = new JTextField();
		txtEmpID.setBounds(155, 97, 104, 20);
		getContentPane().add(txtEmpID);
		txtEmpID.setColumns(10);
		
		txtFn = new JTextField();
		txtFn.setColumns(10);
		txtFn.setBounds(155, 128, 104, 20);
		getContentPane().add(txtFn);
		
		JLabel lblFirstname = new JLabel("First Name:");
		lblFirstname.setBounds(77, 131, 69, 14);
		getContentPane().add(lblFirstname);
		
		txtLn = new JTextField();
		txtLn.setColumns(10);
		txtLn.setBounds(155, 159, 104, 20);
		getContentPane().add(txtLn);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(77, 162, 69, 14);
		getContentPane().add(lblLastName);
		
		txtMn = new JTextField();
		txtMn.setColumns(10);
		txtMn.setBounds(155, 190, 104, 20);
		getContentPane().add(txtMn);
		
		JLabel lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setBounds(77, 193, 69, 14);
		getContentPane().add(lblMiddleName);
		
		txtDesig = new JTextField();
		txtDesig.setColumns(10);
		txtDesig.setBounds(155, 221, 104, 20);
		getContentPane().add(txtDesig);
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setBounds(77, 224, 69, 14);
		getContentPane().add(lblDesignation);
		
		txtAdd = new JTextField();
		txtAdd.setColumns(10);
		txtAdd.setBounds(155, 252, 104, 20);
		getContentPane().add(txtAdd);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(77, 255, 69, 14);
		getContentPane().add(lblAddress);
		
		txtUn = new JTextField();
		txtUn.setColumns(10);
		txtUn.setBounds(155, 283, 104, 20);
		getContentPane().add(txtUn);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(77, 286, 69, 14);
		getContentPane().add(lblUsername);
		
		txtPw = new JTextField();
		txtPw.setColumns(10);
		txtPw.setBounds(155, 314, 104, 20);
		getContentPane().add(txtPw);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(77, 317, 69, 14);
		getContentPane().add(lblPassword);
		
		txtDOB = new JTextField();
		txtDOB.setColumns(10);
		txtDOB.setBounds(155, 342, 104, 20);
		getContentPane().add(txtDOB);
		
		JLabel lblDob = new JLabel("DOB:");
		lblDob.setBounds(77, 345, 69, 14);
		getContentPane().add(lblDob);
		
		txtType = new JTextField();
		txtType.setColumns(10);
		txtType.setBounds(155, 373, 104, 20);
		getContentPane().add(txtType);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(77, 376, 69, 14);
		getContentPane().add(lblType);
		
		txtSDate = new JTextField();
		txtSDate.setColumns(10);
		txtSDate.setBounds(155, 404, 104, 20);
		getContentPane().add(txtSDate);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(77, 407, 69, 14);
		getContentPane().add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setBounds(77, 438, 69, 14);
		getContentPane().add(lblEndDate);
		
		txtEDate = new JTextField();
		txtEDate.setColumns(10);
		txtEDate.setBounds(155, 435, 104, 20);
		getContentPane().add(txtEDate);
		
		JLabel lblSalaryId = new JLabel("Salary ID:");
		lblSalaryId.setBounds(77, 466, 69, 14);
		getContentPane().add(lblSalaryId);
		
		txtSalaryID = new JTextField();
		txtSalaryID.setColumns(10);
		txtSalaryID.setBounds(155, 463, 104, 20);
		getContentPane().add(txtSalaryID);
		
		JLabel lblOfficeId = new JLabel("Office ID");
		lblOfficeId.setBounds(77, 494, 69, 14);
		getContentPane().add(lblOfficeId);
		
		txtOFC = new JTextField();
		txtOFC.setColumns(10);
		txtOFC.setBounds(155, 491, 104, 20);
		getContentPane().add(txtOFC);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(323, 100, 576, 303);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				int r = table.getSelectedRow();
		        
		        String empID = table.getValueAt(r, 0).toString();
		        String fn = table.getValueAt(r, 1).toString(); 
		        String ln = table.getValueAt(r, 2).toString();
		        String mn =  table.getValueAt(r, 3).toString();
		        String desig =  table.getValueAt(r, 4).toString();
		        String add = table.getValueAt(r, 5).toString();
		        String un = table.getValueAt(r, 6).toString();
		        String pw =  table.getValueAt(r, 7).toString();
		        
		        String dob = table.getValueAt(r, 8).toString();
		        String type = table.getValueAt(r, 9).toString(); 
		        String sdate = table.getValueAt(r, 10).toString();
		        String edate = null;
		        
		        
		        if(table.getValueAt(r, 11) != null)
		        	 edate =  table.getValueAt(r, 11).toString();
		        
		        String sid = null;
		        if(table.getValueAt(r, 12) != null)
		        	 sid =  table.getValueAt(r, 11).toString();
		        
		        String ofc = null;
		        if(table.getValueAt(r, 13) != null)
		        	 ofc =  table.getValueAt(r, 11).toString();
		        
		        
		        
		        txtEmpID.setText(empID);
		        txtFn.setText(fn);
		        txtLn.setText(ln);
		        txtMn.setText(mn);
		        txtDesig.setText(desig);
		        txtAdd.setText(add);
		        txtUn.setText(un);
		        txtPw.setText(pw);
		        txtDOB.setText(dob);
		        txtType.setText(type);
		        txtSDate.setText(sdate);
		        
		        
		        if(edate != null)
		        	txtEDate.setText(edate);
		        
		        if(sid != null)
		        	txtSalaryID.setText(sid);
		        
		        if(ofc != null) 
		        	txtOFC.setText(ofc);
		        
			}
			
			
			
		});
		
		loads();
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String sql = "INSERT INTO employees (`EmployeeID`, `FirstName`, `LastName`, `MiddleName`, `Designation`, `Address`, `Username`, `Password`, `DOB`, `Type`, `StartDate`, `EndDate`, `SalaryProfileID`, `OfficeID`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?, ?)";	
	
				
				try {
					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
					stmt.setString(1, txtEmpID.getText());
					stmt.setString(2, txtFn.getText());
					stmt.setString(3, txtLn.getText());
					stmt.setString(4, txtMn.getText());
					stmt.setString(5, txtDesig.getText());
					stmt.setString(6, txtAdd.getText());
					stmt.setString(7, txtUn.getText());
					stmt.setString(8, txtPw.getText());
					stmt.setString(9, txtDOB.getText());
					stmt.setString(10, txtType.getText());
					stmt.setString(11, txtSDate.getText());
					stmt.setString(12, txtEDate.getText());
					stmt.setString(13, txtSalaryID.getText());
					stmt.setString(14, txtOFC.getText());
					
					if(txtEDate.getText().equals("")) {
						stmt.setString(12, null);
					}
					
					if(txtSalaryID.getText().equals("")) {
						stmt.setString(13, null);
					}
					
					if(txtOFC.getText().equals("")) {
						stmt.setString(14, null);
					}
					
					
					stmt.execute();
					
					loads();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		btnInsert.setBounds(323, 485, 89, 23);
		getContentPane().add(btnInsert);
		
		

		
		
		
		

	}
}
