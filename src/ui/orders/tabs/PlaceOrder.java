package ui.orders.tabs;

import java.awt.EventQueue;

import ui.components.KTab;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class PlaceOrder extends KTab {

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
					PlaceOrder frame = new PlaceOrder();
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
	public PlaceOrder() {
		super("PLACE ORDER");
		
		JLabel lbl = new JLabel("New label");
		lbl.setBounds(387, 59, 172, 28);
		getContentPane().add(lbl);
		
		JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
		timeSpinner.setLocation(182, 52);
		timeSpinner.setSize(100, 28);
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date());
		getContentPane().add(timeSpinner);
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setBackground(new Color(0, 51, 102));
		btnPlaceOrder.setBounds(251, 282, 195, 64);
		getContentPane().add(btnPlaceOrder);
		
		JButton btnTab = new JButton("Tab");
		btnTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date t = (Date)timeSpinner.getValue();

				java.text.SimpleDateFormat sdf = 
					     new java.text.SimpleDateFormat("HH:mm:ss");

				String currentTime = sdf.format(t);
				
				lbl.setText(currentTime);
				
				
			}
		});
		btnTab.setFocusable(false);
		btnTab.setForeground(new Color(255, 255, 255));
		btnTab.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnTab.setBorder(null);
		btnTab.setBackground(new Color(102, 153, 255));
		btnTab.setBounds(192, 127, 160, 40);
		getContentPane().add(btnTab);
		
		
		
	

	}

}
