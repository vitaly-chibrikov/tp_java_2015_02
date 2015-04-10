package executor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class PreparedExecutor extends SimpleExecutor {
	public void execUpdate(Connection connection, Map<Integer, String> idToName) {
		try{
			connection.setAutoCommit(false);
			String update = "insert into users(id, user_name) values(?,?)";
			PreparedStatement stmt = connection.prepareStatement(update);
			
			for(Integer id: idToName.keySet()){
				stmt.setInt(1, id);
				stmt.setString(2, idToName.get(id));
				stmt.executeUpdate();	
			}	
			connection.commit();
			stmt.close();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
