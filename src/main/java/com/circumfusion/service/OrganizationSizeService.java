package com.circumfusion.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.circumfusion.dto.OrganizationSizeDTO;
import com.circumfusion.entity.OrganizationSize;
import com.circumfusion.repo.OrganizationSizeRepo;

@Service
public class OrganizationSizeService 
{
	@Autowired
	OrganizationSizeRepo organizationSizeRepo;
	
	@Autowired
	DozerBeanMapper mapper;
	
	public List<OrganizationSizeDTO> listOrganizationSize()
	{
		List<OrganizationSize> orgSizeList = organizationSizeRepo.findAll();
		List<OrganizationSizeDTO> orgSizeDTOList = new ArrayList<OrganizationSizeDTO>();
		orgSizeList.forEach(orgSize -> {
			orgSizeDTOList.add(mapper.map(orgSize, OrganizationSizeDTO.class));
		});
		return orgSizeDTOList;
	}

}
