package fa.training.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import fa.training.model.Book;

public interface BookDAO {
	
	
	public boolean updateBookById(int book_ID, String title, int page_Count, Date date_Published, int price, int status, int author_ID) throws SQLException;

	public boolean addBook(Book book) throws SQLException;
	
	public List<Book> getAllBooks() throws SQLException;
	

}

