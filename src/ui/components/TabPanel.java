package ui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class TabPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private TabPane pane;

	private KTab current;
	
	private Class<?> tabs[];
	private KTab ktabs[];
	
	public TabPanel(TabStruct ts[], TabNavPanel nav) {
		setBounds(0, 100, 980, 600);
		tabs = new Class<?>[ts.length];
		setLayout(null);
		pane = new TabPane();
		
		add(pane);
		ktabs = new KTab[ts.length];
		
		int i = 0;
		for(TabStruct tab: ts){
			
			TabNavButton btn = new TabNavButton(tab.getTitle(), i, nav);
			tabs[i] = tab.getTab();
			int id = i;
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					loadTab(id);
					btn.clicked();
				}
				
			});
			nav.add(btn);
			if(i == 0) {
				btn.clicked();
			}
			i++;
		}
		
		loadTab(0);
		
		
	}
	
	
	public TabPanel(KFrame frame, KTab[] tabs, TabNavPanel nav) {
		setBounds(0, 100, 980, 600);
		setLayout(null);
		pane = new TabPane(this);
		frame.getContentPane().add(this);
		this.current = tabs[0];
		add(tabs[0]);
		
		int i = 0;
		for(KTab tab: tabs){
			TabNavButton btn = new TabNavButton(tab.getTitle(), i, nav);
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					add(tab);
					btn.clicked();
				}
				
			});
			nav.add(btn);
			if(i == 0) {
				btn.clicked();
			}
			i++;
		}
		
	}
	

	private void add(KTab tab) {
		if(current != null)
			pane.remove(current);
		pane.add(tab);
		current = tab;
		tab.setVisible(true);
	}
	
	public TabPane getPane() {
		return pane;
	}
	

	
	private boolean isAvailable(int id) {
		if(ktabs[id] != null)
			return true;
		return false;
	}
	
	public void loadTab(int id) {
		
		
		if(!isAvailable(id)) {
			
			new SwingWorker<Void, Void>() {

				private KProgressBar bar = KProgressBar.getInstance();
				
				
				@Override
				protected Void doInBackground() throws Exception {
					bar.setIndeterminate(true);
					bar.setVisible(true);
					
					
					ktabs[id] = (KTab)tabs[id].getConstructor().newInstance();
					add(ktabs[id]);
					
					
					return null;
				}

				@Override
				protected void done() {
					bar.setIndeterminate(false);
					bar.setVisible(false);
				}
				
			}.execute();
			
		}else {
		
			add(ktabs[id]);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
