package com.circumfusion.dto;

import java.util.List;

public class ManufacturerTechnicalDTO 
{
	private int orgId;
	private String productsManufactured;
	private List<ManufacturerFacilityDTO> facilityDTOs;
	
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public String getProductsManufactured() {
		return productsManufactured;
	}
	public void setProductsManufactured(String productsManufactured) {
		this.productsManufactured = productsManufactured;
	}
	public List<ManufacturerFacilityDTO> getFacilityDTOs() {
		return facilityDTOs;
	}
	public void setFacilityDTOs(List<ManufacturerFacilityDTO> facilityDTOs) {
		this.facilityDTOs = facilityDTOs;
	}
}
