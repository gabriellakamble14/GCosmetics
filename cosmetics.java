package com.GCosmetics.pojo;

public class cosmetics
{
	private int cosmeticsId;
	private String cosmeticsName,cosmeticsCategory;
	private double cosmeticsPrice;
	
	public int getCosmeticsId() {
		return cosmeticsId;
	}
	public void setCosmeticsId(int cosmeticsId) {
		this.cosmeticsId = cosmeticsId;
	}
	public String getCosmeticsName() {
		return cosmeticsName;
	}
	public void setCosmeticsName(String cosmeticsName) {
		this.cosmeticsName = cosmeticsName;
	}
	public String getCosmeticsCategory() {
		return cosmeticsCategory;
	}
	public void setCosmeticsCategory(String cosmeticsCategory) {
		this.cosmeticsCategory = cosmeticsCategory;
	}
	public double getCosmeticsPrice() {
		return cosmeticsPrice;
	}
	public void setCosmeticsPrice(double cosmeticsPrice) {
		this.cosmeticsPrice = cosmeticsPrice;
	}
	@Override
	public String toString() {
		return "cosmetics [cosmeticsId=" + cosmeticsId + ", cosmeticsName=" + cosmeticsName + ", cosmeticsCategory="
				+ cosmeticsCategory + ", cosmeticsPrice=" + cosmeticsPrice + "]";
	}	




	
}
