package com.example.Project_M.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
  

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public User(Integer id, String username, String name, String email) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.email = email;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", email=" + email + "]";
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	private String email;
}
