package com.circumfusion.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.circumfusion.dto.BusinessSegmentDTO;
import com.circumfusion.entity.BusinessSegment;
import com.circumfusion.repo.BusinessSegmentRepo;

@Service
public class BusinessSegmentService {
	
	@Autowired
	BusinessSegmentRepo busRepo;
	
	@Autowired
	DozerBeanMapper mapper;

	public List<BusinessSegmentDTO> listBusinessSegments() {
		List<BusinessSegment> indSegments = busRepo.findAll();
		List<BusinessSegmentDTO> dtos = new ArrayList<BusinessSegmentDTO>();
		indSegments.forEach(segment -> {
			dtos.add(mapper.map(segment, BusinessSegmentDTO.class));
		});
		return dtos;
	}
	
}
