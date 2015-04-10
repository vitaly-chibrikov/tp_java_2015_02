package examples;

import handlers.TResultHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsersDAO;
import dataSets.UsersDataSet;

import executor.SimpleExecutor;
import executor.TExecutor;

public class DataSetExample {
	public static void connect(){
		try {
			Connection connection = SimpleExample.getConnection();
			SimpleExecutor exec = new SimpleExecutor();
			
			exec.execUpdate(connection, "create table users (id bigint auto_increment, user_name varchar(256), primary key (id))");
			System.out.append("DB created\n");
			exec.execUpdate(connection, "insert into users (user_name) values ('tully')");
			System.out.append("User added\n");
			
			UsersDAO userDAO = new UsersDAO(connection);
			UsersDataSet result = userDAO.get(1);
			
			System.out.append("User id: " + result.getId() + ", name: " + result.getName() + '\n');
			
			exec.execUpdate(connection, "drop table users");
			System.out.append("Done!\n");
					
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
