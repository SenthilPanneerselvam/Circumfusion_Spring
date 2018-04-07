package com.circumfusion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.circumfusion.entity.ManufacturerTechnicalProducts;

public interface ManufacturerTechnicalProductsRepo extends JpaRepository< ManufacturerTechnicalProducts, Integer> 
{
	public List<ManufacturerTechnicalProducts> findByOrgId(int orgId);
	public long deleteByOrgId(int orgId);
}
