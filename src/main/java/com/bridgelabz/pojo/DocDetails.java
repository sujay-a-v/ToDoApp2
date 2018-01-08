package com.bridgelabz.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class DocDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String docName;
	private String docType;
	private double docAmount;
	private double tax;
	private String taxtype;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public double getDocAmount() {
		return docAmount;
	}
	public void setDocAmount(double docAmount) {
		this.docAmount = docAmount;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public String getTaxtype() {
		return taxtype;
	}
	public void setTaxtype(String taxtype) {
		this.taxtype = taxtype;
	}
	
	

}
