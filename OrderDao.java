package com.GCosmetics.Dao;

import java.util.List;

import com.GCosmetics.pojo.Order;

public interface OrderDao {
	//int placeOrder(String emailId);
	int placeOrder (String emailId);
	List<Order>getMyOrders(String email);
	int placeOrder(Order o);	
}




