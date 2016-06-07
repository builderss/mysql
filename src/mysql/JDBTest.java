package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBTest {
	Connection conn = null;
	PreparedStatement statement = null;
	
	//connect to MySQL
	void connSQL() {
		String url = "jdbc:mysql://localhost:3306/Share?characterEncoding = UTF-8";
		String userName = "root";	
		String password = "503851380tlk";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");			
			conn = DriverManager.getConnection(url, userName, password);
			
		} catch (ClassNotFoundException cnfex) {
			System.err.println("Load JDBC Driver Failed");
			cnfex.printStackTrace();
			
		} catch (SQLException sqlex){
			System.err.println("Cannot connect to Server");
			sqlex.printStackTrace();
		}
	}
	
	//disconnect to MySQL
	void disconnSQL() {
		try{
			if(conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println("Failed to close DataBase");
			e.printStackTrace();
		}
	}
	
	//execute selection language
	ResultSet selectSQL(String sql) {
		ResultSet rs = null;
		try{
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//execute insertion language
	boolean insertSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Failed when insert in DataBase");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Failed when insert data");
			e.printStackTrace();
		}
		return false;
	}
	
	//execute delete language
	boolean deleteSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Failed when delete in DataBase");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Faild when delete data");
			e.printStackTrace();
		}
		return false;
	}
	
	boolean updateSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Failed when update in DataBase");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Failed when update data");
		}
		return false;
	}
	
	void layout(ResultSet rs){
		System.out.println("ID\tName");
		try{
			while(rs.next()){
				System.out.println(rs.getString(1) + "\t" + rs.getString(2));
			}	
		} catch (SQLException e){
			System.out.println("Display fault in DataBase");
			e.printStackTrace();		
		} catch (Exception e){
			System.out.println("Display fault");
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		
		JDBTest test = new JDBTest();
		test.connSQL();
		
		String select = "select * from student";
		String insert = "insert into student(NO,name) values('2012001', 'xiaohei')";
		String update = "update student set name='xiaobai' where NO='2012004'";
		String delete = "delete from student where NO='2012004'";
		
		if(test.insertSQL(insert) == true){
			System.out.println("--------insert successfully------");
			ResultSet rs = test.selectSQL(select);
			test.layout(rs);	
		}
		
		if(test.updateSQL(update) == true){
			System.out.println("---------update successfully-------");
			ResultSet rs = test.selectSQL(select);
			test.layout(rs);
		}
		
		if(test.deleteSQL(delete) == true){
			System.out.println("---------delete successfully---------");
			ResultSet rs = test.selectSQL(select);
			test.layout(rs);
		}
		
		test.disconnSQL();
		
	}	
}
