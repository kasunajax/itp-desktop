package ui.employees.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.Date;
//import java.sql.Date;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerModel;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import javax.swing.JTable;

public class Attendance extends KTab {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Attendance frame = new Attendance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private JDateChooser SDate;
	private JTextField txtStatus;
	private JTextField txtemployeeID;
	private JTable table;
	private JTextField txtOfficeID;
	private JComboBox cmbRoute; 
	private JSpinner tsStartTime, tsEndTime;
	
	public void loads() {

		try {
			ResultSet rs = Database.getConnection().prepareStatement("SELECT r.EmployeeID, a.OfficeID, a.Date, a.Start_Time, a.End_Time, r.Route, a.Status FROM routes r, attends a WHERE r.EmployeeID = a.EmployeeID").executeQuery();
			table.setModel(Database.resultSetToTableModel(rs));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Attendance() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 312, 959, 175);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(856, 79, 89, 31);
		getContentPane().add(btnCreate);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(856, 121, 89, 31);
		getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(856, 163, 89, 31);
		getContentPane().add(btnDelete);
		
		JButton btnRefresh = new JButton("Report");
		btnRefresh.setBounds(856, 205, 89, 31);
		getContentPane().add(btnRefresh);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(26, 22, 472, 267);
		getContentPane().add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "General Attendance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{87, 31, 292, 0};
		gbl_panel_1.rowHeights = new int[]{20, 20, 20, 20, 20, 0, 20, 20, 20, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblEmployeeId = new JLabel("Employee ID       :");
		GridBagConstraints gbc_lblEmployeeId = new GridBagConstraints();
		gbc_lblEmployeeId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEmployeeId.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmployeeId.gridx = 0;
		gbc_lblEmployeeId.gridy = 0;
		panel_1.add(lblEmployeeId, gbc_lblEmployeeId);
		
		txtemployeeID = new JTextField();
		GridBagConstraints gbc_txtemployeeID = new GridBagConstraints();
		gbc_txtemployeeID.anchor = GridBagConstraints.NORTH;
		gbc_txtemployeeID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtemployeeID.insets = new Insets(0, 0, 5, 0);
		gbc_txtemployeeID.gridx = 2;
		gbc_txtemployeeID.gridy = 0;
		panel_1.add(txtemployeeID, gbc_txtemployeeID);
		txtemployeeID.setColumns(10);
		
		JLabel lblOfficeID = new JLabel("New label");
		GridBagConstraints gbc_lblOfficeID = new GridBagConstraints();
		gbc_lblOfficeID.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblOfficeID.insets = new Insets(0, 0, 5, 5);
		gbc_lblOfficeID.gridx = 0;
		gbc_lblOfficeID.gridy = 1;
		panel_1.add(lblOfficeID, gbc_lblOfficeID);
		
		txtOfficeID = new JTextField();
		GridBagConstraints gbc_txtOfficeID = new GridBagConstraints();
		gbc_txtOfficeID.insets = new Insets(0, 0, 5, 0);
		gbc_txtOfficeID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOfficeID.gridx = 2;
		gbc_txtOfficeID.gridy = 1;
		panel_1.add(txtOfficeID, gbc_txtOfficeID);
		txtOfficeID.setColumns(10);
		
		JLabel lblDate = new JLabel("Date                    :");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 2;
		panel_1.add(lblDate, gbc_lblDate);
		
		SDate = new JDateChooser();
		GridBagConstraints gbc_SDate = new GridBagConstraints();
		gbc_SDate.anchor = GridBagConstraints.NORTH;
		gbc_SDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_SDate.insets = new Insets(0, 0, 5, 0);
		gbc_SDate.gridx = 2;
		gbc_SDate.gridy = 2;
		panel_1.add(SDate, gbc_SDate);
		
		JLabel lblStartTime = new JLabel("Start Time           :");
		GridBagConstraints gbc_lblStartTime = new GridBagConstraints();
		gbc_lblStartTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStartTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartTime.gridx = 0;
		gbc_lblStartTime.gridy = 3;
		panel_1.add(lblStartTime, gbc_lblStartTime);
		
		tsStartTime = new JSpinner( new SpinnerDateModel() );
		GridBagConstraints gbc_tsStartTime = new GridBagConstraints();
		gbc_tsStartTime.anchor = GridBagConstraints.NORTH;
		gbc_tsStartTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_tsStartTime.insets = new Insets(0, 0, 5, 0);
		gbc_tsStartTime.gridx = 2;
		gbc_tsStartTime.gridy = 3;
		panel_1.add(tsStartTime, gbc_tsStartTime);
		JSpinner.DateEditor de_tsStartTime = new JSpinner.DateEditor(tsStartTime, "HH:mm:ss a");
		tsStartTime.setEditor(de_tsStartTime);
		tsStartTime.setValue(new Date());
		
		JLabel lblEndTime = new JLabel("End Time             :");
		GridBagConstraints gbc_lblEndTime = new GridBagConstraints();
		gbc_lblEndTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEndTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndTime.gridx = 0;
		gbc_lblEndTime.gridy = 4;
		panel_1.add(lblEndTime, gbc_lblEndTime);
		
		tsEndTime = new JSpinner( new SpinnerDateModel() );
		GridBagConstraints gbc_tsEndTime = new GridBagConstraints();
		gbc_tsEndTime.anchor = GridBagConstraints.NORTH;
		gbc_tsEndTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_tsEndTime.insets = new Insets(0, 0, 5, 0);
		gbc_tsEndTime.gridx = 2;
		gbc_tsEndTime.gridy = 4;
		panel_1.add(tsEndTime, gbc_tsEndTime);
		JSpinner.DateEditor de_tsEndTime = new JSpinner.DateEditor(tsEndTime, "HH:mm:ss a");
		tsEndTime.setEditor(de_tsEndTime);
		tsEndTime.setValue(new Date());
		
		JLabel lblRoute = new JLabel("Route                 :");
		GridBagConstraints gbc_lblRoute = new GridBagConstraints();
		gbc_lblRoute.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRoute.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoute.gridx = 0;
		gbc_lblRoute.gridy = 5;
		panel_1.add(lblRoute, gbc_lblRoute);
		
		cmbRoute = new JComboBox();
		GridBagConstraints gbc_cmbRoute = new GridBagConstraints();
		gbc_cmbRoute.insets = new Insets(0, 0, 5, 0);
		gbc_cmbRoute.anchor = GridBagConstraints.NORTH;
		gbc_cmbRoute.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbRoute.gridx = 2;
		gbc_cmbRoute.gridy = 5;
		panel_1.add(cmbRoute, gbc_cmbRoute);
		cmbRoute.setModel(new DefaultComboBoxModel(new String[] {"Select Route", "COLR1", "COLR2", "COLR5", "COL3", "KANR1", "KANR2"}));
		
		JLabel lblStatus = new JLabel("Status                 :");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 6;
		panel_1.add(lblStatus, gbc_lblStatus);
		
		txtStatus = new JTextField();
		GridBagConstraints gbc_txtStatus = new GridBagConstraints();
		gbc_txtStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStatus.insets = new Insets(0, 0, 5, 0);
		gbc_txtStatus.gridx = 2;
		gbc_txtStatus.gridy = 6;
		panel_1.add(txtStatus, gbc_txtStatus);
		txtStatus.setText("");
		txtStatus.setColumns(10);
		
		/*table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int r = table.getSelectedRow();				
					
					String EmpID = table.getValueAt(r, 0).toString();
					String DealerID = table.getValueAt(r, 1).toString();
					String FName = table.getValueAt(r, 2).toString();
					String IVRNo = table.getValueAt(r, 3).toString();
					String ContactNo = table.getValueAt(r, 4).toString();
					String Address = table.getValueAt(r, 5).toString();
					Date DOB = Date.valueOf(table.getValueAt(r , 6).toString());
			
					txtemployeeID.setText(EmpID.toString());
					txtOfficeID.setText(DealerID.toString());
					txtfullname.setText(FName);
					txtivrno.setText(IVRNo.toString());
					txtcontactno.setText(ContactNo.toString());
					txthaddress.setText(Address.toString());
					dob.setDate(DOB);
				
				}
				
			});*/
			
			
			loads();

	}
	
	public void Create() {
		String sql = "INSERT INTO `attends` (`EmployeeID`, `OfficeID`, `Start_Time`, `End_Time`, `Date`, `Status`) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql);

			stmt.setString(1, txtemployeeID.getText());
			stmt.setString(2, txtOfficeID.getText());
			stmt.setString(3, tsStartTime.toString());
			stmt.setString(4, tsEndTime.toString());
			//stmt.setDate(5, new Date(SDate.getDate().getTime()));
			stmt.setString(6, txtStatus.getText());

			stmt.execute();
			loads();

		} catch (SQLException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		
		String sql2 = "INSERT INTO `routes` (`EmployeeID`,`Route`) VALUES (?, ?)";

		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql2);

			stmt.setString(1, txtemployeeID.getText());
			stmt.setString(2, cmbRoute.getSelectedItem().toString());
			

			stmt.execute();
			loads();

		}

		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void Update() {
		String sql = "UPDATE attends SET OfficeID = ?, Start_Time = ?, End_Time = ?, Date = ?, Status = ? WHERE attends.EmployeeID = ?";

		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql);

			stmt.setString(1, txtOfficeID.getText());
			stmt.setString(2, tsStartTime.toString());
			stmt.setString(3, tsEndTime.toString());
			//stmt.setDate(4, new Date(SDate.getDate().getTime()));
			stmt.setString(5, txtStatus.getText());
			stmt.setString(6, txtemployeeID.getText());
			

			stmt.execute();
			loads();

		} catch (SQLException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		String sql2 = "UPDATE `routes` SET  Route =? WHERE EmployeeID =?";

		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql2);

			stmt.setString(2, txtemployeeID.getText());
			stmt.setString(1, cmbRoute.getSelectedItem().toString());
			

			stmt.execute();
			loads();

		}

		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void Delete() {
		
		String sql1 = "DELETE FROM `routes` WHERE `EmployeeID` = ?";

		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql1);

			stmt.setString(1, txtemployeeID.getText());

			stmt.execute();
			loads();

		}

		catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		String sql2 = "DELETE FROM `attends` WHERE `EmployeeID` = ?";

		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql2);

			stmt.setString(1, txtemployeeID.getText());

			stmt.execute();
			loads();

		}

		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void Refresh() {
		txtemployeeID.setText(null);
		txtOfficeID.setText(null);
		tsStartTime.setValue(null);
		tsEndTime.setValue(null);
		txtStatus.setText(null);
		cmbRoute.setSelectedItem("Select Route");
		SDate.setDate(null);
	}
	
}
