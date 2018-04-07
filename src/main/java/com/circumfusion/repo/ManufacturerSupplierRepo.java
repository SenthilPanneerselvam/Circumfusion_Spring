package com.circumfusion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.circumfusion.entity.ManufacturerSupplier;

public interface ManufacturerSupplierRepo extends JpaRepository<ManufacturerSupplier, Integer> 
{
	public ManufacturerSupplier findByOrgId(int orgId);
}
