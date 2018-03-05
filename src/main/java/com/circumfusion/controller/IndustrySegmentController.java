package com.circumfusion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.circumfusion.dto.IndustrySegmentDTO;
import com.circumfusion.service.IndustrySegmentService;

@RestController
@RequestMapping("/industrysegments")
public class IndustrySegmentController {
	
	@Autowired
	IndustrySegmentService service;

	@RequestMapping(method=RequestMethod.GET)
	public List<IndustrySegmentDTO> listAll() {
		return service.listIndustrySegments();
	}
	
}
