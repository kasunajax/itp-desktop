package ui.payroll;

import java.awt.EventQueue;

import ui.components.KFrame;
import ui.components.KTab;
import ui.components.TabNavPanel;
import ui.components.TabPanel;
import ui.payroll.tabs.MonthlyPayroll;
import ui.payroll.tabs.NewEmployeeSalary;
import ui.payroll.tabs.PayrollReports;
import ui.payroll.tabs.UpdateRemoveSalary;
import ui.payroll.tabs.ViewPayslip;

public class PayrollFrame extends KFrame {

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
					PayrollFrame frame = new PayrollFrame();
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
	public PayrollFrame() {
		
		KTab[] tabs = new KTab[5]; //increase the number depending on the number of tabs
		
		tabs[0] = new NewEmployeeSalary(); 
		tabs[1] = new UpdateRemoveSalary();
		tabs[2] = new MonthlyPayroll();
		tabs[3] = new ViewPayslip();
		tabs[4] = new PayrollReports();
		
		new TabPanel(this, tabs, new TabNavPanel(this));


	}

}
