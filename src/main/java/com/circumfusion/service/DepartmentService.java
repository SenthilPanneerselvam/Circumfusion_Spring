package com.circumfusion.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.circumfusion.dto.DepartmentDTO;
import com.circumfusion.entity.Department;
import com.circumfusion.repo.DepartmentRepo;

@Service
@Transactional
public class DepartmentService {
	
	@Autowired
	DepartmentRepo depRepo;
	
	@Autowired
	DozerBeanMapper mapper;
	
	public List<DepartmentDTO> listAll() {
		List<Department> departments = depRepo.findAll();
		List<DepartmentDTO> dtos = new ArrayList<>();
		departments.forEach(department -> dtos.add(mapper.map(department, DepartmentDTO.class)));
		return dtos;
	}

}
