package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "UserModel")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int sno;
	String name;
	String email;
	String password;
	String mobile;
	String filename;
	@Embedded
	Address address;

	@OneToOne(cascade = CascadeType.ALL)
	Laptop laptop;

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public UserModel(String name, String email, String password, String mobile, String filename, Address add) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.filename = filename;
		this.address = add;
	}

	@Override
	public String toString() {
		return "UserModel [sno=" + sno + ", name=" + name + ", email=" + email + ", password=" + password + ", mobile="
				+ mobile + ", filename=" + filename + "]";
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public UserModel() {
		super();
	}

}
