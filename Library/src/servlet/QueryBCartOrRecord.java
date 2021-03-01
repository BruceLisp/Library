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
 * Servlet implementation class QueryBCartOrRecord
 */
@WebServlet("/QueryBCartOrRecord")
public class QueryBCartOrRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryBCartOrRecord() {
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
		if(index.equals("1")){		//����1��תͼ��Ԥ����棬����Ԥ���鱾
			BooksDbTools booksDbTools = new BooksDbTools();
			ArrayList<Book> list = booksDbTools.selectBookCart(userId);
			HttpSession session = request.getSession();
			session.setAttribute("clist", list);
			session.setAttribute("id", userId);
			response.sendRedirect("BookCart.jsp");
		}else{			//����2��תͼ����ļ�¼���棬����ͼ����ļ�¼
			BooksDbTools booksDbTools = new BooksDbTools();
			ArrayList<Book> list = booksDbTools.selectRecord(userId);
			HttpSession session = request.getSession();
			session.setAttribute("rlist", list);
			session.setAttribute("id", userId);
			response.sendRedirect("BorrowedRecord.jsp");
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
