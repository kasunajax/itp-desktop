package ui.sales.tabs;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JInternalFrame;

import ui.components.KTab;
import ui.inventory.tabs.Home;
import utils.common.database.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.JButton;

public class PendingSales extends KTab {
	private JTable table;
	JDateChooser dateChooserFrom;
	JDateChooser dateChooserTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					PendingSales frame = new PendingSales();
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
	public PendingSales() {
		super("Pending Sales");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Pending Sales Reports");
		lblNewLabel.setBounds(400, 25, 200, 45);
		getContentPane().add(lblNewLabel);
		
		dateChooserFrom = new JDateChooser();
		dateChooserFrom.setBounds(310, 115, 116, 22);
		getContentPane().add(dateChooserFrom);
		
		dateChooserTo = new JDateChooser();
		dateChooserTo.setBounds(547, 115, 116, 22);
		getContentPane().add(dateChooserTo);
		
		table = new JTable();
		table.setBounds(170, 107, 663, 112);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 224, 860, 350);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("Date From");
		lblNewLabel_2.setBounds(310, 80, 116, 25);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date to");
		lblNewLabel_3.setBounds(547, 80, 116, 25);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Filter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dateFrom = dateChooserFrom.getDate();
				Date dateTo = dateChooserTo.getDate();
						
				
				if(dateFrom == null && dateTo == null) {
					 tableLoad();										
				}else if(dateFrom != null && dateTo != null) {
					 dateF(dateFrom,dateTo);
				}}
		});
		btnNewButton.setBounds(413, 159, 135, 35);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Export Excel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getRowCount() == 0) {
					
					JOptionPane.showInternalMessageDialog(PendingSales.this, "There're no rows to be exported");
					
					return;
					
				}

				JFileChooser c = new JFileChooser();
				c.setSelectedFile(new File("CW_"+new SimpleDateFormat("ddMMyyyyHHmmss").format(new java.util.Date()) + ".xls"));
			    int rVal = c.showSaveDialog(PendingSales.this);
			    if (rVal == JFileChooser.APPROVE_OPTION) {
			    	toExcel(table, c.getSelectedFile());
			    }
			}
		});
		btnNewButton_1.setBounds(802, 192, 123, 25);
		getContentPane().add(btnNewButton_1);
		
		tableLoad();

	}
	
	public void tableLoad(){
        try{
            String sql = "select * from order_confirmation WHERE Status='Activated'";
            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            table.setModel(Database.resultSetToTableModel(rs));
            
        
        }catch(Exception e){}
    }
	
public void toExcel(JTable table, File file){
		
		
	    try{
	        TableModel model = table.getModel();
	        FileWriter excel = new FileWriter(file);

	        for(int i = 0; i < model.getColumnCount(); i++){
	            excel.write(model.getColumnName(i) + "\t");
	        }

	        excel.write("\n");

	        for(int i=0; i< model.getRowCount(); i++) {
	            for(int j=0; j < model.getColumnCount(); j++) {
	                excel.write(model.getValueAt(i,j).toString()+"\t");
	            }
	            excel.write("\n");
	        }

	        excel.close();
	        
	        if(!Desktop.isDesktopSupported()){
	            return;
	        }
	        
	        Desktop desktop = Desktop.getDesktop();
	        if(file.exists()) 
	        	desktop.open(file);
	

	    }catch(IOException e){  }
	}
	
	public void dateF(Date dateFrom, Date dateTo) {
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		String daFr = df.format(dateFrom);
		String daTo = df.format(dateTo);
		try{
			String sql = "select * from order_confirmation WHERE Status='Activated' && Confirmed_Date between '"+daFr+"' and '"+daTo+"'";
			PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
       
			table.setModel(Database.resultSetToTableModel(rs));
       
   
		}catch(Exception e){}
	}
	
}