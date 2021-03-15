package com.revature.models;

import java.sql.Blob;
import java.sql.Date;
import java.time.LocalDate;

import com.google.gson.annotations.Expose;

public class Reimbursement {
	@Expose
	private int id;
	@Expose
	private int amount;
	@Expose
	private String date_submit;
	@Expose
	private String date_resolved;
	@Expose
	private String desc;
	@Expose
	private Blob receipt;
	@Expose
	private int author;
	@Expose
	private int resolver;
	@Expose
	private int statusId;
	@Expose
	private int typeId;
	@Expose
	private String username;
	
	public Reimbursement(){
		
	}
	
	
	



	public Reimbursement(int id, String date_resolved, int resolver, int statusId) {
		super();
		this.id = id;
		this.date_resolved = date_resolved;
		this.resolver = resolver;
		this.statusId = statusId;
	}

	


	public Reimbursement(int amount, String date_submit, String desc, int author, int resolver, int statusId,
			int typeId) {
		super();
		this.amount = amount;
		this.date_submit = date_submit;
		this.desc = desc;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}






	public Reimbursement(int amount, String date_submit, String date_resolved, String desc, int author, int resolver,
			int statusId, int typeId) {
		super();
		this.amount = amount;
		this.date_submit = date_submit;
		this.date_resolved = date_resolved;
		this.desc = desc;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	
	

	public Reimbursement(int id, int amount, String date_submit, String date_resolved, String desc, int author,
			int resolver, int statusId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.date_submit = date_submit;
		this.date_resolved = date_resolved;
		this.desc = desc;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public Reimbursement(int id, int amount, String date_submit, String date_resolved, String desc, Blob receipt,
			int author, int resolver, int statusId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.date_submit = date_submit;
		this.date_resolved = date_resolved;
		this.desc = desc;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}



	public Reimbursement(int id, int amount, String date_submit, String date_resolved, String desc, int author,
			int resolver, int statusId, int typeId, String username) {
		super();
		this.id = id;
		this.amount = amount;
		this.date_submit = date_submit;
		this.date_resolved = date_resolved;
		this.desc = desc;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
		this.username = username;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}



	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}



	/**
	 * @return the date_submit
	 */
	public String getDate_submit() {
		return date_submit;
	}



	/**
	 * @param date_submit the date_submit to set
	 */
	public void setDate_submit(String date_submit) {
		this.date_submit = date_submit;
	}



	/**
	 * @return the date_resolved
	 */
	public String getDate_resolved() {
		return date_resolved;
	}



	/**
	 * @param date_resolved the date_resolved to set
	 */
	public void setDate_resolved(String date_resolved) {
		this.date_resolved = date_resolved;
	}



	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}



	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}



	/**
	 * @return the receipt
	 */
	public Blob getReceipt() {
		return receipt;
	}



	/**
	 * @param receipt the receipt to set
	 */
	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}



	/**
	 * @return the author
	 */
	public int getAuthor() {
		return author;
	}



	/**
	 * @param author the author to set
	 */
	public void setAuthor(int author) {
		this.author = author;
	}



	/**
	 * @return the resolver
	 */
	public int getResolver() {
		return resolver;
	}



	/**
	 * @param resolver the resolver to set
	 */
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}



	/**
	 * @return the statusId
	 */
	public int getStatusId() {
		return statusId;
	}



	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}



	/**
	 * @return the typeId
	 */
	public int getTypeId() {
		return typeId;
	}



	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}



	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}



	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + author;
		result = prime * result + ((date_resolved == null) ? 0 : date_resolved.hashCode());
		result = prime * result + ((date_submit == null) ? 0 : date_submit.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + id;
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + resolver;
		result = prime * result + statusId;
		result = prime * result + typeId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (amount != other.amount)
			return false;
		if (author != other.author)
			return false;
		if (date_resolved == null) {
			if (other.date_resolved != null)
				return false;
		} else if (!date_resolved.equals(other.date_resolved))
			return false;
		if (date_submit == null) {
			if (other.date_submit != null)
				return false;
		} else if (!date_submit.equals(other.date_submit))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (id != other.id)
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		} else if (!receipt.equals(other.receipt))
			return false;
		if (resolver != other.resolver)
			return false;
		if (statusId != other.statusId)
			return false;
		if (typeId != other.typeId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", date_submit=" + date_submit + ", date_resolved="
				+ date_resolved + ", desc=" + desc + ", receipt=" + receipt + ", author=" + author + ", resolver="
				+ resolver + ", statusId=" + statusId + ", typeId=" + typeId + ", username=" + username + "]";
	}
	
	
	

	
	
}
