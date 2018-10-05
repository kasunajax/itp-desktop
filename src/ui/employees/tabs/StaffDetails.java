package ui.employees.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import utils.common.database.Database;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StaffDetails extends KTab {
	private JTextField txtfname;
	private JTextField txtlname;
	private JTextField txtnic;
	private JTextField txtmobno;
	private JTextField txtfixedno;
	private JTextField txthaddress;
	private JTextField txtempid;
	private JTextField txtdesignation;
	private JTextField txtofficeid;
	private JTextField txtpayrollid;
	private JTextField txtivrno;
	private JTextField txtuname;
	private JTextField txtpword;
	private JDateChooser dob;
	private JDateChooser SDate;
	private JDateChooser EDate;
	private JTable table_general;
	private JTextField txtFindID;
	private JTable table_office;
	private JComboBox cmbgender, cmbtype;
	private String typeSql;
	private int checkQue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		System.out.println("hello");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffDetails frame = new StaffDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loads() {

		try {
			ResultSet rs = Database.getConnection().prepareStatement(
					"SELECT e.EmployeeID, e.FirstName, e.LastName, e.Gender, e.DOB, e.NIC, e.Address, c.Telephone_No, c.FIXED_NO FROM employees e, contact_no c WHERE e.EmployeeID = c.EmployeeID UNION SELECT se.EmployeeID, se.FirstName, se.LastName, se.Gender, se.DOB, se.NIC, se.Address, c.Telephone_No, c.FIXED_NO FROM sales_executives se, contact_no c WHERE se.EmployeeID = c.EmployeeID ")
					.executeQuery();

			table_general.setModel(Database.resultSetToTableModel(rs));

			ResultSet rs2 = Database.getConnection().prepareStatement(
					"SELECT EmployeeID, Designation, Username, Password, Type, StartDate, EndDate, SalaryProfileID,OfficeID, NULL AS IVR FROM employees UNION SELECT EmployeeID, Designation, Username, Password, Type, StartDate, EndDate, SalaryProfileID, OfficeID, IVR FROM sales_executives ")
					.executeQuery();
			table_office.setModel(Database.resultSetToTableModel(rs2));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public StaffDetails() {

		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(23, 36, 339, 282);
		panel.setBorder(new TitledBorder(null, "General Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 73, 31, 197, 0 }; // General details panel
		gbl_panel.rowHeights = new int[] { 20, 20, 20, 20, 20, 20, 20, 20, 0, 20, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblFirstName = new JLabel("First Name:");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.WEST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5); // FIRST NAME LABEL
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 0;
		panel.add(lblFirstName, gbc_lblFirstName);

		txtfname = new JTextField();
		GridBagConstraints gbc_txtfname = new GridBagConstraints();
		gbc_txtfname.anchor = GridBagConstraints.NORTH;
		gbc_txtfname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfname.insets = new Insets(0, 0, 5, 0); // FIRST NAME TEXT BOX
		gbc_txtfname.gridx = 2; // txtfname
		gbc_txtfname.gridy = 0;
		panel.add(txtfname, gbc_txtfname);
		txtfname.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name:");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5); // LAST NAME LABEL
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 1;
		panel.add(lblLastName, gbc_lblLastName);

		txtlname = new JTextField();
		txtlname.setColumns(10);
		GridBagConstraints gbc_txtlname = new GridBagConstraints();
		gbc_txtlname.anchor = GridBagConstraints.NORTH;
		gbc_txtlname.fill = GridBagConstraints.HORIZONTAL; // LAST NAME TEXT BOX
		gbc_txtlname.insets = new Insets(0, 0, 5, 0); // txtlname
		gbc_txtlname.gridx = 2;
		gbc_txtlname.gridy = 1;
		panel.add(txtlname, gbc_txtlname);

		JLabel lblGender = new JLabel("Gender :");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.fill = GridBagConstraints.HORIZONTAL; // GENDER LABEL
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 2;
		panel.add(lblGender, gbc_lblGender);

		cmbgender = new JComboBox();
		cmbgender.setModel(new DefaultComboBoxModel(new String[] { "GENDER", "MALE", "FEMALE" }));
		GridBagConstraints gbc_cmbgender = new GridBagConstraints();
		gbc_cmbgender.anchor = GridBagConstraints.NORTH;
		gbc_cmbgender.fill = GridBagConstraints.HORIZONTAL; // COMBO BOX GENDER
		gbc_cmbgender.insets = new Insets(0, 0, 5, 0); // cmbgender
		gbc_cmbgender.gridx = 2;
		gbc_cmbgender.gridy = 2;
		panel.add(cmbgender, gbc_cmbgender);

		JLabel lblDob = new JLabel("D.O.B:");
		GridBagConstraints gbc_lblDob = new GridBagConstraints();
		gbc_lblDob.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDob.insets = new Insets(0, 0, 5, 5); // DOB LABEL
		gbc_lblDob.gridx = 0;
		gbc_lblDob.gridy = 3;
		panel.add(lblDob, gbc_lblDob);

		dob = new JDateChooser();
		GridBagConstraints gbc_dob = new GridBagConstraints();
		gbc_dob.anchor = GridBagConstraints.NORTH;
		gbc_dob.fill = GridBagConstraints.HORIZONTAL;
		gbc_dob.insets = new Insets(0, 0, 5, 0); // DATE CHOOSER
		gbc_dob.gridx = 2; // dob
		gbc_dob.gridy = 3;
		panel.add(dob, gbc_dob);

		JLabel lblNic = new JLabel("NIC:");
		GridBagConstraints gbc_lblNic = new GridBagConstraints();
		gbc_lblNic.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNic.insets = new Insets(0, 0, 5, 5); // NIC LABEL
		gbc_lblNic.gridx = 0;
		gbc_lblNic.gridy = 4;
		panel.add(lblNic, gbc_lblNic);

		txtnic = new JTextField();
		txtnic.setColumns(10);
		GridBagConstraints gbc_txtnic = new GridBagConstraints();
		gbc_txtnic.anchor = GridBagConstraints.NORTH;
		gbc_txtnic.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnic.insets = new Insets(0, 0, 5, 0); // NIC TEXT BOX
		gbc_txtnic.gridx = 2; // txtnic
		gbc_txtnic.gridy = 4;
		panel.add(txtnic, gbc_txtnic);

		JLabel lblMobileNo = new JLabel("Mobile No:");
		GridBagConstraints gbc_lblMobileNo = new GridBagConstraints();
		gbc_lblMobileNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMobileNo.insets = new Insets(0, 0, 5, 5); // MOBILE NUMBER LABEL
		gbc_lblMobileNo.gridx = 0;
		gbc_lblMobileNo.gridy = 5;
		panel.add(lblMobileNo, gbc_lblMobileNo);

		txtmobno = new JTextField();
		txtmobno.setColumns(10);
		GridBagConstraints gbc_txtmobno = new GridBagConstraints();
		gbc_txtmobno.anchor = GridBagConstraints.NORTH;
		gbc_txtmobno.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtmobno.insets = new Insets(0, 0, 5, 0); // MOBILE NUMBER TEXT BOX
		gbc_txtmobno.gridx = 2; // txtmobno
		gbc_txtmobno.gridy = 5;
		panel.add(txtmobno, gbc_txtmobno);

		JLabel lblFixedNo = new JLabel("Fixed No:");
		GridBagConstraints gbc_lblFixedNo = new GridBagConstraints();
		gbc_lblFixedNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFixedNo.insets = new Insets(0, 0, 5, 5); // FIXED NUMBER LABEL
		gbc_lblFixedNo.gridx = 0;
		gbc_lblFixedNo.gridy = 6;
		panel.add(lblFixedNo, gbc_lblFixedNo);

		txtfixedno = new JTextField();
		txtfixedno.setColumns(10);
		GridBagConstraints gbc_txtfixedno = new GridBagConstraints();
		gbc_txtfixedno.anchor = GridBagConstraints.NORTH;
		gbc_txtfixedno.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfixedno.insets = new Insets(0, 0, 5, 0); // FIXED NUMBER TEXT BOX
		gbc_txtfixedno.gridx = 2; // txtfixedno
		gbc_txtfixedno.gridy = 6;
		panel.add(txtfixedno, gbc_txtfixedno);

		JLabel lblAddress = new JLabel("Address:");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5); // ADDRESS LABEL
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 7;
		panel.add(lblAddress, gbc_lblAddress);

		txthaddress = new JTextField();
		txthaddress.setColumns(10);
		GridBagConstraints gbc_txthaddress = new GridBagConstraints();
		gbc_txthaddress.gridheight = 3;
		gbc_txthaddress.insets = new Insets(0, 0, 5, 0); // ADDRESS TEXT BOX
		gbc_txthaddress.fill = GridBagConstraints.BOTH; // txthaddress
		gbc_txthaddress.gridx = 2;
		gbc_txthaddress.gridy = 7;
		panel.add(txthaddress, gbc_txthaddress);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(364, 36, 339, 282);
		panel_1.setBorder(new TitledBorder(null, "Office Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 77, 31, 193, 0 }; // OFFICE DETAILS PANEL
		gbl_panel_1.rowHeights = new int[] { 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblIvrNo = new JLabel("IVR No:");
		GridBagConstraints gbc_lblIvrNo = new GridBagConstraints();
		gbc_lblIvrNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIvrNo.insets = new Insets(0, 0, 5, 5); // IVR NO LABEL
		gbc_lblIvrNo.gridx = 0;
		gbc_lblIvrNo.gridy = 5;
		panel_1.add(lblIvrNo, gbc_lblIvrNo);

		JLabel lblType = new JLabel("Employee Type:");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.WEST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0; // EMPLOYEE TYPE LABEL
		gbc_lblType.gridy = 0;
		panel_1.add(lblType, gbc_lblType);

		cmbtype = new JComboBox();
		cmbtype.setModel(
				new DefaultComboBoxModel(new String[] { "EMPLOYEE TYPE", "Internal Staff", "Sales Executive" }));
		cmbtype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtivrno.setEnabled(false);
				lblIvrNo.setEnabled(false);
				checkQue = 6;
				if (cmbtype.getSelectedItem().equals("Sales Executive")) {
					txtivrno.setEnabled(true);
					lblIvrNo.setEnabled(true);
					checkQue = 0;

				} else if (cmbtype.getSelectedItem().equals("Internal Staff")) {
					txtivrno.setEnabled(false);
					lblIvrNo.setEnabled(false);
					checkQue = 1;
				} else {
					txtivrno.setEnabled(false);
					lblIvrNo.setEnabled(false);
					// checkQue = 2;
				}
			}
		});
		GridBagConstraints gbc_cmbtype = new GridBagConstraints();
		gbc_cmbtype.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbtype.anchor = GridBagConstraints.NORTH;
		gbc_cmbtype.insets = new Insets(0, 0, 5, 0); // TYPE COMBO BOX
		gbc_cmbtype.gridx = 2; // cmbtype
		gbc_cmbtype.gridy = 0;
		panel_1.add(cmbtype, gbc_cmbtype);

		JLabel lblEmpID = new JLabel("Employee ID:");
		GridBagConstraints gbc_lblEmpID = new GridBagConstraints();
		gbc_lblEmpID.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEmpID.insets = new Insets(0, 0, 5, 5); // EMPLOYEEID LABEL
		gbc_lblEmpID.gridx = 0;
		gbc_lblEmpID.gridy = 1;
		panel_1.add(lblEmpID, gbc_lblEmpID);

		txtempid = new JTextField();
		GridBagConstraints gbc_txtempid = new GridBagConstraints();
		gbc_txtempid.anchor = GridBagConstraints.NORTH;
		gbc_txtempid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtempid.insets = new Insets(0, 0, 5, 0); // EMPLOYEEID TEXT BOX
		gbc_txtempid.gridx = 2; // txtempid
		gbc_txtempid.gridy = 1;
		panel_1.add(txtempid, gbc_txtempid);
		txtempid.setColumns(10);

		JLabel lblDesignation = new JLabel("Designation:");
		GridBagConstraints gbc_lblDesignation = new GridBagConstraints();
		gbc_lblDesignation.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDesignation.insets = new Insets(0, 0, 5, 5); // DESIGNATION LABEL
		gbc_lblDesignation.gridx = 0;
		gbc_lblDesignation.gridy = 2;
		panel_1.add(lblDesignation, gbc_lblDesignation);

		txtdesignation = new JTextField();
		txtdesignation.setColumns(10);
		GridBagConstraints gbc_txtdesignation = new GridBagConstraints();
		gbc_txtdesignation.anchor = GridBagConstraints.NORTH;
		gbc_txtdesignation.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdesignation.insets = new Insets(0, 0, 5, 0); // DESIGNATION TEXT BOX
		gbc_txtdesignation.gridx = 2; // txtdesignation
		gbc_txtdesignation.gridy = 2;
		panel_1.add(txtdesignation, gbc_txtdesignation);

		JLabel lblOfficeId = new JLabel("Office ID:");
		GridBagConstraints gbc_lblOfficeId = new GridBagConstraints();
		gbc_lblOfficeId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblOfficeId.insets = new Insets(0, 0, 5, 5); // OFFICE ID LABEL
		gbc_lblOfficeId.gridx = 0;
		gbc_lblOfficeId.gridy = 3;
		panel_1.add(lblOfficeId, gbc_lblOfficeId);

		txtofficeid = new JTextField();
		txtofficeid.setColumns(10);
		GridBagConstraints gbc_txtofficeid = new GridBagConstraints();
		gbc_txtofficeid.anchor = GridBagConstraints.NORTH;
		gbc_txtofficeid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtofficeid.insets = new Insets(0, 0, 5, 0); // OFFICE ID TEXT BOX
		gbc_txtofficeid.gridx = 2; // txtofficeid
		gbc_txtofficeid.gridy = 3;
		panel_1.add(txtofficeid, gbc_txtofficeid);

		JLabel lblPayrollId = new JLabel("Payroll ID:");
		GridBagConstraints gbc_lblPayrollId = new GridBagConstraints();
		gbc_lblPayrollId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPayrollId.insets = new Insets(0, 0, 5, 5); // PAYROLL ID LABEL
		gbc_lblPayrollId.gridx = 0;
		gbc_lblPayrollId.gridy = 4;
		panel_1.add(lblPayrollId, gbc_lblPayrollId);

		txtpayrollid = new JTextField();
		txtpayrollid.setColumns(10);
		GridBagConstraints gbc_txtpayrollid = new GridBagConstraints();
		gbc_txtpayrollid.anchor = GridBagConstraints.NORTH;
		gbc_txtpayrollid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpayrollid.insets = new Insets(0, 0, 5, 0); // PAYROLL TEXT BOX
		gbc_txtpayrollid.gridx = 2; // txtpayrollid
		gbc_txtpayrollid.gridy = 4;
		panel_1.add(txtpayrollid, gbc_txtpayrollid);

		txtivrno = new JTextField();
		txtivrno.setColumns(10);
		GridBagConstraints gbc_txtivrno = new GridBagConstraints();
		gbc_txtivrno.anchor = GridBagConstraints.NORTH;
		gbc_txtivrno.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtivrno.insets = new Insets(0, 0, 5, 0); // IVR TEXT BOX
		gbc_txtivrno.gridx = 2; // txtivrno
		gbc_txtivrno.gridy = 5;
		panel_1.add(txtivrno, gbc_txtivrno);

		JLabel lblUserName = new JLabel("User Name:");
		GridBagConstraints gbc_lblUserName = new GridBagConstraints();
		gbc_lblUserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUserName.insets = new Insets(0, 0, 5, 5); // USER NAME LABEL
		gbc_lblUserName.gridx = 0;
		gbc_lblUserName.gridy = 6;
		panel_1.add(lblUserName, gbc_lblUserName);

		txtuname = new JTextField();
		txtuname.setColumns(10);
		GridBagConstraints gbc_txtuname = new GridBagConstraints();
		gbc_txtuname.anchor = GridBagConstraints.NORTH;
		gbc_txtuname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtuname.insets = new Insets(0, 0, 5, 0); // USER NAME TEXT BOX
		gbc_txtuname.gridx = 2; // txtuname
		gbc_txtuname.gridy = 6;
		panel_1.add(txtuname, gbc_txtuname);

		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5); // PASSWORD LABEL
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 7;
		panel_1.add(lblPassword, gbc_lblPassword);

		txtpword = new JTextField();
		txtpword.setColumns(10);
		GridBagConstraints gbc_txtpword = new GridBagConstraints();
		gbc_txtpword.anchor = GridBagConstraints.NORTH;
		gbc_txtpword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpword.insets = new Insets(0, 0, 5, 0); // PASSWORD TEXT BOX
		gbc_txtpword.gridx = 2; // txtpword
		gbc_txtpword.gridy = 7;
		panel_1.add(txtpword, gbc_txtpword);

		JLabel lblStartDate = new JLabel("Start Date:");
		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStartDate.insets = new Insets(0, 0, 5, 5); // START DATE LABEL
		gbc_lblStartDate.gridx = 0;
		gbc_lblStartDate.gridy = 8;
		panel_1.add(lblStartDate, gbc_lblStartDate);

		SDate = new JDateChooser();
		GridBagConstraints gbc_SDate = new GridBagConstraints();
		gbc_SDate.anchor = GridBagConstraints.NORTH;
		gbc_SDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_SDate.insets = new Insets(0, 0, 5, 0); // DATECHOOSER
		gbc_SDate.gridx = 2; // SDate
		gbc_SDate.gridy = 8;
		panel_1.add(SDate, gbc_SDate);

		JLabel lblEndDate = new JLabel("End Date:");
		GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
		gbc_lblEndDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEndDate.insets = new Insets(0, 0, 0, 5); // END DATE LABEL
		gbc_lblEndDate.gridx = 0;
		gbc_lblEndDate.gridy = 9;
		panel_1.add(lblEndDate, gbc_lblEndDate);

		EDate = new JDateChooser();
		GridBagConstraints gbc_EDate = new GridBagConstraints();
		gbc_EDate.anchor = GridBagConstraints.NORTH;
		gbc_EDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_EDate.gridx = 2; // DATE CHOOSER
		gbc_EDate.gridy = 9; // EDate
		panel_1.add(EDate, gbc_EDate);

		JScrollPane scrollPane = new JScrollPane(); // SCROLL PANE FOR GENERAL TABLE
		scrollPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"General Details", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		scrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(10, 329, 960, 95);
		getContentPane().add(scrollPane);

		table_general = new JTable(); // GENERAL TABLE
		table_general.setBorder(null); // table_general
		scrollPane.setViewportView(table_general);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "Search Employee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(727, 59, 243, 81);
		getContentPane().add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0 }; // PANEL FOR SEARCH EMPLOYEE
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblEmployeeId = new JLabel("Employee ID:");
		GridBagConstraints gbc_lblEmployeeId = new GridBagConstraints();
		gbc_lblEmployeeId.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmployeeId.gridx = 0; // EMPLOYEE ID LABEL
		gbc_lblEmployeeId.gridy = 0;
		panel_2.add(lblEmployeeId, gbc_lblEmployeeId);

		txtFindID = new JTextField();
		GridBagConstraints gbc_txtFindID = new GridBagConstraints();
		gbc_txtFindID.insets = new Insets(0, 0, 5, 0);
		gbc_txtFindID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFindID.gridx = 2; // EMPLOYEE ID TEXT BOX
		gbc_txtFindID.gridy = 0; // txtFindID
		panel_2.add(txtFindID, gbc_txtFindID);
		txtFindID.setColumns(10);

		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() { // SEARCH BUTTON
			public void actionPerformed(ActionEvent e) { // BUTTON ID: btnSearch
				Search();
			}
		});
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.anchor = GridBagConstraints.EAST;
		gbc_btnSearch.gridx = 2;
		gbc_btnSearch.gridy = 1;
		panel_2.add(btnSearch, gbc_btnSearch);

		JButton btnCreate = new JButton("CREATE"); // CREATE BUTTON
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Create();
			}
		});
		btnCreate.setBounds(804, 163, 89, 23); // btnCreate
		getContentPane().add(btnCreate);

		JButton btnUpdate = new JButton("UPDATE"); // UPDATE BUTTON
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Update();
			}
		});
		btnUpdate.setBounds(804, 197, 89, 23); // btnUpdate
		getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("DELETE"); // DELETE BUTTON
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Delete();
			}
		});
		btnDelete.setBounds(804, 231, 89, 23); // btnDelete
		getContentPane().add(btnDelete);

		JButton btnRefresh = new JButton("REFRESH"); // REFRESH BUTTON
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Refresh();
			}
		});
		btnRefresh.setBounds(804, 265, 89, 23); // btnRefresh
		getContentPane().add(btnRefresh);

		JScrollPane scrollPane_1 = new JScrollPane(); // PANE FOR OFFICE DETAILS
		scrollPane_1.setBorder(
				new TitledBorder(null, "Office Details", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		scrollPane_1.setBounds(10, 440, 961, 96);
		getContentPane().add(scrollPane_1);

		table_office = new JTable();
		scrollPane_1.setViewportView(table_office); // OFFICE TABLE table_office

		loads(); // LOADING VALUES TO THE TWO TABLES
	}

	/**
	 * 
	 */
	public void Search() {
		String sql = "SELECT * FROM employees WHERE EmployeeID = ?";
		String sql3 = "SELECT EmployeeID, FirstName, LastName, GENDER, DOB, NIC, Address, Type, Designation, Username, Password, IVR, StartDate, EndDate, SalaryProfileID, OfficeID FROM sales_executives WHERE EmployeeID = ?";
		String sql2 = "SELECT Telephone_No, FIXED_NO FROM contact_no  WHERE EmployeeID = ?";

		try {
			PreparedStatement ps = Database.getConnection().prepareStatement(sql);
			PreparedStatement ps1 = Database.getConnection().prepareStatement(sql2);
			PreparedStatement ps2 = Database.getConnection().prepareStatement(sql3);

			ps.setString(1, txtFindID.getText());
			ResultSet rs = ps.executeQuery();
			ps1.setString(1, txtFindID.getText());
			ResultSet rs1 = ps1.executeQuery();
			ps2.setString(1, txtFindID.getText());
			ResultSet rs2 = ps2.executeQuery();

			if (rs1.next()) {
				txtmobno.setText(rs1.getString("Telephone_No"));
				txtfixedno.setText(rs1.getString("FIXED_NO"));
			}

			if (rs.next()) {

				txtempid.setText(rs.getString("EmployeeID"));
				txtfname.setText(rs.getString("FirstName"));
				txtlname.setText(rs.getString("LastName"));
				cmbgender.setSelectedItem(rs.getString("Gender"));
				dob.setDate(rs.getDate("DOB"));
				txtnic.setText(rs.getString("NIC"));
				txthaddress.setText(rs.getString("Address"));
				txtuname.setText(rs.getString("Username"));
				txtpword.setText(rs.getString("Password"));
				txtdesignation.setText(rs.getString("Designation"));
				cmbtype.setSelectedItem(rs.getString("Type"));
				SDate.setDate(rs.getDate("StartDate"));
				EDate.setDate(rs.getDate("EndDate"));
				txtofficeid.setText(rs.getString("OfficeID"));
				txtpayrollid.setText(rs.getString("SalaryProfileID"));

			}

			if (rs2.next()) {
				txtempid.setText(rs2.getString("EmployeeID"));
				txtfname.setText(rs2.getString("FirstName"));
				txtlname.setText(rs2.getString("LastName"));
				cmbgender.setSelectedItem(rs2.getString("GENDER"));
				dob.setDate(rs2.getDate("DOB"));
				txtnic.setText(rs2.getString("NIC"));
				txthaddress.setText(rs2.getString("Address"));
				txtuname.setText(rs2.getString("Username"));
				txtpword.setText(rs2.getString("Password"));
				txtdesignation.setText(rs2.getString("Designation"));
				cmbtype.setSelectedItem(rs2.getString("Type"));
				SDate.setDate(rs2.getDate("StartDate"));
				EDate.setDate(rs2.getDate("EndDate"));
				txtivrno.setText(rs2.getString("IVR"));
				txtofficeid.setText(rs2.getString("OfficeID"));
				txtpayrollid.setText(rs2.getString("SalaryProfileID"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	public void Create() {

		if (checkQue == 1) {
			typeSql = "INSERT INTO `employees` (`EmployeeID`, `FirstName`, `LastName`, `Gender`, `DOB`, `NIC`, `Address`, `Designation`,`Username`, `Password`, `Type`, `StartDate`, `EndDate`, `SalaryProfileID`, `OfficeID`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			try {
				PreparedStatement stmt = Database.getConnection().prepareStatement(typeSql);

				stmt.setString(1, txtempid.getText());
				stmt.setString(2, txtfname.getText());
				stmt.setString(3, txtlname.getText());
				stmt.setString(4, cmbgender.getSelectedItem().toString());
				stmt.setDate(5, new Date(dob.getDate().getTime()));
				stmt.setString(6, txtnic.getText());
				stmt.setString(7, txthaddress.getText());
				stmt.setString(8, txtdesignation.getText());
				stmt.setString(9, txtuname.getText());
				stmt.setString(10, txtpword.getText());
				stmt.setString(11, cmbtype.getSelectedItem().toString());
				stmt.setDate(12, new Date(SDate.getDate().getTime()));
				stmt.setDate(13, new Date(EDate.getDate().getTime()));
				stmt.setString(14, txtpayrollid.getText());
				stmt.setString(15, txtofficeid.getText());

				stmt.execute();
				loads();

			} catch (SQLException e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		} else if (checkQue == 0) {
			String sql1 = "INSERT INTO `sales_executives` (`EmployeeID`, `FirstName`, `LastName`, `Gender`, `DOB`, `NIC`, `Address`, `Designation`,`Username`, `Password`, `Type`, `IVR`, `StartDate`, `EndDate`, `SalaryProfileID`, `OfficeID`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			try {
				PreparedStatement stmt = Database.getConnection().prepareStatement(sql1);

				stmt.setString(1, txtempid.getText());
				stmt.setString(2, txtfname.getText());
				stmt.setString(3, txtlname.getText());
				stmt.setString(4, cmbgender.getSelectedItem().toString());
				stmt.setDate(5, new Date(dob.getDate().getTime()));
				stmt.setString(6, txtnic.getText());
				stmt.setString(7, txthaddress.getText());
				stmt.setString(8, txtdesignation.getText());
				stmt.setString(9, txtuname.getText());
				stmt.setString(10, txtpword.getText());
				stmt.setString(11, cmbtype.getSelectedItem().toString());
				stmt.setString(12, txtivrno.getText());
				stmt.setDate(13, new Date(SDate.getDate().getTime()));
				stmt.setDate(14, new Date(EDate.getDate().getTime()));
				stmt.setString(15, txtpayrollid.getText());
				stmt.setString(16, txtofficeid.getText());

				stmt.execute();
				loads();

			} catch (SQLException e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		}
		String sql2 = "INSERT INTO `contact_no` (`EmployeeID`,`Telephone_No`, `FIXED_NO`) VALUES (?, ?, ?)";

		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql2);

			stmt.setString(1, txtempid.getText());
			stmt.setString(2, txtmobno.getText());
			stmt.setString(3, txtfixedno.getText());

			stmt.execute();
			loads();

		}

		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	// END OF METHOD CREATE

	public void Refresh() {

		txtfname.setText(null);
		txtlname.setText(null);
		cmbgender.setSelectedItem("GENDER");
		dob.setDate(null);
		txtnic.setText(null);
		txtmobno.setText(null);
		txtfixedno.setText(null);
		txthaddress.setText(null);
		txtuname.setText(null);
		txtpword.setText(null);
		txtdesignation.setText(null);
		cmbtype.setSelectedItem("EMPLOYEE TYPE");
		txtivrno.setText(null);
		txtempid.setText(null);
		SDate.setDate(null);
		EDate.setDate(null);
		txtofficeid.setText(null);
		txtpayrollid.setText(null);
		txtFindID.setText(null);
		// loads();
	}// end of method refresh

	public void Update() {

		if (checkQue == 1) {
			typeSql = "UPDATE `employees` SET `FirstName` = ?, `LastName` = ?, `Gender` = ?, `DOB` = ?, `NIC` = ?, `Address` = ?, `Designation` = ?, `Username` = ?, `Password` = ?, `Type` = ?, `StartDate` = ?, `EndDate` = ?, `SalaryProfileID` = ?, `OfficeID` = ? WHERE `employees`.`EmployeeID` = ?";

			try {
				PreparedStatement stmt = Database.getConnection().prepareStatement(typeSql);

				stmt.setString(15, txtempid.getText());
				stmt.setString(1, txtfname.getText());
				stmt.setString(2, txtlname.getText());
				stmt.setString(3, cmbgender.getSelectedItem().toString());
				stmt.setDate(4, new Date(dob.getDate().getTime()));
				stmt.setString(5, txtnic.getText());
				stmt.setString(6, txthaddress.getText());
				stmt.setString(7, txtdesignation.getText());
				stmt.setString(8, txtuname.getText());
				stmt.setString(9, txtpword.getText());
				stmt.setString(10, cmbtype.getSelectedItem().toString());
				stmt.setDate(11, new Date(SDate.getDate().getTime()));
				stmt.setDate(12, new Date(EDate.getDate().getTime()));
				stmt.setString(13, txtpayrollid.getText());
				stmt.setString(14, txtofficeid.getText());

				stmt.execute();
				loads();

			} catch (SQLException e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}

		} else if (checkQue == 0) {

			String sql = "UPDATE `sales_executives` SET `FirstName` = '?', `LastName` = '?', `Gender` = '?', `DOB` = '?', `NIC` = '?', `Address` = '?', `Designation` = '?', `Username` = '?', `Password` = '?', `Type` = '?', `StartDate` = '?', `EndDate` = '?', `SalaryProfileID` = '?', `OfficeID` = '?', `IVR` = '?' WHERE `sales_executives`.`EmployeeID` = '?'";
			try {
				PreparedStatement stmt = Database.getConnection().prepareStatement(sql);

				stmt.setString(16, txtempid.getText());
				stmt.setString(1, txtfname.getText());
				stmt.setString(2, txtlname.getText());
				stmt.setString(3, cmbgender.getSelectedItem().toString());
				stmt.setDate(4, new Date(dob.getDate().getTime()));
				stmt.setString(5, txtnic.getText());
				stmt.setString(6, txthaddress.getText());
				stmt.setString(7, txtdesignation.getText());
				stmt.setString(8, txtuname.getText());
				stmt.setString(9, txtpword.getText());
				stmt.setString(10, cmbtype.getSelectedItem().toString());
				stmt.setDate(11, new Date(SDate.getDate().getTime()));
				stmt.setDate(12, new Date(EDate.getDate().getTime()));
				stmt.setString(13, txtpayrollid.getText());
				stmt.setString(14, txtofficeid.getText());
				stmt.setString(15, txtivrno.getText());

				stmt.execute();
				loads();

			} catch (SQLException e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}

		}

		String sql1 = "UPDATE `contact_no` SET `Telephone_No` = ?, `FIXED_NO` = ? WHERE EmployeeID = ? ";
		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql1);

			stmt.setString(3, txtempid.getText());
			stmt.setString(1, txtmobno.getText());
			stmt.setString(2, txtfixedno.getText());

			stmt.execute();
			loads();

		}

		catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void Delete() {
		
		if (checkQue == 1) {
			typeSql = "DELETE FROM `employees` WHERE `EmployeeID` = ?";
			try {
				PreparedStatement stmt = Database.getConnection().prepareStatement(typeSql);

				stmt.setString(1, txtempid.getText());

				stmt.execute();
				loads();

			}

			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		else if (checkQue == 0) {
			
			String sql = "DELETE FROM sales_executives WHERE EmployeeID = ?";
			try {
				PreparedStatement stmt = Database.getConnection().prepareStatement(sql);

				stmt.setString(1, txtempid.getText());

				stmt.execute();
				loads();
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		String sql1 = "DELETE FROM `contact_no` WHERE `EmployeeID` = ?";

		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql1);

			stmt.setString(1, txtempid.getText());

			stmt.execute();
			loads();

		}

		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
