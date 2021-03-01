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
 * Servlet implementation class QueryBooksCart
 */
@WebServlet("/QueryBooksCart")
public class QueryBooksCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryBooksCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String index = request.getParameter("index");
		String userId = request.getParameter("id");
		System.out.println("****"+index+"**"+userId);
		if(index.equals("1")){		//等于1跳转图书预借界面，加载预借书本
			BooksDbTools booksDbTools = new BooksDbTools();
			ArrayList<Book> list = booksDbTools.selectBookCart(userId);
			HttpSession session = request.getSession();
			session.setAttribute("clist", list);
			session.setAttribute("id", userId);
			response.sendRedirect("BookCart.jsp");
		}else{			//等于2跳转图书借阅记录界面，加载图书借阅记录
             //	........		
            //	........
            //	........
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
