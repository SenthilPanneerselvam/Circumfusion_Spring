package com.circumfusion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.circumfusion.dto.DepartmentDTO;
import com.circumfusion.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService depService;

	@RequestMapping(method=RequestMethod.GET)
	public List<DepartmentDTO> listAll() {
		return depService.listAll();
	}
	
}
