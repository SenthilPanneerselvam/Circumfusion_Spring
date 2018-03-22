package com.circumfusion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.circumfusion.entity.ServiceIndustry;

public interface ServiceIndustryRepo extends JpaRepository<ServiceIndustry, Integer>
{
	public ServiceIndustry findByOrgName(String orgName);
}
