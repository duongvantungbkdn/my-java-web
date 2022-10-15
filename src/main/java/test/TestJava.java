package test;

import java.sql.Connection;
import java.sql.SQLException;

import context.DBContext;
import dao.ProductDAO;

public class TestJava {

	public static void main(String[] args) {
		
	}
	
	private static void testDAO() throws SQLException {
		ProductDAO pDao = new ProductDAO();
		System.out.println(pDao.getProducts());
	}
	
	private static void testContext() {
		DBContext db = new DBContext();		
		Connection con = db.getConnection();		
		if(con == null) {
			System.out.println("connct fail");
		} else {
			System.out.println("connect successed");
		}
	}

}
