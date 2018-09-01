package ui.sales;

import java.awt.EventQueue;

import ui.components.KFrame;
import ui.components.KTab;
import ui.components.TabNavPanel;
import ui.components.TabPanel;
//<<<<<<< HEAD
//=======
import ui.components.TabStruct;
//<<<<<<< HEAD
import ui.employees.tabs.AddEmp;
import ui.employees.tabs.AddEmployeeFrame;
import ui.employees.tabs.ViewEmployees;
//=======
import ui.regions.tabs.Tab1;
import ui.regions.tabs.Tab2;
import ui.regions.tabs.Tab3;
//>>>>>>> branch 'master' of https://github.com/kasunajax/itp-desktop.git
//>>>>>>> branch 'master' of https://github.com/kasunajax/itp-desktop.git
import ui.sales.tabs.ConfirmSales;
import ui.sales.tabs.ConfirmedSales;
import ui.sales.tabs.PendingSales;
import ui.sales.tabs.UnconfirmedSales;



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
/*<<<<<<< HEAD
		KTab[] tabs = new KTab[4];
		tabs[0] = new ConfirmSales();
		tabs[1] = new ConfirmedSales();
		tabs[2] = new UnconfirmedSales();
		tabs[3] = new PendingSales();
				
		new TabPanel(this, tabs, new TabNavPanel(this));
=======*/
		
		TabStruct[] ts = {
				new TabStruct(ConfirmSales.class, "CONFIRM SALES"),
				new TabStruct(ConfirmedSales.class, "CONFIRMED SALES"),
				new TabStruct(PendingSales.class, "PENDING SALES"),
				new TabStruct(UnconfirmedSales.class, "UNCONFIRMED SALES")
		};
		
		setStruct(ts);
		
//		KTab[] tabs = new KTab[2];
//		tabs[0] = new ConfirmSales();
//		tabs[1] = new ViewReports();
//				
//		new TabPanel(this, tabs, new TabNavPanel(this));
//>>>>>>> branch 'master' of https://github.com/kasunajax/itp-desktop.git
	}

}
