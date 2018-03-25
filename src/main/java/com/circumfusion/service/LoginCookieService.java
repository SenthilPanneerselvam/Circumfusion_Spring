package com.circumfusion.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.circumfusion.entity.LoginCookie;
import com.circumfusion.entity.User;
import com.circumfusion.repo.LoginCookieRepo;
import com.circumfusion.repo.UserRepo;

@Service
@Transactional
public class LoginCookieService 
{
	@Autowired
	LoginCookieRepo loginCookieRepo;
	
	@Autowired
	UserRepo userRepo;
	 
	public LoginCookie createLoginCookie(Integer userId)
	{
		String cookieValue = null;
		boolean isAvailable = false;
		while(!isAvailable)
		{
			cookieValue = UUID.randomUUID().toString().toLowerCase();
			cookieValue = cookieValue.replaceAll("[^a-z0-9]", "");
			LoginCookie loginCookie = loginCookieRepo.findByLoginCookieValue(cookieValue);
			if(loginCookie == null)
			{
				isAvailable = true;
			}
		}
		
		LoginCookie cookieObj = new LoginCookie();
		cookieObj.setUser(userRepo.findOne(userId));
		cookieObj.setLoginCookieValue(cookieValue);
		cookieObj = loginCookieRepo.save(cookieObj);
		return cookieObj;
	}
	
	public LoginCookie getLoginCookie(Integer userId)
	{
		LoginCookie resultCookie = null;
		List<LoginCookie> cookieList = loginCookieRepo.findByUserId(userId);
		if(cookieList != null && cookieList.size() > 0)
		{
			resultCookie = cookieList.get(0);
		}
		else
		{
			resultCookie = createLoginCookie(userId);
		}
		return resultCookie;
	}
	
	public User getUser(String cookieValue)
	{
		User user = null;
		LoginCookie loginCookie = loginCookieRepo.findByLoginCookieValue(cookieValue);
		if(loginCookie != null)
		{
			user = loginCookie.getUser();
		}
		return user;
	}
}
