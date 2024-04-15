package fa.training.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.ContentDAO;
import fa.training.dao.ContentDAOImpl;
import fa.training.entity.Member;

/**
 * Servlet implementation class AddContentController
 */
@WebServlet("/AddContentController")
public class AddContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("view/addContent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContentDAO contentDAO = new ContentDAOImpl();
		String title = request.getParameter("titlename");
		String brief = request.getParameter("brief");
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		Member currentUser = (Member) session.getAttribute("member");
		try {
			if(contentDAO.AddContent(title, brief, content, currentUser.getId())) {
				request.setAttribute("message", "Content added");
				request.getRequestDispatcher("View/addContent.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//fix varchar size in sql to > 50
	}

}
