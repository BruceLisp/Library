package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDbTools;
import vo.User;

/**
 * Servlet implementation class URegisterConfirm
 */
@WebServlet("/URegisterConfirm")
public class URegisterConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public URegisterConfirm() {
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
		HttpSession session = request.getSession();
		if(request.getParameter("index").equals("1")){
			User user = new User(request.getParameter("id"),request.getParameter("username"),request.getParameter("password"),
					request.getParameter("email"),request.getParameter("phone"));
			UsersDbTools usersDbTools = new UsersDbTools();
			if(usersDbTools.registerConfirm(user)){//手机号码或者学号已被注册
				usersDbTools.close();//关闭连接
				session.setAttribute("rindex", "false");
				response.sendRedirect("usersRegister.jsp");
			}else{		//手机号码或者学号未被注册，执行。
				usersDbTools.register(user);
				session.setAttribute("index", "true");
				response.sendRedirect("usersLogin.jsp");
			}
		}else{
			session.setAttribute("rindex", "true");
			response.sendRedirect("usersRegister.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if(request.getParameter("index").equals("1")){
			User user = new User(request.getParameter("id"),request.getParameter("username"),request.getParameter("password"),
					request.getParameter("email"),request.getParameter("phone"));
			UsersDbTools usersDbTools = new UsersDbTools();
			if(usersDbTools.registerConfirm(user)){//手机号码或者学号已被注册
				usersDbTools.close();//关闭连接
				session.setAttribute("rindex", "false");
				response.sendRedirect("usersRegister.jsp");
			}else{		//手机号码或者学号未被注册，执行。
				usersDbTools.register(user);
				session.setAttribute("index", "true");
				response.sendRedirect("usersLogin.jsp");
			}
		}else{
			session.setAttribute("rindex", "true");
			response.sendRedirect("usersRegister.jsp");
		}
	}

}
