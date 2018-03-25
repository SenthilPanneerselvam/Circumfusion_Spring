package com.circumfusion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.circumfusion.dto.UserDTO;
import com.circumfusion.service.LoginService;

@RestController
@RequestMapping(value="/login")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping( method=RequestMethod.POST)
	public UserDTO validateLogin(@RequestBody UserDTO userDTO) 
	{
		return loginService.validateUserLogin(userDTO);
	}
	
}
