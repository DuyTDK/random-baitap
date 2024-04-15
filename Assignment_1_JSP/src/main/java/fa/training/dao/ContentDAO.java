package fa.training.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.entity.Content;

public interface ContentDAO {
	public boolean AddContent(String title, String brief, String content, int authorId) throws SQLException;
	
	public List<Content> GetAllContent() throws SQLException; 
}
