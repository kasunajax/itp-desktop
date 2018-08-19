package ui.employees;

import java.awt.EventQueue;

import ui.components.KFrame;
import ui.components.KTab;
import ui.components.TabNavPanel;
import ui.components.TabPanel;
import ui.components.TabStruct;
import ui.employees.tabs.AddEmp;
import ui.employees.tabs.AddEmployeeFrame;
import ui.employees.tabs.ViewEmployees;
import ui.orders.tabs.PlaceOrder;
import ui.orders.tabs.ProcessOrders;
import ui.orders.tabs.ViewOrders;

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
				new TabStruct(AddEmployeeFrame.class, "ADD EMP"),
				new TabStruct(ViewEmployees.class, "VIEW EMPLOYEE"),
				new TabStruct(AddEmp.class, "ADD EMPLOYEE")
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
