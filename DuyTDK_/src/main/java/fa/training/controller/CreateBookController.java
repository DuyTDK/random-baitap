package fa.training.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.AuthorDAO;
import fa.training.dao.AuthorDAOImpl;
import fa.training.dao.BookDAO;
import fa.training.dao.BookDAOImpl;
import fa.training.model.Author;
import fa.training.model.Book;

/**
 * Servlet implementation class test
 */
@WebServlet("/create")
public class CreateBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateBookController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AuthorDAO authorDAO = new AuthorDAOImpl();
		try {
			List<Author> authors = authorDAO.getAllAuthor();
			request.setAttribute("authors", authors);
//			response.getWriter().print(authors);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("view/CreateBook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDAO bookDAO = new BookDAOImpl();
		AuthorDAO authorDAO = new AuthorDAOImpl();

		String title = request.getParameter("Title");
		int pageCount = Integer.parseInt(request.getParameter("Page_Count"));
		int price = Integer.parseInt(request.getParameter("Price"));
		Date datePublished = Date.valueOf(request.getParameter("Date_published"));
		int authorId = Integer.parseInt(request.getParameter("Author_id"));
		int status = Integer.parseInt(request.getParameter("Status"));

		Book book = new Book();
		book.setTitle(title);
		book.setPage_Count(pageCount);
		book.setPrice(price);
		book.setDate_Published(datePublished);
		book.setStatus(status);
		book.setAuthor_ID(authorId);
		try {
			response.getWriter().print(bookDAO.addBook(book));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}