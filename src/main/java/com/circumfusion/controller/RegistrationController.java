package com.circumfusion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.circumfusion.dto.ManufactureRegistrationDTO;
import com.circumfusion.dto.ServiceIndustryDTO;
import com.circumfusion.service.RegistrationService;

@RestController
@RequestMapping(value="/register")
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;

	@RequestMapping(value="/manufacturer", method=RequestMethod.POST)
	public void registerManufacturer(@RequestBody ManufactureRegistrationDTO registrationDTO) {
		registrationService.registerManufacturer(registrationDTO);
	}
	
	@RequestMapping(value="/serviceindustry", method=RequestMethod.POST)
	public void registerServiceIndustry(@RequestBody ServiceIndustryDTO serviceIndustryDTO) {
		registrationService.registerServiceIndustry(serviceIndustryDTO);
	}
	
}
