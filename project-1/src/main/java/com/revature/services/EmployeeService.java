package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.EmployeeDAOImpl;
import com.revature.repositories.ReimbursementDao;
import com.revature.repositories.ReimbursementDaoImpl;

public class EmployeeService {
	
	public static EmployeeDAO eDao = new EmployeeDAOImpl();
	public static ReimbursementDao rDao = new ReimbursementDaoImpl();
	
	
	public static boolean insert(Employee e) {
		
		return eDao.insert(e);
	}
	
	public static boolean insert(Reimbursement re) {
		
		return rDao.insert(re);
	}
	
	public static boolean update(Employee e) {
		
		return eDao.update(e);
	}
	
	public Reimbursement findByUsername(int id) {
		return rDao.findByUsername(id);
		
	}
	
	public static boolean update(Reimbursement re) {
		
		return rDao.update(re);
	}
	
	public static List<Employee> findAll() {
		return eDao.findAll();
	}
	
	public static List<Reimbursement> findAllReimb() {
		return rDao.findAllReimb();
	}
	
	// find by username...
	public static Employee findByUsername(String username) {
		List<Employee> all = eDao.findAll();
		//List<Employee> all = findAll(); // another way to do it
		
		for (Employee e : all) { // filtering with an enhanced for-loop!
			if (e.getUsername().equals(username)) {
				return e; // we return the Employee object with a matching ID
			} else {
				continue;   // if username doesn't match the username prop of the Employee element
							// then continue coninue the loop to the next element.
			}
		}
		
		return null;
	}
	
	
	// find by ID...
		public static Reimbursement findRembiById(int author) {
			List<Reimbursement> all = rDao.findAllReimb();
			//List<Employee> all = findAll(); // another way to do it
			
			for (Reimbursement e : all) { // filtering with an enhanced for-loop!
				if (e.getAuthor()==author) {
					return e; // we return the Employee object with a matching ID
				} else {
					continue;   // if username doesn't match the username prop of the Employee element
								// then continue coninue the loop to the next element.
				}
			}
			
			return null;
		}
	
	// confirm login method
	public static Employee confirmManagerLogin(String username, String password) {
		
		// we use the above method
		Employee e = findByUsername(username);
		
		if (e == null) {
			return null;
		}
		
		if (e.getPassword().equals(password)&&e.getRole_id()==1) {
			return e;
		} else {
			return null;
		}
	}
	
	// confirm login method
		public static Employee confirmLogin(String username, String password) {
			
			// we use the above method
			Employee e = findByUsername(username);
			
			if (e == null) {
				return null;
			}
			
			if (e.getPassword().equals(password)&&e.getRole_id()==2) {
				return e;
			} else {
				return null;
			}
		}
	
	
	
	
	
	
	
	

}
