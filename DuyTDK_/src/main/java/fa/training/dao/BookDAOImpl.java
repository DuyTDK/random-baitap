package fa.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.model.Book;
import fa.training.util.DBUtils;
import fa.training.util.SQLCommand;

public class BookDAOImpl implements BookDAO {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;

	@Override
	public boolean addBook(Book book) throws SQLException {
		boolean isSaved = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.ADD_BOOK);
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setInt(2, book.getPage_Count());
			preparedStatement.setDate(3, book.getDate_Published());
			preparedStatement.setInt(4, book.getPrice());
			preparedStatement.setInt(5, book.getStatus());
			preparedStatement.setInt(6, book.getAuthor_ID());
			preparedStatement.executeUpdate();
			isSaved = true;
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
		return isSaved;
	}


	@Override
	public boolean updateBookById(int book_ID, String title, int page_Count, Date date_Published, int price, int status, int author_ID) throws SQLException {
		boolean isUpdated = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_BOOK);
			preparedStatement.setString(1, title);		
			preparedStatement.setInt(2, page_Count);
			preparedStatement.setDate(3, date_Published);
			preparedStatement.setInt(4, price);		
			preparedStatement.setInt(5, status);
			preparedStatement.setInt(6, author_ID);
			preparedStatement.executeUpdate();
			isUpdated = true;
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
		return isUpdated;
	}

	@Override
	public List<Book> getAllBooks() throws SQLException {
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<>(); 
		Book book = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.GET_ALL_BOOK); 
			results = preparedStatement.executeQuery();
			while(results.next()) {
				book = new Book();
				book.setBook_ID(results.getInt("Book_ID"));
				book.setTitle(results.getString("Title"));
				book.setPage_Count(results.getInt("Page_Count"));
				book.setDate_Published(results.getDate("Date_published"));			
				book.setPrice(results.getInt("Price"));				
				book.setStatus(results.getInt("Status"));				
				book.setAuthor_ID(results.getInt("Author_id"));				
				books.add(book);
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
		return books;
	}





}
