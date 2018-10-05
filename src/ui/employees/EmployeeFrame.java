package ui.employees;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import ui.components.KFrame;
import ui.components.KTab;
import ui.components.TabNavPanel;
import ui.components.TabPanel;
import ui.components.TabStruct;
import ui.employees.tabs.Attendance;
import ui.employees.tabs.DealerInfo;
import ui.employees.tabs.StaffDetails;
import ui.orders.tabs.PlaceOrder;
import ui.orders.tabs.ProcessOrders;
import ui.orders.tabs.ViewOrders;
import utils.common.database.Database;
 
public class EmployeeFrame extends KFrame {

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
					EmployeeFrame frame = new EmployeeFrame();
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
	public EmployeeFrame() {
		
		TabStruct[] ts = {
				new TabStruct(StaffDetails.class, "STAFF DETAILS"),
				new TabStruct(DealerInfo.class, "DEALER DETAILS"),
				new TabStruct(Attendance.class, "ATTENDANCE"),
				
		};
		
		setStruct(ts);
		
//		KTab[] tabs = new KTab[3];
//		tabs[0] = new AddEmployeeFrame();
//		tabs[1] = new ViewEmployees();
//		tabs[2] = new AddEmp(); 
		
//
//		new TabPanel(this, tabs, new TabNavPanel(this));

	}
}
