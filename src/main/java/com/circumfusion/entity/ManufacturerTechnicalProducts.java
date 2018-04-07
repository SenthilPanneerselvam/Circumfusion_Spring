package com.circumfusion.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ManufacturerTechnicalProducts implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	//Foreignkey to manufacturer table
	private int orgId;
	private String productsManufactured;
	
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
	public String getProductsManufactured() {
		return productsManufactured;
	}
	public void setProductsManufactured(String productsManufactured) {
		this.productsManufactured = productsManufactured;
	}
}
