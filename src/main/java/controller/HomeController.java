package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet(value = {"/", "/home","/trangchu"}, loadOnStartup = 1)
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, ServletException, IOException {
		try {
			process(request, response);
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action != null && action.equals("login")) {
			// login
		}else {
			ProductDAO pDao = new ProductDAO();
			List<Product> pList = pDao.getProducts();
			request.setAttribute("pList", pList);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
	}

}
