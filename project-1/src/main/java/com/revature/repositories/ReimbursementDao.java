package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDao {
	
	public boolean insert(Reimbursement re); //insert 
	public boolean update(Reimbursement re); //update
	public List<Reimbursement> findAllReimb();
	
	public Reimbursement findByUsername(int id); //find record by username
	

}
