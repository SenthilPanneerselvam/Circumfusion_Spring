package com.circumfusion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.circumfusion.dto.ClusterTypeDTO;
import com.circumfusion.service.ClusterTypeService;

@RestController
@RequestMapping("/clustertype")
public class ClusterTypeController 
{
	@Autowired
	ClusterTypeService clusterTypeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ClusterTypeDTO> listAll()
	{
		return clusterTypeService.listClusterType();
	}
}
