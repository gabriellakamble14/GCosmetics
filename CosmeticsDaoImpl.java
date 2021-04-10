package com.GCosmetics.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;  
import java.util.List;

import com.GCosmetics.pojo.cosmetics;
import com.GCosmetics.utility.DBUtility;

import java.sql.ResultSet;

public class CosmeticsDaoImpl implements CosmeticsDao
{
	Connection con;
	int rows;
	PreparedStatement ps;
	boolean  flag;
	String query;

	@Override
	public boolean addcosmetics(cosmetics cosmetics) {
		 
		 try {
			 con = DBUtility.connection();
			 query = "insert into cosmetics(name,category,price) values(?,?,?)";
			 ps = con.prepareStatement(query);
			 ps.setString(1,cosmetics.getCosmeticsName());
			 ps.setString(2,cosmetics.getCosmeticsCategory());
			 ps.setDouble(3,cosmetics.getCosmeticsPrice());
			 rows = ps.executeUpdate();
			 if(rows>0) flag=true;
			 else flag=false; 
			 
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return flag;
	}

	@Override
	public boolean updatecosmetics(cosmetics cosmetics) {
		
		 try {
			 con =DBUtility.connection();
			 query = "update cosmetics set name=?,category=?,price=? where cosmeticsId=?";
			 ps = con.prepareStatement(query);
			 ps.setString(1,cosmetics.getCosmeticsName());
			 ps.setString(2,cosmetics.getCosmeticsCategory());
			 ps.setDouble(3,cosmetics.getCosmeticsPrice());
			 ps.setInt(4,cosmetics.getCosmeticsId());
			 rows = ps.executeUpdate();
			 if(rows>0) flag=true;
			 else flag=false; 
			 /**/
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return flag;
	}

	

	@Override
	public cosmetics getcosmeticsById(int id) 
	{
		cosmetics c = new cosmetics();
		try {
		con =DBUtility.connection();
		query = "Select * from cosmetics where cosmeticsId=?";
	    ps = con.prepareStatement(query);
	    ps.setInt(1, id);
	    ResultSet rs = ps.executeQuery();//select queries
	    while(rs.next())
	    {
	    c.setCosmeticsId(rs.getInt("cosmeticsId"));
	    c.setCosmeticsName(rs.getString("cosmeticsname"));
	    c.setCosmeticsCategory(rs.getString("cosmeticscategory"));
	    c.setCosmeticsPrice(rs.getInt("cosmeticsprice"));
		}}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	    return c;
	}

	@Override
	public List<cosmetics> getAllcosmetics() {
		List <cosmetics> clist = new ArrayList<>();
		try {
		con = DBUtility.connection();
		query = "Select * from cosmetics";
	    ps = con.prepareStatement(query);
	    ResultSet rs = ps.executeQuery();//select queries
	    while(rs.next())
	    {
	    	cosmetics c = new cosmetics();
	    	c.setCosmeticsId(rs.getInt("cosmeticsId"));
		    c.setCosmeticsName(rs.getString("cosmeticsName"));
		    c.setCosmeticsCategory(rs.getString("cosmeticsCat"));
		    c.setCosmeticsPrice(rs.getInt("cosmeticsPrice"));
		    clist.add(c);
	    }
	    
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	    return clist;
	}

	@Override
	public boolean deletecosmetics(int id) {
		try {
			 con =DBUtility.connection();
			 query = "delete from cosmetics  where cosmeticsId=?";
			 ps = con.prepareStatement(query);
			 ps.setInt(1,id);
			 rows = ps.executeUpdate();
			 if(rows>0) flag=true;
			 else flag=false; 
			 }
		 catch (SQLException e)
		 {
			e.printStackTrace();
		 }
		
		 return flag;
	}

	@Override
	public List<cosmetics> getcosmeticsBycategory(String cosmeticsCategory) {
		String category="Select * from cosmetics where category=?";
		
		
			ArrayList<cosmetics> al=new ArrayList<>();
			try(Connection con=DBUtility.connection())
			{
				ps=con.prepareStatement(category);
				ps.setString(1,cosmeticsCategory);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					cosmetics c = new cosmetics();
			    	c.setCosmeticsId(rs.getInt("cosmeticsId"));
				    c.setCosmeticsName(rs.getString("cosmeticsName"));
				    c.setCosmeticsCategory(rs.getString("cosmeticsCat"));
				    c.setCosmeticsPrice(rs.getInt("cosmeticsPrice"));
				    al.add(c);
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return al;
	}
	

}



//@Override
//public List<Cosmetics> getCosmeticsBycategory(String cosmeticsCategory) {
//	String category="Select * from cosmetics where category=?";
//
//
//	ArrayList<cosmetics> al=new ArrayList<>();
//	try(Connection con=DBUtility.connection())
//	{
//		stmt=con.prepareStatement(category);
//		stmt.setString(1,cosmeticsCategory);
//		ResultSet rs=stmt.executeQuery();
//		while(rs.next())
//		{
//			cosmetics=new Cosmetics(rs.getString("cosmeticsName"),rs.getString("cosmeticsCat"),rs.getDouble("cosmeticsPrice"));
//			cosmetics.setcosmeticsId(rs.getInt("cosmeticsId"));
//			al.add(cosmetics);
//		}
//	}
//	catch(SQLException e)
//	{
//		e.printStackTrace();
//	}
//	return al;
//}

