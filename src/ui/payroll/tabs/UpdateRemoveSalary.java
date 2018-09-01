package ui.payroll.tabs;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateRemoveSalary extends KTab {
	private JTextField empid;
	private JTextField bsal;
	private JTextField com;
	private JTextField tar_A;
	private JTextField tar_E;
	private JTextField tar_P;
	
	String empID = null;
	String fname = null;
    String lname = null;
    String desig = null;
    String cat = null;
    String bas = null;
    String comm = null;
    String ta = null;
    String te = null;
    String tp = null;
    String epf = null;
    String pyt = null;
    String sql;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateRemoveSalary frame = new UpdateRemoveSalary();
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
	public UpdateRemoveSalary() {
		super("Update/Delete Payroll Information");
		
		JLabel lblNewLabel = new JLabel("Update/Delete Payroll Information");
		lblNewLabel.setBounds(68, 63, 185, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Basic Salary");
		lblNewLabel_2.setBounds(386, 234, 86, 14);
		getContentPane().add(lblNewLabel_2);
		
		bsal = new JTextField();
		bsal.setBounds(518, 231, 110, 20);
		getContentPane().add(bsal);
		bsal.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Commission %");
		lblNewLabel_3.setBounds(386, 274, 86, 14);
		getContentPane().add(lblNewLabel_3);
		
		com = new JTextField();
		com.setBounds(518, 271, 110, 20);
		getContentPane().add(com);
		com.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("EPF Employee Contribution");
		lblNewLabel_4.setBounds(386, 430, 149, 14);
		getContentPane().add(lblNewLabel_4);
		
		JRadioButton min = new JRadioButton("8%");
		min.setBounds(537, 426, 51, 23);
		getContentPane().add(min);
		
		JRadioButton max = new JRadioButton("9%");
		max.setBounds(625, 426, 46, 23);
		getContentPane().add(max);
		
		JLabel lblNewLabel_7 = new JLabel("Payment Type");
		lblNewLabel_7.setBounds(386, 472, 76, 14);
		getContentPane().add(lblNewLabel_7);
		
		JComboBox pymt = new JComboBox();
		pymt.setModel(new DefaultComboBoxModel(new String[] {"Bank Transfer", "Cheque", "Cash"}));
		pymt.setBounds(518, 468, 110, 22);
		getContentPane().add(pymt);
		
		
		
		JButton del = new JButton("Delete");
		del.setEnabled(false);
		del.setBounds(65, 399, 89, 23);
		getContentPane().add(del);
		
		JTextPane txtpnFvhyugkkl = new JTextPane();
		txtpnFvhyugkkl.setText("Edit the existing payroll information of any employee after searching the employee payroll details");
		txtpnFvhyugkkl.setBounds(68, 80, 536, 20);
		getContentPane().add(txtpnFvhyugkkl);
		
		JLabel lblNewLabel_6 = new JLabel("Employee Name");
		lblNewLabel_6.setBounds(386, 130, 86, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Designation");
		lblNewLabel_8.setBounds(386, 155, 76, 14);
		getContentPane().add(lblNewLabel_8);
		
		JTextPane empn = new JTextPane();
		empn.setBounds(518, 124, 178, 20);
		getContentPane().add(empn);
		
		JTextPane empd = new JTextPane();
		empd.setBounds(518, 149, 178, 20);
		getContentPane().add(empd);
		
		JTextPane txtpnepfEmployerContribution = new JTextPane();
		txtpnepfEmployerContribution.setText("**EPF Employer Contribution will be 12% and ETF will be 3% for all employees");
		txtpnepfEmployerContribution.setBounds(386, 515, 472, 20);
		getContentPane().add(txtpnepfEmployerContribution);
		
		JLabel lblNewLabel_5 = new JLabel("Target Bonus %");
		lblNewLabel_5.setBounds(386, 316, 86, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_9 = new JLabel("Achieved");
		lblNewLabel_9.setBounds(508, 316, 46, 14);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Exceeded");
		lblNewLabel_10.setBounds(509, 350, 66, 14);
		getContentPane().add(lblNewLabel_10);
		
		tar_A = new JTextField();
		tar_A.setBounds(599, 313, 51, 20);
		getContentPane().add(tar_A);
		tar_A.setColumns(10);
		
		tar_E = new JTextField();
		tar_E.setBounds(599, 347, 51, 20);
		getContentPane().add(tar_E);
		tar_E.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Target Penalty %");
		lblNewLabel_11.setBounds(386, 389, 99, 14);
		getContentPane().add(lblNewLabel_11);
		
		tar_P = new JTextField();
		tar_P.setBounds(518, 386, 86, 20);
		getContentPane().add(tar_P);
		tar_P.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Category");
		lblNewLabel_12.setBounds(387, 191, 46, 14);
		getContentPane().add(lblNewLabel_12);
		
		JRadioButton mgt = new JRadioButton("Management");
		JRadioButton sale = new JRadioButton("Sales");
		
		
		sale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mgt.setSelected(false);
				com.setEditable(true);
				tar_A.setEditable(true);
				tar_E.setEditable(true);;
				tar_P.setEditable(true);
				
			}
		});
		
		mgt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sale.setSelected(false);
				com.setEditable(false);
				com.setText(null);
				tar_A.setEditable(false);
				tar_A.setText(null);
				tar_E.setEditable(false);
				tar_E.setText(null);
				tar_P.setEditable(false);
				tar_P.setText(null);
			}
		});
		mgt.setBounds(479, 187, 109, 23);
		getContentPane().add(mgt);
		
		
		sale.setBounds(625, 187, 66, 23);
		getContentPane().add(sale);
		
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(68, 468, 89, 23);
		getContentPane().add(cancel);
		
		JPanel panel = new JPanel();
		panel.setBounds(68, 129, 262, 137);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setBounds(10, 29, 60, 14);
		panel.add(lblNewLabel_1);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bas = bsal.getText();
				if (mgt.isSelected()) {
					cat = mgt.getText();
					
				}
					
					else if (sale.isSelected()) {
						cat = sale.getText();
						comm = com.getText();
						ta = tar_A.getText();
						te = tar_E.getText();
						tp = tar_P.getText();
					}
						
					
				if (min.isSelected()) 
					epf = min.getText();
				else if (max.isSelected())
					epf = max.getText();
				
				pyt = (String) pymt.getSelectedItem();
				
				if (cat == "Management") {
					if (bas.isEmpty() || epf.isEmpty() || pyt.isEmpty()) {
						JOptionPane.showMessageDialog(null, "One or more required information is not entered. Please check!");
					}
					else {
						double basic = Double.parseDouble(bas);
						double epfcon = Double.parseDouble(epf);
						
						sql = "update payroll set Category = '"+cat+"', Basic_Sal = '"+basic+"', EPF_Employee = '"+epfcon+"', Payment_Type = '"+pyt+"' where EmpID ='"+empID+"'";
					}
				}
				else if (cat == "Sales") {
					if (bas.isEmpty() || comm.isEmpty() || ta.isEmpty() || te.isEmpty() || tp.isEmpty() || epf.isEmpty() || pyt.isEmpty()) {
						JOptionPane.showMessageDialog(null, "One or more required information is not entered. Please check!");
					}
					else {
						double basic = Double.parseDouble(bas);
						double commission = Double.parseDouble(comm);
						double tarAchv = Double.parseDouble(ta);
						double tarExce =  Double.parseDouble(te);
						double pen =  Double.parseDouble(tp);
						double epfcon = Double.parseDouble(epf);

						sql = "update payroll set Category = '"+cat+"', Basic_Sal = '"+basic+"',Comm = '"+commission+"', Target_Achieved_Bonus = '"+ta+"', Target_Exceeded_Bonus = '"+te+"', Target_Penalty = '"+tp+"', EPF_Employee = '"+epfcon+"', Payment_Type = '"+pyt+"'";
					}
				}
				
				try {
            		PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            		stmt.execute();
            		JOptionPane.showConfirmDialog(null, "Details added");
            	} catch (SQLException es) {
            		es.printStackTrace();
            	}

				
			}
		});
		update.setEnabled(false);
		update.setBounds(68, 329, 89, 23);
		getContentPane().add(update);
		
		
		
		empid = new JTextField();
		empid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update.setEnabled(false);
				del.setEnabled(false);
			}
		});
		empid.setBounds(113, 26, 110, 20);
		panel.add(empid);
		empid.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empID = empid.getText();
				
				if (empID.length() < 0 || empID.length() > 5)
					JOptionPane.showMessageDialog(null, "Please select a valid employee ID");
				else {
					
					try {
						
						sql = "select e.FirstName, e.LastName, e.Designation, p.Category, p.Basic_sal, p.Comm, p.Target_Achieved_Bonus, p.Target_Exceeded_Bonus, p.Target_Penalty, p.EPF_Employee, p.Payment_Type from employees e, payroll p where e.EmployeeID = p.EmpID and p.EmpID ='"+ empID +"'";
			            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
			            ResultSet rs = stmt.executeQuery();
			            
			            if(rs.next()) {
			            	fname = rs.getString(1);
				            lname = rs.getString(2);
				            desig = rs.getString(3);
				            cat = rs.getString(4);
				            bas = rs.getString(5);
				            comm = rs.getString(6);
				            ta = rs.getString(7);
				            te = rs.getString(8);
				            tp = rs.getString(9);
				            epf = rs.getString(10);
				            pyt = rs.getString(11);
				            
				            empn.setText(fname +" "+ lname);
				            empd.setText(desig);
				            
				            if (cat.matches("Management")) {
				            	mgt.setSelected(true);
				            	 bsal.setText(bas);
				            }
				            else if (cat.matches("Sales")) {
				            	sale.setSelected(true);
				            	 bsal.setText(bas);
						           com.setText(comm);
						           tar_A.setText(ta);
						           tar_E.setText(te);
						           tar_P.setText(tp);
				            }
				            
				           if (epf.matches("8%")) {
				        	   min.setSelected(true);
				           }
				           else if (epf.matches("9%")) {
				        	   max.setSelected(true);
				           }

				           if (pyt.matches("Bank Transfer"))
				        	   pymt.setSelectedIndex(0);
				           else if (pyt.matches("Cheque"))
				        	   pymt.setSelectedIndex(1);
				           else if (pyt.matches("Cash"))
				        	   pymt.setSelectedIndex(2);
				           
				           update.setEnabled(true);
				           del.setEnabled(true);
				       
				    
			            }
			            
			            else JOptionPane.showMessageDialog(null, "Check the ID entered, No matching Salary profile available!");
			            
			            	
					}catch (SQLException es) {
						es.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(84, 77, 89, 23);
		panel.add(btnNewButton);

		
	}
}
