package com.circumfusion.service;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.circumfusion.dto.ManufacturerFacilityDTO;
import com.circumfusion.dto.ManufacturerFinanceDTO;
import com.circumfusion.dto.ManufacturerSupplierDTO;
import com.circumfusion.dto.ManufacturerTechnicalDTO;
import com.circumfusion.entity.ManufacturerFinance;
import com.circumfusion.entity.ManufacturerSupplier;
import com.circumfusion.entity.ManufacturerSupplierJobs;
import com.circumfusion.entity.ManufacturerTechnical;
import com.circumfusion.entity.ManufacturerTechnicalProducts;
import com.circumfusion.repo.ManufacturerFinanceRepo;
import com.circumfusion.repo.ManufacturerSupplierJobsRepo;
import com.circumfusion.repo.ManufacturerSupplierRepo;
import com.circumfusion.repo.ManufacturerTechnicalProductsRepo;
import com.circumfusion.repo.ManufacturerTechnicalRepo;

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
	
	public void saveManufacturerFinanceInfo(ManufacturerFinanceDTO manufacturerFinanceDTO)
	{
		ManufacturerFinance manufacturerFinance = beanMapper.map(manufacturerFinanceDTO, ManufacturerFinance.class);
		manufacturerFinanceRepo.save(manufacturerFinance);
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
}
