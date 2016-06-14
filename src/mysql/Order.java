package mysql;

public class Order {
	private int ID_order = 0;
	private int ID_borrower = 0;
	private int ID_goods = 0;
	private int ID_owner = 0;
	
	private String date_get = null;
	private String date_startUse = null;
	private String date_endUse = null;
	private String date_return = null;
	
	private String address_get = null;
	private String address_return = null;
	
	private String judge_goods = null;
	private String judge_owner = null;
	private String judge_borrower = null;
	
	private boolean status_isConfirmed = false;
	private boolean status_isGet = false;
	private boolean status_isReturned = false;
	private boolean status_isCompleted = false;
	
	public Order() {}
	
	public Order(int id_order, int id_borrower, int id_goods, int id_owner, String getDate, String returnDate){
		ID_order = id_order;
		ID_borrower = id_borrower;
		ID_goods = id_goods;
		ID_owner = id_owner;
		date_get = getDate;
		date_return = returnDate;
	}
	
	public void addNewOrder() {
		JDB mySQL = new JDB();
		mySQL.connSQL();
		
		String newOrder = "insert into Orders(ID_order, ID_borrower, ID_goods, Use_ID_user, date_get, date_return, status_order_isCompleted)" +
				"values" + "('" + Integer.toString(ID_order) + "','" + Integer.toString(ID_borrower) + "','" + Integer.toString(ID_goods) +"','" +
				Integer.toString(ID_owner) + "','" + date_get + "','" + date_return + "','" + "0" + "')";
		if(mySQL.insertSQL(newOrder) == true) {
			System.out.println("-------Add----NewOrder----Success----");
		}
		
		mySQL.disconnSQL();
	}
	
	public void setAppointment(int orderID) {
		JDB mySQL = new JDB();
		mySQL.connSQL();
		
		String update = "update Orders set status_order_isConfirmed = '1' where ID_order = '" + Integer.toString(orderID) + "'";
		if(mySQL.updateSQL(update) == true) {
			System.out.println("----Set----Appointment----Success----");
		}
		
		mySQL.disconnSQL();
	}
	
	public void setGet(int orderID) {
		JDB mySQL = new JDB();
		mySQL.connSQL();
		
		String update = "update Orders set status_order_isGet = '1' where ID_order = '" + Integer.toString(orderID) + "'";
		if(mySQL.updateSQL(update) == true) {
			System.out.println("----Set----Get----Success----");
		}
		
		mySQL.disconnSQL();
	}
	
	public void setReturn(int orderID){
		JDB mySQL = new JDB();
		mySQL.connSQL();
		
		String update = "update Orders set status_order_isReturned = '1' where ID_order = '" + Integer.toString(orderID) + "'";
		if(mySQL.updateSQL(update) == true) {
			System.out.println("----Set----Return----Success----");
		}
		
		mySQL.disconnSQL();
	}
	
	public void setComplete(int orderID){
		JDB mySQL = new JDB();
		mySQL.connSQL();
		
		String update = "update Orders set status_order_isCompleted = '1' where ID_order = '" + Integer.toString(orderID) + "'";
		if(mySQL.updateSQL(update) == true) {
			System.out.println("----Set----Complete----Success----");
		}
		
		mySQL.disconnSQL();
	}
}
