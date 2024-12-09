package com.client.ShoppersStack.PojoUtility;

public class PojoAddAddress 
{
	String addressId;
	String buildingInfo= "haque mansion";
	String city= "banglore";
	String country = "india";
	String landmark = "near shoppers stop";
	String name = "haque";
	String phone = "6206861440";
	String pincode = "560010";
	String state = "karnataka";
	String streetInfo = "btm 2nd stage";
	String type = "pg";
			  
	public PojoAddAddress() {}
	
	public PojoAddAddress(String buildingInfo, String city, String country, String landmark, String name,
			String phone, String pincode, String state, String streetInfo, String type) 
	{
		super();
		this.buildingInfo = buildingInfo;
		this.city = city;
		this.country = country;
		this.landmark = landmark;
		this.name = name;
		this.phone = phone;
		this.pincode = pincode;
		this.state = state;
		this.streetInfo = streetInfo;
		this.type = type;
	}
	
	

	public PojoAddAddress(String addressId, String buildingInfo, String city, String country, String landmark,
			String name, String phone, String pincode, String state, String streetInfo, String type) {
		super();
		this.addressId = addressId;
		this.buildingInfo = buildingInfo;
		this.city = city;
		this.country = country;
		this.landmark = landmark;
		this.name = name;
		this.phone = phone;
		this.pincode = pincode;
		this.state = state;
		this.streetInfo = streetInfo;
		this.type = type;
	}
	
	

	public String getAddressId() {
		return addressId;
	}

	public String getBuildingInfo() {
		return buildingInfo;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getLandmark() {
		return landmark;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getPincode() {
		return pincode;
	}

	public String getState() {
		return state;
	}

	public String getStreetInfo() {
		return streetInfo;
	}

	public String getType() {
		return type;
	}  
	
	
}
