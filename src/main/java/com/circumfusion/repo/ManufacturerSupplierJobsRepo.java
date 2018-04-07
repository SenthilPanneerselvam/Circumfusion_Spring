package com.circumfusion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.circumfusion.entity.ManufacturerSupplierJobs;

public interface ManufacturerSupplierJobsRepo extends JpaRepository< ManufacturerSupplierJobs, Integer>
{
	public List<ManufacturerSupplierJobs> findByOrgId(int orgId);
	public long deleteByOrgId(int orgId);
}
