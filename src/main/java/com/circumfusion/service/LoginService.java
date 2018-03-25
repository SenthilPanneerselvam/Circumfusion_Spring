package com.circumfusion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.circumfusion.dto.UserDTO;
import com.circumfusion.entity.User;
import com.circumfusion.exception.InvalidLoginException;
import com.circumfusion.repo.UserRepo;

@Service
@Transactional
public class LoginService 
{
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	LoginCookieService loginCookieService;
	
	
	public UserDTO validateUserLogin(UserDTO userDTO)
	{
		UserDTO resultDTO = null;
		User user = userRepo.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
		if(user != null && user.getId() != null)
		{
			String cookieValue = loginCookieService.getLoginCookie(user.getId()).getLoginCookieValue();
			resultDTO = new UserDTO();
			resultDTO.setId(user.getId());
			resultDTO.setUsername(user.getUsername());
			resultDTO.setLoginCookieValue(cookieValue);
		}
		else
		{
			throw new InvalidLoginException();
		}
		return resultDTO;
	}
}
