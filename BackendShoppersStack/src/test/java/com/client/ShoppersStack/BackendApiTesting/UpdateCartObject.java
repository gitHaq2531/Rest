package com.client.ShoppersStack.BackendApiTesting;

public class UpdateCartObject 
{
int productId;
int quantity;

public UpdateCartObject(int productId, int quantity) {
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
