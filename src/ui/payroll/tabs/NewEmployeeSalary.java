package ui.payroll.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

import utils.common.database.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class NewEmployeeSalary extends KTab {
	private JTextField empid;
	private JTextField bsal;
	private JTextField comm;
	private JTextField t_achv;
	private JTextField t_exce;
	private JTextField penalty;
	
	String empID = null;
	String fname = null;
    String lname = null;
    String desig = null;
    String cat = null;
    String bas = null;
    String epf = null;    
    String pyt = null;
	
	String com = null;
	String tarA = null;
	String tarE = null;
	String tarP = null;
	String sql;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewEmployeeSalary frame = new NewEmployeeSalary();
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
	public NewEmployeeSalary() {
		super("New Employee Payroll");
		
			
		JLabel lblNewLabel = new JLabel("New Employee Payroll");
		lblNewLabel.setBounds(69, 61, 321, 14);
		getContentPane().add(lblNewLabel);
		
		JTextPane txtpnFvhyugkkl = new JTextPane();
		txtpnFvhyugkkl.setText("Add new employee payroll details / update exisiting employee details after validating the employee using employee ID");
		txtpnFvhyugkkl.setBounds(69, 86, 826, 20);
		getContentPane().add(txtpnFvhyugkkl);
		
		comm = new JTextField();
		comm.setBounds(777, 217, 50, 20);
		getContentPane().add(comm);
		comm.setColumns(10);
		
		penalty = new JTextField();
		penalty.setBounds(777, 341, 50, 20);
		getContentPane().add(penalty);
		penalty.setColumns(10);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(69, 106, 401, 180);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setBounds(20, 23, 105, 14);
		panel.add(lblNewLabel_1);
		
		JTextPane empn = new JTextPane();
		empn.setBounds(130, 78, 172, 20);
		panel.add(empn);
		
		JTextPane empd = new JTextPane();
		empd.setBounds(130, 112, 172, 20);
		panel.add(empd);
		
		empid = new JTextField();
		empid.setBounds(132, 20, 86, 20);
		panel.add(empid);
		empid.setColumns(10);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(69, 306, 401, 272);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Employee Name");
		lblNewLabel_6.setBounds(20, 84, 105, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Designation");
		lblNewLabel_8.setBounds(20, 118, 105, 14);
		panel.add(lblNewLabel_8);
		
		JButton add = new JButton("Add");
		add.setEnabled(false);
		
		JRadioButton mgt = new JRadioButton("Management");
		mgt.setBounds(195, 20, 111, 23);
		panel_1.add(mgt);
		JRadioButton sale = new JRadioButton("Sales");
		sale.setBounds(318, 20, 76, 23);
		panel_1.add(sale);
		
		//EPF employee radio buttons
		JRadioButton min = new JRadioButton("8");
		min.setBounds(195, 97, 51, 23);
		panel_1.add(min);

		
		JRadioButton max = new JRadioButton("9");
		max.setBounds(281, 99, 46, 23);
		panel_1.add(max);
		
		JComboBox pymt = new JComboBox();
		pymt.setBounds(195, 193, 132, 20);
		panel_1.add(pymt);
		pymt.setModel(new DefaultComboBoxModel(new String[] {"Bank Transfer", "Cheque", "Cash"}));
		
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sql=null;
				bas = bsal.getText();
				if (mgt.isSelected()) {
					cat = mgt.getText();
					
				}
					
					else if (sale.isSelected()) {
						cat = sale.getText();
						com = comm.getText();
						tarA = t_achv.getText();
						tarE = t_exce.getText();
						tarP = penalty.getText();
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
						
						sql = "update payroll set Category = '"+cat+"', Basic_Sal = '"+basic+"', Comm = 'NULL', Target_Achieved_Bonus = 'NULL', Target_Exceeded_Bonus = 'NULL', Target_Penalty = 'NULL', EPF_Employee = '"+epfcon+"', Payment_Type = '"+pyt+"' where EmpID ='"+empID+"'";
					}
				}
				else if (cat == "Sales") {
					if (bas.isEmpty() || com.isEmpty() || tarA.isEmpty() || tarE.isEmpty() || tarP.isEmpty() || epf.isEmpty() || pyt.isEmpty()) {
						JOptionPane.showMessageDialog(null, "One or more required information is not entered. Please check!");
					}
					else {
						double basic = Double.parseDouble(bas);
						double commission = Double.parseDouble(com);
						double tarAchv = Double.parseDouble(tarA);
						double tarExce =  Double.parseDouble(tarE);
						double pen =  Double.parseDouble(tarP);
						double epfcon = Double.parseDouble(epf);

						sql = "update payroll set Category = '"+cat+"', Basic_Sal = '"+basic+"',Comm = '"+commission+"', Target_Achieved_Bonus = '"+tarAchv+"', Target_Exceeded_Bonus = '"+tarExce+"', Target_Penalty = '"+pen+"', EPF_Employee = '"+epfcon+"', Payment_Type = '"+pyt+"' where EmpID ='"+empID+"'";
					}
				}
				
				try {
            		PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            		stmt.execute();
            		JOptionPane.showMessageDialog(null, "Details Updated!");
            	} catch (SQLException es) {
            		es.printStackTrace();
            	}

				

			}
		});
		update.setEnabled(false);
		update.setBounds(717, 416, 85, 23);
		getContentPane().add(update);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				empID = empid.getText();
				int a =JOptionPane.showConfirmDialog(null, "Do you want to delete this record?");
				if (a==0) {
					String sql1 = "delete from payroll where EmpID ='" +empID+"'";
					try {
						PreparedStatement stmt = Database.getConnection().prepareStatement(sql1);
						stmt.executeQuery();
						JOptionPane.showMessageDialog(null, "Employee details removed from records");
						
					}catch (SQLException es) {
						es.printStackTrace();
					}
				}
			}
		});
		delete.setEnabled(false);
		delete.setBounds(717, 451, 85, 21);
		getContentPane().add(delete);
		
		
		
		
		
		JButton search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				empID = empid.getText();
				
				if (empID.length() < 1 || empID.length() > 5)
					JOptionPane.showMessageDialog(null, "Please enter a valid employee ID");
				
				else {
					
					try {
						
						sql = "select * from payroll where EmpID = '"+ empID +"'";
						PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
			            ResultSet rs = stmt.executeQuery();
			            
			            if (rs.next()) {
			            	
			            	
			            	String sql1 = "select e.FirstName, e.LastName, e.Designation, p.Category, p.Basic_sal, p.Comm, p.Target_Achieved_Bonus, p.Target_Exceeded_Bonus, p.Target_Penalty, p.EPF_Employee, p.Payment_Type from employees e, payroll p where e.EmployeeID = p.EmpID and p.EmpID ='"+ empID +"'";
				            PreparedStatement stmt1 = Database.getConnection().prepareStatement(sql1);
				            ResultSet rs1 = stmt1.executeQuery();
				            
				            if(rs1.next()) {
				            		fname = rs1.getString(1);
				            		lname = rs1.getString(2);
				            		desig = rs1.getString(3);
				            		cat = rs1.getString(4);
				            		bas = rs1.getString(5);
				            		com = rs1.getString(6);
				            		tarA = rs1.getString(7);
				            		tarE = rs1.getString(8);
				            		tarP = rs1.getString(9);
				            	int	epfc = rs1.getInt(10);
				            		pyt = rs1.getString(11);
					            
				            		empn.setText(fname +" "+ lname);
				            		empd.setText(desig);
					            
				            		if (cat.matches("Management")) {
				            			mgt.setSelected(true);
				            			bsal.setText(bas);
				            			comm.setEnabled(false);
				            			t_achv.setEnabled(false);
				            			t_exce.setEnabled(false);
				            			penalty.setEnabled(false);
				            			
				            		}
				            		else if (cat.matches("Sales")) {
				            			sale.setSelected(true);
				            			bsal.setText(bas);
				            			comm.setText(com);
				            			t_achv.setText(tarA);
				            			t_exce.setText(tarE);
				            			penalty.setText(tarP);
				            		}
					            
				            		if (epfc == 8)
				            			min.setSelected(true);
	
				            		else if (epfc == 9) 
				            			max.setSelected(true);
				            			

				            		if (pyt.matches("Bank Transfer"))
				            			pymt.setSelectedIndex(0);
				            		else if (pyt.matches("Cheque"))
				            			pymt.setSelectedIndex(1);
				            		else if (pyt.matches("Cash"))
				            			pymt.setSelectedIndex(2);
					           
				            		update.setEnabled(true);
				            		delete.setEnabled(true);
				            }
				            
			            	
			            	
			            }
			            else {
			            	
			            	String sql2 = "select FirstName, LastName, Designation from employees where EmployeeID = '"+ empID +"'";
				            PreparedStatement stmt2 = Database.getConnection().prepareStatement(sql2);
				            ResultSet rs2 = stmt2.executeQuery();
			            	
			            	
				            if (rs2.next()) {
				            	fname = rs2.getString(1);
					            lname = rs2.getString(2);
					            desig = rs2.getString(3);
					            
					            JOptionPane.showMessageDialog(null, "Please add the employee details");
				            	empn.setText(fname+" "+lname);
				            	empd.setText(desig);
				            	add.setEnabled(true);
					            
				            }
				            
				            else {
				            	empid.setText(" ");
				            	JOptionPane.showMessageDialog(null, "Employee details not found, please enter the correct ID");
				            }
				         
			            	
			            	
			            }
						
			            
			           
					}catch (SQLException es) {
						es.printStackTrace();
					}
					}
			}
		});
		search.setBounds(265, 19, 89, 23);
		panel.add(search);
		
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Payment Type");
		lblNewLabel_7.setBounds(31, 194, 136, 18);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_12 = new JLabel("Category");
		lblNewLabel_12.setBounds(31, 24, 99, 14);
		panel_1.add(lblNewLabel_12);
		
		
		
		
		
		
		JTextPane txtpnepfEmployerContribution = new JTextPane();
		txtpnepfEmployerContribution.setBounds(31, 131, 344, 43);
		panel_1.add(txtpnepfEmployerContribution);
		txtpnepfEmployerContribution.setText("**EPF Employer Contribution will be 12% and ETF will be 3% for all employees");
		
		JLabel lblNewLabel_4 = new JLabel("EPF Employee Contribution");
		lblNewLabel_4.setBounds(31, 97, 197, 23);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Basic Salary");
		lblNewLabel_2.setBounds(31, 61, 86, 14);
		panel_1.add(lblNewLabel_2);
		
		bsal = new JTextField();
		bsal.setBounds(194, 58, 110, 20);
		panel_1.add(bsal);
		bsal.setColumns(10);
		
		

		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(519, 188, 346, 189);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Commission %");
		lblNewLabel_3.setBounds(26, 25, 134, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_9 = new JLabel("Achieved");
		lblNewLabel_9.setBounds(141, 73, 106, 14);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Exceeded");
		lblNewLabel_10.setBounds(141, 109, 88, 14);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_5 = new JLabel("Target Bonus %");
		lblNewLabel_5.setBounds(26, 73, 105, 14);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_11 = new JLabel("Target Penalty %");
		lblNewLabel_11.setBounds(26, 150, 144, 14);
		panel_2.add(lblNewLabel_11);
		
		t_achv = new JTextField();
		t_achv.setBounds(257, 71, 51, 20);
		panel_2.add(t_achv);
		t_achv.setColumns(10);
		
		t_exce = new JTextField();
		t_exce.setBounds(257, 107, 51, 20);
		panel_2.add(t_exce);
		t_exce.setColumns(10);
		
		max.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (max.isSelected()) {
					min.setSelected(false);
				}
			}
		});
		
		min.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (min.isSelected()) {
					max.setSelected(false);
				}
			}
		});
		
		//action listener for category radio button sale
		sale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sale.isSelected()) {
					mgt.setSelected(false);
					comm.setEditable(true);
					t_achv.setEditable(true);
					t_exce.setEditable(true);
					penalty.setEditable(true);
				}
			}
		});
		
		
		//action listener for category radio button mgt
		mgt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mgt.isSelected()) {
					sale.setSelected(false);
					comm.setEditable(false);
					t_achv.setEditable(false);
					t_exce.setEditable(false);
					penalty.setEditable(false);
				}
			}
		});
		
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String emp = empid.getText();
				String bas = bsal.getText();
				String cat;
				double basic;
				double epfcon;
				double commission;
				double tarAchv;
				double tarExce;
				double pen;
				
				if (mgt.isSelected())
					cat = mgt.getText();
					else if (sale.isSelected()) {
						cat = sale.getText();
						com = comm.getText();
						tarA = t_achv.getText();
						tarE = t_exce.getText();
						tarP = penalty.getText();
					}
					else cat = null;
				
				String epf;
				if (min.isSelected()) 
					epf = min.getText();
				else if (max.isSelected())
					epf = max.getText();
				else epf = null;
				
				String pyt = (String) pymt.getSelectedItem();
				
				
				String sql = null;
				
				if (cat == null) {
					JOptionPane.showMessageDialog(null, "Please select a suitable category");
				}
				else if (cat == "Management") {
					if (emp.isEmpty() || bas.isEmpty() || epf.isEmpty() || pyt.isEmpty()) {
						JOptionPane.showMessageDialog(null, "One or more required information is not entered. Please check!");
					}
					else {
						basic = Double.parseDouble(bas);
						epfcon = Double.parseDouble(epf);
						
						sql = "insert into payroll (EmpID, Category, Basic_Sal, EPF_Employee, Payment_Type) values('"+emp+"','"+cat+"','"+basic+"','"+epfcon+"','"+pyt+"')";
					}
				}
				else if (cat == "Sales") {
					if (emp.isEmpty() || bas.isEmpty() || com.isEmpty() || tarA.isEmpty() || tarE.isEmpty() || tarP.isEmpty() || epf.isEmpty() || pyt.isEmpty()) {
						JOptionPane.showMessageDialog(null, "One or more required information is not entered. Please check!");
					}
					else {
						basic = Double.parseDouble(bas);
						commission = Double.parseDouble(com);						
						tarAchv = Double.parseDouble(tarA);
						tarExce =  Double.parseDouble(tarE);
						pen =  Double.parseDouble(tarP);
						epfcon = Double.parseDouble(epf);

						sql = "insert into payroll (EmpID, Category, Basic_Sal,Comm, Target_Achieved_Bonus, Target_Exceeded_Bonus, Target_Penalty, EPF_Employee, Payment_Type) values('"+emp+"','"+cat+"','"+basic+"','"+commission+"','"+tarAchv+"','"+tarExce+"','"+pen+"','"+epfcon+"','"+pyt+"')";
					} 
					
				}
				 
				try {
            		PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            		stmt.execute();
            		JOptionPane.showMessageDialog(null, "Details added");
            	} catch (SQLException es) {
            		es.printStackTrace();
            	}
			}
		});
		add.setBounds(717, 482, 86, 23);
		getContentPane().add(add);
		
		JButton clr = new JButton("Clear");
		clr.setBounds(717, 515, 85, 23);
		getContentPane().add(clr);
		
		
		
		
		
	}
}