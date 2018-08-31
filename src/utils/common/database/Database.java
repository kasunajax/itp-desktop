package utils.common.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Database {
	
	private static final String URL = "jdbc:mysql://db4free.net:3306/dms_cell_world?useSSL=false";
	private static final String USER = "user_cell_world";
	private static final String PASS = "jkl@84MMy";
	
	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static TableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();

            // Get the column names
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }

            // Get all rows.
            Vector rows = new Vector();

            while (rs.next()) {
                Vector newRow = new Vector();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }

                rows.addElement(newRow);
            }

            return new DefaultTableModel(rows, columnNames) {
            	@Override
    			public boolean isCellEditable(int row, int column) {
    				return false;
    			}
            };
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

}
