package com.client.ShoppersStack.BackendApiTesting;

public class PojoPlaceOrder 
{

	Address address;
	String paymentMode;
	
	public PojoPlaceOrder() {}

	public PojoPlaceOrder(Address address, String paymentMode) {
		super();
		this.address = address;
		this.paymentMode = paymentMode;
	}

	public Address getAddress() {
		return address;
	}

	public String getPaymentMode() {
		return paymentMode;
	}
	
	
}

class Address
{
	Object addressId;
	
	public Address() {}
	public Address(Object addressId) 
	{
		super();
		this.addressId = addressId;
	}

	public Object getAddressId() {
		return addressId;
	}
	
	
}
