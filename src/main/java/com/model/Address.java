package com.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

	String loc;
	String landmark;
	String city;
	String state;
	String country;
	public Address(String loc, String landmark, String city, String state, String country) {
		super();
		this.loc = loc;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public String getAdd() {
		return loc;
	}
	public void setAdd(String loc) {
		this.loc = loc;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
	
}
