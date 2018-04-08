package com.circumfusion.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.circumfusion.dto.ManufactureRegistrationDTO;
import com.circumfusion.dto.ManufacturerFacilityDTO;
import com.circumfusion.dto.ManufacturerFinanceDTO;
import com.circumfusion.dto.ManufacturerSupplierDTO;
import com.circumfusion.dto.ManufacturerTechnicalDTO;
import com.circumfusion.entity.Manufacturer;
import com.circumfusion.entity.ManufacturerFinance;
import com.circumfusion.entity.ManufacturerSupplier;
import com.circumfusion.entity.ManufacturerSupplierJobs;
import com.circumfusion.entity.ManufacturerTechnical;
import com.circumfusion.entity.ManufacturerTechnicalProducts;
import com.circumfusion.entity.User;
import com.circumfusion.exception.OrgAlreadyExistsException;
import com.circumfusion.repo.ManufactureRepo;
import com.circumfusion.repo.ManufacturerFinanceRepo;
import com.circumfusion.repo.ManufacturerSupplierJobsRepo;
import com.circumfusion.repo.ManufacturerSupplierRepo;
import com.circumfusion.repo.ManufacturerTechnicalProductsRepo;
import com.circumfusion.repo.ManufacturerTechnicalRepo;
import com.circumfusion.repo.UserRepo;

@Service
@Transactional
public class ManufacturerService 
{
	@Autowired
	DozerBeanMapper beanMapper;
	
	@Autowired
	ManufacturerFinanceRepo manufacturerFinanceRepo;
	
	@Autowired
	ManufacturerTechnicalRepo manufacturerTechnicalRepo;
	
	@Autowired
	ManufacturerSupplierRepo manufacturerSupplierRepo;
	
	@Autowired
	ManufacturerTechnicalProductsRepo manufacturerTechnicalProductsRepo;
	
	@Autowired
	ManufacturerSupplierJobsRepo manufacturerSupplierJobsRepo;
	
	@Autowired
	ManufactureRepo manufactureRepo;
	
	@Autowired
	UserRepo userRepo;
	
	public void saveManufacturerGeneralInfo(ManufactureRegistrationDTO manufactureRegistrationDTO)
	{
	/*	String orgName = manufactureRegistrationDTO.getOrgName();
		if(orgName != null && !orgName.isEmpty() &&  manufactureRepo.findByOrgName(orgName) != null)
		{
			throw new OrgAlreadyExistsException();
		} */
		//Get and set the user details
		Manufacturer manufacturerTemp = manufactureRepo.findOne(manufactureRegistrationDTO.getId());
		
		Manufacturer manufacturer = beanMapper.map(manufactureRegistrationDTO, Manufacturer.class);
		manufacturer.setUser(manufacturerTemp.getUser());
		manufactureRepo.save(manufacturer);
	}
	
	public ManufactureRegistrationDTO getManufacturerGeneralInfo(int orgId)
	{
		Manufacturer manufacturer = manufactureRepo.findOne(orgId);
		ManufactureRegistrationDTO manufactureRegistrationDTO = beanMapper.map(manufacturer, ManufactureRegistrationDTO.class);
		return manufactureRegistrationDTO;
	}
	
	public void saveManufacturerFinanceInfo(ManufacturerFinanceDTO manufacturerFinanceDTO)
	{
		ManufacturerFinance manufacturerFinance = beanMapper.map(manufacturerFinanceDTO, ManufacturerFinance.class);
		manufacturerFinanceRepo.save(manufacturerFinance);
	}
	
	public ManufacturerFinanceDTO getManufacturerFinanceInfo(int orgId)
	{
		ManufacturerFinance manufacturerFinance = manufacturerFinanceRepo.findByOrgId(orgId);
		ManufacturerFinanceDTO manufacturerFinanceDTO = beanMapper.map(manufacturerFinance, ManufacturerFinanceDTO.class);
		return manufacturerFinanceDTO;
	}
	
	public void saveManufacturerSupplierInfo(ManufacturerSupplierDTO manufacturerSupplierDTO)
	{
		// Save type of Jobs
		List<Integer> typeOfJobs = manufacturerSupplierDTO.getTypeOfJobs();
		int orgId = manufacturerSupplierDTO.getOrgId();
		if(typeOfJobs != null)
		{
			manufacturerSupplierJobsRepo.deleteByOrgId(orgId);
			for(Integer typeOfJobId:typeOfJobs)
			{
				ManufacturerSupplierJobs manufacturerSupplierJob = new ManufacturerSupplierJobs();
				manufacturerSupplierJob.setOrgId(orgId);
				manufacturerSupplierJob.setClusterTypeId(typeOfJobId);
				manufacturerSupplierJobsRepo.save(manufacturerSupplierJob);
			}
		}
		
		// Save supplier details
		ManufacturerSupplier manufacturerSupplier = beanMapper.map(manufacturerSupplierDTO, ManufacturerSupplier.class);
		manufacturerSupplierRepo.save(manufacturerSupplier);
	}
	
	public ManufacturerSupplierDTO getManufacturerSupplierInfo(int orgId)
	{
		List<Integer> typeOfJobs = new ArrayList<Integer>();
		List<ManufacturerSupplierJobs> manufacturerSupplierJobs = manufacturerSupplierJobsRepo.findByOrgId(orgId);
		if(manufacturerSupplierJobs != null)
		{
			for(ManufacturerSupplierJobs manufacturerSupplierJob:manufacturerSupplierJobs)
			{
				typeOfJobs.add(manufacturerSupplierJob.getClusterTypeId());
			}
		}
		
		ManufacturerSupplier manufacturerSupplier = manufacturerSupplierRepo.findByOrgId(orgId);
		ManufacturerSupplierDTO manufacturerSupplierDTO = beanMapper.map(manufacturerSupplier, ManufacturerSupplierDTO.class);
		manufacturerSupplierDTO.setTypeOfJobs(typeOfJobs);
		return manufacturerSupplierDTO;
	}
	
	public void saveManufacturerTechnicalInfo(ManufacturerTechnicalDTO manufacturerTechnicalDTO)
	{
		// Save Products manufactured
		String productsManufactured = manufacturerTechnicalDTO.getProductsManufactured();
		int orgId = manufacturerTechnicalDTO.getOrgId();
		manufacturerTechnicalProductsRepo.deleteByOrgId(orgId);
		ManufacturerTechnicalProducts manufacturerTechnicalProducts = new ManufacturerTechnicalProducts();
		manufacturerTechnicalProducts.setOrgId(orgId);
		manufacturerTechnicalProducts.setProductsManufactured(productsManufactured);
		manufacturerTechnicalProductsRepo.save(manufacturerTechnicalProducts);
		
		// Save Facility details
		List<ManufacturerFacilityDTO> facilityDTOs = manufacturerTechnicalDTO.getFacilityDTOs();
		if(facilityDTOs != null)
		{
			for(ManufacturerFacilityDTO facilityDTO:facilityDTOs)
			{
				ManufacturerTechnical manufacturerTechnical = beanMapper.map(facilityDTO, ManufacturerTechnical.class);
				manufacturerTechnical.setOrgId(orgId);
				manufacturerTechnicalRepo.save(manufacturerTechnical);
			}
		}
	}
	
	public ManufacturerTechnicalDTO getManufacturerTechnicalInfo(int orgId)
	{
		ManufacturerTechnicalDTO manufacturerTechnicalDTO = new ManufacturerTechnicalDTO();
		//Get product manufactured details
		String productsManufactured = "";
		List<ManufacturerTechnicalProducts> manufacturerTechnicalProductsList = manufacturerTechnicalProductsRepo.findByOrgId(orgId);
		if(manufacturerTechnicalProductsList != null && manufacturerTechnicalProductsList.size() > 0)
		{
			productsManufactured = manufacturerTechnicalProductsList.get(0).getProductsManufactured();
		}
		manufacturerTechnicalDTO.setProductsManufactured(productsManufactured);
		manufacturerTechnicalDTO.setOrgId(orgId);
		
		//Get facility details
		List<ManufacturerFacilityDTO> facilityDTOs = new ArrayList<ManufacturerFacilityDTO>();
		List<ManufacturerTechnical> manufacturerTechnicalList = manufacturerTechnicalRepo.findByOrgId(orgId);
		if(manufacturerTechnicalList != null && manufacturerTechnicalList.size() > 0)
		{
			for(ManufacturerTechnical manufacturerTechnical:manufacturerTechnicalList)
			{
				ManufacturerFacilityDTO facilityDTO = beanMapper.map(manufacturerTechnical, ManufacturerFacilityDTO.class);
				facilityDTOs.add(facilityDTO);
			}
		}
		manufacturerTechnicalDTO.setFacilityDTOs(facilityDTOs);
		return manufacturerTechnicalDTO;
	}
}
