package ui.components;

import javax.swing.JProgressBar;

public class KProgressBar extends JProgressBar {

	private static final long serialVersionUID = 1L;
	
	private static KProgressBar instance;
	
	private KProgressBar() {}
	
	public static KProgressBar getInstance() {
		if(instance == null) {
			instance = new KProgressBar();
		}
		
		return instance;
	}

}
