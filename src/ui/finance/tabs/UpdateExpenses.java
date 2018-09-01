package ui.finance.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateExpenses extends KTab {
	private JTextField textField;
	private JTable table;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateExpenses frame = new UpdateExpenses();
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
	public UpdateExpenses() {
		
		super("Update Expenses");
		
		JLabel lblNewLabel = new JLabel("Search by month");
		lblNewLabel.setBounds(160, 69, 46, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(327, 66, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(542, 65, 89, 23);
		getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(21, 103, 932, 247);
		getContentPane().add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Update Details");
		lblNewLabel_1.setBounds(43, 29, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Expenses Id");
		lblNewLabel_2.setBounds(95, 409, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblDescription = new JLabel("Description ");
		lblDescription.setBounds(95, 466, 46, 14);
		getContentPane().add(lblDescription);
		
		JLabel lblDates = new JLabel("Date");
		lblDates.setBounds(95, 519, 46, 14);
		getContentPane().add(lblDates);
		
		JLabel lblSalesAndDistribution = new JLabel("Net Epenses");
		lblSalesAndDistribution.setBounds(95, 574, 46, 14);
		getContentPane().add(lblSalesAndDistribution);
		
		JLabel lblAdministrativeExpenses = new JLabel("Types");
		lblAdministrativeExpenses.setBounds(443, 409, 46, 14);
		getContentPane().add(lblAdministrativeExpenses);
		
		t1 = new JTextField();
		t1.setBounds(251, 406, 86, 20);
		getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(251, 463, 86, 20);
		getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(251, 516, 86, 20);
		getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(251, 571, 86, 20);
		getContentPane().add(t4);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(607, 406, 86, 20);
		getContentPane().add(t5);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
 int x = JOptionPane.showConfirmDialog(null,"Do you really want to update");
				 
				 if(x==0) {
					 
					 	String expensId = t1.getText();
						String dscrp = t2.getText();
						String date = t3.getText();
						String NetExpens = t5.getText();
						String typ = t4.getText();
						
						try {
							
							String sql = "Update Expenses set Description='"+dscrp+"',Date='"+date+"',NetExpenses='"+NetExpens+"',Types='"+typ+"'where ExpensId='"+expensId+"'";
							
					
							
					//		ps = con.prepareStatement(sql);
				        
			                
			          //      ps.execute();
			            
			                
			                
			              
							
						}catch(Exception e1) {
							
							e1.printStackTrace();
						}
					 
				 }
				
			}
		});
		btnNewButton_1.setBounds(527, 570, 89, 23);
		getContentPane().add(btnNewButton_1);

	}
}
