package com.circumfusion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.circumfusion.dto.OrganizationSizeDTO;
import com.circumfusion.service.OrganizationSizeService;

@RestController
@RequestMapping("/organizationsize")
public class OrganizationSizeController 
{
	@Autowired
	OrganizationSizeService organizationSizeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<OrganizationSizeDTO> listAll()
	{
		return organizationSizeService.listOrganizationSize();
	}
}
