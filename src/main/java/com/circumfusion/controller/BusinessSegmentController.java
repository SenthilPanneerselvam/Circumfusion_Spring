package com.circumfusion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.circumfusion.dto.BusinessSegmentDTO;
import com.circumfusion.service.BusinessSegmentService;

@RestController
@RequestMapping("/businesssegments")
public class BusinessSegmentController {
	
	@Autowired
	BusinessSegmentService service;

	@RequestMapping(method=RequestMethod.GET)
	public List<BusinessSegmentDTO> listAll() {
		return service.listBusinessSegments();
	}

}
