package com.circumfusion.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ManufacturerFinance implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	//Foreignkey to manufacturer table
	private int orgId;
	private String annualTurnover;
	private String nameOfBank;
	private String bankBranch;
	private String accountNumber;
	private String panNumber;
	private String tanNumber;
	private String gstNo;
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
	public String getAnnualTurnover() {
		return annualTurnover;
	}
	public void setAnnualTurnover(String annualTurnover) {
		this.annualTurnover = annualTurnover;
	}
	public String getNameOfBank() {
		return nameOfBank;
	}
	public void setNameOfBank(String nameOfBank) {
		this.nameOfBank = nameOfBank;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getTanNumber() {
		return tanNumber;
	}
	public void setTanNumber(String tanNumber) {
		this.tanNumber = tanNumber;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
}
