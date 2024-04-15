package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.entity.Content;
import fa.training.util.DBUtils;
import fa.training.util.SQLCommand;

public class ContentDAOImpl implements ContentDAO {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;

	@Override
	public boolean AddContent(String title, String brief, String content, int authorId) throws SQLException {
		// TODO Auto-generated method stub
		boolean isAdded = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.ADD_CONTENT);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, brief);
			preparedStatement.setString(3, content);
			preparedStatement.setInt(4, authorId);
			preparedStatement.executeUpdate();
			isAdded = true;
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
		return isAdded;
	}

	@Override
	public List<Content> GetAllContent() throws SQLException {
		// TODO Auto-generated method stub
		List<Content> contents = new ArrayList<>(); 
		Content content = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.GET_ALL_CONTENT); 
			results = preparedStatement.executeQuery();
			while(results.next()) {
				content = new Content();
				content.setId(results.getInt("id"));
				content.setTitle(results.getString("Title"));
				content.setBrief(results.getString("Brief"));
				content.setContent(results.getString("Content"));
				content.setCreatedDate(results.getDate("CreatedDate"));				
				content.setUpdateTime(results.getDate("UpdateTime"));				
				content.setSort(results.getInt("Sort"));				
				content.setAuthorId(results.getInt("AuthorId"));				
				contents.add(content);
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
		return contents;
	}
}
