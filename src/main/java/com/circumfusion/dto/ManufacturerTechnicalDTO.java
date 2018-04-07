package com.circumfusion.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManufacturerTechnicalDTO 
{
	private int id;
	private int orgId;
	private String facilityName;
	private String city;
	private String state;
	private String country;
	@JsonProperty
	private boolean isManufacturing;
	@JsonProperty
	private boolean isAssembly;
	@JsonProperty
	private boolean isStores;
	@JsonProperty
	private boolean isEngRd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isManufacturing() {
		return isManufacturing;
	}
	public void setManufacturing(boolean isManufacturing) {
		this.isManufacturing = isManufacturing;
	}
	public boolean isAssembly() {
		return isAssembly;
	}
	public void setAssembly(boolean isAssembly) {
		this.isAssembly = isAssembly;
	}
	public boolean isStores() {
		return isStores;
	}
	public void setStores(boolean isStores) {
		this.isStores = isStores;
	}
	public boolean isEngRd() {
		return isEngRd;
	}
	public void setEngRd(boolean isEngRd) {
		this.isEngRd = isEngRd;
	}
}
