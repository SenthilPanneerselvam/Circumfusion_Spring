package com.circumfusion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.circumfusion.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{

}
