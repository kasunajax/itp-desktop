package ui.main;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Cursor;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	
	public MainFrame() {
		setUndecorated(true);
		setBounds(0, 0, 1280, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		NavPanel navPanel = new NavPanel();
		getContentPane().add(navPanel);
		
		MainPanel mainPanel = new MainPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		getContentPane().add(mainPanel);
		
		JButton btnClosex = new JButton("");
		btnClosex.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClosex.setBorder(null);
		btnClosex.setFocusable(false);
		btnClosex.setBackground(new Color(255, 255, 255));
		btnClosex.setBorderPainted(false);
		btnClosex.setIcon(new ImageIcon(MainFrame.class.getResource("/main/close_btn_coloured.png")));
		btnClosex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClosex.setBounds(948, 0, 32, 32);
		mainPanel.add(btnClosex);
		
		JButton button = new JButton("");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		button.setIcon(new ImageIcon(MainFrame.class.getResource("/main/mini_btn_coloured.png")));
		button.setFocusable(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(Color.WHITE);
		button.setBounds(916, 0, 32, 32);
		mainPanel.add(button);
		
		JLabel lblDistributionManagementSystem = new JLabel("DISTRIBUTION MANAGEMENT SYSTEM OF CELL WORLD (PVT) LTD");
		lblDistributionManagementSystem.setForeground(new Color(102, 153, 255));
		lblDistributionManagementSystem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDistributionManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistributionManagementSystem.setBounds(0, 0, 916, 32);
		mainPanel.add(lblDistributionManagementSystem);


	}
}
