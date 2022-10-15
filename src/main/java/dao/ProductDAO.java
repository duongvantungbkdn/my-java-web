package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;

public class ProductDAO {
	public List<Product> getProducts() throws SQLException {
		List<Product> list = new ArrayList<>();
		
		DBContext db = new DBContext();
		Connection con = db.getConnection();
		
		if(con == null) {
			System.out.println("connect to DB is failed");
		} else {
			String sql = "select * from Products";
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("product_id");
				String name = rs.getString("product_name");
				String description = rs.getString("product_des");
				String src = rs.getString("product_img_source");
				String type = rs.getString("product_type");
				String brand = rs.getString("product_brand"); //product's category
				float price = rs.getFloat("product_price");
				
				Product product = new Product(id,name,description,src,type,brand,1,price);
				list.add(product);
			}
			
			con.close();
		}
		
		return list;
	}
}
