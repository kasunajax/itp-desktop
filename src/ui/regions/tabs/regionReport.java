package ui.regions.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class regionReport extends KTab {
	private JTextField txtOfficeId;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regionReport frame = new regionReport();
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
	
	public void getTable(){
        try{
        	String sql = "select ItemID,Serial_Number,Name,Cost,Added_Date,Sold_Date,Status,Executive from items";
            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            table.setModel(Database.resultSetToTableModel(rs));
            
        
        }catch(Exception e){}
    }
	
	public boolean ValidateOfficeId(String txt, String msg) {
		
		return true;
	}
	
	
	public regionReport() {
		super("Sales");
		
		JLabel lblNewLabel = new JLabel("Reports");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(60, 50, 920, 23);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboMonth = new JComboBox();
		comboMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "Februay", "March", "Aipril", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboMonth.setBounds(152, 257, 162, 20);
		getContentPane().add(comboMonth);
		
		JLabel lblNewLabel_2 = new JLabel("Type : ");
		lblNewLabel_2.setBounds(60, 167, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JComboBox comboReportType = new JComboBox();
		comboReportType.setModel(new DefaultComboBoxModel(new String[] {"Inventory Report", "Sales Report"}));
		comboReportType.setBounds(152, 164, 162, 20);
		getContentPane().add(comboReportType);

		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton rdbtnYearly = new JRadioButton("Yearly ");
		rdbtnYearly.setBounds(249, 203, 65, 23);
		getContentPane().add(rdbtnYearly);

		
		
		JRadioButton rdbtnMonthly = new JRadioButton("Mothly");
		rdbtnMonthly.setBounds(152, 204, 65, 21);
		getContentPane().add(rdbtnMonthly);
		
		
		bg.add(rdbtnMonthly);
		bg.add(rdbtnYearly);
		
		JLabel lblNewLabel_1 = new JLabel("Frequency :");
		lblNewLabel_1.setBounds(60, 207, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Month :");
		lblNewLabel_3.setBounds(60, 260, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Year :");
		lblNewLabel_4.setBounds(60, 311, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JComboBox comboYear = new JComboBox();
		comboYear.setModel(new DefaultComboBoxModel(new String[] {"2017", "2016", "2015", "2014", "2013"}));
		comboYear.setBounds(152, 308, 162, 20);
		getContentPane().add(comboYear);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql;	
				var officeId = txtOfficeId.getText();
				int count = 0;	
				
				Pattern pattern1 = Pattern.compile("OFC\\d\\d\\d");
				Matcher match1 = pattern1.matcher(officeId);
				
				if(!match1.matches() && officeId == "") {
					JOptionPane.showMessageDialog(null,"Please enter the office ID");
				}
				
				else if(ValidateOfficeId(officeId,"")) {
					
					try {
						
						sql = "select count(*) from items,sales_executives,office where items.Executive = sales_executives.EmployeeID and sales_executives.OfficeID = office.OfficeID and office.OfficeID = '"+officeId+"'";
						PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
						ResultSet rs = stmt.executeQuery();
						if(rs.next())
							count = rs.getInt(1);
					}
					catch(SQLException ex) {
						ex.printStackTrace();
					}
					if(count == 1) {
						try {
							
							sql = "select items.ItemID,items.Serial_Number,items.Name,items.Added_Date,items.Sold_Date,items.Status,items.Executive,items.cost,office.OfficeID,office.Reigon_Name from items,sales_executives,office where items.Executive = sales_executives.EmployeeID and sales_executives.OfficeID = office.OfficeID and office.OfficeID = '"+officeId+"'";
							PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
							ResultSet rs = stmt.executeQuery();
							table.setModel(Database.resultSetToTableModel(rs));
						}
						catch(SQLException ex) {
							ex.printStackTrace();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "No Office Id exist like '"+officeId+"'");
				}
				
				
			}
		});
		btnSubmit.setBounds(785, 500, 79, 23);
		getContentPane().add(btnSubmit);
		
		JLabel lblNewLabel_5 = new JLabel("Office Id :");
		lblNewLabel_5.setBounds(60, 123, 82, 17);
		getContentPane().add(lblNewLabel_5);
		
		txtOfficeId = new JTextField();
		txtOfficeId.setBounds(152, 121, 162, 20);
		getContentPane().add(txtOfficeId);
		txtOfficeId.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(381, 123, 570, 278);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
