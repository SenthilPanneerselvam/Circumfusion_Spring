package com.circumfusion.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.circumfusion.dto.ManufacturerFinanceDTO;
import com.circumfusion.dto.ManufacturerSupplierDTO;
import com.circumfusion.dto.ManufacturerTechnicalDTO;
import com.circumfusion.entity.ManufacturerFinance;
import com.circumfusion.entity.ManufacturerSupplier;
import com.circumfusion.entity.ManufacturerTechnical;
import com.circumfusion.repo.ManufacturerFinanceRepo;
import com.circumfusion.repo.ManufacturerSupplierRepo;
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
	
	public void saveManufacturerFinanceInfo(ManufacturerFinanceDTO manufacturerFinanceDTO)
	{
		ManufacturerFinance manufacturerFinance = beanMapper.map(manufacturerFinanceDTO, ManufacturerFinance.class);
		manufacturerFinanceRepo.save(manufacturerFinance);
	}
	
	public void saveManufacturerSupplierInfo(ManufacturerSupplierDTO manufacturerSupplierDTO)
	{
		ManufacturerSupplier manufacturerSupplier = beanMapper.map(manufacturerSupplierDTO, ManufacturerSupplier.class);
		manufacturerSupplierRepo.save(manufacturerSupplier);
	}
	
	public void saveManufacturerTechnicalInfo(ManufacturerTechnicalDTO manufacturerTechnicalDTO)
	{
		ManufacturerTechnical manufacturerTechnical = beanMapper.map(manufacturerTechnicalDTO, ManufacturerTechnical.class);
		manufacturerTechnicalRepo.save(manufacturerTechnical);
	}
}
