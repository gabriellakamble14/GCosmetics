package com.GCosmetics.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.GCosmetics.pojo.Customer;
import com.GCosmetics.utility.DBUtility;


public class CustomerDaoImpl implements CustomerDao {
	static Connection con=DBUtility.connection();

	public boolean addCustomer(Customer customer)
	{
		int row=0;
		String add="insert into Customer(custName,custEmail,custPass,custAddress,custContact) values(?,?,?,?,?)";
		try {
			PreparedStatement stmt=con.prepareStatement(add);
			stmt.setString(1, customer.getCustName());
			stmt.setString(2, customer.getCustEmail());
			stmt.setString(3, customer.getCustPass());
			stmt.setString(4, customer.getCustAddress());
			stmt.setString(5, customer.getCustContactNo());
			row=stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		int row=0;
		String update="update Customer set custName=?, custEmail=?, custPass=?, custContact=?, custAddress=? where custid=?";
		try
		{
			PreparedStatement stmt=con.prepareStatement(update);
			stmt.setString(1,customer.getCustName());
			stmt.setString(2, customer.getCustEmail());
			stmt.setString(3, customer.getCustPass());
			stmt.setString(4, customer.getCustContactNo());
			stmt.setString(5, customer.getCustAddress());
			stmt.setInt(6, customer.getCustId());
			row=stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteCust(int id) {

		int row=0;
		String delete="delete from Customer where custid=?";
		try {
			PreparedStatement stmt=con.prepareStatement(delete);
			stmt.setInt(1, id);
			row=stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public Customer getCustByEmail(String emailId) {
		Customer c = new Customer();
		try {
			con = DBUtility.connection();
			String query = "select * from customer where custEmail=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,emailId);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				c.setCustId(rs.getInt("custId"));
				c.setCustName(rs.getString("custName"));
				c.setCustEmail(rs.getString("custEmail"));
				c.setCustPass(rs.getString("custPass"));
				c.setCustContactNo(rs.getString("custContact"));
				c.setCustAddress(rs.getString("custAddress"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return c;

	}

	@Override
	public List<Customer> getAllCustomer() {
		String list="select * from Customer";
		
		ArrayList<Customer> al=new ArrayList<Customer>();
		try
		{
			PreparedStatement stmt=con.prepareStatement(list);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				Customer c=new Customer(rs.getString("custname"),rs.getString("custemail"),rs.getString("custpass"),rs.getString("custcontact"),rs.getString("custaddress"));
				c.setCustId(rs.getInt("custid"));
				al.add(c);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return al;
	}
	@Override
	public boolean doLogin(String type,String email, String password) {
		boolean flag=false;
		if(type.equals("user")) {
			String sql="select * from Customer where custEmail=? and custPass=?";
			try {
				con = DBUtility.connection();
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, email);
				ps.setString(2, password);

				ResultSet rs=ps.executeQuery();
				if(rs.next())
					flag=true;			
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
         if(type.equals("admin")) {
	String sql="select * from admin where email=? and password=?";
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			flag=true;			
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}			
}
         return flag;
	}
}

	


