package ui.regions.tabs;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

import ui.components.KTab;

public class Tab3 extends KTab {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tab3 frame = new Tab3();
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
	public Tab3() {
		super("Tab 3");
		
		JButton btnAdminManagement = new JButton("Admin Management");
		btnAdminManagement.setBounds(217, 120, 300, 50);
		getContentPane().add(btnAdminManagement);
		
		JButton btnBranchDetailes = new JButton("Branch Detailes ");
		btnBranchDetailes.setBounds(217, 221, 300, 50);
		getContentPane().add(btnBranchDetailes);
		
		JButton btnSalesReport = new JButton("Sales Report");
		btnSalesReport.setBounds(217, 328, 300, 50);
		getContentPane().add(btnSalesReport);
		
		JButton btnInventoryReport = new JButton("Inventory Report");
		btnInventoryReport.setBounds(217, 437, 300, 50);
		getContentPane().add(btnInventoryReport);
	}

}
