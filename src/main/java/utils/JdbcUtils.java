
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class JdbcUtils  {

      private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";


//    private static final String DB_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
//    private static final String DB_USERNAME = "root";
//    private static final String DB_PASSWORD = "1234";
//    
      private static final String DB_URL = "jdbc:mysql://db4free.net:3306/irisnatunim?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
      private static final String DB_USERNAME = "irisnatunim";
      private static final String DB_PASSWORD = "Evgenyt1";
    

	static {
		try {
			 Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
    public static Connection getConnection() throws  SQLException {
        Connection connection = null;
      //  DriverManager.setLoginTimeout(10000);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
        return connection;
    }
        
    public static void closeResources(Connection connection, PreparedStatement statement) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Write to log that we have a resource leak
		}

		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			// Write to log that we have a resource leak
			e.printStackTrace();
		}
	}

	public static void closeResources(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		closeResources(connection, statement);
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			// Write to log that we have a resource leak
			e.printStackTrace();
		}

	}

}
