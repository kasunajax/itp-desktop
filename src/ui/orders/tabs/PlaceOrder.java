package ui.orders.tabs;

import java.awt.EventQueue;

import ui.components.KTab;
import javax.swing.JButton;
import java.awt.Color;

public class PlaceOrder extends KTab {

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
					PlaceOrder frame = new PlaceOrder();
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
	public PlaceOrder() {
		super("Place Order");
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setBackground(new Color(0, 51, 102));
		btnPlaceOrder.setBounds(251, 282, 195, 64);
		getContentPane().add(btnPlaceOrder);

	}

}
