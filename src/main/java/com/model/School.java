package com.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int schoolid;
	String sname;
	
	@Embedded
	Address address;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<UserModel> userModel = new ArrayList<UserModel>();

	public School(String sname, Address address) {
		super();
		this.sname = sname;
		this.address = address;
	}

	public School() {
		// TODO Auto-generated constructor stub
	}
	
	public List<UserModel> getUserModel() {
		return userModel;
	}


	public void setUserModel(List<UserModel> userModel) {
		this.userModel = userModel;
	}


	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
