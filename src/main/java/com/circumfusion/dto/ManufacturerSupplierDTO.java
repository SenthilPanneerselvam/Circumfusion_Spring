package com.circumfusion.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManufacturerSupplierDTO 
{
	private int id;
	private int orgId;
	private List<Integer> typeOfJobs;
	private String isoCertification;
	@JsonProperty
	private boolean isMicro;
	@JsonProperty
	private boolean isSmall;
	@JsonProperty
	private boolean isMedium;
	@JsonProperty
	private boolean isLarge;
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
	public String getIsoCertification() {
		return isoCertification;
	}
	public void setIsoCertification(String isoCertification) {
		this.isoCertification = isoCertification;
	}
	public boolean isMicro() {
		return isMicro;
	}
	public void setMicro(boolean isMicro) {
		this.isMicro = isMicro;
	}
	public boolean isSmall() {
		return isSmall;
	}
	public void setSmall(boolean isSmall) {
		this.isSmall = isSmall;
	}
	public boolean isMedium() {
		return isMedium;
	}
	public void setMedium(boolean isMedium) {
		this.isMedium = isMedium;
	}
	public boolean isLarge() {
		return isLarge;
	}
	public void setLarge(boolean isLarge) {
		this.isLarge = isLarge;
	}
	public List<Integer> getTypeOfJobs() {
		return typeOfJobs;
	}
	public void setTypeOfJobs(List<Integer> typeOfJobs) {
		this.typeOfJobs = typeOfJobs;
	}
}
