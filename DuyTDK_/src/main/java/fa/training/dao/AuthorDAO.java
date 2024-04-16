package fa.training.dao;

import java.sql.SQLException;
import java.util.List;

import fa.training.model.Author;

public interface AuthorDAO {

	public List<Author> getAllAuthor() throws SQLException;
	
}
