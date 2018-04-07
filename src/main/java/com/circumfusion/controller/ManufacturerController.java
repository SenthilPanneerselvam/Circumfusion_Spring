package com.circumfusion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.circumfusion.dto.ManufacturerFinanceDTO;
import com.circumfusion.dto.ManufacturerSupplierDTO;
import com.circumfusion.dto.ManufacturerTechnicalDTO;
import com.circumfusion.service.ManufacturerService;

@RestController
@RequestMapping(value="/manufacturer")
public class ManufacturerController
{
	@Autowired
	ManufacturerService manufacturerService;
	
	@RequestMapping(value="/finance", method= {RequestMethod.POST,RequestMethod.PUT})
	public void saveManufacturerFinanceInfo(@RequestBody ManufacturerFinanceDTO manufacturerFinanceDTO)
	{
		manufacturerService.saveManufacturerFinanceInfo(manufacturerFinanceDTO);
	}
	
	@RequestMapping(value="/finance/{orgId}", method= {RequestMethod.GET})
	public ManufacturerFinanceDTO getManufacturerFinanceInfo(@PathVariable("orgId") Integer orgId)
	{
		return manufacturerService.getManufacturerFinanceInfo(orgId);
	}
	
	@RequestMapping(value="/supplier", method= {RequestMethod.POST,RequestMethod.PUT})
	public void saveManufacturerSupplierInfo(@RequestBody ManufacturerSupplierDTO manufacturerSupplierDTO)
	{
		manufacturerService.saveManufacturerSupplierInfo(manufacturerSupplierDTO);
	}
	
	@RequestMapping(value="/supplier/{orgId}", method= {RequestMethod.GET})
	public ManufacturerSupplierDTO getManufacturerSupplierInfo(@PathVariable("orgId") Integer orgId)
	{
		return manufacturerService.getManufacturerSupplierInfo(orgId);
	}
	
	@RequestMapping(value="/technical", method= {RequestMethod.POST,RequestMethod.PUT})
	public void saveManufacturerTechnicalInfo(@RequestBody ManufacturerTechnicalDTO manufacturerTechnicalDTO)
	{
		manufacturerService.saveManufacturerTechnicalInfo(manufacturerTechnicalDTO);
	}

	@RequestMapping(value="/technical/{orgId}", method= {RequestMethod.GET})
	public ManufacturerTechnicalDTO getManufacturerTechnicalInfo(@PathVariable("orgId") Integer orgId)
	{
		return manufacturerService.getManufacturerTechnicalInfo(orgId);
	}
}
