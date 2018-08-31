package ui.finance.tabs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;


import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import com.toedter.calendar.JDateChooser;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Font;

public class GraphicalViews extends KTab {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicalViews frame = new GraphicalViews();
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
	public GraphicalViews() {
		
		JComboBox t1 = new JComboBox();
		t1.setModel(new DefaultComboBoxModel(new String[] {"Select the Type", "", "Administration", "Financial", "Sales and Distribution", "Others"}));
		t1.setBounds(181, 116, 139, 22);
		getContentPane().add(t1);
		
		JPanel panel = new JPanel();
		panel.setBounds(128, 188, 740, 387);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Give the Type ");
		lblNewLabel.setBounds(55, 120, 96, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View Graph");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String typ = t1.getSelectedItem().toString();
				
				int month1 = 0;
			
				float jan = 0,feb = 0,mar = 0,apr = 0,may = 0,jun = 0,jul = 0,aug = 0,sep = 0,oct=0,nov=0,dec=0;
				
				if(typ == "Select the Type") {
					JOptionPane.showMessageDialog(null,"Please Select a valid Type");
				}
				
				
				Date date = new Date();
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int Month2 = localDate.getMonthValue();
				
				
				for(int x=1;x<=Month2;++x) {
					String query = "Select sum(NetExpense) from expenses where Type='"+typ+"' and Month(Date) ='"+x+"'";
					
					try {
						
						Statement st=(Statement) Database.getConnection().createStatement();
						ResultSet rs=st.executeQuery(query);
						
						while(rs.next()) {
							if(x == 1)
								jan = rs.getInt(1);
							else if(x == 2)
								feb = rs.getInt(1);
							else if(x == 3)
								mar = rs.getInt(1);
							else if(x == 4)
								apr = rs.getInt(1);
							else if(x == 5)
								may = rs.getInt(1);
							else if(x == 6)
								jun = rs.getInt(1);
							else if(x == 7)
								jul = rs.getInt(1);
							else if(x == 8)
								aug = rs.getInt(1);
							else if(x == 9)
								sep = rs.getInt(1);
							else if(x == 10)
								oct = rs.getInt(1);
							else if(x == 11)
								nov = rs.getInt(1);
							else if(x == 12)
								dec = rs.getInt(1);
						}
						
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
				
				
				DefaultPieDataset pieDataset = new DefaultPieDataset();
				
				
				
				if(Month2 == 1) {
					pieDataset.setValue("January",jan);
				}
				else if(Month2 == 2) {
					pieDataset.setValue("January",jan);
					pieDataset.setValue("February",feb);
				}
				else if(Month2 == 3) {
					pieDataset.setValue("January",jan);
					pieDataset.setValue("February",feb);
					pieDataset.setValue("March",mar);
				}
				else if(Month2 == 4) {
					pieDataset.setValue("January",jan);
					pieDataset.setValue("February",feb);
					pieDataset.setValue("March",mar);
					pieDataset.setValue("April",apr);
				}
				else if(Month2 == 5) {
					pieDataset.setValue("January",jan);
					pieDataset.setValue("February",feb);
					pieDataset.setValue("March",mar);
					pieDataset.setValue("April",apr);
					pieDataset.setValue("May",may);
				}
				else if(Month2 == 6) {
					pieDataset.setValue("January",jan);
					pieDataset.setValue("February",feb);
					pieDataset.setValue("March",mar);
					pieDataset.setValue("April",apr);
					pieDataset.setValue("May",may);
					pieDataset.setValue("June",jun);
				}
				else if(Month2 == 7) {
					pieDataset.setValue("January",jan);
					pieDataset.setValue("February",feb);
					pieDataset.setValue("March",mar);
					pieDataset.setValue("April",apr);
					pieDataset.setValue("May",may);
					pieDataset.setValue("June",jun);
					pieDataset.setValue("July",jul);
				}
				else if(Month2 == 8) {
					pieDataset.setValue("January",jan);
					pieDataset.setValue("February",feb);
					pieDataset.setValue("March",mar);
					pieDataset.setValue("April",apr);
					pieDataset.setValue("May",may);
					pieDataset.setValue("June",jun);
					pieDataset.setValue("July",jul);
					pieDataset.setValue("August",aug);
				}
				else if(Month2 == 9) {
					pieDataset.setValue("January",jan);
					pieDataset.setValue("February",feb);
					pieDataset.setValue("March",mar);
					pieDataset.setValue("April",apr);
					pieDataset.setValue("May",may);
					pieDataset.setValue("June",jun);
					pieDataset.setValue("July",jul);
					pieDataset.setValue("August",aug);
					pieDataset.setValue("September",sep);
				
				}else if(Month2 == 10) {
					pieDataset.setValue("January",jan);
					pieDataset.setValue("February",feb);
					pieDataset.setValue("March",mar);
					pieDataset.setValue("April",apr);
					pieDataset.setValue("May",may);
					pieDataset.setValue("June",jun);
					pieDataset.setValue("July",jul);
					pieDataset.setValue("August",aug);
					pieDataset.setValue("September",sep);
					pieDataset.setValue("October",oct);
				
				}else if(Month2 == 11) {
					pieDataset.setValue("January",jan);
					pieDataset.setValue("February",feb);
					pieDataset.setValue("March",mar);
					pieDataset.setValue("April",apr);
					pieDataset.setValue("May",may);
					pieDataset.setValue("June",jun);
					pieDataset.setValue("July",jul);
					pieDataset.setValue("August",aug);
					pieDataset.setValue("September",sep);
					pieDataset.setValue("October",oct);
					pieDataset.setValue("November",nov);
				
				}else if(Month2 == 12) {
					pieDataset.setValue("January",jan);
					pieDataset.setValue("February",feb);
					pieDataset.setValue("March",mar);
					pieDataset.setValue("April",apr);
					pieDataset.setValue("May",may);
					pieDataset.setValue("June",jun);
					pieDataset.setValue("July",jul);
					pieDataset.setValue("August",aug);
					pieDataset.setValue("September",sep);
					pieDataset.setValue("October",oct);
					pieDataset.setValue("November",nov);
					pieDataset.setValue("December",dec);
				
				}
				JFreeChart chart = ChartFactory.createPieChart3D("Total Net Expense of "+typ+" for Each month",pieDataset,true,true,true);
				PiePlot3D plot = (PiePlot3D) chart.getPlot();
		        plot.setStartAngle(290);
		        plot.setDirection(Rotation.CLOCKWISE);
		        plot.setForegroundAlpha(0.5f);
				
				
				
				ChartPanel chartPanel = new ChartPanel(chart);
				panel.removeAll();
				panel.add(chartPanel, BorderLayout.CENTER);
				panel.revalidate();
				
				
				
			}
		});
		btnNewButton.setBounds(380, 115, 133, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Monthly Costs for the Selected Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(220, 22, 306, 34);
		getContentPane().add(lblNewLabel_1);
		
		
		

		
		
	}
}
