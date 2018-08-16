package ui.inventory.tabs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JScrollPane;


public class MakeChanges extends KTab {
	
	private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
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
					MakeChanges frame = new MakeChanges();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void tableLoad(){
        try{
            String sql = "select * from items";
            PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            table.setModel(Database.resultSetToTableModel(rs));
            
        
        }catch(Exception e){}
    }

	/**
	 * Create the frame.
	 */
	public MakeChanges() {
		super("Changes");
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(755, 358, 116, 22);
		getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(755, 389, 116, 22);
		getContentPane().add(dateChooser_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 188, 434, 228);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int r = table.getSelectedRow();
		        
		        String id = table.getValueAt(r, 0).toString();
		        String name = table.getValueAt(r, 1).toString();
		        String c =  table.getValueAt(r, 2).toString();
		        String ex = table.getValueAt(r, 3).toString();
		        String br = table.getValueAt(r, 4).toString();
		        Date pd = (Date) table.getValueAt(r, 5);
		        Date sd = (Date) table.getValueAt(r, 6);
		        
		        textField_2.setText(id);
		        textField_3.setText(name);
		        textField_4.setText(c);
		        textField_5.setText(ex);
		        textField_6.setText(br);
		        dateChooser.setDate(pd);
		        dateChooser_1.setDate(sd);
		        
		        
		       
			}
		});
		
		tableLoad();
		
		JLabel lblMakeChangesTo = new JLabel("Make changes to Inventory");
		lblMakeChangesTo.setBounds(110, 88, 761, 27);
		getContentPane().add(lblMakeChangesTo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(755, 185, 116, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(755, 220, 116, 22);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(755, 255, 116, 22);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(755, 290, 116, 22);
		getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(755, 325, 116, 22);
		getContentPane().add(textField_6);
		
		JLabel lblItemId = new JLabel("Item Id");
		lblItemId.setBounds(566, 185, 150, 22);
		getContentPane().add(lblItemId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(566, 220, 150, 22);
		getContentPane().add(lblName);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(566, 255, 150, 22);
		getContentPane().add(lblCost);
		
		JLabel lblExecutive = new JLabel("Executive");
		lblExecutive.setBounds(566, 290, 150, 22);
		getContentPane().add(lblExecutive);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(566, 325, 150, 22);
		getContentPane().add(lblBranch);
		
		JLabel lblPurchasedDate = new JLabel("Purchased Date");
		lblPurchasedDate.setBounds(566, 363, 150, 22);
		getContentPane().add(lblPurchasedDate);
		
		JLabel lblSoldDate = new JLabel("Sold Date");
		lblSoldDate.setBounds(566, 394, 150, 22);
		getContentPane().add(lblSoldDate);
		
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 	textField_2.setText(null);
			        textField_3.setText(null);
			        textField_4.setText(null);
			        textField_5.setText(null);
			        textField_6.setText(null);
			        dateChooser.setDate(null);
			        dateChooser_1.setDate(null);
			}
		});
		btnReset.setBounds(110, 467, 99, 25);
		getContentPane().add(btnReset);
		
		JButton btnAddEntry = new JButton("Add Entry");
		btnAddEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String q;
				float cc = 0;
				String id = textField_2.getText();
				String name = textField_3.getText();
				String c = textField_4.getText();
				String ex  = textField_5.getText();
				String br = textField_6.getText();
				Date pd = dateChooser.getDate();
				Date sd = dateChooser_1.getDate();
				
				if(id == null||name == null||ex == null||br == null||pd == null||c == null)
		            JOptionPane.showMessageDialog(null, "One or more Required fields are empty!!");
				else{
		            cc = Float.valueOf(c);
		            DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		            String ppdate = df.format(pd);
		            String ssdate = null;
		            if(sd != null)
		                ssdate = df.format(sd);

		            if(sd == null)
		                q = "insert into items values( '"+id+"','"+name+"','"+cc+"','"+ex+"','"+br+"','"+ppdate+"',null)";
		            else
		                q = "insert into items values( '"+id+"','"+name+"','"+cc+"','"+ex+"','"+br+"','"+ppdate+"','"+ssdate+"')";
		            
		            
					try {
						PreparedStatement stmt = Database.getConnection().prepareStatement(q);
						stmt.execute();
					} catch (SQLException e) {}
		           
		            tableLoad();
		            
		        }
				
			}
		});
		btnAddEntry.setBounds(341, 467, 99, 25);
		getContentPane().add(btnAddEntry);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q;
				float cc = 0;
				String id = textField_2.getText();
				String name = textField_3.getText();
				String c = textField_4.getText();
				String ex  = textField_5.getText();
				String br = textField_6.getText();
				Date pd = dateChooser.getDate();
				Date sd = dateChooser_1.getDate();
				
				if(id == null||name == null||ex == null||br == null||pd == null||c == null)
		            JOptionPane.showMessageDialog(null, "One or more Required fields are empty!!");
				else{
	                int x = JOptionPane.showConfirmDialog(null, "Do you really want to Update?");
	                if(x == 0){
	                	cc = Float.valueOf( textField_4.getText());
	                    DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
	                    String ppdate = df.format(pd);
	                    String ssdate = null;
	                    if(sd != null)
	                      ssdate = df.format(sd);
	             
	                    if(sd == null)
	                        q = "update items set Name = '"+name+"',Cost = '"+cc+"',Executive = '"+ex+"',Branch = '"+br+"',Purchased_Date = '"+ppdate+"',Sold_Date = null where Item_Id = '"+id+"'";
	                    else  
	                        q = "update items set Name = '"+name+"',Cost = '"+cc+"',Executive = '"+ex+"',Branch = '"+br+"',Purchased_Date = '"+ppdate+"',Sold_Date = '"+ssdate+"' where Item_Id = '"+id+"'";
	                   
						try {
							PreparedStatement stmt = Database.getConnection().prepareStatement(q);
							stmt.execute();
						} catch (SQLException exp) {}
	                    tableLoad();
	                }
	              } 
				
				
			}
		});
		btnUpdate.setBounds(772, 467, 99, 25);
		getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = JOptionPane.showConfirmDialog(null, "Do you really want to Delete?");
		        
		        if(x == 0){
		        
					String id = textField_2.getText();
		        
		            String sql = "delete from items where Item_Id = '"+id+"'";
		           
					try {
						PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
						stmt.execute();
					} catch (SQLException exp) {}
					
		            tableLoad();
		        }
			}
		});
		btnDelete.setBounds(566, 467, 99, 25);
		getContentPane().add(btnDelete);
		

		

	}
}
