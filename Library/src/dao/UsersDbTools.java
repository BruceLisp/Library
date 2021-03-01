package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.User;

public class UsersDbTools {
	PreparedStatement pstmt;
	Connection conn;
	public UsersDbTools(){		//ͨ�����ݿ����ӣ��������
		// TODO Auto-generated constructor stub
		ConnectDb connectDb = new ConnectDb();
		conn = connectDb.getConnection();
	}
	
	public void close(){		//�ر�����
		try {
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isExist(String uId,String uPassword) {
		String sql = "select * from Users where (Uid=? or UPhone=?) and UPassword=?";
		boolean isExist = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uId);
			pstmt.setString(2, uId);
			pstmt.setString(3, uPassword);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				isExist = true;
			}		
			pstmt.close();
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}		//Ԥ����
		return isExist;
	}
	
	public boolean registerConfirm(User user) {
		String sql = "select * from Users where Uid=? or UPhone=?";
		boolean isExist = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUid());
			pstmt.setString(2, user.getUPhone());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				isExist = true;
			}		
			pstmt.close();
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}		//Ԥ����
		return isExist;
	}
	
	public void register(User user) {
		String sql = "insert into Users values(?,?,?,"
				+ "(select DATENAME(YEAR,GETDATE())+'/'+DATENAME(MONTH,GETDATE())+'/'+DATENAME(DAY,GETDATE())),?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUid());
			pstmt.setString(2, user.getUname());
			pstmt.setString(3, user.getUPhone());
			pstmt.setString(4, user.getUEmail());
			pstmt.setString(5, user.getUPhone());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}		//Ԥ����
		close();
	}
	
	public User getUser(String userId) {
		String sql = "select * from Users where Uid=?";
		User user = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			user = new User(rs.getString("Uid"), rs.getString("UName"), rs.getString("UPassword"),
					rs.getString("URegDate"), rs.getString("UEmail"), rs.getString("URegDate"));
			pstmt.close();
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}		//Ԥ����		
		close();
		return user;
	}
	
	public void modifyMess(String id,String name,String email){
		String sql = "update Users set UName = ?,UEmail = ? where Uid = ?";
		try {		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);//���ò���
			pstmt.setString(2, email);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		//Ԥ����
		close();
	}
	
	public void modifyPass(String id,String password){
		String sql = "update Users set UPassword = ? where Uid = ?";
		try {		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);//���ò���
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		//Ԥ����
		close();
	}
	
}
