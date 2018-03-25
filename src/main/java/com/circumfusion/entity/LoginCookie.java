package com.circumfusion.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LoginCookie implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private User user;
	
	private String loginCookieValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLoginCookieValue() {
		return loginCookieValue;
	}

	public void setLoginCookieValue(String loginCookieValue) {
		this.loginCookieValue = loginCookieValue;
	}

}
