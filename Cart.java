package com.GCosmetics.pojo;


public class Cart {
	private int cartId,cosmeticsId,quantity;
	private String emailId;
	private String cosmeticsName;
	private double cosmeticsPrice;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getCosmeticsId() {
		return cosmeticsId;
	}
	public void setCosmeticsId(int cosmeticsId) {
		this.cosmeticsId = cosmeticsId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCosmeticsName() {
		return cosmeticsName;
	}
	public void setCosmeticsName(String cosmeticsName) {
		this.cosmeticsName = cosmeticsName;
	}
	public double getCosmeticsPrice() {
		return cosmeticsPrice;
	}
	public void setCosmeticsPrice(double cosmeticsPrice) {
		this.cosmeticsPrice = cosmeticsPrice;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cosmeticsName=" + cosmeticsName + ", quantity=" + quantity
				+ ", cosmeticsPrice=" + cosmeticsPrice + "]";
	}
	
	
	
	
}



