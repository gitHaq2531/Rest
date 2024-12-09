package com.client.ShoppersStack.endPoints;

import com.client.ShoppersStack.BaseApiUtility.BaseApiUtils;

public interface IEndPoints
{
	public String shopperId = BaseApiUtils.shopperId;
	public String userLogin ="/users/login";
	public String addToWishlist = "/shoppers/"+shopperId+"/wishlist";
	public String deleteFromWishlist ="/shoppers/"+shopperId+"/wishlist/";
	public String viewProducts ="/products/alpha";
	public String verifyProduct ="/products/alpha";
	public String addToCart = "/shoppers/"+shopperId+"/carts";
	public String getProductFromCart = "/shoppers/"+shopperId+"/carts";
	public String updateProductInCart = "/shoppers/"+shopperId+"/carts/";
	public String addAddress = "/shoppers/"+shopperId+"/address";
	public String getAllAddresses = "/shoppers/"+shopperId+"/address";
	public String deleteAddress = "/shoppers/"+shopperId+"/address/";
	public String getParticularAddress = "/shoppers/"+shopperId+"/address/";
	public String updateAddress = "/shoppers/"+shopperId+"/address/";
	public String placeOrder = "/shoppers/"+shopperId+"/orders";
	public String orderHistory = "/shoppers/"+shopperId+"/orders";
	public String updateOrderHistory = "/shoppers/"+shopperId+"/orders/";
	public String generateInvoice = "/shoppers/"+shopperId+"/orders/";
	public String addReview = "/reviews";
	public String getReviews = "/reviews/";
	public String updateReviews = "/reviews/";
	public String deleteReview = "/reviews/";


}
