package ui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import ui.main.DesktopPane;
import ui.main.NavPanel;

public class NavButton extends JButton {

	private static final long serialVersionUID = 1L;

	public NavButton(String name, NavPanel nav, int id) {
		super(name);
		setForeground(Color.WHITE);
		setFont(new Font("Segoe UI", Font.PLAIN, 15));
		setFocusable(false);
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 153)));
		setBackground(new Color(0, 51, 153));
		nav.add(this);
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DesktopPane.getInstance().add(id);
				changeState();
			}
			
		});
	}
	
	
	private void changeState() {
		setBackground(new Color(0, 51, 102));
		Rectangle r = this.getBounds();
		r.width = 300;
		r.x = 0;
		setBounds(r);
	}
	
}
