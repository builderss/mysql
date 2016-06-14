package mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Goods {
	private int ID_owner = 0;
	private int ID_goods = 0;
	private int ID_category = 0;
	private String name_goods = "";
	private float rent = 0;
	private String pic_goods = null;
	private boolean status_goods_isBorrowed = false;
	private boolean status_goods_isDamaged = false;
	private String content_desc_goods = null;
	
	public Goods(int id_owner, int id_goods, int id_category, String goodsName, float goodsRent, String pic){
		ID_owner = id_owner;
		ID_goods = id_goods;
		ID_category = id_category;
		name_goods = goodsName;
		rent = goodsRent;
		pic_goods = pic;
	}
	
	public void addNewGoods(){
		JDB mySQL = new JDB();
		mySQL.connSQL();
		
		String newGoods = "insert into Goods(ID_user, ID_goods, ID_category, name_goods, rent, pic_goods, status_goods_isBorrowed, status_goods_isDamaged, content_desc_goods)" +
				"values" + "('" + Integer.toString(ID_owner) + "','" + Integer.toString(ID_goods) + "','" + "0" + "','" + name_goods + "','" + Float.toString(rent) + "','" +
				pic_goods + "','" + "0" + "','" + "0" + "','" + content_desc_goods + "')";
		if(mySQL.insertSQL(newGoods) == true) {
			System.out.println("------Add----NewGoods----Succcess----");
		}
		
		mySQL.disconnSQL();
	}
	
	public void matchGoods(int id_goods) {
		 JDB mySQL = new JDB();
		 mySQL.connSQL();
		 
		 String select = "select * from Goods where ID_goods = '" + Integer.toString(id_goods) + "'";
		 ResultSet rs = mySQL.selectSQL(select);
		 
		 try{
			 if(rs.next()){
				 ID_owner = rs.getInt(1);
				 ID_goods = rs.getInt(2);
				 ID_category = rs.getInt(3);
				 name_goods = rs.getString(4);
				 rent = rs.getFloat(5);
				 pic_goods = rs.getString(6);
				 status_goods_isBorrowed = rs.getBoolean(7);
				 status_goods_isDamaged = rs.getBoolean(8);
				 content_desc_goods = rs.getString(9);
			 }
			 System.out.println("-----Match----Goods----Success----");
			 System.out.println(Integer.toString(ID_owner) + Boolean.toString(status_goods_isDamaged) + content_desc_goods);
			 
		 } catch (SQLException e) {
			 System.out.println("Goods match failed");
			 e.printStackTrace();
		 } catch (Exception e) {
			 e.printStackTrace();	 
		 }
		 
		 mySQL.disconnSQL();
	}
	
}
