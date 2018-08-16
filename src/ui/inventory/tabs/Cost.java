package ui.inventory.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;

public class Cost extends KTab {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cost frame = new Cost();
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
	public Cost() {
		super("Costs");
	}

}
