package com.circumfusion.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.circumfusion.dto.IndustrySegmentDTO;
import com.circumfusion.entity.IndustrySegment;
import com.circumfusion.repo.IndustrySegmentRepo;

@Service
public class IndustrySegmentService {
	
	@Autowired
	IndustrySegmentRepo indRepo;
	
	@Autowired
	DozerBeanMapper mapper;

	public List<IndustrySegmentDTO> listIndustrySegments() {
		List<IndustrySegment> indSegments = indRepo.findAll();
		List<IndustrySegmentDTO> dtos = new ArrayList<IndustrySegmentDTO>();
		indSegments.forEach(segment -> {
			dtos.add(mapper.map(segment, IndustrySegmentDTO.class));
		});
		return dtos;
	}
	
}
