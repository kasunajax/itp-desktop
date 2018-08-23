package ui.finance.tabs;

import java.awt.EventQueue;

import ui.components.KTab;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ExpensesDetails extends KTab {
	private JTextField t1;
	private JTextField t2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpensesDetails frame = new ExpensesDetails();
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
	public ExpensesDetails() {
		super("Expenses Details");
		
		JLabel lblNewLabel = new JLabel("Search by Type");
		lblNewLabel.setBounds(59, 102, 89, 14);
		getContentPane().add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setBounds(170, 98, 146, 23);
		getContentPane().add(t1);
		t1.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(373, 98, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblSearchByDate = new JLabel("Search by date");
		lblSearchByDate.setBounds(59, 179, 89, 14);
		getContentPane().add(lblSearchByDate);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(170, 176, 146, 23);
		getContentPane().add(t2);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(373, 175, 89, 23);
		getContentPane().add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 247, 960, 256);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Expense Id", "Description", "Date", "Net Expenses", "Type", "Employee Id"
			}
		));
		scrollPane.setViewportView(table);

	}

}
