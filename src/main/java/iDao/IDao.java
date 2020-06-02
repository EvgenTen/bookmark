package iDao;

import java.util.List;

import entities.Message;

public interface IDao {

	public void createMessage(Message message);
	
//	public Message getRowById(int id);
//	
//	public Message getRowByPassword(String password);
//	
	public List<Message> getMessagesList();
//	
//	public void updateRow(Message message);
//	
	public void deleteMessageById(int id);

}
