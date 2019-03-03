package ui.employees.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.Insets;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class DealerInfo extends KTab {
	private JTable table;
	private JTextField txtivrno;
	private JTextField txtcontactno;
	private JTextField txthaddress;
	private JTextField txtseID;
	private JTextField txtdealerID;
	private JTextField txtfullname;
	private JDateChooser dob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DealerInfo frame = new DealerInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loads() {

		try {
			ResultSet rs = Database.getConnection().prepareStatement("SELECT * FROM `dealer`").executeQuery();

			table.setModel(Database.resultSetToTableModel(rs));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public DealerInfo() {

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 321, 933, 213);
		getContentPane().add(scrollPane);

			
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btncreate = new JButton("Create");
		btncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Create();
			}
		});
		btncreate.setBounds(848, 66, 89, 31);
		getContentPane().add(btncreate);

		JButton btnupdate = new JButton("Update");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update();
			}
		});
		btnupdate.setBounds(848, 108, 89, 31);
		getContentPane().add(btnupdate);

		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete();
			}
		});
		btnDelete.setBounds(848, 150, 89, 31);
		getContentPane().add(btnDelete);

		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dealer Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(42, 54, 352, 251);
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 99, 99, 104, 0 };
		gbl_panel.rowHeights = new int[] { 21, 21, 21, 21, 21, 21, 21, 21, 26, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblfullname = new JLabel("Full Name              :");
		GridBagConstraints gbc_lblfullname = new GridBagConstraints();
		gbc_lblfullname.fill = GridBagConstraints.BOTH;
		gbc_lblfullname.insets = new Insets(0, 0, 5, 5);
		gbc_lblfullname.gridx = 0;
		gbc_lblfullname.gridy = 1;
		panel.add(lblfullname, gbc_lblfullname);

		txtfullname = new JTextField();
		GridBagConstraints gbc_txtfullname = new GridBagConstraints();
		gbc_txtfullname.gridwidth = 2;
		gbc_txtfullname.fill = GridBagConstraints.BOTH;
		gbc_txtfullname.insets = new Insets(0, 0, 5, 0);
		gbc_txtfullname.gridx = 1;
		gbc_txtfullname.gridy = 1;
		panel.add(txtfullname, gbc_txtfullname);
		txtfullname.setColumns(10);

		JLabel lblDealerid = new JLabel("DealerID               :");
		GridBagConstraints gbc_lblDealerid = new GridBagConstraints();
		gbc_lblDealerid.fill = GridBagConstraints.BOTH;
		gbc_lblDealerid.insets = new Insets(0, 0, 5, 5);
		gbc_lblDealerid.gridx = 0;
		gbc_lblDealerid.gridy = 2;
		panel.add(lblDealerid, gbc_lblDealerid);

		txtdealerID = new JTextField();
		GridBagConstraints gbc_txtdealerID = new GridBagConstraints();
		gbc_txtdealerID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdealerID.anchor = GridBagConstraints.NORTH;
		gbc_txtdealerID.gridwidth = 2;
		gbc_txtdealerID.insets = new Insets(0, 0, 5, 0);
		gbc_txtdealerID.gridx = 1;
		gbc_txtdealerID.gridy = 2;
		panel.add(txtdealerID, gbc_txtdealerID);
		txtdealerID.setColumns(10);

		JLabel lblExecutivesid = new JLabel("Executive ID         :");
		GridBagConstraints gbc_lblExecutivesid = new GridBagConstraints();
		gbc_lblExecutivesid.fill = GridBagConstraints.BOTH;
		gbc_lblExecutivesid.insets = new Insets(0, 0, 5, 5);
		gbc_lblExecutivesid.gridx = 0;
		gbc_lblExecutivesid.gridy = 3;
		panel.add(lblExecutivesid, gbc_lblExecutivesid);

		txtseID = new JTextField();
		GridBagConstraints gbc_txtseID = new GridBagConstraints();
		gbc_txtseID.gridwidth = 2;
		gbc_txtseID.fill = GridBagConstraints.BOTH;
		gbc_txtseID.insets = new Insets(0, 0, 5, 0);
		gbc_txtseID.gridx = 1;
		gbc_txtseID.gridy = 3;
		panel.add(txtseID, gbc_txtseID);
		txtseID.setColumns(10);

		JLabel lblIvrNo = new JLabel("IVR No                  :");
		GridBagConstraints gbc_lblIvrNo = new GridBagConstraints();
		gbc_lblIvrNo.fill = GridBagConstraints.BOTH;
		gbc_lblIvrNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblIvrNo.gridx = 0;
		gbc_lblIvrNo.gridy = 4;
		panel.add(lblIvrNo, gbc_lblIvrNo);

		txtivrno = new JTextField();
		GridBagConstraints gbc_txtivrno = new GridBagConstraints();
		gbc_txtivrno.gridwidth = 2;
		gbc_txtivrno.fill = GridBagConstraints.BOTH;
		gbc_txtivrno.insets = new Insets(0, 0, 5, 0);
		gbc_txtivrno.gridx = 1;
		gbc_txtivrno.gridy = 4;
		panel.add(txtivrno, gbc_txtivrno);
		txtivrno.setColumns(10);

		JLabel lblContactNo = new JLabel("Contact No           :");
		GridBagConstraints gbc_lblContactNo = new GridBagConstraints();
		gbc_lblContactNo.anchor = GridBagConstraints.WEST;
		gbc_lblContactNo.fill = GridBagConstraints.VERTICAL;
		gbc_lblContactNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblContactNo.gridx = 0;
		gbc_lblContactNo.gridy = 5;
		panel.add(lblContactNo, gbc_lblContactNo);

		txtcontactno = new JTextField();
		GridBagConstraints gbc_txtcontactno = new GridBagConstraints();
		gbc_txtcontactno.gridwidth = 2;
		gbc_txtcontactno.fill = GridBagConstraints.BOTH;
		gbc_txtcontactno.insets = new Insets(0, 0, 5, 0);
		gbc_txtcontactno.gridx = 1;
		gbc_txtcontactno.gridy = 5;
		panel.add(txtcontactno, gbc_txtcontactno);
		txtcontactno.setColumns(10);

		JLabel lblAddress = new JLabel("Regional address  :");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 6;
		panel.add(lblAddress, gbc_lblAddress);

		txthaddress = new JTextField();
		GridBagConstraints gbc_txthaddress = new GridBagConstraints();
		gbc_txthaddress.gridwidth = 2;
		gbc_txthaddress.fill = GridBagConstraints.BOTH;
		gbc_txthaddress.insets = new Insets(0, 0, 5, 0);
		gbc_txthaddress.gridx = 1;
		gbc_txthaddress.gridy = 6;
		panel.add(txthaddress, gbc_txthaddress);
		txthaddress.setColumns(10);

		JLabel lblJoinedDate = new JLabel("Joined Date          :");
		GridBagConstraints gbc_lblJoinedDate = new GridBagConstraints();
		gbc_lblJoinedDate.fill = GridBagConstraints.BOTH;
		gbc_lblJoinedDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblJoinedDate.gridx = 0;
		gbc_lblJoinedDate.gridy = 7;
		panel.add(lblJoinedDate, gbc_lblJoinedDate);

		dob = new JDateChooser();
		GridBagConstraints gbc_dob = new GridBagConstraints();
		gbc_dob.insets = new Insets(0, 0, 5, 0);
		gbc_dob.gridwidth = 2;
		gbc_dob.anchor = GridBagConstraints.NORTH;
		gbc_dob.fill = GridBagConstraints.HORIZONTAL;
		gbc_dob.gridx = 1; // dob
		gbc_dob.gridy = 7;
		panel.add(dob, gbc_dob);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Refresh();
			}
		});
		btnRefresh.setBounds(848, 192, 89, 31);
		getContentPane().add(btnRefresh);
		
		table.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int r = table.getSelectedRow();				
				
				String EmpID = table.getValueAt(r, 0).toString();
				String DealerID = table.getValueAt(r, 1).toString();
				String FName = table.getValueAt(r, 2).toString();
				String IVRNo = table.getValueAt(r, 3).toString();
				String ContactNo = table.getValueAt(r, 4).toString();
				String Address = table.getValueAt(r, 5).toString();
				Date DOB = Date.valueOf(table.getValueAt(r , 6).toString());
		
				txtseID.setText(EmpID.toString());
				txtdealerID.setText(DealerID.toString());
				txtfullname.setText(FName);
				txtivrno.setText(IVRNo.toString());
				txtcontactno.setText(ContactNo.toString());
				txthaddress.setText(Address.toString());
				dob.setDate(DOB);
			
			}
			
		});
		
		
		loads();
	}


	public void Create() {
		String sql = "INSERT INTO dealer (EmployeeID, DealerID, Full_Name, IVR_No, Contact_No, Localcy, Joined_Date) VALUES (?,?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql);

			stmt.setString(1, txtseID.getText());
			stmt.setString(2, txtdealerID.getText());
			stmt.setString(3, txtfullname.getText());
			stmt.setString(4, txtivrno.getText());
			stmt.setString(5, txtcontactno.getText());
			stmt.setString(6, txthaddress.getText());
			stmt.setDate(7, new Date(dob.getDate().getTime()));

			stmt.execute();
			loads();

		} catch (SQLException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
	}
	
	public void Update() {
		String sql = "UPDATE dealer SET Full_Name = ?, IVR_No = ?, Contact_No = ?, Localcy = ?, Joined_Date = ? WHERE dealer.EmployeeID = ? AND dealer.DealerID = ?";

		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql);

			stmt.setString(1, txtfullname.getText());
			stmt.setString(2, txtivrno.getText());
			stmt.setString(3, txtcontactno.getText());
			stmt.setString(4, txthaddress.getText());
			stmt.setDate(5, new Date(dob.getDate().getTime()));
			stmt.setString(6, txtseID.getText());
			stmt.setString(7, txtdealerID.getText());

			stmt.execute();
			loads();

		} catch (SQLException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
	}
	
	public void Delete() {
		
		String sql1 = "DELETE FROM `dealer` WHERE `DealerID` = ?";

		try {
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql1);

			stmt.setString(1, txtdealerID.getText());

			stmt.execute();
			loads();

		}

		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void Refresh() {
		txtseID.setText(null);
		txtdealerID.setText(null);
		txtfullname.setText(null);
		txtivrno.setText(null);
		txthaddress.setText(null);
		txtcontactno.setText(null);
		dob.setDate(null);
	}
	}	
	

