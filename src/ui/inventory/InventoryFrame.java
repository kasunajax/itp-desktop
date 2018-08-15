package ui.inventory;

import java.awt.EventQueue;

import ui.components.KFrame;
import ui.components.KTab;
import ui.components.TabNavPanel;
import ui.components.TabPanel;
import ui.inventory.tabs.InventoryMain;
import ui.regions.tabs.Tab1;
import ui.regions.tabs.Tab2;
import ui.regions.tabs.Tab3;

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
		KTab[] tabs = new KTab[1];
		tabs[0] = new InventoryMain();
		 

		new TabPanel(this, tabs, new TabNavPanel(this));
	}

}
