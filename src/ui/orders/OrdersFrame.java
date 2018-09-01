package ui.orders;

import java.awt.EventQueue;

import ui.components.KFrame;
import ui.components.KTab;
import ui.components.TabPanel;
import ui.orders.tabs.PlaceOrder;
import ui.orders.tabs.ViewOrders;
import ui.components.TabNavPanel;



public class OrdersFrame extends KFrame {

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
					OrdersFrame frame = new OrdersFrame();
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
	public OrdersFrame() {
		
		
		KTab[] tabs = new KTab[2];
		tabs[0] = new ViewOrders();
		tabs[1] = new PlaceOrder();
		

		new TabPanel(this, tabs, new TabNavPanel(this));

	}
}
