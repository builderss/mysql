package mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by eagle on 16/6/8.
 */
public class User {
    private  int ID_user = 0;
    private  String password = null;
    private  String name_user = null;
    private  String address_loc = null;
    private  String phoneNum = null;
    private  String content_desc_user = null;

    public User(int id, String name, String password, String address, String phoneNum) {
        this.ID_user = id;
        this.name_user =name;
        this.password = password;
        this.address_loc = address;
        this.phoneNum = phoneNum;
    }
    
    public void setPassword(String pwd) {
    	password = pwd;
    }
    
    public void setPhoneNum(String tel) {
    	phoneNum = tel;
    }
    
    public void addNewUser() {
    	JDB mySQL = new JDB();
    	mySQL.connSQL();
    	
    	String newUser = "insert into Users(ID_user, password, name_user, address_loc, phoneNumber) " + 
    			"values" + "('" + Integer.toString(ID_user) + "', '" + password + "','" + name_user + "', '"
    			+ address_loc + "', '" + phoneNum +"')";
    	if(mySQL.insertSQL(newUser) == true) {
    		System.out.println("---------Add----NewUser----Success--------");
    	}
    	
    	mySQL.disconnSQL();    			
    }
    
    public boolean comparePWD(int UserID, String InputPwd) {
    	String ID = Integer.toString(UserID);
    	String quriedPwd = null;
    	JDB mySQL = new JDB();
    	mySQL.connSQL();
    	
    	String select = "select password from Users where ID_user = '" + ID + "'";
    	ResultSet rs = mySQL.selectSQL(select);
    	
    	try{
    		if(rs.next())	quriedPwd = rs.getString(1);
    		System.out.println(quriedPwd);
    		if(quriedPwd.equals(InputPwd)){
    			mySQL.disconnSQL();
    			return true;  			 
    		}
    	} catch (SQLException e) {
    		System.out.println("UserID doesn't exist or Wrong password");
    		e.printStackTrace();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	 
    	mySQL.disconnSQL(); 
    	return false;
    }

}
