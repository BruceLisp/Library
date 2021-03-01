package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BooksDbTools;
import service.CalculateDate;

/**
 * Servlet implementation class RenewBook
 */
@WebServlet("/RenewBook")
public class RenewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RenewBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int days = new Integer(request.getParameter("index"));
		String bid = request.getParameter("bid");
		System.out.println("Ö´ÐÐ³É¹¦"+"   "+bid+"  "+days);
		BooksDbTools booksDbTools = new BooksDbTools();
		String deadline = booksDbTools.selectBookDeadLine(bid);
		deadline = CalculateDate.calculate(deadline, days);
		booksDbTools.renewBook(bid, deadline);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
