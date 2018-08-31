package ui.inventory;

import java.awt.EventQueue;

import ui.components.KFrame;
import ui.components.KTab;
import ui.components.TabNavPanel;
import ui.components.TabPanel;
import ui.components.TabStruct;
import ui.inventory.tabs.Cost;
import ui.inventory.tabs.Forcast;
import ui.inventory.tabs.Home;
import ui.inventory.tabs.MakeChanges;
import ui.orders.tabs.PlaceOrder;
import ui.orders.tabs.ProcessOrders;
import ui.orders.tabs.ViewOrders;

public class InventoryFrame extends KFrame {

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
					InventoryFrame frame = new InventoryFrame();
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
	public InventoryFrame() {
		TabStruct[] ts = {
				new TabStruct(Home.class, "HOME"),
				new TabStruct(MakeChanges.class, "MAKE CHANGES"),
				new TabStruct(Forcast.class, "FORCARSTS"),
				new TabStruct(Cost.class, "COST CALCULATION")
		};
		
		setStruct(ts);
		
//		KTab[] tabs = new KTab[4];
//		tabs[0] = new Home();
//		tabs[1] = new MakeChanges();
//		tabs[2] = new Forcast();
//		tabs[3] = new Cost();
//		 
//
//		new TabPanel(this, tabs, new TabNavPanel(this));
	}

}
