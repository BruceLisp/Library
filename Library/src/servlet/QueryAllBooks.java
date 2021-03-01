package servlet;

import java.io.IOException;
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
 * Servlet implementation class QueryAllBooks
 */
@WebServlet("/QueryAllBooks")
public class QueryAllBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Book> list = null;
		String index = request.getParameter("index");
		BooksDbTools booksDbTools = new BooksDbTools();
		if(index.equals("1")){
			list = booksDbTools.selectAll();			
		}else{
			String search = request.getParameter("searchText");
			booksDbTools.selectAll();//修改数据库连接代码（将searchText作为参数传过去，模糊搜索）
		}
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		response.sendRedirect("booksTable.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}
}
