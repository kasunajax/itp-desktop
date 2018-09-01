package ui.orders.tabs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import ui.components.KTab;
import utils.common.database.Database;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Color;

public class ProcessOrders extends KTab {
	
	private static final long serialVersionUID = 1L;


	private JScrollPane scrollPane_1, scrollPane_2;
	
	private JButton btnRefreshInventory, btnRefreshCart,  btnRefreshQueue;
	private JButton btnAdd, btnRemove;
	private JButton btnLock, btnUnlock;
	
	private JProgressBar progressBar, pbCart, pbInventory, pbQueue;
	
	private JLabel lblQueue, lblCart, lblInventory, lblPStatus;

	private JTable tableOrders, tableCart, tableInventory;
	
	private JPanel panelCart;
	
	private int lockStatus = 0;
	private JPanel panelInventory;
	private JPanel panelOrders;
	private JPanel panelOptions;
	private JLabel lblNewLabel;
	private JLabel lblMyCart;
	private JLabel lblMyInventory;
	

	public ProcessOrders() {
		super("PROCESS ORDER");
		
		pbQueue = new JProgressBar();
		pbQueue.setIndeterminate(true);
		pbQueue.setVisible(false);
		pbQueue.setBounds(494, 64, 80, 25);
		getContentPane().add(pbQueue);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 550, 980, 50);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setBounds(764, 17, 146, 16);
		progressBar.setVisible(false);
		panel.add(progressBar);
		
		lblPStatus = new JLabel("Status: Ready");
		lblPStatus.setBounds(64, 11, 680, 28);
		panel.add(lblPStatus);
		
		panelCart = new JPanel();
		panelCart.setBackground(new Color(255, 255, 255));
		panelCart.setBounds(64, 275, 334, 225);
		getContentPane().add(panelCart);
		panelCart.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 33, 334, 152);
		panelCart.add(scrollPane_1);
		
		tableCart = new JTable();
		scrollPane_1.setViewportView(tableCart);
		
		lblCart = new JLabel("Status: ");
		lblCart.setBounds(0, 194, 119, 25);
		panelCart.add(lblCart);
		lblCart.setHorizontalAlignment(SwingConstants.LEFT);
		
		pbCart = new JProgressBar();
		pbCart.setIndeterminate(true);
		pbCart.setBounds(136, 194, 80, 25);
		panelCart.add(pbCart);
		
		btnRefreshCart = new JButton("Refresh");
		btnRefreshCart.setBounds(234, 194, 100, 25);
		panelCart.add(btnRefreshCart);
		btnRefreshCart.setEnabled(false);
		
		lblMyCart = new JLabel("My Cart > ");
		lblMyCart.setBounds(0, 0, 110, 24);
		panelCart.add(lblMyCart);
		
		panelInventory = new JPanel();
		panelInventory.setBackground(new Color(255, 255, 255));
		panelInventory.setBounds(515, 275, 401, 225);
		getContentPane().add(panelInventory);
		panelInventory.setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 33, 401, 152);
		panelInventory.add(scrollPane_2);
		
		tableInventory = new JTable();
		scrollPane_2.setViewportView(tableInventory);
		
		btnRefreshInventory = new JButton("Refresh");
		btnRefreshInventory.setBounds(301, 191, 100, 25);
		panelInventory.add(btnRefreshInventory);
		btnRefreshInventory.setEnabled(false);
		
		pbInventory = new JProgressBar();
		pbInventory.setIndeterminate(true);
		pbInventory.setBounds(201, 191, 80, 25);
		panelInventory.add(pbInventory);
		
		lblInventory = new JLabel("Status: ");
		lblInventory.setBounds(0, 191, 181, 25);
		panelInventory.add(lblInventory);
		
		lblMyInventory = new JLabel("My Inventory >");
		lblMyInventory.setBounds(0, 0, 110, 24);
		panelInventory.add(lblMyInventory);
		
		panelOrders = new JPanel();
		panelOrders.setBackground(new Color(255, 255, 255));
		panelOrders.setBounds(64, 60, 852, 204);
		getContentPane().add(panelOrders);
		panelOrders.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 40, 852, 164);
		panelOrders.add(scrollPane);
		
		tableOrders = new JTable();
		scrollPane.setViewportView(tableOrders);
		
		btnRefreshQueue = new JButton("Refresh");
		btnRefreshQueue.setBounds(752, 4, 100, 25);
		panelOrders.add(btnRefreshQueue);
		
		btnLock = new JButton("Lock");
		btnLock.setBounds(644, 4, 100, 25);
		panelOrders.add(btnLock);
		btnLock.setEnabled(false);
		
		btnUnlock = new JButton("Unlock");
		btnUnlock.setBounds(534, 4, 100, 25);
		panelOrders.add(btnUnlock);
		btnUnlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unlockOrder();
			}
		});
		btnUnlock.setEnabled(false);
		
		lblNewLabel = new JLabel("Select an order > ");
		lblNewLabel.setBounds(0, 5, 110, 24);
		panelOrders.add(lblNewLabel);
		
		lblQueue = new JLabel("Status: ");
		lblQueue.setBounds(120, 4, 283, 25);
		panelOrders.add(lblQueue);
		
		panelOptions = new JPanel();
		panelOptions.setBackground(new Color(255, 255, 255));
		panelOptions.setBounds(408, 275, 97, 225);
		getContentPane().add(panelOptions);
		panelOptions.setLayout(null);
		
		btnAdd = new JButton("<<<<");
		btnAdd.setBounds(0, 54, 97, 40);
		panelOptions.add(btnAdd);
		btnAdd.setEnabled(false);
		
		btnRemove = new JButton(">>>>");
		btnRemove.setBounds(0, 95, 97, 40);
		panelOptions.add(btnRemove);
		btnRemove.setEnabled(false);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				removeFromCart();
				
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addToCart();
				
			}
		});
		btnLock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lockOrder();
				
			}
		});
		btnRefreshQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//refreshQueue();
				
				
			}
		});
		pbInventory.setVisible(false);
		btnRefreshInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refreshInventory();
				
			}
		});
		btnRefreshCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refreshCart();
				
			}
		});
		pbCart.setVisible(false);
		

		
//		try {
//			String sql = "SELECT ItemID, Serial_Number, Executive, Package FROM items WHERE Executive = 'EMP001' AND Status = 'INITIAL'";
//			PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
//			ResultSet res = stmt.executeQuery();
//			table.setModel(Database.resultSetToTableModel(res));
//			
//		} catch (SQLException e) {e.printStackTrace();}
//		
//		
//		try {
//			String sql = "SELECT ItemID, Package FROM items WHERE Executive = 'EMP001' AND Status = 'ASSIGNED'";
//			PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
//			ResultSet res = stmt.executeQuery();
//			table_1.setModel(Database.resultSetToTableModel(res));
//			
//		} catch (SQLException e) {e.printStackTrace();}
//		
//		try {
//			String sql = "SELECT * FROM orders WHERE  Status = 'INITIAL'";
//			PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
//			ResultSet res = stmt.executeQuery();
//			table_2.setModel(Database.resultSetToTableModel(res));
//
//		} catch (SQLException e) {e.printStackTrace();}
		
		init();
		
	}
	
	
	public void showOrderStatus(String msg) {
		pbQueue.setVisible(true);
		lblQueue.setText(msg);
	}
	
	public void hideOrderStatus(String msg) {
		pbQueue.setVisible(false);
		lblQueue.setText(msg);
	}
	
	public void showInventoryStatus(String msg) {
		pbInventory.setVisible(true);
		lblInventory.setText(msg);
	}
	public void hideInventoryStatus(String msg) {
		pbInventory.setVisible(false);
		lblInventory.setText(msg);
	}
	
	public void showCartStatus(String msg) {
		pbCart.setVisible(true);
		lblCart.setText(msg);
	}
	public void hideCartStatus(String msg) {
		pbCart.setVisible(false);
		lblCart.setText(msg);
	}
	
	public void showGeneralStatus(String msg) {
		progressBar.setVisible(true);
		lblPStatus.setText(msg);
	}
	public void hideGeneralStatus(String msg) {
		progressBar.setVisible(false);
		lblPStatus.setText(msg);
	}
	
	
	public void disableAllPanels() {
		
		disableOrdersPanel();
		disableInventoryPanel();
		disableCartPanel();
		
	}
	
	public void disableOperationsPanel() {	
		for(Component cmp : panelOptions.getComponents()) {
			cmp.setEnabled(false);
		}
	}
	public void enableOperationsPanel() {	
		for(Component cmp : panelOptions.getComponents()) {
			cmp.setEnabled(true);
		}
	}
	public void disableOrdersPanel() {
		for(Component cmp : panelOrders.getComponents()) {
			cmp.setEnabled(false);
		}
	}
	public void disableInventoryPanel() {
		for(Component cmp : panelInventory.getComponents()) {
			cmp.setEnabled(false);
		}
	}
	public void disableCartPanel() {
		for(Component cmp : panelCart.getComponents()) {
			cmp.setEnabled(false);
		}
	}
	
	public void enableOrdersPanel() {
		for(Component cmp : panelOrders.getComponents()) {
			cmp.setEnabled(true);
		}
	}
	public void enableInventoryPanel() {
		for(Component cmp : panelInventory.getComponents()) {
			cmp.setEnabled(true);
		}
	}
	public void enableCartPanel() {
		for(Component cmp : panelCart.getComponents()) {
			cmp.setEnabled(true);
		}
	}
	
	public void setLocked() {
		btnLock.setEnabled(false);
		btnUnlock.setEnabled(true);
	}
	public void setUnlocked() {
		btnLock.setEnabled(true);
		btnUnlock.setEnabled(false);
	}
	public void setOrdersPointer() {
		
		int rowCount = tableOrders.getRowCount();
		if(rowCount > 0)
			tableOrders.setRowSelectionInterval(0, 0);
		
	}
	public void setCartPointer() {
		
		int rowCount = tableCart.getRowCount();
		if(rowCount > 0)
			tableCart.setRowSelectionInterval(0, 0);
		
	}
	public void setInventoryPointer() {
		int rowCount = tableInventory.getRowCount();
		if(rowCount > 0)
			tableInventory.setRowSelectionInterval(0, 0);
	}
	
	public void refreshOrders() {

	
		final String STATUS_ENTER = "Status: Refreshing Order Queue - Pending ...";
		final String STATUS_EXIT = "Status: Refreshing Order - Done !";
		
		final String SQL_ORDER_INITIAL = "SELECT * FROM orders WHERE  Status = 'INITIAL'";
		final String SQL_ORDER_LOCKED = "SELECT * FROM orders WHERE  Status = 'LOCKED'";
		
		new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				
				showGeneralStatus(STATUS_ENTER);
				showOrderStatus(STATUS_ENTER);
				
				
				tableOrders.setModel(new DefaultTableModel());
				btnLock.setEnabled(false);
				
				PreparedStatement stmt1 = Database.get(SQL_ORDER_LOCKED);
				ResultSet res1 = stmt1.executeQuery();
				
				if(res1.next()) {
					setLocked();
					btnLock.setEnabled(false);
					tableOrders.setModel(Database.resultSetToTableModel(res1));
					return null;
				}else {
					setUnlocked();
					PreparedStatement stmt2 = Database.get(SQL_ORDER_INITIAL);
					ResultSet res2 = stmt2.executeQuery();
					tableOrders.setModel(Database.resultSetToTableModel(res2));
				}
				
				
				
				
				return null;
			}
			
			@Override
			protected void done() {
				hideGeneralStatus(STATUS_EXIT);
				hideOrderStatus(STATUS_EXIT);
				setOrdersPointer();
			}
			
		}.execute();
		
		
	}
	
	public void init() {
		
		disableAllPanels();
		setUnlocked();
		
		
		new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				
				refreshOrders();
				
				return null;
			}

			@Override
			protected void done() {
				
			}
			
		}.execute();
		
	}
		
//	public void removeFromCart() {
//		
//		new SwingWorker<Void, Void>(){
//
//			@Override
//			protected Void doInBackground() throws Exception {
//				
//				if(tableCart.getRowCount() == 0)
//					return null;
//				
//				btnAdd.setEnabled(false);
//				btnRemove.setEnabled(false);
//				progressBar.setVisible(true);
//				progressBar.setIndeterminate(true);
//				lblPStatus.setText("Status: Removing Item from Cart ...");
//				
//				int row = tableCart.getSelectedRow();
//				String itemId = (String)tableCart.getValueAt(row, 0);
//				
//				String sql = "UPDATE items SET Status = 'INITIAL' WHERE ItemID = ? ";
//				PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
//				stmt.setString(1, itemId);
//				stmt.execute();
//				
//				return null;
//			}
//
//			@Override
//			protected void done() {
//				btnAdd.setEnabled(true);
//				btnRemove.setEnabled(true);
//				progressBar.setVisible(false);
//				lblPStatus.setText("Status: Done !");
//				
//				refreshCart();
//				refreshInventory();
//			}
//			
//			
//			
//		}.execute();
//		
//	}
	
	public void addToCart() {
		
		
		
		
		
		final String STATUS_ENTER = "Status: Adding to Cart - Pending ...";
		final String STATUS_EXIT = "Status: Added - Successful!";
		
		final String SQL_ITEMS = "UPDATE items SET Status = 'ASSIGNED' WHERE ItemID = ? ";
		
		new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				
				btnAdd.setEnabled(false);
				showGeneralStatus(STATUS_ENTER);

				
				int row = tableInventory.getSelectedRow();
				String itemId = (String) tableInventory.getValueAt(row, 0);
				
				
				PreparedStatement stmt2 = Database.get(SQL_ITEMS);
				stmt2.setString(1, itemId);
				stmt2.execute();
				
				return null;
			}
			
			@Override
			protected void done() {
				hideGeneralStatus(STATUS_EXIT);
				setOperations();
				refreshCart();
				refreshInventory();
				
			}
			
		}.execute();
		
		
		
		

		
	}
	
	
	
	
	
	public void removeFromCart() {
		
		
		
		
		
		final String STATUS_ENTER = "Status: Removing from Cart - Pending ...";
		final String STATUS_EXIT = "Status: Removed - Successful!";
		
		final String SQL_ITEMS = "UPDATE items SET Status = 'INITIAL' WHERE ItemID = ? ";
		
		new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				
				btnRemove.setEnabled(false);
				showGeneralStatus(STATUS_ENTER);

				
				int row = tableCart.getSelectedRow();
				String itemId = (String) tableCart.getValueAt(row, 0);
				
				
				PreparedStatement stmt2 = Database.get(SQL_ITEMS);
				stmt2.setString(1, itemId);
				stmt2.execute();
				
				return null;
			}
			
			@Override
			protected void done() {
				hideGeneralStatus(STATUS_EXIT);
				setOperations();
				refreshCart();
				refreshInventory();
				
			}
			
		}.execute();
		
		
		
		

		
	}
	
	
	
	
	
	public void showProgress() {
		progressBar.setVisible(true);
		progressBar.setIndeterminate(true);
	}
	
	public void showProgress(JProgressBar p) {
		p.setVisible(true);
		p.setIndeterminate(true);
	}
	
	public void hideProgress(JProgressBar p) {
		p.setVisible(false);
		p.setIndeterminate(false);
	}
	
	public void hideProgress() {
		progressBar.setVisible(false);
		progressBar.setIndeterminate(false);
		
		
	}
	
	public void unlockOrder() {
		
		
		final String STATUS_ENTER = "Status: Unlocking the Order - Pending ...";
		final String STATUS_EXIT = "Status: Unlocked - Successful!";
		
		final String SQL_ORDER_UNLOCK = "UPDATE orders SET Status = 'INITIAL' WHERE OrderID = ?"; 
		final String SQL_ORDER_GETUNLOCK = "SELECT * FROM orders WHERE Status = 'INITIAL'";
		
		new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				
				tableInventory.setModel(new DefaultTableModel());
				tableCart.setModel(new DefaultTableModel());
				disableInventoryPanel();
				showGeneralStatus(STATUS_ENTER);
				showOrderStatus(STATUS_ENTER);
				disableOperationsPanel();
				disableCartPanel();
				
				int row = tableOrders.getSelectedRow();
				int rowCount = tableOrders.getRowCount();
				
				if(rowCount != 1) return null;
				
				
				String orderId = tableOrders.getValueAt(row, 0).toString();
				
				tableOrders.setModel(new DefaultTableModel());
				btnUnlock.setEnabled(false);
				
				PreparedStatement stmt1 = Database.get(SQL_ORDER_UNLOCK);
				stmt1.setString(1, orderId);
				stmt1.execute();
				
				PreparedStatement stmt2 = Database.get(SQL_ORDER_GETUNLOCK);
				ResultSet res2 = stmt2.executeQuery();
				tableOrders.setModel(Database.resultSetToTableModel(res2));
				
				return null;
			}
			
			@Override
			protected void done() {
				setUnlocked();
				hideGeneralStatus(STATUS_EXIT);
				hideOrderStatus(STATUS_EXIT);
				setOrdersPointer();
				
				
			}
			
		}.execute();
		
	}
	
//	public void unlockOrder() {
//		
//		new SwingWorker<Void, Object>() {
//
//
//			@Override
//			protected Void doInBackground() throws Exception {
//				
//				showProgress(pbQueue);
//				lblQueue.setVisible(true);
//				lblQueue.setText("Status: Unlocking the Order ...");
//				btnUnlock.setEnabled(false);
//				btnRefreshCart.setEnabled(false);
//				btnRefreshInventory.setEnabled(false);
//				
//				btnRefreshQueue.setEnabled(false);
//				
//			
//				
//				int row = tableOrders.getSelectedRow();
//				
//				String id = (String)tableOrders.getValueAt(row, 0);
//				
//				tableOrders.setModel(new DefaultTableModel());
//				tableCart.setModel(new DefaultTableModel());
//				tableInventory.setModel(new DefaultTableModel());
//				try {
//					
//					lblQueue.setText("Status: Unlocking Routine Inititiated ...");
//					String sql = "UPDATE `orders` SET `Status` = 'INITIAL' WHERE `OrderID` = ?";
//					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
//					stmt.setString(1, id);
//					stmt.execute();
//					
//					} catch (SQLException e) {e.printStackTrace();}
//				
//				hideProgress(pbQueue);
//				lblQueue.setText("Status: Initiating a Full Refresh ...");
//				refreshQueue();
//
//				
//				return null;
//			}
//
//
//			@Override
//			protected void done() {
//				lockStatus = 0;
//				btnAdd.setEnabled(false);
//				btnRemove.setEnabled(false);
//			}
//			
//			
//			
//		}.execute(); 		
//		
//	}
	
//	public void lockOrder() {
//		
//		new SwingWorker<Void, Object>() {
//
//
//			@Override
//			protected Void doInBackground() throws Exception {
//				
//				showProgress(pbQueue);
//				lblQueue.setVisible(true);
//				lblQueue.setText("Status: Locking the Order ...");
//				btnLock.setEnabled(false);
//				btnRefreshQueue.setEnabled(false);
//				btnRefreshCart.setEnabled(false);
//				btnRefreshInventory.setEnabled(false);
//				
//				
//				
//				int row = tableOrders.getSelectedRow();
//				
//				
//				
//				String id = (String)tableOrders.getValueAt(row, 0);
//				
//				tableOrders.setModel(new DefaultTableModel());
//				tableCart.setModel(new DefaultTableModel());
//				tableInventory.setModel(new DefaultTableModel());
//				
//				try {
//					
//					lblQueue.setText("Status: Locking Inititiated ...");
//					String sql = "UPDATE `orders` SET `Status` = 'LOCKED' WHERE `OrderID` = ?";
//					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
//					stmt.setString(1, id);
//					stmt.execute();
//					
//					} catch (SQLException e) {e.printStackTrace();}
//				
//				hideProgress(pbQueue);
//				lblQueue.setText("Status: Initiated a Full Refresh ...");
//				refreshQueue();
//
//				
//				return null;
//			}
//
//
//			@Override
//			protected void done() {
//				lockStatus = 1;
//				btnAdd.setEnabled(true);
//				btnRemove.setEnabled(true);
//			}
//			
//			
//			
//		}.execute(); 
//		
//	}
	
	public void lockOrder() {

		final String STATUS_ENTER = "Status: Locking the Order - Pending ...";
		final String STATUS_EXIT = "Status: Locking - Successful!";
		
		final String SQL_ORDER_LOCK = "UPDATE orders SET Status = 'LOCKED' WHERE OrderID = ?"; 
		final String SQL_ORDER_GETLOCK = "SELECT * FROM orders WHERE Status = 'LOCKED' AND OrderID = ? LIMIT 1";
		
		new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				
				showGeneralStatus(STATUS_ENTER);
				showOrderStatus(STATUS_ENTER);
				
				enableInventoryPanel();
				enableCartPanel();
				refreshInventory();
				refreshCart();
				
				int row = tableOrders.getSelectedRow();
				int rowCount = tableOrders.getRowCount();
				
				if(rowCount <= 0) return null;
				
				
				String orderId = tableOrders.getValueAt(row, 0).toString();
				
				tableOrders.setModel(new DefaultTableModel());
				btnLock.setEnabled(false);
				
				PreparedStatement stmt1 = Database.get(SQL_ORDER_LOCK);
				stmt1.setString(1, orderId);
				stmt1.execute();
				
				PreparedStatement stmt2 = Database.get(SQL_ORDER_GETLOCK);
				stmt2.setString(1, orderId);
				ResultSet res2 = stmt2.executeQuery();
				tableOrders.setModel(Database.resultSetToTableModel(res2));
				
				
				return null;
			}
			
			@Override
			protected void done() {
				setLocked();
				hideGeneralStatus(STATUS_EXIT);
				hideOrderStatus(STATUS_EXIT);
				setOrdersPointer();
				
				
			}
			
		}.execute();
		
		
		
	}
	
	public void refreshInventory() {
		
		final String STATUS_ENTER = "Status: Refreshing the Inventory - Pending ...";
		final String STATUS_EXIT = "Status: Resfreshed - Successful!";
		
		final String SQL_ITEMS = "SELECT * FROM items WHERE Status = 'INITIAL'";
		
		new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				
				
				showGeneralStatus(STATUS_ENTER);
				showInventoryStatus(STATUS_ENTER);
				
				tableInventory.setModel(new DefaultTableModel());
				btnRefreshInventory.setEnabled(false);
				
				
				PreparedStatement stmt2 = Database.get(SQL_ITEMS);
				ResultSet res2 = stmt2.executeQuery();
				tableInventory.setModel(Database.resultSetToTableModel(res2));
				
				return null;
			}
			
			@Override
			protected void done() {
				setLocked();
				hideGeneralStatus(STATUS_EXIT);
				hideInventoryStatus(STATUS_EXIT);
				
				btnRefreshInventory.setEnabled(true);
				setInventoryPointer();
				setOperations();
				
			}
			
		}.execute();
		
	}
	
	public void setOperations() {
		
		int rowCount1 = tableInventory.getRowCount();
		int rowCount2 = tableCart.getRowCount();
		
		if(rowCount1 > 0) {
			btnAdd.setEnabled(true);
		}else {
			btnAdd.setEnabled(false);
		}
		
		if(rowCount2 > 0) {
			btnRemove.setEnabled(true);
		}else {
			btnRemove.setEnabled(false);
		}
		
	}
	
//	public void refreshInventory() {
//	
//		new SwingWorker<Void, Object>() {
//
//
//			@Override
//			protected Void doInBackground() throws Exception {
//				
//				tableInventory.setModel(new DefaultTableModel());
//				showProgress(pbInventory);
//				lblInventory.setVisible(true);
//				lblInventory.setText("Status: Refreshing ...");
//				btnRefreshInventory.setEnabled(false);
//				
//				
//				try {
//					
//					String sql = "SELECT ItemID, Serial_Number, Name, Executive, Package FROM items WHERE Executive = 'EMP001' AND Status = 'INITIAL'";
//					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
//					ResultSet res = stmt.executeQuery();
//					
//					tableInventory.setModel(Database.resultSetToTableModel(res));
//
//					} catch (SQLException e) {e.printStackTrace();}
//				
//				return null;
//			}
//
//
//			@Override
//			protected void done() {
//				hideProgress(pbInventory);
//				if(tableInventory.getRowCount() != 0)
//					tableInventory.setRowSelectionInterval(0, 0);
//				
//				lblInventory.setVisible(false);
//				lblInventory.setText("Status: Finished !");
//				btnRefreshInventory.setEnabled(true);
//			}
//			
//			
//			
//		}.execute();
//		
//	}
	
//	public void refreshQueue() {
//		
//		new SwingWorker<Void, Object>() {
//
//
//			@Override
//			protected Void doInBackground() throws Exception {
//				
//				showProgress(pbQueue);
//				lblQueue.setVisible(true);
//				lblQueue.setText("Status: Refreshing ...");
//				btnRefreshQueue.setEnabled(false);
//				btnRefreshCart.setEnabled(false);
//				btnRefreshInventory.setEnabled(false);
//				tableOrders.setModel(new DefaultTableModel());
//				tableCart.setModel(new DefaultTableModel());
//				tableInventory.setModel(new DefaultTableModel());
//				
//				
//				
//				try {
//					
//					lblQueue.setText("Status: Refreshing Initiated ...");
//					String sql = "SELECT * FROM orders WHERE  Status = 'INITIAL' OR Status = 'LOCKED'";
//					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
//					ResultSet res = stmt.executeQuery();
//					
//					lblQueue.setText("Status: Verifying Locks ...");
//					String sqlx = "SELECT * FROM orders WHERE  Status = 'LOCKED'";
//					PreparedStatement stmtx = Database.getConnection().prepareStatement(sqlx);
//					ResultSet resx = stmtx.executeQuery();
//					
//					lblQueue.setText("Status: Determining the Table Model ...");
//					if(resx.next()) {
//						tableOrders.setEnabled(false);
//						
//						lblQueue.setText("Status: Loading Model ...");
//						String sqly = "SELECT * FROM orders WHERE  Status = 'LOCKED'";
//						PreparedStatement stmty = Database.getConnection().prepareStatement(sqly);
//						ResultSet resy = stmty.executeQuery();
//						
//						lockStatus = 1;
//						
//						tableOrders.setModel(Database.resultSetToTableModel(resy));
//					}else {
//						tableOrders.setEnabled(true);
//						tableOrders.setModel(Database.resultSetToTableModel(res));
//						btnLock.setEnabled(true);
//						lockStatus = 0;
//					}
//					
//					
//					
//
//					} catch (SQLException e) {e.printStackTrace();}
//				
//				return null;
//			}
//
//
//			@Override
//			protected void done() {
//				hideProgress(pbQueue);
//				if(tableOrders.getRowCount() != 0)
//					tableOrders.setRowSelectionInterval(0, 0);
//				
//				lblQueue.setVisible(false);
//				lblQueue.setText("Status: Finished !");
//				btnRefreshQueue.setEnabled(true);
//				
//				if(lockStatus == 0) {
//					btnLock.setEnabled(true);
//					btnUnlock.setEnabled(false);
//				}else {
//					btnLock.setEnabled(false);
//					btnUnlock.setEnabled(true);
//				}
//				
//				refreshCart();
//				refreshInventory();
//			}
//			
//			
//			
//		}.execute();
//		
//
//	}
	
	public void refreshCart() {
		final String STATUS_ENTER = "Status: Refreshing the Cart - Pending ...";
		final String STATUS_EXIT = "Status: Refreshed - Successful!";
		
		final String SQL_ITEMS = "SELECT ItemID, Serial_Number, Name FROM items WHERE Status = 'ASSIGNED'";
		
		new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				
				
				showGeneralStatus(STATUS_ENTER);
				showCartStatus(STATUS_ENTER);
				
				tableCart.setModel(new DefaultTableModel());
				btnRefreshCart.setEnabled(false);
				
				
				PreparedStatement stmt2 = Database.get(SQL_ITEMS);
				ResultSet res2 = stmt2.executeQuery();
				tableCart.setModel(Database.resultSetToTableModel(res2));
				
				return null;
			}
			
			@Override
			protected void done() {
				setLocked();
				hideGeneralStatus(STATUS_EXIT);
				hideCartStatus(STATUS_EXIT);
				
				btnRefreshCart.setEnabled(true);
				setCartPointer();
				setOperations();
				
			}
			
		}.execute();
	}
	
//	public void refreshCart() {
//		
//		new SwingWorker<Void, Object>() {
//
//			@Override
//			protected Void doInBackground() throws Exception {
//				
//				tableCart.setModel(new DefaultTableModel());
//				showProgress(pbCart);
//				lblCart.setVisible(true);
//				lblCart.setText("Status: Refreshing ...");
//				btnRefreshCart.setEnabled(false);
//				
//				
//				try {
//					
//					String sql = "SELECT ItemID, Serial_Number, Name FROM items WHERE  Status = 'ASSIGNED'";
//					PreparedStatement stmt = Database.getConnection().prepareStatement(sql);
//					ResultSet res = stmt.executeQuery();
//					
//					tableCart.setModel(Database.resultSetToTableModel(res));
//
//					} catch (SQLException e) {e.printStackTrace();}
//				
//				return null;
//			}
//
//
//			@Override
//			protected void done() {
//				hideProgress(pbCart);
//				if(tableCart.getRowCount() != 0)
//					tableCart.setRowSelectionInterval(0, 0);
//				
//				lblCart.setVisible(false);
//				btnRefreshCart.setEnabled(true);
//				lblCart.setText("Status: Finished !");
//			}
//			
//			
//			
//		}.execute();
//		
//	}
}
