package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Book;

public class BooksDbTools {
	PreparedStatement pstmt;
	Connection conn;
	public BooksDbTools(){		//通过数据库连接，获得连接
		// TODO Auto-generated constructor stub
		ConnectDb connectDb = new ConnectDb();
		conn = connectDb.getConnection();
	}
	
	public void close(){		//关闭连接
		try {
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Book> selectAll() {
		String sql = "select * from Books";
		ArrayList<Book> list = new ArrayList<Book>();
		Book book = null;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				book = new Book(rs.getString("Bid"),rs.getString("BName"),rs.getString("BProductor"),rs.getInt("IsBorrowed"),rs.getString("BAuthor"));	
				list.add(book);
			}
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		//预处理
		close();
		return list;
	}
	
	public void changeCondition(String bid,String id){
		String sqls = "select * from Books where Bid = ?";
		String sql = "update Books set IsBorrowed = ?,BUsersId = ? where Bid = ?";
		int condition = 1;
		try {
			pstmt = conn.prepareStatement(sqls);
			pstmt.setString(1, bid);//设置参数
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			if(rs.getInt("IsBorrowed")==1){
				condition=2;
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, condition);//设置参数
			pstmt.setString(2, id);
			pstmt.setString(3, bid);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		//预处理
		close();
	}
	
	
	public String selectBookDeadLine(String bid) {
		String sql = "select DeadLine from Record where Bid = ?";
		ArrayList<Book> list = new ArrayList<Book>();
		String date = "1995/9/2";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bid);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			date = rs.getString("DeadLine");
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		//预处理
		return date;
	}
	
	
	public void renewBook(String bid,String deadline){
		String sql = "update Record set DeadLine = ? where Bid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deadline);//设置参数
			pstmt.setString(2, bid);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		//预处理
		close();
	}
	
	public ArrayList<Book> selectVarify(String index) {
		String sql = "select * from Books where BType = ?";
		ArrayList<Book> list = new ArrayList<Book>();
		Book book = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, index);//设置参数
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				book = new Book(rs.getString("Bid"),rs.getString("BName"),rs.getString("BProductor"),rs.getInt("IsBorrowed"),rs.getString("BAuthor"));	
				list.add(book);
			}
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		//预处理
		close();
		return list;
	}
	
	public ArrayList<Book> selectBookCart(String index) {
		String sql = "select * from Books where BUsersId = ? and IsBorrowed = 2";
		ArrayList<Book> list = new ArrayList<Book>();
		Book book = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, index);//设置参数
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				book = new Book(rs.getString("Bid"),rs.getString("BName"),rs.getString("BProductor"),rs.getInt("IsBorrowed"),rs.getString("BAuthor"));	
				list.add(book);
			}
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		//预处理
		close();
		return list;
	}
	
	public ArrayList<Book> selectRecord(String id){
		String sql = "select Books.Bid,Books.BName,Books.IsBorrowed,Books.BProductor,Books.BAuthor,Record.Date,Record.DeadLine from Books,Record where Books.Bid in "
				+ "(select Bid from Record where Uid = ?) and Books.Bid = Record.Bid";
		ArrayList<Book> list = new ArrayList<Book>();
		Book book = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);//设置参数
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				book = new Book(rs.getString("Bid"),rs.getString("BName"),rs.getString("BProductor"),rs.getInt("IsBorrowed"),
						rs.getString("BAuthor"),rs.getString("Date"),rs.getString("DeadLine"));	
				list.add(book);
			}
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		//预处理
		close();
		return list;
	}
	
	
	
	public ArrayList<Book> blurSelect(String index){
		ArrayList<Book> list = new ArrayList<Book>();
		String sql = "select * from Books where Bid like ? or BAuthor like ? or BName like ?";
		Book book = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,index+"%");
			pstmt.setString(2,"%"+index+"%");
			pstmt.setString(3,"%"+index+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				book = new Book(rs.getString("Bid"),rs.getString("BName"),rs.getString("BProductor"),rs.getInt("IsBorrowed"),rs.getString("BAuthor"));	
				list.add(book);
			}	
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		//预处理
		close();
		return list;
	}
	
	
	
}


//public ScoreRecord select(String no) {
//	String sql = "select * from record where no=?";
//	ScoreRecord sr = null;
//	try {
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1,no);
//		ResultSet rs = pstmt.executeQuery();
//		rs.next();
//		sr = new ScoreRecord(rs.getString("no"), rs.getString("name"),
//				rs.getInt("ds"),rs.getInt("db"), rs.getInt("java"), rs.getInt("web"));			
//		pstmt.close();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}		//预处理
//	return sr;
//}
//
//public ArrayList<ScoreRecord> selectAll() {
//	ArrayList<ScoreRecord> list = new ArrayList<ScoreRecord>();
//	String sql = "select * from record";
//	ScoreRecord sr = null;
//	try {
//		pstmt = conn.prepareStatement(sql);
//		ResultSet rs = pstmt.executeQuery();
//		while(rs.next()){
//			sr = new ScoreRecord(rs.getString("no"), rs.getString("name"),
//					rs.getInt("ds"),rs.getInt("db"), rs.getInt("java"), rs.getInt("web"));	
//			list.add(sr);
//		}
//		pstmt.close();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}		//预处理
//	return list;
//}
//
//public void delete(String no) {
//	String sql = "delete from record where no=?";
//	try {
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1,no);//设置参数
//		pstmt.executeUpdate();
//		pstmt.close();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}		//预处理
//}
//
//
//public void updata(ScoreRecord rs,String no) {
//	String sql = "update record set no=?,name=?,db=?,ds=?,java=?,web=? where no=?";
//	try {
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1,rs.getNo());//设置参数
//		pstmt.setString(2,rs.getName());
//		pstmt.setInt(3,rs.getDb());
//		pstmt.setInt(4,rs.getDs());
//		pstmt.setInt(5,rs.getJava());
//		pstmt.setInt(6,rs.getWeb());
//		pstmt.setString(7,no);
//		pstmt.executeUpdate();
//		pstmt.close();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}		//预处理
//}
//
//public void insert(ScoreRecord rs) {
//	String sql = "insert into record values(?,?,?,?,?,?)";
//	try {
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1,rs.getNo());//设置参数
//		pstmt.setString(2,rs.getName());
//		pstmt.setInt(3,rs.getDb());
//		pstmt.setInt(4,rs.getDs());
//		pstmt.setInt(5,rs.getJava());
//		pstmt.setInt(6,rs.getWeb());
//		pstmt.executeUpdate();
//		pstmt.close();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}		//预处理
//}