package fa.training.util;

public class SQLCommand {
	public static String LOGIN = "SELECT * FROM Member WHERE Email=? AND [Password]=?;";
	public static String UPDATE_MEMBER = "UPDATE Member SET Firstname =? , Lastname= ?, Phone=?, [Description] =?, UpdateTime = GETDATE()  WHERE id = ?;";
	public static String ADD_MEMBER = "INSERT INTO Member(Username, [Password], Email, CreatedDate, UpdateTime) VALUES (?,?,?,GETDATE(),GETDATE())";
	public static String ADD_CONTENT = "INSERT INTO Content(Title, Brief, Content, CreatedDate, UpdateTime, AuthorId) VALUES (?,?,?,GETDATE(),GETDATE(),?)";
	public static String GET_ALL_CONTENT = "SELECT * FROM Content";
	
}
