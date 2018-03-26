package com.circumfusion.dto;

public class UserDTO {
	
	private Integer id;

	private String username;
	
	private String password;
	
	private boolean status;

	private String type;
	
	private String loginCookieValue;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginCookieValue() {
		return loginCookieValue;
	}

	public void setLoginCookieValue(String loginCookieValue) {
		this.loginCookieValue = loginCookieValue;
	}
	
}
