package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	
	static String url="jdbc:mysql://localhost:3307/hrms_ajax";
	static String userName = "root";
	static String password="";
	public static Connection getConnetion() throws ClassNotFoundException, SQLException
	{
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,userName,password);
		if(con!=null)
		{
			System.out.println("Connection created");
		}
		return con;
		
	}
	
	

}
