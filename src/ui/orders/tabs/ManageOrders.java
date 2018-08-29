package ui.orders.tabs;

import java.awt.EventQueue;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JToolBar;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageOrders extends KTab {
	private JTextField txtOrderId;
	private JTextField txtStatus;
	private JTextField txtPackage;
	private JTextField txtContact;
	private JTextField txtNic;
	private JTextField txtName;
	private JTable table;
	private JDateChooser dcEndDate, dcStartDate, dcPlacedDate, dcProcessedDate;
	private JProgressBar progressBar;
	private JLabel lblPStatus;
	private JComboBox cmbStatus;
	private JTextPane txtAddress;
	private ListSelectionListener tableListener;
	private JButton btnAdd, btnRemove, btnRefresh, btnSave, btnFilterDate, btnFilterStatus;
	private JButton btnSetPackage;
	private JButton btnSetStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageOrders frame = new ManageOrders();
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
	public ManageOrders() {
		
		
		getContentPane().setLayout(null);
		
		JPanel panelCustomerInfo = new JPanel();
		panelCustomerInfo.setBackground(Color.WHITE);
		panelCustomerInfo.setBorder(BorderFactory.createTitledBorder("Customer Details"));
		panelCustomerInfo.setBounds(324, 293, 250, 160);
		getContentPane().add(panelCustomerInfo);
		GridBagLayout gbl_panelCustomerInfo = new GridBagLayout();
		gbl_panelCustomerInfo.columnWidths = new int[]{0, 0, 0};
		gbl_panelCustomerInfo.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelCustomerInfo.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCustomerInfo.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCustomerInfo.setLayout(gbl_panelCustomerInfo);
		
		JLabel lblFullName = new JLabel("Full Name: ");
		GridBagConstraints gbc_lblFullName = new GridBagConstraints();
		gbc_lblFullName.anchor = GridBagConstraints.WEST;
		gbc_lblFullName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFullName.gridx = 0;
		gbc_lblFullName.gridy = 0;
		panelCustomerInfo.add(lblFullName, gbc_lblFullName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 0;
		panelCustomerInfo.add(txtName, gbc_txtName);
		
		JLabel lblAddress = new JLabel("Address: ");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddress.gridheight = 2;
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 1;
		panelCustomerInfo.add(lblAddress, gbc_lblAddress);
		
		txtAddress = new JTextPane();
		txtAddress.setBorder(UIManager.getBorder("TextField.border"));
		GridBagConstraints gbc_txtAddress = new GridBagConstraints();
		gbc_txtAddress.gridheight = 2;
		gbc_txtAddress.fill = GridBagConstraints.BOTH;
		gbc_txtAddress.insets = new Insets(0, 0, 5, 0);
		gbc_txtAddress.gridx = 1;
		gbc_txtAddress.gridy = 1;
		panelCustomerInfo.add(txtAddress, gbc_txtAddress);
		
		JLabel lblNic = new JLabel("NIC: ");
		GridBagConstraints gbc_lblNic = new GridBagConstraints();
		gbc_lblNic.anchor = GridBagConstraints.WEST;
		gbc_lblNic.insets = new Insets(0, 0, 5, 5);
		gbc_lblNic.gridx = 0;
		gbc_lblNic.gridy = 3;
		panelCustomerInfo.add(lblNic, gbc_lblNic);
		
		txtNic = new JTextField();
		txtNic.setColumns(10);
		GridBagConstraints gbc_txtNic = new GridBagConstraints();
		gbc_txtNic.insets = new Insets(0, 0, 5, 0);
		gbc_txtNic.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNic.gridx = 1;
		gbc_txtNic.gridy = 3;
		panelCustomerInfo.add(txtNic, gbc_txtNic);
		
		JLabel lblContactNo = new JLabel("Contact NO: ");
		GridBagConstraints gbc_lblContactNo = new GridBagConstraints();
		gbc_lblContactNo.anchor = GridBagConstraints.WEST;
		gbc_lblContactNo.insets = new Insets(0, 0, 0, 5);
		gbc_lblContactNo.gridx = 0;
		gbc_lblContactNo.gridy = 4;
		panelCustomerInfo.add(lblContactNo, gbc_lblContactNo);
		
		txtContact = new JTextField();
		txtContact.setColumns(10);
		GridBagConstraints gbc_txtContact = new GridBagConstraints();
		gbc_txtContact.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtContact.gridx = 1;
		gbc_txtContact.gridy = 4;
		panelCustomerInfo.add(txtContact, gbc_txtContact);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 94, 852, 188);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panelGeneral = new JPanel();
		panelGeneral.setBorder(BorderFactory.createTitledBorder("General Details"));
		panelGeneral.setBounds(64, 293, 250, 160);
		getContentPane().add(panelGeneral);
		panelGeneral.setBackground(new Color(255, 255, 255));
		GridBagLayout gbl_panelGeneral = new GridBagLayout();
		gbl_panelGeneral.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panelGeneral.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelGeneral.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelGeneral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelGeneral.setLayout(gbl_panelGeneral);
		
		JLabel lblNewLabel = new JLabel("Order ID:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelGeneral.add(lblNewLabel, gbc_lblNewLabel);
		
		txtOrderId = new JTextField();
		GridBagConstraints gbc_txtOrderId = new GridBagConstraints();
		gbc_txtOrderId.gridwidth = 3;
		gbc_txtOrderId.insets = new Insets(0, 0, 5, 0);
		gbc_txtOrderId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOrderId.gridx = 1;
		gbc_txtOrderId.gridy = 0;
		panelGeneral.add(txtOrderId, gbc_txtOrderId);
		txtOrderId.setColumns(10);
		
		JLabel lblPlacedDate_1 = new JLabel("Placed Date: ");
		GridBagConstraints gbc_lblPlacedDate_1 = new GridBagConstraints();
		gbc_lblPlacedDate_1.anchor = GridBagConstraints.WEST;
		gbc_lblPlacedDate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlacedDate_1.gridx = 0;
		gbc_lblPlacedDate_1.gridy = 1;
		panelGeneral.add(lblPlacedDate_1, gbc_lblPlacedDate_1);
		
		dcPlacedDate = new JDateChooser();
		GridBagConstraints gbc_dcPlacedDate = new GridBagConstraints();
		gbc_dcPlacedDate.gridwidth = 3;
		gbc_dcPlacedDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_dcPlacedDate.insets = new Insets(0, 0, 5, 0);
		gbc_dcPlacedDate.gridx = 1;
		gbc_dcPlacedDate.gridy = 1;
		panelGeneral.add(dcPlacedDate, gbc_dcPlacedDate);
		
		JLabel lblProcessedDate_1 = new JLabel("Processed Date: ");
		GridBagConstraints gbc_lblProcessedDate_1 = new GridBagConstraints();
		gbc_lblProcessedDate_1.anchor = GridBagConstraints.WEST;
		gbc_lblProcessedDate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblProcessedDate_1.gridx = 0;
		gbc_lblProcessedDate_1.gridy = 2;
		panelGeneral.add(lblProcessedDate_1, gbc_lblProcessedDate_1);
		
		dcProcessedDate = new JDateChooser();
		GridBagConstraints gbc_dcProcessedDate = new GridBagConstraints();
		gbc_dcProcessedDate.gridwidth = 3;
		gbc_dcProcessedDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_dcProcessedDate.insets = new Insets(0, 0, 5, 0);
		gbc_dcProcessedDate.gridx = 1;
		gbc_dcProcessedDate.gridy = 2;
		panelGeneral.add(dcProcessedDate, gbc_dcProcessedDate);
		
		JLabel lblStatus_1 = new JLabel("Status: ");
		GridBagConstraints gbc_lblStatus_1 = new GridBagConstraints();
		gbc_lblStatus_1.anchor = GridBagConstraints.WEST;
		gbc_lblStatus_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus_1.gridx = 0;
		gbc_lblStatus_1.gridy = 3;
		panelGeneral.add(lblStatus_1, gbc_lblStatus_1);
		
		txtStatus = new JTextField();
		txtStatus.setEditable(false);
		txtStatus.setColumns(10);
		GridBagConstraints gbc_txtStatus = new GridBagConstraints();
		gbc_txtStatus.gridwidth = 2;
		gbc_txtStatus.insets = new Insets(0, 0, 5, 5);
		gbc_txtStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStatus.gridx = 1;
		gbc_txtStatus.gridy = 3;
		panelGeneral.add(txtStatus, gbc_txtStatus);
		
		btnSetStatus = new JButton("..");
		btnSetStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] possibilities = {"COMPLETED", "REJECTED", "INITIAL", "PENDING"};
				String s = (String)JOptionPane.showInternalInputDialog(ManageOrders.this, "Select the order status ... ", "Set Status", JOptionPane.PLAIN_MESSAGE, null, possibilities, "Ham");

				if ((s != null) && (s.length() > 0)) {
					txtStatus.setText(s);
				}
				
			}
		});
		GridBagConstraints gbc_btnSetStatus = new GridBagConstraints();
		gbc_btnSetStatus.insets = new Insets(0, 0, 5, 0);
		gbc_btnSetStatus.gridx = 3;
		gbc_btnSetStatus.gridy = 3;
		panelGeneral.add(btnSetStatus, gbc_btnSetStatus);
		
		JLabel lblPackage_1 = new JLabel("Package: ");
		GridBagConstraints gbc_lblPackage_1 = new GridBagConstraints();
		gbc_lblPackage_1.anchor = GridBagConstraints.WEST;
		gbc_lblPackage_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblPackage_1.gridx = 0;
		gbc_lblPackage_1.gridy = 4;
		panelGeneral.add(lblPackage_1, gbc_lblPackage_1);
		
		txtPackage = new JTextField();
		txtPackage.setEditable(false);
		txtPackage.setColumns(10);
		GridBagConstraints gbc_txtPackage = new GridBagConstraints();
		gbc_txtPackage.gridwidth = 2;
		gbc_txtPackage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPackage.insets = new Insets(0, 0, 0, 5);
		gbc_txtPackage.gridx = 1;
		gbc_txtPackage.gridy = 4;
		panelGeneral.add(txtPackage, gbc_txtPackage);
		
		btnSetPackage = new JButton("..");
		btnSetPackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] possibilities = {"100", "3"};
				String s = (String)JOptionPane.showInternalInputDialog(ManageOrders.this, "Select the package ... ", "Set Package", JOptionPane.PLAIN_MESSAGE, null, possibilities, "Ham");

				if ((s != null) && (s.length() > 0)) {
					txtPackage.setText(s);
				}
				
			}
		});
		GridBagConstraints gbc_btnSetPackage = new GridBagConstraints();
		gbc_btnSetPackage.anchor = GridBagConstraints.EAST;
		gbc_btnSetPackage.gridx = 3;
		gbc_btnSetPackage.gridy = 4;
		panelGeneral.add(btnSetPackage, gbc_btnSetPackage);
		
		JPanel panelFilterDate = new JPanel();
		panelFilterDate.setBackground(new Color(255, 255, 255));
		panelFilterDate.setBounds(584, 293, 332, 80);
		getContentPane().add(panelFilterDate);
		GridBagLayout gbl_panelFilterDate = new GridBagLayout();
		gbl_panelFilterDate.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelFilterDate.rowHeights = new int[]{0, 0, 0};
		gbl_panelFilterDate.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelFilterDate.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelFilterDate.setLayout(gbl_panelFilterDate);
		
		JLabel lblStartDate = new JLabel("Start Date: ");
		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.anchor = GridBagConstraints.WEST;
		gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDate.gridx = 0;
		gbc_lblStartDate.gridy = 0;
		panelFilterDate.add(lblStartDate, gbc_lblStartDate);
		
		dcStartDate = new JDateChooser();
		GridBagConstraints gbc_dcStartDate = new GridBagConstraints();
		gbc_dcStartDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_dcStartDate.gridwidth = 6;
		gbc_dcStartDate.insets = new Insets(0, 0, 5, 5);
		gbc_dcStartDate.gridx = 1;
		gbc_dcStartDate.gridy = 0;
		panelFilterDate.add(dcStartDate, gbc_dcStartDate);
		
		
		dcEndDate = new JDateChooser();
		GridBagConstraints gbc_dcEndDate = new GridBagConstraints();
		gbc_dcEndDate.gridwidth = 6;
		gbc_dcEndDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_dcEndDate.insets = new Insets(0, 0, 0, 5);
		gbc_dcEndDate.gridx = 1;
		gbc_dcEndDate.gridy = 1;
		panelFilterDate.add(dcEndDate, gbc_dcEndDate);
		panelFilterDate.setBorder(BorderFactory.createTitledBorder("Filter By Date"));
		
		
		btnFilterDate = new JButton("Filter");
		btnFilterDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				filterByDate(btnFilterDate);
				
			}
		});
		GridBagConstraints gbc_btnFilterDate = new GridBagConstraints();
		gbc_btnFilterDate.anchor = GridBagConstraints.WEST;
		gbc_btnFilterDate.insets = new Insets(0, 0, 5, 0);
		gbc_btnFilterDate.gridx = 7;
		gbc_btnFilterDate.gridy = 0;
		panelFilterDate.add(btnFilterDate, gbc_btnFilterDate);
		
		JLabel lblEndDate = new JLabel("End Date: ");
		GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
		gbc_lblEndDate.anchor = GridBagConstraints.WEST;
		gbc_lblEndDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblEndDate.gridx = 0;
		gbc_lblEndDate.gridy = 1;
		panelFilterDate.add(lblEndDate, gbc_lblEndDate);
		
		JButton filterByDateReset = new JButton("Reset");
		filterByDateReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dcStartDate.setDate(null);
				dcEndDate.setDate(null);
				
			}
		});
		GridBagConstraints gbc_filterByDateReset = new GridBagConstraints();
		gbc_filterByDateReset.anchor = GridBagConstraints.WEST;
		gbc_filterByDateReset.insets = new Insets(0, 0, 0, 5);
		gbc_filterByDateReset.gridx = 7;
		gbc_filterByDateReset.gridy = 1;
		panelFilterDate.add(filterByDateReset, gbc_filterByDateReset);

		JPanel panelFilterStatus = new JPanel();
		panelFilterStatus.setBackground(new Color(255, 255, 255));
		panelFilterStatus.setBorder(BorderFactory.createTitledBorder("Filter By Status"));
		panelFilterStatus.setBounds(584, 395, 332, 58);
		getContentPane().add(panelFilterStatus);
		GridBagLayout gbl_panelFilterStatus = new GridBagLayout();
		gbl_panelFilterStatus.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelFilterStatus.rowHeights = new int[]{0, 0};
		gbl_panelFilterStatus.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelFilterStatus.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelFilterStatus.setLayout(gbl_panelFilterStatus);
		
		JLabel lblStatus = new JLabel("Status: ");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.WEST;
		gbc_lblStatus.gridwidth = 2;
		gbc_lblStatus.insets = new Insets(0, 0, 0, 5);
		gbc_lblStatus.gridx = 1;
		gbc_lblStatus.gridy = 0;
		panelFilterStatus.add(lblStatus, gbc_lblStatus);
		
		cmbStatus = new JComboBox();
		cmbStatus.setModel(new DefaultComboBoxModel(new String[] {"COMPLETED", "INITIAL", "REJECTED"}));
		GridBagConstraints gbc_cmbStatus = new GridBagConstraints();
		gbc_cmbStatus.insets = new Insets(0, 0, 0, 5);
		gbc_cmbStatus.gridwidth = 8;
		gbc_cmbStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbStatus.gridx = 3;
		gbc_cmbStatus.gridy = 0;
		panelFilterStatus.add(cmbStatus, gbc_cmbStatus);
		
		btnFilterStatus = new JButton("Filter");
		btnFilterStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filterByStatus(btnFilterStatus);
			}
		});
		GridBagConstraints gbc_btnFilterStatus = new GridBagConstraints();
		gbc_btnFilterStatus.anchor = GridBagConstraints.EAST;
		gbc_btnFilterStatus.insets = new Insets(0, 0, 0, 5);
		gbc_btnFilterStatus.gridx = 11;
		gbc_btnFilterStatus.gridy = 0;
		panelFilterStatus.add(btnFilterStatus, gbc_btnFilterStatus);
		
		JPanel panelOps = new JPanel();
		panelOps.setBackground(new Color(255, 255, 255));
		panelOps.setBounds(584, 464, 332, 75);
		getContentPane().add(panelOps);
		panelOps.setBorder(BorderFactory.createTitledBorder("Operations"));
		panelOps.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addRow(btnAdd);
				
			}
		});
		panelOps.add(btnAdd);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateRow(btnSave);
			}
		});
		panelOps.add(btnSave);
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRow(btnRemove);
			}
		});
		panelOps.add(btnRemove);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh(btnRefresh);
			}
		});
		panelOps.add(btnRefresh);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 550, 980, 50);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(764, 17, 146, 16);
		progressBar.setVisible(false);
		panel.add(progressBar);
		
		lblPStatus = new JLabel("Status: Ready");
		lblPStatus.setBounds(64, 11, 680, 28);
		panel.add(lblPStatus);
		
		tableListener = new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow();
				txtOrderId.setText(table.getValueAt(row , 0).toString());
				dcPlacedDate.setDate(Date.valueOf(table.getValueAt(row , 1).toString()));
				dcProcessedDate.setDate((table.getValueAt(row , 2) == null) ? null : Date.valueOf(table.getValueAt(row , 2).toString()));
				txtStatus.setText(table.getValueAt(row , 3).toString());
				txtPackage.setText((table.getValueAt(row , 8) == null) ? null : table.getValueAt(row , 8).toString());
				txtName.setText(table.getValueAt(row , 4).toString());
				txtAddress.setText(table.getValueAt(row , 5).toString());
				txtNic.setText(table.getValueAt(row , 6).toString());
				txtContact.setText(table.getValueAt(row , 7).toString());
				
			}
			
		};
		
		
		
	}
	
	public boolean isValidDate(java.util.Date d) {
		
		return (d != null) ? true:  false;
		
	}
	
	
	public void showProgress(JButton btn) {
		progressBar.setVisible(true);
		btn.setEnabled(false);
		btnAdd.setEnabled(false);
		btnSave.setEnabled(false);
		btnRemove.setEnabled(false);
		btnRefresh.setEnabled(false);
		btnFilterDate.setEnabled(false);
		btnFilterStatus.setEnabled(false);
		progressBar.setIndeterminate(true);
		table.getSelectionModel().removeListSelectionListener(tableListener);
		table.setModel(new DefaultTableModel());
	}
	
	public void hideProgress(JButton btn) {
		btn.setEnabled(true);
		btnAdd.setEnabled(true);
		btnSave.setEnabled(true);
		btnRemove.setEnabled(true);
		btnRefresh.setEnabled(true);
		btnFilterDate.setEnabled(true);
		btnFilterStatus.setEnabled(true);
		progressBar.setIndeterminate(false);
		progressBar.setVisible(false);
		table.getSelectionModel().addListSelectionListener(tableListener);
		table.setRowSelectionInterval(0, 0);
	}
	
	public void updateRow(JButton btn) {
		
		
		int i = JOptionPane.showInternalConfirmDialog(ManageOrders.this, "Are you sure you need to save this row ?");
		if(i != JOptionPane.OK_OPTION) {
			return;
		}
		
		
		new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				showProgress(btn);
				lblPStatus.setText("Status: Sending data to the server ...");
				try {
					
					String sql = "UPDATE `orders` SET `PlacedDate` = ?, `ProcessedDate` = ?, `Status` = ?, `CustomerFullName` = ?, `CustomerAddress` = ?, `CustomerNIC` = ?, `CustomerContactNO` = ?, `Package` = ? WHERE OrderID = ?";
					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
					
					
					stmt.setDate(1, new Date(dcPlacedDate.getDate().getTime()));
					stmt.setDate(2, (dcProcessedDate.getDate() != null) ? new Date(dcProcessedDate.getDate().getTime()) : null);
					stmt.setString(3, txtStatus.getText());
					stmt.setString(4, txtName.getText());
					stmt.setString(5, txtAddress.getText());
					stmt.setString(6, txtNic.getText());
					stmt.setString(7, txtContact.getText());
					stmt.setString(8, (!txtPackage.getText().equals("")) ? txtPackage.getText() : null );
					stmt.setString(9, txtOrderId.getText());


					stmt.execute();
				} catch (SQLException ex) {ex.printStackTrace();}
				lblPStatus.setText("Status: Initializing rows ...");
				
				lblPStatus.setText("Status: Refreshing data from the server ...");
				refresh();
				
				return null;
			}
			
			@Override
			protected void done() {
				hideProgress(btn);
				lblPStatus.setText("Status: Ready at " + LocalDateTime.now().toString());
			}
			
		}.execute();	
	}
	
	public void filterByStatus(JButton btn) {
		
		new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				showProgress(btn);
				lblPStatus.setText("Status: Loading data from the server ...");
				try {
					
					String sql = "SELECT * FROM orders WHERE STATUS = ? ORDER BY PlacedDate DESC";
					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
					stmt.setString(1, cmbStatus.getSelectedItem().toString().toUpperCase());

					table.setModel(Database.resultSetToTableModel(stmt.executeQuery()));
					
					
				} catch (SQLException ex) {}
				lblPStatus.setText("Status: Initializing rows ...");
				
				return null;
			}
			
			@Override
			protected void done() {
				hideProgress(btn);
				lblPStatus.setText("Status: Ready at " + LocalDateTime.now().toString());
			}
			
		}.execute();
		
	}
	
	public void addRow(JButton btn) {
		int i = JOptionPane.showInternalConfirmDialog(ManageOrders.this, "Are you sure you need to add this row ?");
		if(i != JOptionPane.OK_OPTION) {
			return;
		}
		new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				showProgress(btn);
				lblPStatus.setText("Status: Sending data to the server ...");
				try {
					
					String sql = "INSERT INTO `orders` (`OrderID`, `PlacedDate`, `ProcessedDate`, `Status`, `CustomerFullName`, `CustomerAddress`, `CustomerNIC`, `CustomerContactNO`, `Package`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
					
					stmt.setString(1, txtOrderId.getText());
					stmt.setDate(2, new Date(dcPlacedDate.getDate().getTime()));
					stmt.setDate(3, (dcProcessedDate.getDate() != null) ? new Date(dcProcessedDate.getDate().getTime()) : null);
					stmt.setString(4, txtStatus.getText());
					stmt.setString(5, txtName.getText());
					stmt.setString(6, txtAddress.getText());
					stmt.setString(7, txtNic.getText());
					stmt.setString(8, txtContact.getText());
					stmt.setString(9, (!txtPackage.getText().equals("")) ? txtPackage.getText() : null );


					stmt.execute();
				} catch (SQLException ex) {ex.printStackTrace();}
				lblPStatus.setText("Status: Initializing rows ...");
				
				lblPStatus.setText("Status: Refreshing data from the server ...");
				refresh();
				
				return null;
			}
			
			@Override
			protected void done() {
				hideProgress(btn);
				lblPStatus.setText("Status: Ready at " + LocalDateTime.now().toString());
			}
			
		}.execute();
		
		
	}
	
	public void refresh(JButton btn) {
		
		
		
		
		
		new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				showProgress(btn);
				lblPStatus.setText("Status: Reloading data from the server ...");
				
				try {
					
					table.setModel(Database.resultSetToTableModel((Database.getConnection().prepareStatement("SELECT * FROM orders ORDER BY PlacedDate DESC").executeQuery())));
					
				} catch (SQLException e) {}
				 
				
				
				lblPStatus.setText("Status: Initializing rows ...");
				return null;
			}
			
			@Override
			protected void done() {
				hideProgress(btn);
				lblPStatus.setText("Status: Ready at " + LocalDateTime.now().toString());
			}
			
		}.execute();
		
		
	}
	
	public void refresh() {
		try {
			
			AbstractTableModel m = (AbstractTableModel) Database.resultSetToTableModel((Database.getConnection().prepareStatement("SELECT * FROM orders ORDER BY PlacedDate DESC").executeQuery()));
			table.setModel(m);

			
		} catch (SQLException e) {}
		 

	}
	
	public void deleteRow(JButton btn) {
		
		int i = JOptionPane.showInternalConfirmDialog(ManageOrders.this, "Are you sure you need to delete this row ?");
		if(i != JOptionPane.OK_OPTION) {
			return;
		}
		
		new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				showProgress(btn);
				lblPStatus.setText("Status: Sending delete request to the server ...");
				try {
					
					String sql = "DELETE FROM orders WHERE OrderID = ?";
					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
					
					stmt.setString(1, txtOrderId.getText());


					stmt.execute();
				} catch (SQLException ex) {ex.printStackTrace();}
				lblPStatus.setText("Status: Initializing rows ...");
				
				lblPStatus.setText("Status: Refreshing data from the server ...");
				refresh();
				
				return null;
			}
			
			@Override
			protected void done() {
				hideProgress(btn);
				lblPStatus.setText("Status: Ready at " + LocalDateTime.now().toString());
			}
			
		}.execute();
	}
	
	public void filterByDate(JButton btn) {
		
		
		if(!isValidDate(dcStartDate.getDate()) || !isValidDate(dcEndDate.getDate())) {
			JOptionPane.showInternalMessageDialog(this, "Please enter both Start and the End Dates !");
			return;
		}
		
		new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				showProgress(btn);
				lblPStatus.setText("Status: Loading data from the server ...");
				try {
					
					String sql = "SELECT * FROM orders WHERE PlacedDate BETWEEN ? AND ? ORDER BY PlacedDate DESC";
					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
					stmt.setDate(1, new Date(dcStartDate.getDate().getTime()));
					stmt.setDate(2, new Date(dcEndDate.getDate().getTime()));

					table.setModel(Database.resultSetToTableModel(stmt.executeQuery()));
					
				} catch (SQLException ex) {}
				lblPStatus.setText("Status: Initializing rows ...");
				
				return null;
			}
			
			@Override
			protected void done() {
				hideProgress(btn);
				lblPStatus.setText("Status: Ready at " + LocalDateTime.now().toString());
			}
			
		}.execute();
				
		
	}
}
