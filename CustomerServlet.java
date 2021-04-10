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



import com.GCosmetics.pojo.Customer;
import com.GCosmetics.Dao.CustomerDao;
import com.GCosmetics.Dao.CustomerDaoImpl;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		Customer Cust = new Customer();
		CustomerDao dao=new CustomerDaoImpl();
		HttpSession session=request.getSession();
		List<Customer> custList;
		
		String operation=request.getParameter("operation");
	     if(operation!=null && operation.equals("delete")) 
	     {
			int id=Integer.parseInt(request.getParameter("id"));
			boolean flag=dao.deleteCust(id);
			if(flag)
			{
				request.setAttribute("success", "customer deleted successfully!!!");
				RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
			}	
			else 
			{
				request.setAttribute("failure", "error in deleting");
				custList=dao.getAllCustomer();
				session.setAttribute("custlist", custList);
				RequestDispatcher rd=request.getRequestDispatcher("CustomerList.jsp");
				rd.forward(request,response);
				
			}
					
		}
	     else if(operation!=null&&operation.equals("getCust"))
			{
				String email = (String)session.getAttribute("userEmail");
				Customer c = dao.getCustByEmail(email);
				session.setAttribute("custtoupdate", c);
				response.sendRedirect("UpdateCustomer.jsp");
			}
	     /*
		 else if(operation!=null&&operation.equals("update")) { int id =
	    	 /*
	 		  * else if(operation!=null&&operation.equals("update")) { int id =
		 * Integer.parseInt(request.getParameter("id")); cust = dao.getCustomerById(id);
		 * session.setAttribute("custtoupdate", cust);
		 * response.sendRedirect("UpdateCustomer.jsp"); }
	 		 */
		else
		{
			custList=dao.getAllCustomer();
			session.setAttribute("custlist", custList);
			RequestDispatcher rd=request.getRequestDispatcher("CustomerList.jsp");
			rd.forward(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd;
		PrintWriter out = response.getWriter();
		Customer cust = new Customer();
		HttpSession session = request.getSession();
		CustomerDao dao = new CustomerDaoImpl();
		
		String custName = request.getParameter("CustName");
		String custEmail = request.getParameter("CustEmail");
		String custPass = request.getParameter("CustPass");
		String custAddress = request.getParameter("CustAddress");
		String custContact = request.getParameter("CustContact");
		cust.setCustName(custName);
		cust.setCustEmail(custEmail);
		cust.setCustPass(custPass);
		cust.setCustContactNo(custContact);
		cust.setCustAddress(custAddress);
		
		String operation = request.getParameter("operation");
		if(operation!=null&&operation.equals("addCust"))
		{
		boolean flag=dao.addCustomer(cust);
		if(flag) 
			{
			rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			}
		else
			{
			rd=request.getRequestDispatcher("AddCustomer.jsp");
			rd.forward(request, response);
			}
		}
		else 
		{
			int id = Integer.parseInt(request.getParameter("CustId"));
			cust.setCustId(id);
			boolean flag = dao.updateCustomer(cust);
			if(flag) 
				{
				session.invalidate();
				request.setAttribute("success", "Profile updated successfully!! Kindly login again");
				rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
//				response.sendRedirect("Login.jsp");
				}
			else
			{
				request.setAttribute("failure", "Profile not updated!!Kindly try again");
//				rd=request.getRequestDispatcher("UpdateCustomer.jsp");
//				rd.forward(request, response);
				response.sendRedirect("UpdateCustomer.jsp");
		}
	}
	}
}

		
		