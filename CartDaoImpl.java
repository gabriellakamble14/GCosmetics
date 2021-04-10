package com.GCosmetics.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.GCosmetics.utility.DBUtility;
import com.GCosmetics.pojo.Cart;
import com.GCosmetics.pojo.cosmetics;

public class CartDaoImpl implements CartDao{

	Connection con= DBUtility.connection();
	PreparedStatement ps;
	ResultSet rs;
	String str;
	cosmetics cm;
	int row;
	
	@Override
	public boolean addCart(Cart cart)
	{
		str="insert into Cart(Cosmeticsid,quantity,custEmail) values(?,?,?)";
		try 
		{
			ps=con.prepareStatement(str);
			ps.setInt(1, cart.getCosmeticsId());
			ps.setInt(2, cart.getQuantity());
			ps.setString(3, cart.getEmailId());

			row=ps.executeUpdate();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<Cart> showMyCart(String custEmail) {
		str="select c.cartId,ct.cosmeticsName,ct.cosmeticsPrice,c.quantity from cosmetics as ct inner join Cart as c where ct.cosmeticsId=c.cartId and custEmail=?";
		List<Cart> cl=new ArrayList<Cart>();
		try {
			ps=con.prepareStatement(str);
			ps.setString(1,custEmail);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Cart c=new Cart();
				c.setCartId(rs.getInt("cartId"));
				c.setCosmeticsName(rs.getString("cosmeticsName"));
				c.setCosmeticsPrice(rs.getDouble("cosmeticsPrice"));
				c.setQuantity(rs.getInt("quantity"));
				cl.add(c);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return cl;
	}

	@Override
	public boolean deleteCartById(int cartid) {
		str="delete from Cart where cartId=?";
		try
		{
			ps=con.prepareStatement(str);
			ps.setInt(1,cartid);
			row=ps.executeUpdate();
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
	public boolean clearCart(String custEmail) {
		str="delete from Cart where custEmail=?";
		try
		{
			ps=con.prepareStatement(str);
			ps.setString(1,custEmail);
			row=ps.executeUpdate();
			if(row>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();

		}
		return false;
	}
}


