package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	public Connection getConnection() {
		Connection con = null;
		String username = "sa";
		String password = "123456";
		String dbName = "ShoppingDB";
		String port = "1433";
		String serverName = "localhost";
		String instance = "";		
		String url = "";
		
//		if(instance == null || instance.trim().isEmpty()) {
//			url = "jdbc:sqlserver://" + serverName +":" 
//					+ port + ";databaseName=" + dbName
//					+ ";encrypt=true;trustServerCertificate=true";
//		} else {
//			url = "jdbc:sqlserver://" + serverName +":" 
//					+ port + "\\" + instance + ";databaseName=" + dbName 
//					+ ";encrypt=true;trustServerCertificate=true";
//		}
		
		if(instance == null || instance.strip().isEmpty()) {
			url = "jdbc:sqlserver://" + serverName + ":" + port +
					";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true";
		} else {
			url = "jdbc:sqlserver://" + serverName + ":" + port + "\\" + instance +
					";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true";
		}
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			try {
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				System.out.println("can not connect to DB");
			}			
		} catch (ClassNotFoundException e) {
			System.out.println("can not load driver");
		}
		return con;		
	}
}
