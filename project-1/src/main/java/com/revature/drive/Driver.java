package com.revature.drive;


import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDao;
import com.revature.repositories.ReimbursementDaoImpl;
import com.revature.services.EmployeeService;

public class Driver {
	
	public static void main(String[] args) {
		
		Reimbursement re=new Reimbursement(2,"20-32-43",1,2);

		System.out.println(EmployeeService.findRembiById(1));
		
		
		
	}

}
