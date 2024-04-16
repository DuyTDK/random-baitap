package fa.training.model;

import java.sql.*;

public class Book {
	private int Book_ID;
	private String Title;
	private int Page_Count;
	private Date Date_Published;
	private int Price;
	private int Status;
	private int Author_ID;

	public Book() {

		// TODO Auto-generated constructor stub
	}

	public Book(int book_ID, String title, int page_Count, Date date_Published, int price, int status, int author_ID) {
		super();
		Book_ID = book_ID;
		Title = title;
		Page_Count = page_Count;
		Date_Published = date_Published;
		Price = price;
		Status = status;
		Author_ID = author_ID;
	}

	public int getBook_ID() {
		return Book_ID;
	}

	public void setBook_ID(int book_ID) {
		Book_ID = book_ID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public int getPage_Count() {
		return Page_Count;
	}

	public void setPage_Count(int page_Count) {
		Page_Count = page_Count;
	}

	public Date getDate_Published() {
		return Date_Published;
	}

	public void setDate_Published(Date date_Published) {
		Date_Published = date_Published;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public int getAuthor_ID() {
		return Author_ID;
	}

	public void setAuthor_ID(int author_ID) {
		Author_ID = author_ID;
	}

}
