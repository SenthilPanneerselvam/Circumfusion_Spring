package com.circumfusion.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cluster_type")
public class ClusterType implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String name;
	
	public ClusterType()
	{
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
