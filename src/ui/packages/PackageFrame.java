package ui.packages;

import java.awt.EventQueue;

import ui.components.KFrame;
import ui.components.TabStruct;
import ui.finance.tabs.CreateExpenses;
import ui.finance.tabs.UpdateExpenses;
import ui.packages.tabs.CustomerFeedBack;
import ui.packages.tabs.ManagePackages;
import ui.packages.tabs.ManagePromotions;
import ui.packages.tabs.Packages;
import ui.packages.tabs.Promotions;

public class PackageFrame extends KFrame {

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
					PackageFrame frame = new PackageFrame();
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
	public PackageFrame() {
		
		
		TabStruct[] ts = {
				new TabStruct(Packages.class, "PACKAGES"),
				new TabStruct(ManagePackages.class,"MANAGE PACKAGES"),
				new TabStruct(Promotions.class,"PROMOTIONS"),
				new TabStruct(ManagePromotions.class,"MANAGE PROMOTION")
		};
		
		setStruct(ts);

	}

}
