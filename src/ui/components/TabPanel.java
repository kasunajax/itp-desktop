package ui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class TabPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private TabPane pane;

	private KTab current;
	
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
		pane.remove(current);
		pane.add(tab);
		current = tab;
		tab.setVisible(true);
	}
	
	public TabPane getPane() {
		return pane;
	}

}
