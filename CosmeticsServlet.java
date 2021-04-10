package com.GCosmetics.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.GCosmetics.Dao.CosmeticsDao;
import com.GCosmetics.Dao.CosmeticsDaoImpl;
import com.GCosmetics.pojo.cosmetics;

/**
 * Servlet implementation class CosmeticsServlet
 */
@WebServlet("/CosmeticsServlet")
public class CosmeticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CosmeticsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		CosmeticsDao dao=new CosmeticsDaoImpl();
		String operation=request.getParameter("operation");
		PrintWriter out = response.getWriter();
		HttpSession session= request.getSession();
		if(operation !=null && operation.equals("delete"))
		{
			//delete the cosmetics
			/*
			String id=request.getParameter("id"); int cosmeticsId = Integer.parseInt(id);
			int CosmeticsId = Integer.parseInt(id);
			 */
			int cosmeticsId = Integer.parseInt(request.getParameter("id"));
			boolean flag=dao.deletecosmetics(cosmeticsId);
			if(flag) out.print("<h1>Success</h1>");
			else 	out.print("<h1>Error</h1>");
		}
		else if(operation !=null && operation.equals("getcosmeticsObj")) {
			//get cosmetics obj
			int cosmeticsId = Integer.parseInt(request.getParameter("id"));
			cosmetics c=dao.getcosmeticsById(cosmeticsId);
			session.setAttribute("Cosmeticstoupdate", c);
			response.sendRedirect("UpdateCosmetics.jsp");
		}
		else
		{
			//code for cosmeticslist
			//1.fetch the data from daoimpl			
			List<cosmetics> cosmeticslist = dao.getAllcosmetics();

			//2.pass this list to jsp.
			//session is server side memory, which is accessible to jsp n servlet 

			session.setAttribute("cosmeticslist", cosmeticslist);
			response.sendRedirect("CosmeticsList.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//A.Adding the product in db
		//1. get the values entered in the form and
		//using the values we will create a cosmetics object.
		PrintWriter out = response.getWriter();
		
		String cosmeticsName = request.getParameter("CosmeticsName");
		String cosmeticsCat= request.getParameter("CosmeticsCat");
		String cosmeticsP = request.getParameter("Cosmeticsprice");
		int cosmeticsPrice=Integer.parseInt(cosmeticsP);
		//using these values we will create the cosmetics object
		cosmetics cosmetics=new cosmetics();
		cosmetics.setCosmeticsCategory(cosmeticsCat);
		cosmetics.setCosmeticsName(cosmeticsName);
		cosmetics.setCosmeticsPrice(cosmeticsPrice);
		HttpSession session = request.getSession();
		//2.Using Daoimp obj we will call addCosmetics() and return a boolean value.
		CosmeticsDao dao=new CosmeticsDaoImpl();
		String operation=request.getParameter("operation");

		if(operation.equals("addcosmetics"))
		{
	     boolean flag= dao.addcosmetics(cosmetics);
			//3. based on the return value, we can generate response to client
	     
			if (flag) 	
			{
//				out.write("success");
				List<cosmetics> cosmeticslist = dao.getAllcosmetics();
				session.setAttribute("cosmeticslist", cosmeticslist);
				request.setAttribute("Success", "Cosmetics Added Successfully!!!");
				RequestDispatcher rd = request.getRequestDispatcher("CosmeticsList.jsp");
				rd.forward(request, response);
			}
			else		
			{
				request.setAttribute("failure", "Cosmetics is not added");
//				RequestDispatcher rd=request.getRequestDispatcher("AddCosmetics.jsp");
//				rd.forward(request, response);
				//out.write("Error");
//				
			}
		}
		else
		{
			int id=Integer.parseInt(request.getParameter("cosmeticsId"));
			cosmetics.setCosmeticsId(id);
			boolean flag=dao.updatecosmetics(cosmetics);
			if (flag) 	
			{
				List<cosmetics> cosmeticslist = dao.getAllcosmetics();
				session.setAttribute("cosmeticslist", cosmeticslist);
				request.setAttribute("success", "cosmetics updated successfully!!!");
				RequestDispatcher rd=request.getRequestDispatcher("CosmeticsList.jsp");
				rd.forward(request, response);
				
				out.write("Success");
			}
			else		
			{
				request.setAttribute("failure", "Cosmetics is not updated");
				RequestDispatcher rd=request.getRequestDispatcher("UpdateCosmetics.jsp");
				rd.forward(request, response);
				out.write("Error");
			}
		}
	}
	
}



