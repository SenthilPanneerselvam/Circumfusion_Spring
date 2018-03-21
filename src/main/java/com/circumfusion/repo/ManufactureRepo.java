package com.circumfusion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.circumfusion.entity.Manufacturer;

public interface ManufactureRepo extends JpaRepository<Manufacturer, Integer>{
	
	public Manufacturer findByOrgName(String orgName);

}
