package com.quintrix.jfs;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DatabaseDemo {
	public static void main(String[] args) {
		Connection connection = null;
		Statement insertStmt = null;
		Statement selectStmt = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDemo", "root", "root");
			
			/*insertStmt = connection.createStatement();
		    insertStmt.execute("INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,STAT_CD) VALUES (17,'Xu','Shang-Chi',10)");
		    insertStmt.execute("INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,STAT_CD) VALUES (18,'Marc','Spector',10)");*/
		      
			selectStmt = connection.createStatement();
			ResultSet rs = selectStmt.executeQuery("SELECT ID,FIRST_NAME,LAST_NAME,STAT_CD FROM EMPLOYEE WHERE STAT_CD = 10");
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				selectStmt.close();
				insertStmt.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
