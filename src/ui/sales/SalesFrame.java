package ui.sales;

import java.awt.EventQueue;

import ui.components.KFrame;
import ui.components.KTab;
import ui.components.TabNavPanel;
import ui.components.TabPanel;
import ui.employees.tabs.AddEmp;
import ui.employees.tabs.AddEmployeeFrame;
import ui.employees.tabs.ViewEmployees;
import ui.sales.tabs.ConfirmSales;
import ui.sales.tabs.ViewReports;


public class SalesFrame extends KFrame {

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
					SalesFrame frame = new SalesFrame();
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
	public SalesFrame() {
		KTab[] tabs = new KTab[2];
		tabs[0] = new ConfirmSales();
		tabs[1] = new ViewReports();
				
		new TabPanel(this, tabs, new TabNavPanel(this));
	}

}
