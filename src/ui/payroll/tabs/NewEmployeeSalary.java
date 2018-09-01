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
	
	
	String com = null;
	String tarA = null;
	String tarE = null;
	String tarP = null;

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
		lblNewLabel.setBounds(69, 61, 123, 14);
		getContentPane().add(lblNewLabel);
		
		JTextPane txtpnFvhyugkkl = new JTextPane();
		txtpnFvhyugkkl.setText("Add new employee payroll details below after validating the employee using employee ID");
		txtpnFvhyugkkl.setBounds(69, 86, 536, 20);
		getContentPane().add(txtpnFvhyugkkl);
		
		comm = new JTextField();
		comm.setBounds(717, 217, 110, 20);
		getContentPane().add(comm);
		comm.setColumns(10);
		
		t_achv = new JTextField();
		t_achv.setBounds(717, 266, 51, 20);
		getContentPane().add(t_achv);
		t_achv.setColumns(10);
		
		t_exce = new JTextField();
		t_exce.setBounds(717, 303, 51, 20);
		getContentPane().add(t_exce);
		t_exce.setColumns(10);
		
		penalty = new JTextField();
		penalty.setBounds(717, 341, 86, 20);
		getContentPane().add(penalty);
		penalty.setColumns(10);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(69, 106, 401, 180);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setBounds(20, 23, 60, 14);
		panel.add(lblNewLabel_1);
		
		JTextPane empn = new JTextPane();
		empn.setBounds(130, 105, 172, 20);
		panel.add(empn);
		
		JTextPane empd = new JTextPane();
		empd.setBounds(130, 136, 172, 20);
		panel.add(empd);
		
		JTextPane msg = new JTextPane();
		msg.setBounds(20, 58, 337, 20);
		panel.add(msg);
		
		empid = new JTextField();
		empid.setBounds(132, 20, 86, 20);
		panel.add(empid);
		empid.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Employee Name");
		lblNewLabel_6.setBounds(20, 111, 86, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Designation");
		lblNewLabel_8.setBounds(20, 142, 76, 14);
		panel.add(lblNewLabel_8);
		
		JButton add = new JButton("Add");
		add.setEnabled(false);
		
		JButton validate = new JButton("Validate");
		validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String empID = empid.getText();
				
				if (empID.length() < 1 || empID.length() > 5)
					msg.setText("Please enter a valid employee number");
				
				else {
					
					
					
					try {
						String sql = "select * from employees where EmployeeID = '"+ empID +"'";
			            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
			            ResultSet rs = stmt.executeQuery();
						
			            if (rs.next()) {
			            	String fname = rs.getString(2);
				            String lname = rs.getString(3);
				            String desig = rs.getString(8);
				            
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
				            	add.setEnabled(true);
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
		validate.setBounds(265, 19, 89, 23);
		panel.add(validate);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(69, 306, 401, 211);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox pymt = new JComboBox();
		pymt.setBounds(195, 162, 91, 20);
		panel_1.add(pymt);
		pymt.setModel(new DefaultComboBoxModel(new String[] {"Bank Transfer", "Cheque", "Cash"}));
		
		JLabel lblNewLabel_7 = new JLabel("Payment Type");
		lblNewLabel_7.setBounds(31, 163, 76, 18);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_12 = new JLabel("Category");
		lblNewLabel_12.setBounds(31, 24, 99, 14);
		panel_1.add(lblNewLabel_12);
		
		JRadioButton mgt = new JRadioButton("Management");
		mgt.setBounds(150, 20, 111, 23);
		panel_1.add(mgt);
		JRadioButton sale = new JRadioButton("Sales");
		sale.setBounds(281, 20, 76, 23);
		panel_1.add(sale);
		
		
		
		
		JTextPane txtpnepfEmployerContribution = new JTextPane();
		txtpnepfEmployerContribution.setBounds(10, 131, 384, 20);
		panel_1.add(txtpnepfEmployerContribution);
		txtpnepfEmployerContribution.setText("**EPF Employer Contribution will be 12% and ETF will be 3% for all employees");
		
		JLabel lblNewLabel_4 = new JLabel("EPF Employee Contribution");
		lblNewLabel_4.setBounds(31, 97, 135, 23);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Basic Salary");
		lblNewLabel_2.setBounds(31, 61, 86, 14);
		panel_1.add(lblNewLabel_2);
		
		bsal = new JTextField();
		bsal.setBounds(194, 58, 110, 20);
		panel_1.add(bsal);
		bsal.setColumns(10);
		
		
		//EPF employee radio buttons
		JRadioButton min = new JRadioButton("8");
		min.setBounds(195, 99, 51, 23);
		panel_1.add(min);
		
		
		
		
		JRadioButton max = new JRadioButton("9");
		max.setBounds(281, 99, 46, 23);
		panel_1.add(max);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(519, 188, 346, 189);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Commission %");
		lblNewLabel_3.setBounds(26, 25, 69, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_9 = new JLabel("Achieved");
		lblNewLabel_9.setBounds(141, 73, 46, 14);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Exceeded");
		lblNewLabel_10.setBounds(137, 109, 61, 14);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_5 = new JLabel("Target Bonus %");
		lblNewLabel_5.setBounds(26, 73, 86, 14);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_11 = new JLabel("Target Penalty %");
		lblNewLabel_11.setBounds(26, 150, 99, 14);
		panel_2.add(lblNewLabel_11);
		
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
		add.setBounds(714, 455, 89, 23);
		getContentPane().add(add);
		
		JButton clr = new JButton("Clear");
		clr.setBounds(714, 489, 89, 23);
		getContentPane().add(clr);
		
	}
}