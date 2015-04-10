package examples;

import handlers.TResultHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import executor.SimpleExecutor;
import executor.TExecutor;

public class TExample {
	public static void connect(){
        Connection connection = SimpleExample.getConnection();
        SimpleExecutor exec = new SimpleExecutor();
		try {
			exec.execUpdate(connection, "create table users (id bigint auto_increment, user_name varchar(256), primary key (id))");
			System.out.append("Table created\n");
			exec.execUpdate(connection, "insert into users (user_name) values ('tully')");
			System.out.append("User added\n");
			
			TExecutor execT = new TExecutor();
			
			String name = execT.execQuery(connection, "select * from users where id=1", result -> {
                result.next();
                return result.getString(2);
            });
			
			System.out.append("Read user: " + name + '\n');

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                exec.execUpdate(connection, "drop table users");
                connection.close();
            } catch (SQLException e) {
                System.out.append(e.toString());
            }
            System.out.append("Done!\n");
        }
    }
}
