package ui.inventory.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Cost extends KTab {
	private JTextField textField;

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
		super("Cost Calculating");
		
		JLabel lblCostCalculationOf = new JLabel("Cost Calculation of Products");
		lblCostCalculationOf.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCostCalculationOf.setBounds(23, 35, 637, 33);
		getContentPane().add(lblCostCalculationOf);
		
		JLabel lblEnterItemId = new JLabel("Enter Item Id and the Month");
		lblEnterItemId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterItemId.setBounds(23, 93, 214, 26);
		getContentPane().add(lblEnterItemId);
		
		JLabel lblItemId = new JLabel("Item Name");
		lblItemId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblItemId.setBounds(23, 142, 86, 13);
		getContentPane().add(lblItemId);
		
		textField = new JTextField();
		textField.setBounds(119, 140, 118, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMonth.setBounds(23, 188, 58, 13);
		getContentPane().add(lblMonth);
		

		JPanel panel = new JPanel();
		panel.setBounds(23, 260, 947, 326);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(325, 118, 495, 67);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 36, 469, 26);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select a month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "Octomber", "November", "December"}));
		comboBox.setBounds(119, 185, 118, 21);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = textField.getText();
				String monthtxt = comboBox.getSelectedItem().toString();
				int month = 0;
				float cost = 0;
				float jan = 0,feb = 0,mar = 0,apr = 0,may = 0,jun = 0,jul = 0,aug = 0,sep = 0,oct,nov,dec;
				
				if(item == null||monthtxt == "Select a Month")
					JOptionPane.showMessageDialog(null, "One or more Required fields are empty!!");
				else {
					if(monthtxt == "January")
						month = 1;
					else if(monthtxt == "February")
						month = 2;
					else if(monthtxt == "March")
						month = 3;
					else if(monthtxt == "April")
						month = 4;
					else if(monthtxt == "May")
						month = 5;
					else if(monthtxt == "June")
						month = 6;
					else if(monthtxt == "July")
						month = 7;
					else if(monthtxt == "August")
						month = 8;
					else if(monthtxt == "September")
						month = 9;
					else if(monthtxt == "Octomber")
						month = 10;
					else if(monthtxt == "November")
						month = 11;
					else if(monthtxt == "December")
						month = 12;
					
					String sql = "select sum(cost) from items where Name = '"+item+"' and MONTH(Added_Date) = '"+month+"'";
					
					try {
						Statement st=(Statement) Database.getConnection().createStatement();
						ResultSet rs=st.executeQuery(sql);
						
						while(rs.next())
							cost = rs.getInt(1);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					lblNewLabel.setText("Total cost for the '"+item+"' in '"+monthtxt+"' is '"+cost+"'");
				}
				
				Date date = new Date();
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int Month = localDate.getMonthValue();
				
				for(int i = 1;i <= Month;++i) {
					String sql = "select sum(cost) from items where Name = '"+item+"' and MONTH(Added_Date) = '"+i+"'";
					
					try {
						Statement st=(Statement) Database.getConnection().createStatement();
						ResultSet rs=st.executeQuery(sql);
						
						while(rs.next()) {
							if(i == 1)
								jan = rs.getInt(1);
							else if(i == 2)
								feb = rs.getInt(1);
							else if(i == 3)
								mar = rs.getInt(1);
							else if(i == 4)
								apr = rs.getInt(1);
							else if(i == 5)
								may = rs.getInt(1);
							else if(i == 6)
								jun = rs.getInt(1);
							else if(i == 7)
								jul = rs.getInt(1);
							else if(i == 8)
								aug = rs.getInt(1);
							else if(i == 9)
								sep = rs.getInt(1);
							else if(i == 10)
								oct = rs.getInt(1);
							else if(i == 11)
								nov = rs.getInt(1);
							else if(i == 12)
								dec = rs.getInt(1);
							
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				if(Month == 1) {
					dataset.setValue(jan, "", "January");
				}
				else if(Month == 2) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
				}
				else if(Month == 3) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
				}
				else if(Month == 4) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
				}
				else if(Month == 5) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
					dataset.setValue(may, "", "May");
				}
				else if(Month == 6) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
					dataset.setValue(may, "", "May");
					dataset.setValue(jun, "", "June");
				}
				else if(Month == 7) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
					dataset.setValue(may, "", "May");
					dataset.setValue(jun, "", "June");
					dataset.setValue(jul, "", "July");
				}
				else if(Month == 8) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
					dataset.setValue(may, "", "May");
					dataset.setValue(jun, "", "June");
					dataset.setValue(jul, "", "July");
					dataset.setValue(aug, "", "August");
				}
				else if(Month == 9) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
					dataset.setValue(may, "", "May");
					dataset.setValue(jun, "", "June");
					dataset.setValue(jul, "", "July");
					dataset.setValue(aug, "", "August");
					dataset.setValue(sep, "", "September");
				}
				else if(Month == 10) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
					dataset.setValue(may, "", "May");
					dataset.setValue(jun, "", "June");
					dataset.setValue(jul, "", "July");
					dataset.setValue(aug, "", "August");
					dataset.setValue(sep, "", "September");
					dataset.setValue(sep, "", "Octomber");
				}
				
				JFreeChart chart = ChartFactory.createBarChart("Total Cost of '"+item+"' in Each Month", "", "", dataset,PlotOrientation.VERTICAL,false,false,false);
				CategoryPlot catplot = chart.getCategoryPlot();
				catplot.setRangeGridlinePaint(Color.BLACK);
				NumberAxis range = (NumberAxis)catplot.getRangeAxis();
				range.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
				
				ChartPanel chartPanel = new ChartPanel(chart);
				panel.removeAll();
				panel.add(chartPanel, BorderLayout.CENTER);
				panel.revalidate();
			}
		});
		btnNewButton.setBounds(119, 225, 118, 21);
		getContentPane().add(btnNewButton);
		
	}
}
