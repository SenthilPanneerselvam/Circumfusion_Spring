package com.circumfusion.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.circumfusion.dto.ClusterTypeDTO;
import com.circumfusion.entity.ClusterType;
import com.circumfusion.repo.ClusterTypeRepo;

@Service
public class ClusterTypeService
{
	@Autowired
	ClusterTypeRepo clusterTypeRepo;
	
	@Autowired
	DozerBeanMapper mapper;
	
	public List<ClusterTypeDTO> listClusterType()
	{
		List<ClusterType> clusterTypeList = clusterTypeRepo.findAll();
		List<ClusterTypeDTO> clusterTypeDTOList = new ArrayList<ClusterTypeDTO>();
		clusterTypeList.forEach(clusterType -> {
			clusterTypeDTOList.add(mapper.map(clusterType, ClusterTypeDTO.class));
		});
		return clusterTypeDTOList;
	}
}
