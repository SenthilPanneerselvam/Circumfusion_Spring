package com.circumfusion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.circumfusion.entity.ManufacturerTechnical;

public interface ManufacturerTechnicalRepo extends JpaRepository<ManufacturerTechnical, Integer> 
{
	public List<ManufacturerTechnical> findByOrgId(int orgId);
}
