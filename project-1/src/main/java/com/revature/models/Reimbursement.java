package com.revature.models;

import java.util.Date;

import javax.management.relation.Role;

public class Reimbursement {
	
	private int id;
	private int amount;
	private Date sumbmit_time;
	private Date resolved_time;
	private String description;
	private int receipt;
	private int author;
	private int resolver;
	private Role statusID;
	private Role type_id;
	
	public Reimbursement() {
		
	}

	
	

}
