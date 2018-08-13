package ui.orders.tabs;

import java.awt.EventQueue;

import ui.components.KTab;
import javax.swing.JButton;

public class ViewOrders extends KTab {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOrders frame = new ViewOrders();
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
	public ViewOrders() {
		super("View Orders");
		
		JButton btnViewOrders = new JButton("View orders");
		btnViewOrders.setBounds(251, 168, 89, 23);
		getContentPane().add(btnViewOrders);

	}

}
