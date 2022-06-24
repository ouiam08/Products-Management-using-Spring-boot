package com.example.demo.entities;

import javax.persistence.*;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	
	private String userName;
	private String passWord;
	
	
	public User(String u, String p) {
		this.setUserName(u);
		this.setPassWord(p);
	}
	
	public User() {
		super();
	}

	public Long getId() {
		return this.idUser;
	}

	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	

}
