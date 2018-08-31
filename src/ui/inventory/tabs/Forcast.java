package ui.inventory.tabs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import ui.components.KTab;
import utils.common.database.Database;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class Forcast extends KTab {
	
	private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTable table_1;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forcast frame = new Forcast();
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
	public Forcast() {
		super("Forcasting");
		
		
		JLabel lblForcastingOfFuture = new JLabel("Forcasting of Future Demand for Products");
		lblForcastingOfFuture.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblForcastingOfFuture.setBounds(10, 26, 544, 34);
		getContentPane().add(lblForcastingOfFuture);
		
		JLabel lblGetForcastOn = new JLabel("Get Forcast on Branch basis");
		lblGetForcastOn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGetForcastOn.setBounds(10, 61, 306, 34);
		getContentPane().add(lblGetForcastOn);
		
		JLabel lblEnterBranchCode = new JLabel("Enter Office Id:");
		lblEnterBranchCode.setBounds(10, 105, 140, 23);
		getContentPane().add(lblEnterBranchCode);
		
		JLabel lblEnterItemId = new JLabel("Enter Item Name:");
		lblEnterItemId.setBounds(10, 138, 140, 23);
		getContentPane().add(lblEnterItemId);
		
		textField_7 = new JTextField();
		textField_7.setBounds(169, 105, 116, 22);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(169, 139, 116, 22);
		getContentPane().add(textField_8);
		
		JLabel lblGetForcastOn_1 = new JLabel("Get Forcast on Executive basis");
		lblGetForcastOn_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGetForcastOn_1.setBounds(552, 61, 306, 34);
		getContentPane().add(lblGetForcastOn_1);
		
		JLabel lblEnterExecutiveCode = new JLabel("Enter Executive Id:");
		lblEnterExecutiveCode.setBounds(552, 105, 140, 23);
		getContentPane().add(lblEnterExecutiveCode);
		
		JLabel lblEnterItemName = new JLabel("Enter Item Name:");
		lblEnterItemName.setBounds(552, 138, 140, 23);
		getContentPane().add(lblEnterItemName);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(710, 106, 116, 22);
		getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(710, 139, 116, 22);
		getContentPane().add(textField_10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 217, 960, 341);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 558, 905, 34);
		getContentPane().add(lblNewLabel);
		
		JButton btnGetForcast = new JButton("Get Forcast");
		btnGetForcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int month = localDate.getMonthValue();
				 //JOptionPane.showMessageDialog(null, month);
				
				float count = 0;
				String br = textField_7.getText();
				String item = textField_8.getText();
				int jan = 0,feb = 0,mar = 0,apr = 0,may = 0,jun = 0,jul = 0,aug = 0,sep = 0,oct,nov,dec;
				
				
				for(int i = 1;i<= month;++i) {
					String sql = "select count(*) from items,sales_executives,office where items.Executive = sales_executives.EmployeeID and sales_executives.OfficeID = office.OfficeID and office.OfficeID = '"+br+"' and items.Name = '"+item+"' and MONTH(items.Sold_Date) = '"+i+"'";
					
					try {
						Statement st=(Statement) Database.getConnection().createStatement();
						ResultSet rs=st.executeQuery(sql);
						while(rs.next()) {
							count = count +  rs.getInt(1);
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
				
				//JOptionPane.showMessageDialog(null, count);
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				if(month == 1) {
					dataset.setValue(jan, "", "January");
				}
				else if(month == 2) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
				}
				else if(month == 3) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
				}
				else if(month == 4) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
				}
				else if(month == 5) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
					dataset.setValue(may, "", "May");
				}
				else if(month == 6) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
					dataset.setValue(may, "", "May");
					dataset.setValue(jun, "", "June");
				}
				else if(month == 7) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
					dataset.setValue(may, "", "May");
					dataset.setValue(jun, "", "June");
					dataset.setValue(jul, "", "July");
				}
				else if(month == 8) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
					dataset.setValue(may, "", "May");
					dataset.setValue(jun, "", "June");
					dataset.setValue(jul, "", "July");
					dataset.setValue(aug, "", "August");
				}
				else if(month == 9) {
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
				
				JFreeChart chart = ChartFactory.createBarChart("Demand for '"+item+"' in each Month in Reigon '"+br+"'", "", "", dataset,PlotOrientation.VERTICAL,false,false,false);
				CategoryPlot catplot = chart.getCategoryPlot();
				catplot.setRangeGridlinePaint(Color.BLACK);
				NumberAxis range = (NumberAxis)catplot.getRangeAxis();
				range.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
				
				ChartPanel chartPanel = new ChartPanel(chart);
				panel.removeAll();
				panel.add(chartPanel, BorderLayout.CENTER);
				panel.revalidate();
				
				float avg;
				avg = count / month;
				int avg2 = Math.round(avg);
				String round = String.valueOf(avg2);
				lblNewLabel.setText("For the Next Month approximately '"+round+"' '"+item+"' items will be needed.");
			}
		});
		btnGetForcast.setBounds(169, 171, 116, 25);
		getContentPane().add(btnGetForcast);
		
		JButton button_3 = new JButton("Get Forcast");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int month = localDate.getMonthValue();
				 //JOptionPane.showMessageDialog(null, month);
				
				float count = 0;
				String ex = textField_9.getText();
				String item = textField_10.getText();
				int jan = 0,feb = 0,mar = 0,apr = 0,may = 0,jun = 0,jul = 0,aug = 0,sep = 0,oct,nov,dec;
				
				
				for(int i = 1;i<= month;++i) {
					String sql = "select count(*) from items where items.Executive = '"+ex+"' and items.Name = '"+item+"' and MONTH(items.Sold_Date) = '"+i+"'";
					
					try {
						Statement st=(Statement) Database.getConnection().createStatement();
						ResultSet rs=st.executeQuery(sql);
						while(rs.next()) {
							count = count +  rs.getInt(1);
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
				
				//JOptionPane.showMessageDialog(null, count);
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				if(month == 1) {
					dataset.setValue(jan, "", "January");
				}
				else if(month == 2) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
				}
				else if(month == 3) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
				}
				else if(month == 4) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
				}
				else if(month == 5) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
					dataset.setValue(may, "", "May");
				}
				else if(month == 6) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
					dataset.setValue(may, "", "May");
					dataset.setValue(jun, "", "June");
				}
				else if(month == 7) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
					dataset.setValue(may, "", "May");
					dataset.setValue(jun, "", "June");
					dataset.setValue(jul, "", "July");
				}
				else if(month == 8) {
					dataset.setValue(jan, "", "January");
					dataset.setValue(feb, "", "February");
					dataset.setValue(mar, "", "March");
					dataset.setValue(apr, "", "April");
					dataset.setValue(may, "", "May");
					dataset.setValue(jun, "", "June");
					dataset.setValue(jul, "", "July");
					dataset.setValue(aug, "", "August");
				}
				else if(month == 9) {
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
				
				JFreeChart chart = ChartFactory.createBarChart("Number of '"+item+"' items released to Executive '"+ex+"' in each Month", "", "", dataset,PlotOrientation.VERTICAL,false,false,false);
				CategoryPlot catplot = chart.getCategoryPlot();
				catplot.setRangeGridlinePaint(Color.BLACK);
				NumberAxis range = (NumberAxis)catplot.getRangeAxis();
				range.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
				
				ChartPanel chartPanel = new ChartPanel(chart);
				panel.removeAll();
				panel.add(chartPanel, BorderLayout.CENTER);
				panel.revalidate();
				
				float avg;
				avg = count / month;
				int avg2 = Math.round(avg);
				String round = String.valueOf(avg2);
				lblNewLabel.setText("For the Next Month approximately '"+round+"' '"+item+"' items should be released to '"+ex+"' .");
			}
		});
		button_3.setBounds(710, 171, 116, 25);
		getContentPane().add(button_3);
		
	}
}
