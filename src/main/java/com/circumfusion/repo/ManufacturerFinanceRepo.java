package com.circumfusion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.circumfusion.entity.ManufacturerFinance;

public interface ManufacturerFinanceRepo extends JpaRepository<ManufacturerFinance, Integer> {
	public ManufacturerFinance findByOrgId(int orgId);
}
