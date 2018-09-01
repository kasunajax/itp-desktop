package ui.orders.tabs;

import java.awt.EventQueue;

import ui.components.KButton;
import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormatSymbols;

import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JProgressBar;

public class ViewOrders extends KTab {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JDateChooser startDate, endDate;
	private JFreeChart ch;
	private DefaultCategoryDataset ds;
	private ChartPanel pch;
	private JButton btnGenerateGraph, btnSave;
	private JProgressBar progressBar;
	
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
		super("VIEW ORDERS");
		
		
		
		
		
		ds = new DefaultCategoryDataset();
		

		
//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		dataset.addValue(10, "Pending", "January");
//		dataset.addValue(13, "Completed", "January");
//		dataset.addValue(22, "Rejected", "January");
//		
//		dataset.addValue(9, "Pending", "February");
//		dataset.addValue(22, "Completed", "February");
//		dataset.addValue(2, "Rejected", "February");
//
//		dataset.addValue(15, "Pending", "March");
//		dataset.addValue(29, "Completed", "March");
//		dataset.addValue(7, "Rejected", "March");
//		
		ch = ChartFactory.createBarChart("Order Statistics", "Categories", "Values", ds, PlotOrientation.VERTICAL, true, true, false);
//		
		pch = new ChartPanel(ch);
		pch.setBounds(64, 131, 852, 405);
		pch.setPreferredSize(new Dimension(540, 300));
		pch.setVisible(true);
		
		//setContentPane(pch);
		pch.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(715, 11, 178, 273);
		setContentPane(panel);
		panel.setLayout(null);
		
		panel.add(pch);
		
		btnSave = new JButton("Save");
		btnSave.setEnabled(false);
		btnSave.setBounds(827, 60, 89, 23);
		panel.add(btnSave);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(64, 60, 200, 20);
		panel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblStartDate = new JLabel("Start Date: ");
		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblStartDate.gridx = 0;
		gbc_lblStartDate.gridy = 0;
		panel_1.add(lblStartDate, gbc_lblStartDate);
		
		
		startDate = new JDateChooser();
		GridBagConstraints gbc_startDate = new GridBagConstraints();
		gbc_startDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_startDate.gridx = 1;
		gbc_startDate.gridy = 0;
		panel_1.add(startDate, gbc_startDate);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(278, 60, 200, 20);
		panel.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblEndDate = new JLabel("End Date: ");
		GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
		gbc_lblEndDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblEndDate.gridx = 0;
		gbc_lblEndDate.gridy = 0;
		panel_2.add(lblEndDate, gbc_lblEndDate);
		
		endDate = new JDateChooser();
		GridBagConstraints gbc_endDate = new GridBagConstraints();
		gbc_endDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_endDate.gridx = 1;
		gbc_endDate.gridy = 0;
		panel_2.add(endDate, gbc_endDate);
		
		btnGenerateGraph = new JButton("Generate Graph");
		btnGenerateGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				generate();
				
			}
		});
		btnGenerateGraph.setBounds(687, 60, 130, 23);
		panel.add(btnGenerateGraph);
		
		progressBar = new JProgressBar();
		progressBar.setVisible(false);
		progressBar.setIndeterminate(true);
		progressBar.setBounds(513, 63, 146, 14);
		panel.add(progressBar);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser sv = new JFileChooser();
				int rval = sv.showSaveDialog(ViewOrders.this);
				
				if(rval == JFileChooser.APPROVE_OPTION) {

					File file = sv.getSelectedFile();
					try {
						ChartUtilities.saveChartAsJPEG( file , ch , 640 , 480 );
					} catch (IOException e1) {}
					
				}
				
				if(rval == JFileChooser.CANCEL_OPTION) {
					
				}
				
				
			}
		});
		
		//pch.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0)));
		
	}
	
	public void generate() {
		
		new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				
				btnGenerateGraph.setEnabled(false);
				progressBar.setVisible(true);
				btnSave.setEnabled(false);
				
				Date sDate = new Date(startDate.getDate().getTime());
				Date eDate = new Date(endDate.getDate().getTime());
				
				String sqlI = "SELECT Month, Status, COUNT(*) AS Amount FROM (SELECT OrderID, Status, Month(PlacedDate) as Month  FROM `orders` WHERE `PlacedDate` BETWEEN '2017-01-01' AND '2018-08-01' AND Status = 'INITIAL') AS C GROUP BY Month";
				String sqlP = "SELECT Month, Status, COUNT(*) AS Amount FROM (SELECT OrderID, Status, Month(PlacedDate) as Month  FROM `orders` WHERE `PlacedDate` BETWEEN '2017-01-01' AND '2018-08-01' AND Status = 'PENDING') AS C GROUP BY Month";
				String sqlC = "SELECT Month, Status, COUNT(*) AS Amount FROM (SELECT OrderID, Status, Month(PlacedDate) as Month  FROM `orders` WHERE `PlacedDate` BETWEEN '2017-01-01' AND '2018-08-01' AND Status = 'COMPLETED') AS C GROUP BY Month";
				
				PreparedStatement stmtI = Database.get(sqlI);
				PreparedStatement stmtP = Database.get(sqlP);
				PreparedStatement stmtC = Database.get(sqlC);
				
				try {
					ResultSet rsI = stmtI.executeQuery();
					ResultSet rsP = stmtP.executeQuery();
					ResultSet rsC = stmtC.executeQuery();
					
			
					while(rsI.next()) {
						
						int monthInt = rsI.getInt("Month");
						int amount = rsI.getInt("Amount");
						String status = rsI.getString("Status");
						
						String month = new DateFormatSymbols().getMonths()[monthInt-1];
						ds.addValue(amount, status, month);
						
					}
					
					while(rsP.next()) {
						
						int monthInt = rsP.getInt("Month");
						int amount = rsP.getInt("Amount");
						String status = rsP.getString("Status");
						
						String month = new DateFormatSymbols().getMonths()[monthInt-1];
						ds.addValue(amount, status, month);
						
					}
		
					while(rsC.next()) {
						
						int monthInt = rsC.getInt("Month");
						int amount = rsC.getInt("Amount");
						String status = rsC.getString("Status");
						
						String month = new DateFormatSymbols().getMonths()[monthInt-1];
						ds.addValue(amount, status, month);
						
					}
					
					ch = ChartFactory.createBarChart("Order Statistics", "Categories", "Values", ds, PlotOrientation.VERTICAL, true, true, false);
					pch.setChart(ch);
					
				} catch (SQLException e2) {}
				
				
				return null;
			}
			
			@Override
			protected void done() {
				btnGenerateGraph.setEnabled(true);
				progressBar.setVisible(false);
				btnSave.setEnabled(true);
			}
			
			
		}.execute();
		
	}
}
