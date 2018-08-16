package ui.main;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import ui.employees.EmployeeFrame;
import ui.finance.FinanceFrame;
import ui.inventory.InventoryFrame;
import ui.orders.OrdersFrame;
import ui.packages.PackageFrame;
import ui.payroll.PayrollFrame;
import ui.regions.RegionFrame;
import ui.sales.SalesFrame;

public class DesktopPane extends JDesktopPane{

	private static final long serialVersionUID = 1L;
	
	private JInternalFrame[] frames;
	private JInternalFrame currentFrame;
	private static DesktopPane instance;
	
	private DesktopPane() {
		frames = new JInternalFrame[8];
		frames[0] = new OrdersFrame(); 
		frames[1] = new EmployeeFrame();
		frames[2] = new SalesFrame(); 
		frames[3] = new RegionFrame();
		frames[4] = new PayrollFrame(); 
		frames[5] = new FinanceFrame();
		frames[6] = new PackageFrame(); 
		frames[7] = new InventoryFrame();
		currentFrame = frames[0];
		add(currentFrame);
		
	}
	
	public static DesktopPane getInstance() {
		
		if(instance == null) {
			instance = new DesktopPane();
		}
		
		return instance;
	}
	
	public void add(int i) {
		remove(currentFrame);
		add(frames[i]);
		frames[i].setVisible(true);
		frames[i].setBounds(0, -50, 980, 700);
		currentFrame = frames[i];
		
	}

}
