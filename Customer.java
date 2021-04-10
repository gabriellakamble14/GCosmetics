package com.GCosmetics.pojo;

public class Customer extends Cart {
	private int custId;
	private String custName,custEmail,custPass,custContactNo,custAddress;
	
	public Customer()
	{
		
	}
	public Customer(String custName,String custEmail,String custPass,String custContactNo,String custAddress)
	{
		this.custName=custName;
		this.custEmail=custEmail;
		this.custPass=custPass;
		this.custContactNo=custContactNo;
		this.custAddress=custAddress;
	}
	
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPass() {
		return custPass;
	}

	public void setCustPass(String custPass) {
		this.custPass = custPass;
	}

	public String getCustContactNo() {
		return custContactNo;
	}

	public void setCustContactNo(String custContactNo) {
		this.custContactNo = custContactNo;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custPass="
				+ custPass + ", custContactNo=" + custContactNo + ", custAddress=" + custAddress + "]";
	}
	
	

}




