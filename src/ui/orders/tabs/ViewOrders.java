package ui.orders.tabs;

import java.awt.EventQueue;

import ui.components.KButton;
import ui.components.KTab;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.sql.DriverManager;

import javax.swing.border.LineBorder;

public class ViewOrders extends KTab {

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
					ViewOrders frame = new ViewOrders();
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
	public ViewOrders() {
		super("View Orders");
		
		KButton btnViewOrders = new KButton("VIEW ORDERS");
		btnViewOrders.setBounds(new Rectangle(188, 201, 102, 40));
		getContentPane().add(btnViewOrders);
		
		KButton btnHelloWorld = new KButton("Hello World ");
		btnHelloWorld.setBounds(329, 159, 89, 23);
		getContentPane().add(btnHelloWorld);
		

	}
}
