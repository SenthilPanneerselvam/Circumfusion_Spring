package com.circumfusion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.circumfusion.entity.LoginCookie;

public interface LoginCookieRepo extends JpaRepository<LoginCookie, Integer>
{
	public LoginCookie findByLoginCookieValue(String loginCookieValue);
	public List<LoginCookie> findByUserId(Integer id); 
}
