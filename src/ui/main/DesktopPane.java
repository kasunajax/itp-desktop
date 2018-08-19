package ui.main;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.SwingWorker;

import ui.components.KProgressBar;
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
		
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				frames[0] = new OrdersFrame(); 
//				
//			}}).start();
//		
////		frames[0] = new OrdersFrame(); 
//		frames[1] = new EmployeeFrame();
//		frames[2] = new SalesFrame(); 
//		frames[3] = new RegionFrame();
//		frames[4] = new PayrollFrame(); 
//		frames[5] = new FinanceFrame();
//		frames[6] = new PackageFrame(); 
//		frames[7] = new InventoryFrame();
//		currentFrame = frames[0];
//		add(currentFrame);

		
	}
	
	public static DesktopPane getInstance() {
		
		if(instance == null) {
			instance = new DesktopPane();
		}
		
		return instance;
	}
	
	public Class<?> getFrame(int id){
		
		Class<?> context = null;
		
		try {
		switch(id) {
			case 0: return Class.forName("ui.orders.OrdersFrame");
			case 1: return Class.forName("ui.employees.EmployeeFrame");
			case 2: return Class.forName("ui.sales.SalesFrame");
			case 3: return Class.forName("ui.regions.RegionFrame");
			case 4: return Class.forName("ui.payroll.PayrollFrame");
			case 5: return Class.forName("ui.finance.FinanceFrame");
			case 6: return Class.forName("ui.packages.PackageFrame");
			case 7: return Class.forName("ui.inventory.InventoryFrame");
		}
		
		}catch(ClassNotFoundException e) {}
		
		return context;
		
		
	}
	
	public boolean isAvailable(int id) {
		if(frames[id] != null)
			return false;
		return true;
	}
	
	
	public void init(int id){
		

		if(isAvailable(id)) {

		new SwingWorker<Integer, Integer>() {

			
			
			
			
			KProgressBar p = KProgressBar.getInstance();
			
			@Override
			protected Integer doInBackground() throws Exception {
				p.setIndeterminate(true);
				p.setVisible(true);
				//publish(0);
				//frames[id] = new OrdersFrame();


				Class<?> context = getFrame(id);

				if(context != null) {
					frames[id] = (JInternalFrame) context.getConstructor().newInstance();
				}
				//publish(90);
//				frames[id].setBounds(0, -50, 980, 700);
//				currentFrame = frames[id];
//				frames[id].setVisible(true);
//				add(frames[id]);
				//publish(100);

				
				return null;
			}

			@Override
			protected void process(List<Integer> chunks) {
				//p.setValue(chunks.get(chunks.size()-1));

			}

			@Override
			protected void done() {
				add(id);
				//p.setIndeterminate(false);
				//p.setVisible(false);
			}
			
			
			
		}.execute();
		

		}else {
			
			add(id);
			
		}

		
		

	}
	
	public void add(int i) {
		if(currentFrame != null)
			remove(currentFrame);
		add(frames[i]);
		frames[i].setVisible(true);
		frames[i].setBounds(0, -50, 980, 700);
		currentFrame = frames[i];
		
	}

}
