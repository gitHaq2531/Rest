package com.client.ShoppersStack.BackendApiTesting;

public class AddTocartObject 
{

	int productId;
	int quantity;
	
	public AddTocartObject(int productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public int getProductId() {
		return productId;
	}
	public int getQuantity() {
		return quantity;
	}
}
