package com.bruce.model;

public class User {

	private Long id;
	private String username;
	private String gender;
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User() {
		super();
	}

	public User(Long id, String username, String gender, String address) {
		super();
		this.id = id;
		this.username = username;
		this.gender = gender;
		this.address = address;
	}
}
