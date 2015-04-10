package executor;

import handlers.ResultHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SimpleExecutor {
	public void execQuery(Connection connection, String query, ResultHandler handler)
			throws SQLException {
		Statement stmt = connection.createStatement();
		stmt.execute(query);
		ResultSet result = stmt.getResultSet();
		handler.handle(result);
		result.close();
		stmt.close();
	}

	public void execUpdate(Connection connection, String update) throws SQLException {
		Statement stmt = connection.createStatement();
		stmt.execute(update);
		stmt.close();
	}
}
