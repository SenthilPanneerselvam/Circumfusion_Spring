package com.circumfusion.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.circumfusion.dto.ManufactureRegistrationDTO;
import com.circumfusion.dto.UserDTO;
import com.circumfusion.entity.Manufacturer;
import com.circumfusion.entity.User;
import com.circumfusion.exception.OrgAlreadyExistsException;
import com.circumfusion.repo.ManufactureRepo;
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
	
	public static final String MANUFACTURER_TYPE = "MANUFACTURER";

	public void registerManufacturer(ManufactureRegistrationDTO dto) {
		// save the user
		UserDTO user = new UserDTO();
		user.setUsername(dto.getUserId());
		user.setPassword(dto.getPassword());
		user.setType(MANUFACTURER_TYPE);
		user.setStatus(true);
		UserDTO newUser = userService.createUser(user);
		// save the manufacturer
		Manufacturer manufacturer = beanMapper.map(dto, Manufacturer.class);
		if(manRepo.findByOrgName(dto.getOrgName()) != null) {
			throw new OrgAlreadyExistsException();
		}
		manufacturer.setUser(userRepo.findOne(newUser.getId()));
		manRepo.save(manufacturer);
	}
	
}
