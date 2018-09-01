package ui.inventory.tabs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ui.components.KTab;
import utils.common.database.Database;

public class Forcast extends KTab {
	
	private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTable table_1;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forcast frame = new Forcast();
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
	public Forcast() {
		super("Forcasting");
		
		
		JLabel lblForcastingOfFuture = new JLabel("Forcasting of Future Demand for Products");
		lblForcastingOfFuture.setBounds(87, 105, 420, 34);
		getContentPane().add(lblForcastingOfFuture);
		
		JLabel lblGetForcastOn = new JLabel("Get Forcast on Branch basis");
		lblGetForcastOn.setBounds(87, 169, 306, 34);
		getContentPane().add(lblGetForcastOn);
		
		JLabel lblEnterBranchCode = new JLabel("Enter Branch Code:");
		lblEnterBranchCode.setBounds(87, 216, 140, 23);
		getContentPane().add(lblEnterBranchCode);
		
		JLabel lblEnterItemId = new JLabel("Enter Item Name:");
		lblEnterItemId.setBounds(87, 264, 140, 23);
		getContentPane().add(lblEnterItemId);
		
		textField_7 = new JTextField();
		textField_7.setBounds(232, 217, 116, 22);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(232, 265, 116, 22);
		getContentPane().add(textField_8);
		
		JLabel label_9 = new JLabel("Get Forcast on Branch basis");
		label_9.setBounds(552, 105, 306, 34);
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("Enter Branch Code:");
		label_10.setBounds(552, 164, 140, 23);
		getContentPane().add(label_10);
		
		JLabel lblEnterItemName = new JLabel("Enter Item Name:");
		lblEnterItemName.setBounds(552, 200, 140, 23);
		getContentPane().add(lblEnterItemName);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(697, 165, 116, 22);
		getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(697, 201, 116, 22);
		getContentPane().add(textField_10);
		
		JButton btnGetForcast = new JButton("Get Forcast");
		btnGetForcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int month = localDate.getMonthValue();
				 //JOptionPane.showMessageDialog(null, month);
				
				int count = 0;
				String br = textField_7.getText();
				String item = textField_8.getText();
				
				
				for(int i = 1;i<= month;++i) {
					String sql = "select count(*) from items where Branch = '"+br+"' and Name = '"+item+"' and MONTH(Purchased_Date) = '"+i+"'";
					try {
						Statement st=(Statement) Database.getConnection().createStatement();
						ResultSet rs=st.executeQuery(sql);
						while(rs.next())
							count = count +  rs.getInt(1);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				JOptionPane.showMessageDialog(null, count);			
			}
		});
		btnGetForcast.setBounds(232, 300, 99, 25);
		getContentPane().add(btnGetForcast);
		
		JButton button_3 = new JButton("Get Forcast");
		button_3.setBounds(697, 236, 99, 25);
		getContentPane().add(button_3);
	}

}
