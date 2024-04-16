package fa.training.util;

public class SQLCommand {
	public static String ADD_AUTHOR = "INSERT INTO Author(Author_Id,Auhtor_Name) VALUES (?,?);";
	public static String ADD_BOOK = "INSERT INTO Book(Book_ID,Title,Page_Count,Date_published,Price,Status,Author_id) VALUES (?,?,?,GETDATE(),?,?,?);";
	public static String UPDATE_BOOK = "UPDATE Book SET Title = ?,Page_Count = ?,Date_published = GETDATE() ,Price = ? ,Status =? ,Author_id =? WHERE Book_ID = ?;";
	public static String GET_ALL_BOOK ="SELECT * FROM Book";
	public static String GET_ALL_AUTHOR = "SELECT * FROM Author";
	
	
}
