package com.revature.services;

import java.util.List;

import com.revature.models.Users;
import com.revature.repo.UserDao;
import com.revature.repo.UserDaoImpl;

import jdk.internal.org.jline.utils.Log;


public class EmployeeServices {

	
	public static UserDao uDao = new UserDaoImpl();
	
	public static int insert(Users u) {
	
		return uDao.insert(u);
	}
	
	public static List<Users> findAll() {
		return uDao.findAll();
	}



	/*
	 * Inserts new users to the database
	 */
	public static void insertEmployee(Users u) {
		
		String username = "";
		String pass="";
		String first_name="";
		String last_name="";
		String email="";
		int role=u.getRole();
		
		Users usr=new Users(username, pass, first_name, last_name,email,role);
		
		uDao.insert(usr);
		Log.info(usr);
	
	} 
	
	
	public static Users findByUsername(String username) {
		List<Users> all = uDao.findAll();
		//List<Employee> all = findAll(); // another way to do it
		
		for (Users e : all) { // filtering with an enhanced for-loop!
			if (e.getUsername().equals(username)) {
				return e; // we return the Employee object with a matching ID
			} else {
				continue;   // if username doesn't match the username prop of the Employee element
							// then continue coninue the loop to the next element.
			}
		}
		
		return null;
	}
	
	// confirm login method
	public static Users confirmLogin(String username, String password) {
		
		// we use the above method
		Users usr = findByUsername(username);
		
		if (usr == null) {
			return null;
		}
		
		if (usr.getPassword().equals(password)) {
			return usr;
		} else {
			return null;
		}
	}
	
}
