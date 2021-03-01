package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDb {
	Connection SurveyCon;
	public ConnectDb(){
		// TODO Auto-generated constructor stub
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=BookManagement";
	    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	    try {
			Class.forName(driver);
			SurveyCon = DriverManager.getConnection(url,"sa","123456");	//获取连接
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//加载驱动
	}
	
	public Connection getConnection(){
	    return SurveyCon;
	}
}