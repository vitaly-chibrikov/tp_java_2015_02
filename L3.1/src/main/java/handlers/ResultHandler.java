package handlers;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultHandler {
	void handle(ResultSet result) throws SQLException;
}
