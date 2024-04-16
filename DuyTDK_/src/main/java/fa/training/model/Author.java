package fa.training.model;

public class Author {
	private int Author_ID;
	private String Author_Name;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(int author_ID, String author_Name) {
		super();
		Author_ID = author_ID;
		Author_Name = author_Name;
	}

	public int getAuthor_ID() {
		return Author_ID;
	}

	public void setAuthor_ID(int author_ID) {
		Author_ID = author_ID;
	}

	public String getAuthor_Name() {
		return Author_Name;
	}

	public void setAuthor_Name(String author_Name) {
		Author_Name = author_Name;
	}
	
	
	
}
