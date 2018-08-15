package ui.regions.tabs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.components.KTab;

public class Tab1 extends KTab {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField textField, textField_1, textField_2, textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tab1 frame = new Tab1();
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
	public Tab1() {
		super("Tab 1");
		
		textField = new JTextField();
		textField.setBounds(410, 94, 170, 40); 
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Office Id :");
		lblNewLabel.setBounds(97, 94, 170, 40);
		getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(410, 162, 170, 40);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Region Name :");
		lblNewLabel_1.setBounds(97, 162, 170, 40);
		getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(410, 228, 170, 40);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contact no. :");
		lblNewLabel_2.setBounds(97, 228, 170, 40);
		getContentPane().add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(410, 297, 170, 40);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Address :");
		lblNewLabel_3.setBounds(97, 297, 170, 40);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBounds(278, 416, 130, 40);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton_2.setBounds(450, 416, 130, 40);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setBounds(97, 416, 130, 40);
		getContentPane().add(btnNewButton);
	}

}
