package ui.components;

import java.awt.Color;

import javax.swing.JInternalFrame;

public class KFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	protected Class<?>[] tabNames;
	protected String[] tabTitles;
	protected TabNavPanel navbar;

	public KFrame() {
		setBorder(null);
		setBounds(0, 0, 980, 650);
		getContentPane().setLayout(null);
		setBackground(new Color(255, 255, 255));
	}
	
	public void setStruct(TabStruct[] ts) {
		
		navbar = new TabNavPanel();
		getContentPane().add(navbar);
		getContentPane().add(new TabPanel(ts, navbar));
	}
	
	public KFrame(int count) {
		setBorder(null);
		setBounds(0, 0, 980, 650);
		getContentPane().setLayout(null);
		setBackground(new Color(255, 255, 255));
		tabNames = new Class<?>[count];
	}
	
	public void addKtab(int index, Class<?> cls, String title) {
		tabNames[index] = cls;
	}
	
	public Class<?>[] getTabNames(){
		return tabNames;
	}

}
