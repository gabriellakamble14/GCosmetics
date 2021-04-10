package com.GCosmetics.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.GCosmetics.Dao.CustomerDao;
import com.GCosmetics.Dao.CustomerDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		session.invalidate();
		request.setAttribute("success", "Logged out sucessully!!");
		RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		
		String type=request.getParameter("type");
		String email=request.getParameter("CustEmail");
		String password=request.getParameter("Custpass");		
		CustomerDao dao=new CustomerDaoImpl();
		boolean flag=dao.doLogin(type,email, password);
		if (flag) {
			if(type.equals("user"))
				session.setAttribute("userEmail", email);
			if(type.equals("admin"))
				session.setAttribute("adminEmail", email);
//	//		request.setAttribute("success", "you have logged in successfully!!!");
//	//		RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
//	//		rd.forward(request, response);			
			response.sendRedirect("CosmeticsServlet");
		}
		else {
//			request.setAttribute("failure", "Kindly check the credentials");
//			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
//			rd.forward(request, response);
			response.sendRedirect("Login.jsp");
		}		
	}

}