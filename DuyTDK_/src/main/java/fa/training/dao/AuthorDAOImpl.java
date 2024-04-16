package fa.training.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.model.Author;
import fa.training.util.DBUtils;
import fa.training.util.SQLCommand;

public class AuthorDAOImpl implements AuthorDAO{

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;
	
	@Override
	public List<Author> getAllAuthor() throws SQLException {
		List<Author> authors = new ArrayList<>(); 
		Author author = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.GET_ALL_AUTHOR); 
			results = preparedStatement.executeQuery();
			while(results.next()) {
				author = new Author();
				author.setAuthor_ID(results.getInt("Author_Id"));
				author.setAuthor_Name(results.getString("Auhtor_Name"));		
				authors.add(author);
			}
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return authors;
	}

}
