package fa.training.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.MemberDAO;
import fa.training.dao.MemberDAOImpl;
import fa.training.entity.Member;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/MemberUpdateController")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDAO memberDAO = new MemberDAOImpl();
		String firstname = request.getParameter("Firstname");
		String lastname = request.getParameter("Lastname");
		String phone = request.getParameter("Phone");
		String description = request.getParameter("Description");
		HttpSession session = request.getSession();
		Member currentUser = (Member)session.getAttribute("member");
		try {
			if(memberDAO.UpdateMember(currentUser.getId(), firstname, lastname, phone, description)) {
				request.setAttribute("message", "Profile updated sucessfully!");
				currentUser.setFirstname(firstname);
				currentUser.setLastname(lastname);
				currentUser.setPhone(phone);
				currentUser.setDescription(description);
				session.setAttribute("member", currentUser);
				request.getRequestDispatcher("View/editProfile.jsp").forward(request, response);
				//				response.getWriter().print(currentUser.getFirstname());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
