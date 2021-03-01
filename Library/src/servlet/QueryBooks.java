package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BooksDbTools;
import vo.Book;

/**
 * Servlet implementation class QueryBooks
 */
@WebServlet("/QueryBooks")
public class QueryBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String index = MyUTF.getNewString(request.getParameter("index"));
		BooksDbTools booksDbTools = new BooksDbTools();
		ArrayList<Book> list = booksDbTools.blurSelect(index);
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		response.sendRedirect("booksTable.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	public static class MyUTF {
		public static String getNewString(String str) throws UnsupportedEncodingException{
			return new String(str.getBytes("ISO-8859-1"),"UTF-8");
		}
	}
}
