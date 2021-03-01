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
 * Servlet implementation class ModifyMess
 */
@WebServlet("/ModifyMess")
public class ModifyMess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyMess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String index = request.getParameter("index");
		System.out.println(index);
		String id = request.getParameter("id");
		System.out.println(index+"  "+id);
		UsersDbTools usersDbTools = new UsersDbTools();
		HttpSession session = request.getSession();
		if(index.equals("1")){
			String name = request.getParameter("username");
			String email = request.getParameter("email");
			usersDbTools.modifyMess(id, name, email);
		}else if(index.equals("2")){
			String oldPass = request.getParameter("oldPass");
			if(usersDbTools.isExist(id, oldPass)){
				String password = request.getParameter("password");
				usersDbTools.modifyPass(id, password);
				response.sendRedirect("success.html");
			}else{
				session.setAttribute("mindex", "false");
				response.sendRedirect("modifyPass.jsp");
			}
		}else{
			session.setAttribute("mindex", "true");
			response.sendRedirect("modifyPass.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String index = request.getParameter("index");
		System.out.println(index);
		String id = request.getParameter("id");
		System.out.println(index+"  "+id);
		UsersDbTools usersDbTools = new UsersDbTools();
		HttpSession session = request.getSession();
		if(index.equals("1")){
			String name = request.getParameter("username");
			String email = request.getParameter("email");
			usersDbTools.modifyMess(id, name, email);
			response.sendRedirect("success.html");
		}else if(index.equals("2")){
			String oldPass = request.getParameter("oldPass");
			if(usersDbTools.isExist(id, oldPass)){
				String password = request.getParameter("password");
				usersDbTools.modifyPass(id, password);
				response.sendRedirect("success.html");
			}else{
				session.setAttribute("mindex", "false");
				response.sendRedirect("modifyPass.jsp");
			}
		}else{
			session.setAttribute("mindex", "true");
			response.sendRedirect("modifyPass.jsp");
		}
	}

}
