package examples;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleExample {
	
	public static Connection getConnection() {
		try{
			DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
			
			StringBuilder url = new StringBuilder();
			
			url.
			append("jdbc:mysql://").		//db type
			append("localhost:"). 			//host name
			append("3306/").				//port
			append("db_example?").			//db name
			append("user=tully&").			//login
			append("password=tully");		//password
			
			System.out.append("URL: " + url + "\n");
			
			Connection connection = DriverManager.getConnection(url.toString());
			return connection;
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        return null;
	}
	
	public static void connect(){
		Connection connection = getConnection();
		System.out.append("Connected!\n");
		try {
			System.out.append("Autocommit: " + connection.getAutoCommit() + '\n');
			System.out.append("DB name: " + connection.getMetaData().getDatabaseProductName() + '\n');
			System.out.append("DB version: " + connection.getMetaData().getDatabaseProductVersion() + '\n');
			System.out.append("Driver: " + connection.getMetaData().getDriverName() + '\n');
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		 
	}
}
