package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Message;
import iDao.IDao;
import utils.JdbcUtils;

public class Dao extends JdbcUtils implements IDao {

	PreparedStatement statement = null;
	Connection connection = null;
	ResultSet resultSet = null;
	
	
	public Message getMessageById(int id) {
		System.out.println("In Dao message with id " + id + " called");
		String query = "SELECT * FROM messagetab WHERE id= ?";

		Message message = new Message();

		try {
			connection = getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			resultSet.next();

			message.setId(resultSet.getInt(id));
			message.setMessage(resultSet.getString("message"));

			statement.execute(query);

		} catch (Exception e) {

		} finally {
			JdbcUtils.closeResources(connection, statement, resultSet);
		}
		return message;

	}

	
	public void createMessage(Message message) {

		String query = "INSERT INTO messagetab (message) " + "VALUES(?)";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(query);

		//	statement.setInt(1, message.getId());
			statement.setString(1, message.getMessage());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("A new row " + message.toString() + " was inserted successfully!");
			}
			
		} catch (Exception e) {

		} finally {
			JdbcUtils.closeResources(connection, statement);
		}
	}

	
	public List<Message> getMessagesList() {
		
		System.out.println("In Dao messages list called");

		List<Message> msgList = new ArrayList<Message>();

		String query = "SELECT * FROM messagetab";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Message message = new Message();

				message.setId(resultSet.getInt("id"));
				message.setMessage(resultSet.getString("message"));

				msgList.add(message);
			}
		} catch (Exception e) {

		} finally {
			JdbcUtils.closeResources(connection, statement, resultSet);
		}
		return msgList;
	}

	
	public void deleteMessageById(int id) {
		
		String query = "delete from messagetab where id = ?";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("A new row with id " + id + " was deleted successfully!");
			}
		

		} catch (Exception e) {

		} finally {
			JdbcUtils.closeResources(connection, statement);
		}
	}
//
//	public Message getRowByPassword(String password) {
//		String query = "SELECT * FROM messagetable WHERE password= ?";
//
//		Message message = new Message();
//
//		try {
//			connection = getConnection();
//			statement = connection.prepareStatement(query);
//			statement.setString(1, password);
//			resultSet = statement.executeQuery();
//			resultSet.next();
//
//			message.setId(resultSet.getInt("id"));
//			message.setPassword(resultSet.getString("password"));
//			message.setMessage(resultSet.getString("message"));
//			message.setTimeCrteated(resultSet.getString("timeCreated"));
//
//			statement.execute();
//
//		} catch (Exception e) {
//
//		} finally {
//			JdbcUtils.closeResources(connection, statement, resultSet);
//		}
//		return message;
//
//	}

	
}
