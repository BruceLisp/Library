package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Book;
import vo.Varity;

public class VarityDbtools {
	PreparedStatement pstmt;
	Connection conn;
	public VarityDbtools(){		//通过数据库连接，获得连接
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
	
	public ArrayList<Varity> selectVarity() {
		String sql = "select * from Varity";
		ArrayList<Varity> list = new ArrayList<Varity>();
		Varity varity = null;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				varity = new Varity(rs.getInt(1),rs.getString(2));	
				list.add(varity);
			}
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		//预处理
		return list;
	}	
	
	
	public ArrayList<Varity> selectVarities(int index) {
		String str = String.valueOf(index)+"%";
		String sql = "select * from Varities where Vsid like ?";
		ArrayList<Varity> list = new ArrayList<Varity>();
		Varity varity = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				varity = new Varity(rs.getInt(1),rs.getString(2));	
				list.add(varity);
			}
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		//预处理
		return list;
	}	
}