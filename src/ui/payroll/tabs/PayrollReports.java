package ui.payroll.tabs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PayrollReports extends KTab {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayrollReports frame = new PayrollReports();
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
	public PayrollReports() {
		super("Payroll Reports");
		
		JPanel panel = new JPanel();
		panel.setName("Payroll Report");
		panel.setForeground(SystemColor.menu);
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Payroll Report", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(67, 121, 741, 424);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Show chart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String sql = "select e.EmployeeID, p.Basic_Sal from employees e, payroll p where e.EmployeeID = p.EmpID";
					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					
					
					//DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					
					//dataset.setValue(value, "", columnKey);
				}catch (SQLException e) {
					e.printStackTrace();
				}
				
				/* JFreeChart chart = ChartFactory.createBarChart("Total Cost of '"+item+"' in Each Month", "", "", dataset,PlotOrientation.VERTICAL,false,false,false);
				CategoryPlot catplot = chart.getCategoryPlot();
				catplot.setRangeGridlinePaint(Color.BLACK);
				NumberAxis range = (NumberAxis)catplot.getRangeAxis();
				range.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
				
				ChartPanel chartPanel = new ChartPanel(chart);
				panel.removeAll();
				panel.add(chartPanel, BorderLayout.CENTER);
				panel.revalidate(); */
			}
		});
		btnNewButton.setBounds(584, 350, 85, 21);
		panel.add(btnNewButton);
		

	}
}
