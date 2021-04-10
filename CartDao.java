package com.GCosmetics.Dao;

import java.util.List;
import com.GCosmetics.pojo.Cart;

public interface CartDao {
	boolean addCart(Cart cart);
	List<Cart> showMyCart(String email);
	boolean deleteCartById(int cartid);
	boolean clearCart(String email);
}



