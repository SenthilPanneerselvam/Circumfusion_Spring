package com.circumfusion.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.circumfusion.dto.ManufactureRegistrationDTO;
import com.circumfusion.dto.ServiceIndustryDTO;
import com.circumfusion.dto.UserDTO;
import com.circumfusion.entity.Manufacturer;
import com.circumfusion.entity.ServiceIndustry;
import com.circumfusion.entity.User;
import com.circumfusion.exception.OrgAlreadyExistsException;
import com.circumfusion.repo.ManufactureRepo;
import com.circumfusion.repo.ServiceIndustryRepo;
import com.circumfusion.repo.UserRepo;

@Service
@Transactional
public class RegistrationService {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	DozerBeanMapper beanMapper;
	
	@Autowired
	ManufactureRepo manRepo;
	
	@Autowired
	ServiceIndustryRepo serviceIndustryRepo;
	
	public static final String MANUFACTURER_TYPE = "MANUFACTURER";
	public static final String SERVICEINDUSTRY_TYPE = "SERVICEINDUSTRY";

	public UserDTO createUser(String username, String password, String type)
	{
		UserDTO user = new UserDTO();
		user.setUsername(username);
		user.setPassword(password);
		user.setType(type);
		user.setStatus(true);
		UserDTO newUser = userService.createUser(user);
		return newUser;
	}
	
	public void registerManufacturer(ManufactureRegistrationDTO dto) {
		// save the user
		UserDTO newUser = createUser(dto.getUserId(), dto.getPassword(), MANUFACTURER_TYPE);
		
		// save the manufacturer
		Manufacturer manufacturer = beanMapper.map(dto, Manufacturer.class);
		if(manRepo.findByOrgName(dto.getOrgName()) != null) {
			throw new OrgAlreadyExistsException();
		}
		manufacturer.setUser(userRepo.findOne(newUser.getId()));
		manRepo.save(manufacturer);
	}
	
	public void registerServiceIndustry(ServiceIndustryDTO serviceIndustryDTO) 
	{
		// save the user
		UserDTO newUser = createUser(serviceIndustryDTO.getUserId(), serviceIndustryDTO.getPassword(), SERVICEINDUSTRY_TYPE);
		
		// save the service industry
		ServiceIndustry serviceIndustry = beanMapper.map(serviceIndustryDTO, ServiceIndustry.class);
		if(serviceIndustryRepo.findByOrgName(serviceIndustryDTO.getOrgName()) != null)
		{
			throw new OrgAlreadyExistsException();
		}
		serviceIndustry.setUser(userRepo.findOne(newUser.getId()));
		serviceIndustryRepo.save(serviceIndustry);
	}
}
