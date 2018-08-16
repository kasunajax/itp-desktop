package ui.orders.tabs;

import java.awt.EventQueue;

import ui.components.KTab;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

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
		
		JButton btnTab = new JButton("Tab");
		btnTab.setFocusable(false);
		btnTab.setForeground(new Color(255, 255, 255));
		btnTab.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnTab.setBorder(null);
		btnTab.setBackground(new Color(102, 153, 255));
		btnTab.setBounds(192, 127, 160, 40);
		getContentPane().add(btnTab);

	}

}
