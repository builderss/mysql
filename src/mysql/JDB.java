package mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDB {
	Connection conn = null;
	PreparedStatement statement = null;
	
	//connect to MySQL
	void connSQL() {
		
//		String url = "jdbc:mysql://db4free.net:3306/sharing";
//      String userName = "sharing";
//      String password = "503851380";
		
	String url = "jdbc:mysql://127.0.0.1:3306/Share?characterEncoding = UTF-8";
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
		
		
		
		
//		//addUser		
//		User kkk = new User(503851380, "TK", "000000", "SCU", "10110");
//		kkk.addNewUser();
//		
//		//cmpPWD
//		int ID_User = 503851380;
//		String pwd = "123456";
//		boolean isCorrect = kkk.comparePWD(ID_User, pwd);
//		System.out.println(Boolean.toString(isCorrect));
		
//		//addGoods
//		Goods ttt = new Goods(503851380, 1, 1, "pen", 2, "1.jpg");
//		ttt.addNewGoods();
//		
//		//matchGoods
//		ttt.matchGoods(1);
		
//		//addOrder
//		Order lll = new Order(1, 503851380, 1, 503851380, "1995-12-12 12:12:12", "1995-12-12 12:12:13");
//		lll.addNewOrder();
//		//setAppointment
//		Order lll = new Order();
//		lll.setAppointment(1);
//		lll.setGet(1);
//		lll.setReturn(1);
//		lll.setComplete(1);
		
		
//		JDB test = new JDB();
//		test.connSQL();
//		
//		String select = "select * from student";
//		String insert = "insert into student(NO,name) values('2012002', 'xiaohei')";
//		String update = "update student set name='xiaobai' where NO='2012001'";
//		String delete = "delete from student where NO='2012004'";
//		
//		if(test.insertSQL(insert) == true){
//			System.out.println("--------insert successfully------");
//			ResultSet rs = test.selectSQL(select);
//			test.layout(rs);	
//		}
//		
//		if(test.updateSQL(update) == true){
//			System.out.println("---------update successfully-------");
//			ResultSet rs = test.selectSQL(select);
//			test.layout(rs);
//		}
//		
//		if(test.deleteSQL(delete) == true){
//			System.out.println("---------delete successfully---------");
//			ResultSet rs = test.selectSQL(select);
//			test.layout(rs);
//		}
//		
//		test.disconnSQL();
		
	}	
}
