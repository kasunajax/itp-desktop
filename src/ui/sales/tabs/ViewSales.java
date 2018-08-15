package ui.sales.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ViewSales extends KTab {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSales frame = new ViewSales();
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
	public ViewSales() {
		super("View Sales");
		
		JButton btnViewSales = new JButton("View Sales");
		btnViewSales.setBounds(85, 111, 85, 21);
		getContentPane().add(btnViewSales);
		
		textField = new JTextField();
		textField.setBounds(252, 112, 96, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblViewSales = new JLabel("View Sales");
		lblViewSales.setBounds(403, 333, 131, 58);
		getContentPane().add(lblViewSales);
	}
}
