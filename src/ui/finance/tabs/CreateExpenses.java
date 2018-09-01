package ui.finance.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateExpenses extends KTab {
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateExpenses frame = new CreateExpenses();
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
	public CreateExpenses() {
		super("Create Expenses");
		
		t1 = new JTextField();
		t1.setBounds(319, 122, 86, 20);
		getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Expense Id");
		lblNewLabel.setBounds(104, 125, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Description ");
		lblNewLabel_1.setBounds(104, 200, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(104, 269, 46, 14);
		getContentPane().add(lblDate);
		
		JLabel lblNewLabel_2 = new JLabel("NetAmount");
		lblNewLabel_2.setBounds(104, 350, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Type");
		lblNewLabel_3.setBounds(104, 434, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(319, 197, 86, 20);
		getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(319, 266, 86, 20);
		getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(319, 347, 86, 20);
		getContentPane().add(t4);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(319, 428, 86, 20);
		getContentPane().add(t6);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String expensId = t1.getText();
				String dscrp = t2.getText();
				String date = t3.getText();
				String NetExpenses = t4.getText();
				String Types = t6.getText();
				
				
				try {
					String sql = "INSERT INTO Expenses(ExpensesId,Description,Date,NetExpenses,,Type) Values ('"+expensId+"','"+dscrp+"','"+date+"','"+NetExpenses+"','"+Types+"')";
				
					//ps = con.prepareStatement(sql);
					//ps.execute();
				
				}catch(Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(205, 517, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Create Expenses");
		lblNewLabel_4.setBounds(43, 33, 46, 14);
		getContentPane().add(lblNewLabel_4);
		

	}
}
