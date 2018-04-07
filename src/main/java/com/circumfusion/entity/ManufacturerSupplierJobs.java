package com.circumfusion.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ManufacturerSupplierJobs implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	//Foreignkey to manufacturer table
	private int orgId;
	//Foreignkey to Cluster type table
	private int clusterTypeId;
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
	public int getClusterTypeId() {
		return clusterTypeId;
	}
	public void setClusterTypeId(int clusterTypeId) {
		this.clusterTypeId = clusterTypeId;
	}
}
