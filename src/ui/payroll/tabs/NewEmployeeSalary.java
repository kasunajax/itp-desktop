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

public class NewEmployeeSalary extends KTab {
	private JTextField empid;
	private JTextField bsal;
	private JTextField comm;
	private JTextField t_achv;
	private JTextField t_exce;
	private JTextField penalty;

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
		lblNewLabel.setBounds(32, 26, 123, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setBounds(32, 111, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		JTextPane msg = new JTextPane();
		msg.setBounds(205, 127, 379, 20);
		getContentPane().add(msg);
		
		JTextPane empn = new JTextPane();
		empn.setBounds(205, 158, 267, 20);
		getContentPane().add(empn);
		
		JTextPane empd = new JTextPane();
		empd.setBounds(205, 185, 267, 20);
		getContentPane().add(empd);
		
		empid = new JTextField();
		empid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String empID = empid.getText();
				
				if (empID == null) {
					msg.setText("Please enter a valid employee number");
				}
				else {
					
				try {
					String sql = "select FirstName, LastName, Designation from employees where EmployeeID = '"+ empID +"'";
		            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
		            ResultSet rs = stmt.executeQuery();
					
		            if (rs.next()) {
		            	String fname = rs.getString(0);
			            String lname = rs.getString(1);
			            String desig = rs.getString(2);
			            
			            String sql1 = "select * from payroll where EmpID = '"+ empID +"'";
			            PreparedStatement stmt1 = Database.getConnection().prepareStatement(sql1);
			            ResultSet rs1 = stmt1.executeQuery();
			            
			            if(rs1.next()) {
			            	msg.setText("Employee salary profile already exists");
			            }
			            else {
			            	msg.setText("Employee validated");
			            	empn.setText(fname+" "+lname);
			            	empd.setText(desig);
			            }
		            }
		            else {
		            	empid.setText(" ");
		        		msg.setText("Employee details not found, please enter the correct ID");
		            }
		            
		           
				}catch (SQLException es) {
					es.printStackTrace();
				}
				}
			}
		});
		empid.setBounds(205, 108, 110, 20);
		getContentPane().add(empid);
		empid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Basic Salary");
		lblNewLabel_2.setBounds(32, 274, 86, 14);
		getContentPane().add(lblNewLabel_2);
		
		JTextPane txtpnFvhyugkkl = new JTextPane();
		txtpnFvhyugkkl.setText("Add new employee payroll details below after validating the employee using employee ID");
		txtpnFvhyugkkl.setBounds(32, 51, 536, 20);
		getContentPane().add(txtpnFvhyugkkl);
		
		JLabel lblNewLabel_6 = new JLabel("Employee Name");
		lblNewLabel_6.setBounds(32, 158, 86, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Designation");
		lblNewLabel_8.setBounds(32, 185, 76, 14);
		getContentPane().add(lblNewLabel_8);
		         
		
		bsal = new JTextField();
		bsal.setBounds(205, 271, 110, 20);
		getContentPane().add(bsal);
		bsal.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Commission %");
		lblNewLabel_3.setBounds(32, 309, 86, 14);
		getContentPane().add(lblNewLabel_3);
		
		comm = new JTextField();
		comm.setBounds(205, 306, 110, 20);
		getContentPane().add(comm);
		comm.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("EPF Employee Contribution");
		lblNewLabel_4.setBounds(32, 460, 149, 14);
		getContentPane().add(lblNewLabel_4);
		
		
		//EPF employee radio buttons
		JRadioButton min = new JRadioButton("8%");
		JRadioButton max = new JRadioButton("9%");
		
		min.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (min.isSelected()) {
					max.setSelected(false);
				}
			}
		});
		min.setBounds(205, 456, 51, 23);
		getContentPane().add(min);
		
		max.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (max.isSelected()) {
					min.setSelected(false);
				}
			}
		});
		max.setBounds(312, 456, 46, 23);
		getContentPane().add(max);
		
		JLabel lblNewLabel_7 = new JLabel("Payment Type");
		lblNewLabel_7.setBounds(32, 516, 76, 14);
		getContentPane().add(lblNewLabel_7);
		
		JComboBox pymt = new JComboBox();
		pymt.setModel(new DefaultComboBoxModel(new String[] {"Bank Transfer", "Cheque", "Cash"}));
		pymt.setBounds(205, 512, 110, 22);
		getContentPane().add(pymt);
		
		
		
		
		JTextPane txtpnepfEmployerContribution = new JTextPane();
		txtpnepfEmployerContribution.setText("**EPF Employer Contribution will be 12% and ETF will be 3% for all employees");
		txtpnepfEmployerContribution.setBounds(32, 485, 472, 20);
		getContentPane().add(txtpnepfEmployerContribution);
		
		JLabel lblNewLabel_5 = new JLabel("Target Bonus %");
		lblNewLabel_5.setBounds(32, 345, 86, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_9 = new JLabel("Achieved");
		lblNewLabel_9.setBounds(135, 345, 46, 14);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Exceeded");
		lblNewLabel_10.setBounds(135, 376, 66, 14);
		getContentPane().add(lblNewLabel_10);
		
		t_achv = new JTextField();
		t_achv.setBounds(205, 342, 51, 20);
		getContentPane().add(t_achv);
		t_achv.setColumns(10);
		
		t_exce = new JTextField();
		t_exce.setBounds(205, 373, 51, 20);
		getContentPane().add(t_exce);
		t_exce.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Target Penalty %");
		lblNewLabel_11.setBounds(32, 416, 99, 14);
		getContentPane().add(lblNewLabel_11);
		
		penalty = new JTextField();
		penalty.setBounds(204, 413, 86, 20);
		getContentPane().add(penalty);
		penalty.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Category");
		lblNewLabel_12.setBounds(32, 239, 46, 14);
		getContentPane().add(lblNewLabel_12);
		
		JRadioButton mgt = new JRadioButton("Management");
		JRadioButton sale = new JRadioButton("Sales");
		
		
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
		mgt.setBounds(206, 235, 109, 23);
		getContentPane().add(mgt);
		
		//action listener for category radio button sale
		sale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sale.isSelected()) {
					mgt.setSelected(false);
				}
			}
		});
		sale.setBounds(346, 235, 109, 23);
		getContentPane().add(sale);
		
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String emp = empid.getText();
				String bas = bsal.getText();
				String cat;
				String com = comm.getText();
				String tarA = t_achv.getText();
				String tarE = t_exce.getText();
				String tarP = penalty.getText();
				
				if (mgt.isSelected())
					cat = mgt.getText();
					else if (sale.isSelected())
						cat = sale.getText();
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
						double basic = Double.parseDouble(bas);
						double epfcon = Double.parseDouble(epf);
						
						sql = "insert into payroll (EmpID, Category, Basic_Sal, EPF_Employee, Payment_Type) values('"+emp+"','"+cat+"','"+basic+"','"+epfcon+"','"+pyt+"')";
					}
				}
				else if (cat == "Sales") {
					if (emp.isEmpty() || bas.isEmpty() || com.isEmpty() || tarA.isEmpty() || tarE.isEmpty() || tarP.isEmpty() || epf.isEmpty() || pyt.isEmpty()) {
						JOptionPane.showMessageDialog(null, "One or more required information is not entered. Please check!");
					}
					else {
						double basic = Double.parseDouble(bas);
						double commission = Double.parseDouble(com);
						double tarAchv = Double.parseDouble(tarA);
						double tarExce =  Double.parseDouble(tarE);
						double pen =  Double.parseDouble(tarP);
						double epfcon = Double.parseDouble(epf);

						sql = "insert into payroll (EmpID, Category, Basic_Sal,Comm, Target_Achieved_Bonus, Target_Exceeded_Bonus, Target_Penalty, EPF_Employee, EPF_Employer, ETF, Payment_Type) values('"+emp+"','"+cat+"','"+basic+"','"+commission+"','"+tarAchv+"','"+tarExce+"','"+pen+"','"+epfcon+"','"+pyt+"')";
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
		add.setBounds(269, 574, 89, 23);
		getContentPane().add(add);
		
		JButton clr = new JButton("Clear");
		clr.setBounds(434, 574, 89, 23);
		getContentPane().add(clr);
		
	}
}