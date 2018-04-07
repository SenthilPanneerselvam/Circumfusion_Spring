package com.circumfusion.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ManufacturerSupplier implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	//Foreignkey to manufacturer table
	private int orgId;
	private String isoCertification;
	private boolean isMicro;
	private boolean isSmall;
	private boolean isMedium;
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
}
