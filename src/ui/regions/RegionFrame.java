package ui.regions;

import java.awt.EventQueue;

import ui.components.KFrame;
import ui.components.KTab;
import ui.components.TabNavPanel;
import ui.components.TabPanel;
import ui.orders.tabs.PlaceOrder;
import ui.orders.tabs.ViewOrders;
import ui.regions.tabs.Tab1;
import ui.regions.tabs.Tab2;
import ui.regions.tabs.Tab3;

public class RegionFrame extends KFrame {

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
					RegionFrame frame = new RegionFrame();
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
	public RegionFrame() {
		KTab[] tabs = new KTab[3];
		tabs[0] = new Tab1();
		tabs[1] = new Tab2();
		tabs[2] = new Tab3();
		 

		new TabPanel(this, tabs, new TabNavPanel(this));
	}

}
