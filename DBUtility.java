package com.GCosmetics.utility;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility 
{
public static Connection connection()
{
	Connection con=null;
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gkproject","root","");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return con;
}
}



