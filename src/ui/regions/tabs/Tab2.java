package ui.regions.tabs;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.components.KTab;

public class Tab2 extends KTab {

	private JTextField textField, textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tab2 frame = new Tab2();
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
	public Tab2() {
		super("Tab 2");
		
		JLabel lblOfficeId = new JLabel("Office Id :");
		lblOfficeId.setBounds(130, 98, 170, 40);
		getContentPane().add(lblOfficeId);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(297, 372, 130, 40);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Start Date :");
		lblNewLabel.setBounds(130, 175, 170, 40);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(417, 175, 170, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(417, 98, 170, 40);
		getContentPane().add(comboBox);
		
		JLabel lblEndDate = new JLabel("End Date :");
		lblEndDate.setBounds(130, 259, 170, 40);
		getContentPane().add(lblEndDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(417, 259, 170, 40);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
	}

}
