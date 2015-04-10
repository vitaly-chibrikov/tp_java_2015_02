package executor;

import handlers.TResultHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TExecutor {
	public <T> T execQuery(Connection connection,
			String query,
			TResultHandler<T> handler)
			throws SQLException {
		Statement stmt = connection.createStatement();
		stmt.execute(query);
		ResultSet result = stmt.getResultSet();
		T value = handler.handle(result);
		result.close();
		stmt.close();

		return value;
	}

}
