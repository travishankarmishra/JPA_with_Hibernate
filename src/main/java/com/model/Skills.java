package com.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int sid;
	String tech;

	@ManyToMany(cascade = CascadeType.ALL)
	List<UserModel> userModel = new ArrayList<UserModel>();

	public List<UserModel> getUserModel() {
		return userModel;
	}

	public void setUserModel(List<UserModel> userModel) {
		this.userModel = userModel;
	}

	public Skills() {
		// TODO Auto-generated constructor stub
	}

	public Skills(String tech) {
		super();
		this.tech = tech;
	}

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

}
