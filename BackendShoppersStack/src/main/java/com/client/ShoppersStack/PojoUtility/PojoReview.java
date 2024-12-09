package com.client.ShoppersStack.PojoUtility;

public class PojoReview 
{
	
		  String description;
		  String heading;
		  String rating;
		  String shopperId;
		  String shopperName;
		  
		  public PojoReview() {}
		  
		public PojoReview(String description, String heading, String rating, String shopperId, String shopperName) {
			super();
			this.description = description;
			this.heading = heading;
			this.rating = rating;
			this.shopperId = shopperId;
			this.shopperName = shopperName;
		}
		public String getDescription() {
			return description;
		}
		public String getHeading() {
			return heading;
		}
		public String getRating() {
			return rating;
		}
		public String getShopperId() {
			return shopperId;
		}
		public String getShopperName() {
			return shopperName;
		}
		  
		  
		
}
