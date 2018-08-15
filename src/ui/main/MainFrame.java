package ui.main;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		getContentPane().add(mainPanel);
		
		JButton btnClosex = new JButton("Close (X)");
		btnClosex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClosex.setBounds(820, 44, 89, 23);
		mainPanel.add(btnClosex);


	}
}
