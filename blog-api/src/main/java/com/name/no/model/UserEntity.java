package com.name.no.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	private String id;
	private String username;
	private String password;
	
	public UserEntity() {}
	
	public UserEntity(String id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
