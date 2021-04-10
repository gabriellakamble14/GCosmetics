package com.GCosmetics.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.GCosmetics.Dao.CartDao;
import com.GCosmetics.Dao.CartDaoImpl;
import com.GCosmetics.Dao.OrderDao;
import com.GCosmetics.Dao.OrderDaoImpl;
import com.GCosmetics.pojo.Cart;
import com.GCosmetics.pojo.Order;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(); 
		String email=(String)session.getAttribute("userEmail");
		String operation=request.getParameter("operation");
		CartDao dao=new CartDaoImpl();
		Cart c = new Cart();
		
		
		if(operation!=null && operation.equals("addToCart"))
		{
			int cosmeticsId=Integer.parseInt(request.getParameter("cosmeticsId"));
		    c.setEmailId(email);
			c. setCosmeticsId(cosmeticsId);
			c.setQuantity(1);
			
			boolean flag=dao.addCart(c);
			if(flag)
			{
			request.setAttribute("success", "cosmetics added to cart");
			RequestDispatcher rd=request.getRequestDispatcher("CosmeticsList.jsp");
			rd.forward(request, response);
			}
			
		}
		else if(operation!=null && operation.equals("delete")) {
			int cartId=Integer.parseInt(request.getParameter("id"));
			boolean flag=dao.deleteCartById(cartId);
			request.setAttribute("success", "food deleted from Cart");
			if(flag)
			{
			
			List<Cart> cartList=dao.showMyCart(email);
			session.setAttribute("mycart", cartList);
			RequestDispatcher rd=request.getRequestDispatcher("CartList.jsp");
			rd.forward(request, response);
		}
		}
		
		else 
		{
			List<Cart> cartList=dao.showMyCart(email);
			session.setAttribute("mycart", cartList);
			RequestDispatcher rd=request.getRequestDispatcher("CartList.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			//place order
		HttpSession session=request.getSession();
		String[] price=request.getParameterValues("price");
		String[] quantity=request.getParameterValues("quantity");
        double total=0.0;
		if(price.length>0) 
		{
			for(int i=0;i<price.length;i++) {
				double amount=Integer.parseInt(quantity[i])*Double.parseDouble(price[i]);
				total =total+amount;
			}
		}
		
		//order table structure:
		//set the order obj 
		String email=(String)session.getAttribute("userEmail");
		String today=(new Date()).toString();
		
		Order o=new Order();
		o.setBill(total);
		o.setDate(today);
		o.setEmailId(email);
		
		//insert this obj into db
		OrderDao dao=new OrderDaoImpl();
		int orderId=dao.placeOrder(o);
		
		if(orderId>0) 
		{
			CartDao ctDao=new CartDaoImpl();
			ctDao.clearCart(email);
			request.setAttribute("success", "Order placed!! your Order id: "+orderId);
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("failure", "Unable to place your order");
			RequestDispatcher rd=request.getRequestDispatcher("CartList.jsp");
			rd.forward(request, response);
		}
		
	}

}
}