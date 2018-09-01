package ui.orders;

import java.awt.EventQueue;

import ui.components.KFrame;
import ui.components.KTab;
import ui.components.TabPanel;
import ui.components.TabStruct;
import ui.orders.tabs.ManageOrders;
import ui.orders.tabs.PlaceOrder;
import ui.orders.tabs.ProcessOrders;
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
		
		
//		KTab[] tabs = new KTab[3];
//		tabs[0] = new ViewOrders();
//		tabs[1] = new PlaceOrder();
//		tabs[2] = new ProcessOrders();
//		
//
//		new TabPanel(this, tabs, new TabNavPanel(this));
//		super(3);
//		
//		addKtab(0, ViewOrders.class, "View Orders");
//		addKtab(1, PlaceOrder.class, "Place Order");
//		addKtab(2, ProcessOrders.class, "Process Order");
//		
//		Class<?>[] t = {
//				ViewOrders.class,
//				PlaceOrder.class,
//				ProcessOrders.class
//		};
//		
		TabStruct[] ts = {
				new TabStruct(ManageOrders.class, "MANAGE ORDERS"),
				new TabStruct(ViewOrders.class, "VIEW ORDERS"),
				new TabStruct(ProcessOrders.class, "PROCESS ORDERS")
		};
		
		setStruct(ts);


		

	}
}
