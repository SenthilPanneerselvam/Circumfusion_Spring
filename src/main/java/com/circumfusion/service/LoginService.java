package com.circumfusion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.circumfusion.dto.UserDTO;
import com.circumfusion.entity.Manufacturer;
import com.circumfusion.entity.ServiceIndustry;
import com.circumfusion.entity.User;
import com.circumfusion.exception.InvalidLoginException;
import com.circumfusion.repo.ManufactureRepo;
import com.circumfusion.repo.ServiceIndustryRepo;
import com.circumfusion.repo.UserRepo;

@Service
@Transactional
public class LoginService 
{
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ManufactureRepo manufactureRepo;
	
	@Autowired
	ServiceIndustryRepo serviceIndustryRepo;
	
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
			resultDTO.setType(user.getType());
			resultDTO.setStatus(user.getStatus());
			resultDTO.setLoginCookieValue(cookieValue);
			String orgName = "";
			int orgId = 0;
			if(RegistrationService.MANUFACTURER_TYPE.equals(user.getType()))
			{
				Manufacturer manufacturer = manufactureRepo.findByUserId(user.getId());
				orgId = manufacturer.getId();
				orgName = manufacturer.getOrgName();
			}
			else if(RegistrationService.SERVICEINDUSTRY_TYPE.equals(user.getType()))
			{
				ServiceIndustry serviceIndustry = serviceIndustryRepo.findByUserId(user.getId());
				orgId = serviceIndustry.getId();
				orgName = serviceIndustry.getOrgName();
			}
			resultDTO.setOrgId(orgId);
			resultDTO.setOrgName(orgName);
		}
		else
		{
			throw new InvalidLoginException();
		}
		return resultDTO;
	}
}
