package examples;

import handlers.ResultHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import executor.PreparedExecutor;

public class PreparedExample {
	public static void connect(){
		try {			
			Connection connection = SimpleExample.getConnection();
			
			Map<Integer,String> idToName = new HashMap<Integer,String>();
			idToName.put(1, "Test1");
			idToName.put(2, "Test2");
			idToName.put(3, "Test3");
			idToName.put(4, "Test4");
			
			PreparedExecutor exec = new PreparedExecutor();
			exec.execUpdate(connection, "create table users (id bigint, user_name varchar(256), primary key (id))");
			exec.execUpdate(connection, idToName);	
			System.out.append("All users added\n");
			
			exec.execQuery(connection, "select * from users", new ResultHandler(){

				public void handle(ResultSet result) throws SQLException {
					while(true){
						result.next();
						System.out.append("User: " + result.getInt(1) + " name: "  + result.getString("user_name") + '\n');						
						if(result.isLast())
							break;
					}
				}				
			});
			
			exec.execUpdate(connection, "drop table users");
			System.out.append("Done!\n");
			
			connection.close();			
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
