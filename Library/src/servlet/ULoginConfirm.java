package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UsersDbTools;

/**
 * Servlet implementation class ULoginConfirm
 */
@WebServlet("/ULoginConfirm")
public class ULoginConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ULoginConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsersDbTools dbTools = new UsersDbTools();
		String index = request.getParameter("index");
		HttpSession session = request.getSession();
		if(index.equals("1")){
			session.setAttribute("index", "true");
			response.sendRedirect("usersLogin.jsp");
		}else if(index.equals("2")){
			String Uid,Password;
			Uid = request.getParameter("username");
			Password = request.getParameter("password");
			boolean isExist = dbTools.isExist(Uid, Password);
			if(isExist){
				session.setAttribute("userId", Uid);
				response.sendRedirect("LibraryHome.jsp");
			}else{
				session.setAttribute("index","false");
				response.sendRedirect("usersLogin.jsp");
			}
		}else{
			session.setAttribute("userId", "");
			response.sendRedirect("libraryHome.jsp");
		}
		dbTools.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsersDbTools dbTools = new UsersDbTools();
		String index = request.getParameter("index");
		HttpSession session = request.getSession();
		if(index.equals("1")){
			session.setAttribute("index", "true");
			response.sendRedirect("usersLogin.jsp");
		}else if(index.equals("2")){
			String Uid,Password;
			Uid = request.getParameter("username");
			Password = request.getParameter("password");
			boolean isExist = dbTools.isExist(Uid, Password);
			if(isExist){
				session.setAttribute("userId", Uid);
				response.sendRedirect("libraryHome.jsp");
			}else{
				session.setAttribute("index","false");
				response.sendRedirect("usersLogin.jsp");
			}
		}else{
			session.setAttribute("userId", "");
			response.sendRedirect("libraryHome.jsp");
		};	
	}

}
